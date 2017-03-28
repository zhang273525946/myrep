package com.spring3X.read.eventContainer.source;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.spring3X.read.eventContainer.event.MailsendEvent;
/**
 * @author zhangkefeng
 * 调用方法 并传播事件  必须实现  ApplicationContextAware 
 *  因为 在event 的初始化中 必须传入参数 ApplicationContext
 */
@Component
public class MailSend implements ApplicationContextAware{
	private ApplicationContext apx ;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.apx = applicationContext;
	}
	public void sendEmail(){
		MailsendEvent event = new MailsendEvent(apx, "127@qq.com");
		System.out.println("发邮件啦  -------------！");
		apx.publishEvent(event);
	}
	
}
