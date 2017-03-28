package com.spring3X.read.aop.methodBefore;

import java.lang.reflect.Method;


import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author zhangkefeng
 * 简单的前置通知示例 ,  该方法  会  两次实例化对象   ,使用 cglib 、 jdk 代理 似乎是也有这个情况
 */
public class MethodBeforeProxy implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("hellow  welcome" + args[0]);
	}

	
	
	public static void main(String[] args) {
		Waiter waiter = new Waiter();
		
		MethodBeforeProxy proxy = new MethodBeforeProxy();
		
		ProxyFactory factory = new ProxyFactory();
		//要增强的 代理目标
		factory.setTarget(waiter);
		//增强代理目标
		factory.addAdvice(proxy);
		//获取代理实例
		Waiter w = (Waiter) factory.getProxy();
		w.say("xiaoming");
	}
}
