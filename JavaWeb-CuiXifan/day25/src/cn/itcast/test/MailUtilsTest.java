package cn.itcast.test;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.Session;

import org.junit.Test;

import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;

/*
 * 测试MailUtils，发送邮件
 * 	> 依赖itcast-tools
 * 	> 依赖mail.jar、activation.jar
 */
public class MailUtilsTest {
	@Test
	public void testSend() throws MessagingException, IOException {
		/*
		 * 1. 创建会话，设置邮箱账户信息
		 * 2. 创建邮件对象
		 * 3. 发送
		 */
		Session session = MailUtils.createSession("smtp.126.com", "lajixiang00@126.com", "itcastitcast");
		Mail mail = new Mail("lajixiang00@126.com", "lajixiang00@126.com", "测试邮件一封", "<a href='http://www.baidu.com'>百度</a>");
		MailUtils.send(session, mail);
	}
}
