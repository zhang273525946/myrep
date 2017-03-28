package com.spring3X.read.aop.jdkProxy.invocationHandle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.spring3X.read.aop.jdkProxy.mobj.MyObj;

public class MyInvocationHandle implements InvocationHandler{
	private Object	 target;
	
	public MyInvocationHandle(Object target){
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//proxy  最终生成的代理实例   
		System.out.println(proxy instanceof MyObj);
		
		System.out.println("begin  "+System.currentTimeMillis());
		//通过反射 调用目标方法
		method.invoke(target, args);
		
		System.out.println("end  "+System.currentTimeMillis());
		return null;
	}

}
