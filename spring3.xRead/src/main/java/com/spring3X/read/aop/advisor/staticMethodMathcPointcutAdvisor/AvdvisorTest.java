package com.spring3X.read.aop.advisor.staticMethodMathcPointcutAdvisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring3X.read.aop.bean.Seller;
import com.spring3X.read.aop.bean.Waiter;

public class AvdvisorTest {
	/**
	 * @param args
	 * 通过spring 配置文件 进行测试
	 */
	public static void main(String[] args) {
		ApplicationContext apx = new ClassPathXmlApplicationContext("com/spring3X/read/aop/advisor/staticMethodMathcPointcutAdvisor/spring.xml");
		Seller seller = (Seller) apx.getBean("proxySeller");
		seller.greedTo("name");
		Waiter waiter = (Waiter) apx.getBean("proxyWaiter");
		waiter.greedTo("name");
	}
}
