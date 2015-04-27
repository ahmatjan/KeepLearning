package cn.itcast.web.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import sun.misc.BASE64Encoder;

/*
 * Servlet实现文件的下载，下载要点，两个头两个流：
 * 	1. Content-Type
 * 	2. Content-Disposition
 * 	3. 文件的流
 */
public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String filename = "/tmp/流光飞舞.mp3";

		//两个头
		String framename = filenameEncoding("流光飞舞.mp3", request);		//进行转码，防止乱码
		String contentType = getServletContext().getMimeType(filename);
		response.setHeader("Content-Type", contentType);
		response.setHeader("Content-Disposition", "attachment; filename=" + framename);

		//两个流
		FileInputStream input = new FileInputStream(filename);
		OutputStream output = response.getOutputStream();

		//进行下载
		IOUtils.copy(input, output);
		
		input.close();
	}

	//对文件名进行转码，防止乱码
	public static String filenameEncoding(String filename, HttpServletRequest request) throws IOException {
		String agent = request.getHeader("User-Agent"); //获取浏览器
		if (agent.contains("Firefox")) {
			BASE64Encoder base64Encoder = new BASE64Encoder();
			filename = "=?utf-8?B?"
					+ base64Encoder.encode(filename.getBytes("utf-8"))
					+ "?=";
		} else if(agent.contains("MSIE")) {
			filename = URLEncoder.encode(filename, "utf-8");
		} else {
			filename = URLEncoder.encode(filename, "utf-8");
		}
		return filename;
	}
}