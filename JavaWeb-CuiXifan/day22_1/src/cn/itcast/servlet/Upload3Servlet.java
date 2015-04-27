package cn.itcast.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itcast.commons.CommonUtils;

/*
 * 说明：
 * 	解决上传的许多细节问题
 * 	1. 文件需要存放在"WEB-INF"下
 * 	2. 文件名相关问题
 * 	3. 目录打散
 * 	4. 上传文件大小限制
 * 	5. 缓存阈值和缓存目录
 */
public class Upload3Servlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		//被解析器所解析，可以防止文件名乱码

		try {
			//上传三步
			DiskFileItemFactory factory = new DiskFileItemFactory(10*1024, new File("/tmp"));//缓存阈值及缓存目录
			ServletFileUpload sfu = new ServletFileUpload(factory);
			sfu.setFileSizeMax(100 * 1024);			//设置单文件大小限制
			sfu.setSizeMax(1024 * 1024);			//设置整个表单文件大小限制
			List<FileItem> fileItemList = sfu.parseRequest(request);

			FileItem file1 = fileItemList.get(0);
			FileItem file2 = fileItemList.get(1);

			/*
			 * 文件名相关的操作
			 * 	1. 处理绝对目录问题
			 * 	2. 处理文件名重复问题
			 */
			String filename = file2.getName();
			if (filename.contains("\\"))
				filename = filename.substring(filename.indexOf("\\") + 1);
			filename = CommonUtils.uuid() + "_" + filename;
			

			/*
			 * 存储目录相关操作
			 * 	1. 存在在"/WEB-INF"目录下
			 * 	2. 目录的打散问题
			 */
			 String filesPath = getServletContext().getRealPath("/WEB-INF/files");
			 String hashCode = Integer.toHexString(filename.hashCode());
			 File destPath = new File(filesPath, hashCode.charAt(0) + "/" + hashCode.charAt(1));
			 destPath.mkdirs();
			 File destFile = new File(destPath, filename);

			 //写入文件
			 file2.write(destFile);

		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			request.setAttribute("msg", "您上传的文件大小超出了100KB！");
			request.getRequestDispatcher("/upload3.jsp").forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
