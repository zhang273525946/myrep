package com.spring3X.read.aop.cglib.proxy;

import com.spring3X.read.aop.cglib.interceptor.CglibProxy;
import com.spring3X.read.aop.cglib.mobj.MyObj;

/**
 * @author zhangkefeng
 * spring 3.x  6.2.3  cglib 动态代理章节
 */
public class Proxy {
	public static void main(String[] args) {
		CglibProxy proxy = new CglibProxy();
		
		MyObj myObj = (com.spring3X.read.aop.cglib.mobj.MyObj) proxy.getObject(MyObj.class);
		
		myObj.dosome();
	}
}
