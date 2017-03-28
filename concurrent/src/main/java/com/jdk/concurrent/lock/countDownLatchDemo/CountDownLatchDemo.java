package com.jdk.concurrent.lock.countDownLatchDemo;

import java.util.concurrent.CountDownLatch;

// 随机输出1-100  完成后 输出ok
public class CountDownLatchDemo {
	
	public static boolean b = false;
	
	public static void main(String[] args) throws Exception {
		CountDownLatch startsign = new CountDownLatch(1);
		CountDownLatch donesign = new CountDownLatch(10);
		
		for (int i = 0; i <10; i++) {
			new work(startsign, donesign, i).start();
		}
		System.out.println("begin----------");
		startsign.countDown();
		
		donesign.await();
		System.out.println("ok-------");
		System.out.println("b-----"+new ThreadLocal().get());
	}
	
	
	static class work extends Thread{
		CountDownLatch startSign;
		CountDownLatch downSign;
		int beginIndex;
		
		public work(CountDownLatch startSign, CountDownLatch downSign,
				int beginIndex) {
			super();
			this.startSign = startSign;
			this.downSign = downSign;
			this.beginIndex = beginIndex;
		}

		@Override
		public void run() {
			try {
				startSign.await();//等待开始信号
				beginIndex = beginIndex*10;
				for (int i = 0; i < 10; i++) {
					System.out.println(beginIndex+i);
				}
				new ThreadLocal().set(true);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				downSign.countDown();
			}
			
		}
		
	}
}
