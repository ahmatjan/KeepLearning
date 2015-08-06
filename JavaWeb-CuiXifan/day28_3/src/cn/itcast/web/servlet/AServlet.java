/**
 * 说明：学习Servlet 3.0 对上传的支持。
 * 
 * 上传对表单要求：
 * 	> method="POST"
 * 	> enctype="multipart/form-data" 它的默认值为： application/x-www-form-urlencoded
 * 	> <input type="file" name="xxx">
 * 
 * 上传对Servlet 2.5要求：
 * 	> request.getParameter()不能再使用
 * 	> request.getInputStream()来获取整个表单数据
 * 	> 使用commons-fileupload来解析上传数据
 * 		* 创建工厂
 * 		* 解析器
 * 		* 使用解析器来解析request对象，得到List<FileItem>
 * 
 * 上传对Servlet 3.0要求：
 * 	> 加注解@MultipartConfig
 * 	> 使用 request.getPart("name")，得到Part实例
 * 	> 使用Part来获取各种信息
 * 		* String getContentType() 获取MIME类型
 * 		* String getName() 获取表单项名称，而非文件名称
 * 		* String getHeader(header) 获取制定头的值，其中Content-Disposition中包含了文件名
 * 		* long getSize() 获取文件大小
 * 		* getInputStream() 获取文件内容
 * 		* write() 把文件保存到指定路径
 */
package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns="/AServlet")
@MultipartConfig
public class AServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取普通表单字段：使用getParameter()
		String username = request.getParameter("username");
		System.out.println(username);

		// 获取文件表单字段：使用Part对象
		Part part = request.getPart("photo");

		System.out.println(part.getContentType());	//获取MIME类型
		System.out.println(part.getName());			//获取表单项名称
		System.out.println(part.getHeader("Content-Disposition"));		//其中包含了文件名
		System.out.println(part.getSize());			//获取文件大小
		part.write("/tmp/photo.jpg");				//保存文件

		// 获取上传文件的文件名
		String filename = part.getHeader("Content-Disposition");
		int start = filename.lastIndexOf("filename=\"") + 10;
		int end = filename.length() - 1;
		filename = filename.substring(start, end);
		System.out.println(filename);
	}
}
