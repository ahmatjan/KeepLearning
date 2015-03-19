/*
 * 目的：练习用Java作图。
 */
package cn.itcast;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Demo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//得到图片缓冲区（画纸）
		BufferedImage bi = new BufferedImage(100, 35, BufferedImage.TYPE_INT_RGB);
		//得到绘画环境（画笔）
		Graphics2D g2 = (Graphics2D) bi.getGraphics();

		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, 100, 35);

		g2.setFont(new Font("Microsoft Yahei", Font.PLAIN, 18));
		g2.setColor(Color.BLACK);

		g2.drawString("HelloWorld", 0, 30);

		ImageIO.write(bi, "JPEG", new FileOutputStream("/home/jason/Desktop/a.jpg"));
	}
}
