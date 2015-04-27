package cn.itcast.mail;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.junit.Test;

/*
 * 学习发送邮件
 */
public class Demo2 {
	/*
	 * 发送普通邮件
	 * 	1. 创建Session
	 * 	2. 创建MimeMessage
	 * 	3. 发送邮件
	 */
	@Test
	public void fun1() throws MessagingException {
		//1. 创建Session
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.126.com");
		props.setProperty("mail.smtp.auth", "true");

		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("lajixiang00", "password");
			}
		};

		Session session = Session.getInstance(props, auth);

		//2. 创建MimeMessage
		MimeMessage msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress("lajixiang00@126.com"));
		msg.setRecipients(RecipientType.TO, "lajixiang00@126.com");
		//msg.setRecipients(RecipientType.CC, "lajixiang00@126.com");
		//msg.setRecipients(RecipientType.BCC, "lajixiang00@126.com");
		msg.setSubject("这是一封来自itcast的测试邮件！");
		msg.setContent("我是测试邮件的正文～！", "text/html;charset=UTF-8");

		//3. 发送邮件
		Transport.send(msg);
	}

	/*
	 * 发送带附件的邮件
	 * 	1. 创建Session
	 * 	2. 创建MimeMessage
	 * 	3. 发送邮件
	 */
	@Test
	public void fun2() throws AddressException, MessagingException, IOException {
		//1. 创建Session
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.126.com");
		props.setProperty("mail.smtp.auth", "true");

		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("lajixiang00", "password");
			}
		};

		Session session = Session.getInstance(props, auth);

		//2. 创建MimeMessage
		MimeMessage msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress("lajixiang00@126.com"));
		msg.setRecipients(RecipientType.TO, "lajixiang00@126.com");

		msg.setSubject("这是一封来自itcast的测试邮件！（有附件）");

		//////////////////////////邮件正文和附件
		MimeMultipart list = new MimeMultipart();

		//正文
		MimeBodyPart part1 = new MimeBodyPart();
		part1.setContent("我是邮件的正文～！", "text/html;charset=UTF-8");
		list.addBodyPart(part1);

		//附件
		MimeBodyPart part2 = new MimeBodyPart();
		part2.attachFile(new File("/tmp/流光飞舞.mp3"));
		part2.setFileName(MimeUtility.encodeText("好听的歌曲.mp3"));
		list.addBodyPart(part2);

		msg.setContent(list);
		//////////////////////////

		//3. 发送邮件
		Transport.send(msg);
	}

	/*
	 * 使用MailUtils发送邮件
	 */
	@Test
	public void fun3() throws MessagingException, IOException {
		//1. 创建Session
		Session session = MailUtils.createSession("smtp.126.com", "lajixiang00", "password");

		//2. 创建邮件对象
		Mail mail = new Mail("lajixiang00@126.com", "lajixiang00@126.com,lajixiang01@126.com", 
				"来自itcast的测试邮件（用MailUtils发送）", "我是邮件正文～！");
		//添加附件
		AttachBean attach1 = new AttachBean(new File("/tmp/流光飞舞.mp3"), "好听的歌曲啊啊啊.mp3");
		AttachBean attach2 = new AttachBean(new File("/tmp/new.png"), "一张照片.png");
		mail.addAttach(attach1);
		mail.addAttach(attach2);

		//3. 发送邮件
		MailUtils.send(session, mail);
	}
}
