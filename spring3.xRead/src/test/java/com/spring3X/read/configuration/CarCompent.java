package com.spring3X.read.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangkefeng
 *
 */
//@Configuration
public class CarCompent {
	
	/**
	 * @return
	 * @Configuration 注解的类中 使用@bean注解会根据该方法返回的 类型来注入要返回的值
	 */
	@Bean
	public Color color(){
		return new Color();
	}
	
	public  Color getMyColor(){
		return color();
	}
	
}
