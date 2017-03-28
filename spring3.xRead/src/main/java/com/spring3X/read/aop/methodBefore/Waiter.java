package com.spring3X.read.aop.methodBefore;

public class Waiter {
	public Waiter(){
		System.out.println("waiter --");
	}
	public void say(String name ){
		System.out.println(" 欢迎光临"+name);
	}
}
