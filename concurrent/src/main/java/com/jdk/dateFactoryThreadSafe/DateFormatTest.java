package com.jdk.dateFactoryThreadSafe;

import java.util.Date;

/**
 * @author zhangkefeng
 * 使用 threadlocal 来保存dateformat  解决线程安全的问题
 */
public class DateFormatTest {
	static ThreadLocal threadlocal = new ThreadLocal();
	
	public static void main(String[] args) {
		System.out.println(" main----->   threadLocalName " +new ThreadLocal());
		for (int i = 0; i < 10; i++) {
			System.out.println("threadName " +Thread.currentThread().getName());
			threadlocal.set("123"+i);
			String format = DateFormatUtil.getSimpleDateFormat("yyyy-MM-dd").format(new Date());	
			System.out.println(format);
			System.out.println(threadlocal.get().toString());
		}
	 	ThreadLocalName.getThreadLocalName();
	}
	
}
class ThreadLocalName{
	public static void getThreadLocalName(){
		System.out.println("ThreadLocalName  ---->threadLocalName " +new ThreadLocal());
	}
	
}