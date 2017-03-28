package com.spring3X.read.eventContainer.eventListener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.spring3X.read.eventContainer.event.MailsendEvent;
/**
 * @author zhangkefeng
 * 监听器 初始化时  通过后处理器 判断监听器的 instantof ApplicationListener 将其注册到
 * 事件传播器中  
 */
@Component
public class SendmailListenter implements ApplicationListener<MailsendEvent>{
	
	public SendmailListenter(){
		System.out.println("SendmailListenter 监听器初始化");
	}
	
	@Override
	public void onApplicationEvent(MailsendEvent event) {
		MailsendEvent eve = (MailsendEvent)event;
		System.out.println("邮件发送至："+event.getTo());
	}
}
