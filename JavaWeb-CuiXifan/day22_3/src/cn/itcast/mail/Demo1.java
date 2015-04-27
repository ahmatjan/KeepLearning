package cn.itcast.mail;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

/*
 * 用来说明BASE64的用法
 */
public class Demo1 {
	@Test
	public void fun1() throws IOException {

		//BASE64编码
		BASE64Encoder encoder = new BASE64Encoder();
		String s = "username:";
		s = encoder.encode(s.getBytes("UTF-8"));
		System.out.println(s);

		//BASE64解码
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] bytes = decoder.decodeBuffer("dXNlcm5hbWU6");
		s = new String(bytes, "UTF-8");
		System.out.println(s);
	}
}
