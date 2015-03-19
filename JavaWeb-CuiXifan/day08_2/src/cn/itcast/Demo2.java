/*
 * 目的：练习用itcast-tools.jar生成随机验证码图片。
 */
package cn.itcast;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import cn.itcast.vcode.utils.VerifyCode;

public class Demo2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		VerifyCode verifyCode = new VerifyCode();
		BufferedImage bi = verifyCode.getImage();
		System.out.println(verifyCode.getText());

		VerifyCode.output(bi, new FileOutputStream("/home/jason/Desktop/a.jpg"));
	}

}
