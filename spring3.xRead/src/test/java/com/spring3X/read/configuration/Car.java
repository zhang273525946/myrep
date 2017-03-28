package com.spring3X.read.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangkefeng
 *@Configuration  本身 拥有  @Component 的注解   被 其标注的类 可以直接的作为 bean来进行注入
 */
//@Configuration
public class Car {
	@Autowired
	private CarCompent carCompent;
	public void getMycar(){
		System.out.println("myCarColor------------->"+carCompent.getMyColor());
	}
}
