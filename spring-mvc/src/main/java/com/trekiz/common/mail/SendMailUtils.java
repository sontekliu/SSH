package com.trekiz.common.mail;

import org.apache.commons.mail.SimpleEmail;

public class SendMailUtils {

	public static void sendMail(String mailAddress, String title, String content) throws Exception {
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.quauq.com");
		email.setAuthentication(Mail.USER_QUAUQ, Mail.PASSWD_QUAUQ);
		email.setCharset("UTF-8");
		email.setFrom(Mail.USER_QUAUQ,"测试邮件");
		email.addTo(mailAddress,"收件者");
		email.setSubject(title);
		email.setMsg(content);
		email.send();
	}
	
	public static void main(String[] args) {
		try {
			sendMail("sontek@yeah.net", "邮件标题", "测试邮件内容");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
