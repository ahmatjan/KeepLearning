/*
 * 说明：获取类路径下的资源。
 */
package cn.itcast.servlet.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;


public class AServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.用ClassLoader
		//当前目录是 /WEB-INF/classes
		InputStream is = (InputStream) this.getClass().getClassLoader().getResourceAsStream("cn/itcast/servlet/test.txt");
		System.out.println(IOUtils.toString(is));

		//2. 用Class
		//2.1 路径前带"/"，当前路径是 /WEB-INF/classes
		InputStream is2 = (InputStream) this.getClass().getResourceAsStream("/cn/itcast/servlet/test.txt");
		System.out.println(IOUtils.toString(is2));

		//2.2 路径钱不带"/"，当前路径是 .class文件所在目录
		InputStream is3 = (InputStream) this.getClass().getResourceAsStream("test.txt");
		System.out.println(IOUtils.toString(is3));
	}

}
