package com.spring3X.read.aop.advisor.staticMethodMathcPointcutAdvisor;

import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import com.spring3X.read.aop.bean.Seller;
import com.spring3X.read.aop.bean.Waiter;

/**
 * @author zhangkefeng
 *通过 类过滤 跟方法名 匹配定义的切点， 该方法的不够灵活 如果 waiter中存在多个 greedTo 方法 无法进行区分
 */
public class MyStaticMethodMatchPointCutAdvisor extends StaticMethodMatcherPointcutAdvisor{

	public static void main(String[] args) {
		Waiter waiter = new Waiter();
		Seller seller = new Seller();
		
		BeforeAdvice advice = new BeforeAdvice();
		MyStaticMethodMatchPointCutAdvisor advisor = new MyStaticMethodMatchPointCutAdvisor();
		//切面添加增强  
		advisor.setAdvice(advice);
		//定义类过滤器
//		advisor.setClassFilter(new )
		
		
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(waiter);
		factory.addAdvisor(advisor);
		
		Waiter proxyWaiter = (Waiter) factory.getProxy();
		proxyWaiter.greedTo("name");
		
		
		factory.setTarget(seller);
		factory.addAdvisor(advisor);
		
		Seller proxySeller = (Seller) factory.getProxy();
		
		
		proxySeller.greedTo("name");
	}
	
	
	
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		//判定当前方法是否为 要增强的方法  ,  如果在该方法中进行了 class的判定 是否会起到classFilter的作用？
		if(StringUtils.equals("greedTo", method.getName())&&Waiter.class.isAssignableFrom(targetClass)){
			return true;
		}
		return false;
	}
	
//	@Override
//	public ClassFilter getClassFilter() {
//		//判定当前类是否要增强的类
//		return new ClassFilter() {
//			@Override
//			public boolean matches(Class<?> clazz) {
//				if(Waiter.class.isAssignableFrom(clazz)){
//					return true;
//				}
//				return false;
//			}
//		};
//	}

}
