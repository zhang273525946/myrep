package com.spring3X.read.aop.jdkProxy.proxy;

import java.lang.reflect.Proxy;

import com.spring3X.read.aop.jdkProxy.invocationHandle.MyInvocationHandle;
import com.spring3X.read.aop.jdkProxy.mobj.MyObj;
import com.spring3X.read.aop.jdkProxy.mobj.MyObjImpl;

/**
 * @author zhangkefeng
 * spiring 3.x 6.2.2 jdk 动态代理章节
 */
public class JdkProxy {
	public static void main(String[] args) {
		MyObjImpl obj = new MyObjImpl();
		MyInvocationHandle invocation = new MyInvocationHandle(obj);
		//代理生成  目标类的代理对象
		MyObj proxy = (MyObj) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), invocation);
		proxy.dosome();
	}
}
