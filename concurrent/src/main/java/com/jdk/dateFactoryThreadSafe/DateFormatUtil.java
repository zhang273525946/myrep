package com.jdk.dateFactoryThreadSafe;

import java.text.SimpleDateFormat;

public class DateFormatUtil {
	private static ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<SimpleDateFormat>();

	public static SimpleDateFormat getSimpleDateFormat(String datePattern) {
		SimpleDateFormat sdf = null;
		sdf = t1.get();
		System.out.println("formatUtil ----->threadLocalName " +new ThreadLocal());
		if (sdf == null) {
			System.out.println("threadName " +Thread.currentThread().getName());
			sdf = new SimpleDateFormat(datePattern);
			System.out.println("初始化 sdf");
			t1.set(sdf);
		}
		return sdf;
	}

}
