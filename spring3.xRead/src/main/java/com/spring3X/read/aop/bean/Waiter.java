package com.spring3X.read.aop.bean;

public class Waiter {
	public Waiter(){
		System.out.println(" waiter  生成中");
	}
	
	public void greedTo(String name){
		System.out.println(" 你好 "+name +" 欢迎光临");
	}
}
