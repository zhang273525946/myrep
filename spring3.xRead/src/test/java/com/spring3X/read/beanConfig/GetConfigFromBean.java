package com.spring3X.read.beanConfig;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangkefeng
 *根据bean的 参数 动态的获取 配置属性
 */
@Controller
@RequestMapping("/getbean")
public class GetConfigFromBean {
//	@Value("#{config.url}")
	private String url;
	


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		System.out.println("---------------->"+url);
		this.url = url;
	}
	@Test
	public void testGetBeanConfig(){
		ApplicationContext content = new ClassPathXmlApplicationContext("spring.xml");
		content.getBean(GetConfigFromBean.class);
	}
	@RequestMapping("config.action")
	public void getconfig(){
		System.out.println(url);
	}
}	
