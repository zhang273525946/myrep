package com.spring3X.read.aop.cglib.interceptor;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {
	private Enhancer enhancer = new Enhancer();
	
	//使用字节码技术 为类动态的生成子类实例
	public Object getObject(Class<?> clazz){
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("begin   "+System.currentTimeMillis());
		//通过动态代理生成的子类 调用父类的方法
		Object result = proxy.invokeSuper(obj, args);
		System.out.println("end   "+System.currentTimeMillis());
		return result;
	}

}
