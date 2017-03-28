package com.spring3X.read.eventContainer.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @author zhangkefeng
 * envent 没有默认的无参 构造方法  不要使用 注解进行初始化  否则会报错
 * 它的实际意义本身就是一个 实现了 event 的model ？？
 */
public class MailsendEvent extends ApplicationContextEvent{
	
	private String to;
	
	public MailsendEvent(ApplicationContext source,String to) {
		super(source);
		this.to = to;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

}
