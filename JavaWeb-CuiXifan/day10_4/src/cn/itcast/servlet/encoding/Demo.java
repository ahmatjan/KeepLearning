/*
 * 说明：	练习URL编码的转换，及了解原理。
 */
package cn.itcast.servlet.encoding;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Demo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String name = "张三";
		//URL编码原理说明：
		//		1. 把汉字按照对应的编码集转换为二进制字节。
		//		2. 把每个字节转换为两个十进制字符，并在前面加上%。
		
		//URL编码
		String s = URLEncoder.encode(name, "utf-8");
		System.out.println(s);

		//URL解码
		s = URLDecoder.decode(name, "utf-8");
		System.out.println(s);

	}
}
