package com.jdk.concurrent.lock.cyclicBarries;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author zhangkefeng
 *CyclicBarrier  在所有的线程都到达barrier时  执行任务   这个时候 所有的线程都没有结束 ,初始化 cyclicBarrier 是 传入一个runnable 
 *				该任务会由最后一个完成的线程来执行
 *CountDownLatch 在左右的线程都完成后  执行了后续的线程
 */
public class CyclicBarrierDemo2 {
	static CyclicBarrier barrier;
	
	public static void main(String[] args) {
		barrier = new CyclicBarrier(4, new Runnable() {
			@Override
			public void run() {
				System.out.println(" 最后一个的名字  "+Thread.currentThread().getName());
				System.out.println("大家都做完了 可以下班了！");
			}
		});
		for (int i = 0; i < 4; i++) {
			new work().start();
		}
	}
	
	static class work extends Thread{

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+"完成了");
			try {
				barrier.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("老板回来 偷偷检查"+Thread.currentThread().getName()+"工作是否真的完成了");
		}
		
	}
}
