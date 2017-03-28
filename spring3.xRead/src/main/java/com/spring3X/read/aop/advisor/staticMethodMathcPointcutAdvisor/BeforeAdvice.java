package com.spring3X.read.aop.advisor.staticMethodMathcPointcutAdvisor;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println( target.getClass().getName() + " 切点   "+ method.getName());
		String name = (String) args[0];
		System.out.println("waiter see " +name);
	}
	
}
