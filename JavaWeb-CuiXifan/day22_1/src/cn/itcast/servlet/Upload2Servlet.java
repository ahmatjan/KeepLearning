package cn.itcast.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/*
 * 上传2：保存上传的文件
 */
public class Upload2Servlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			/*
			 * 上传三步：
			 * 	1. 创建工厂
			 * 	2. 通过工厂创建解析器
			 * 	3. 解析request，得到FileItem集合
			 */
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(factory);
			List<FileItem> fileItemList = sfu.parseRequest(request);

			FileItem file1 = fileItemList.get(0);
			FileItem file2 = fileItemList.get(1);

			System.out.println("普通FileItem: ");
			System.out.println("Name: " + file1.getFieldName());
			System.out.println("String:" + file1.getString("UTF-8"));
			System.out.println("\n\n\n");

			System.out.println("文件FileItem: ");
			System.out.println("Name: " + file2.getFieldName());
			System.out.println("Filename: " + file2.getName());
			System.out.println("Content-Type: " + file2.getContentType());
			System.out.println("Size: " + file2.getSize());

			//保存文件
			File destFile = new File("/tmp/pic.png");
			file2.write(destFile);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 


	}
}
