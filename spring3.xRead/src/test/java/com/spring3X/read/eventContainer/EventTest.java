package com.spring3X.read.eventContainer;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring3X.read.eventContainer.source.MailSend;

public class EventTest {
	@Test
	public void test001(){
		ApplicationContext apx = new ClassPathXmlApplicationContext("spring.xml");
		MailSend mail = apx.getBean(MailSend.class);
		mail.sendEmail();
	}
}
