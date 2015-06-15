package cn.itcast.goods.admin.book.web.servlet;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.book.domain.Book;
import cn.itcast.goods.book.service.BookService;
import cn.itcast.goods.category.domain.Category;
import cn.itcast.goods.category.service.CategoryService;

/**
 * 后台管理员 上传图书
 * @author jason
 *
 */
public class AdminAddBookServlet extends HttpServlet {
	private BookService bookService = new BookService();
	private CategoryService categoryService = new CategoryService();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 使用 commons-fileupload组件完成三步解析，得到List<FileItem>
		 * 把 List<FileItem>转换成为一个Map中
		 * 使用Map生成一个Book，使用Map生成一个Category，把Category赋给Book
		 * 设置book.bid
		 * ----
		 * 对文件名进行截取（文件名称可能是绝对路径）
		 * 对文件拓展名进行校验，如果不是jpg或者png，则保存错误转发到add.jsp
		 * 检测图片大小，如果长宽大于 350*350，则保存错误到request域后转发到add.jsp
		 * 给文件名加上uuid前缀（保证文件名唯一）
		 * 给文件名添加上 book_img路径后保存
		 * 文件名赋给book对象
		 * 使用ServletContext.getRealPath()获取真实路径
		 * 保存文件
		 * ----
		 * 文件小图的检验同上
		 * ----
		 * 调用bookService.add(book)添加图书
		 * 保存添加成功信息，转发到msg
		 */

		//上传三步
		FileItemFactory factory = new DiskFileItemFactory();	//1. 创建解析工厂

		ServletFileUpload sfu = new ServletFileUpload(factory);	//2. 创建解析器
		sfu.setFileSizeMax(80 * 1024);			//设置上传文件大小

		List<FileItem> fileItemList = null;
		try {
			fileItemList = sfu.parseRequest(request);			//3. 进行解析
		} catch (FileUploadException e) {		//抛出异常说明大小超出限制
			error("您上传的图片大小超出了80KB", request, response);
			return;
		}

		//把fileItemList转换成一个map
		Map<String, Object> map = new HashMap<String, Object>();
		for (FileItem fileItem : fileItemList) {
			if (fileItem.isFormField()) {
				map.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
			}
		}

		//使用map生成一个Book和Category，然后把Category赋给Book
		Book book = CommonUtils.toBean(map, Book.class);
		Category category = CommonUtils.toBean(map, Category.class);
		book.setCategory(category);

		//设置book.bid
		book.setBid(CommonUtils.uuid());


		/*处理大图*/
		//对文件名进行截取
		FileItem fileItem = fileItemList.get(1);
		String fileName = fileItem.getName();
		int index = fileName.lastIndexOf("\\");
		if (index != -1) {
			fileName = fileName.substring(index + 1);
		}

		//对文件拓展名进行检测
		String lowerCaseFileName = fileName.toLowerCase();
		if (!lowerCaseFileName.endsWith("jpg") && !lowerCaseFileName.endsWith("png")) {
			error("上传的图片必须为jpg或者png类型！", request, response);
			return;
		}

		//给文件名加前缀uuid
		fileName = CommonUtils.uuid() + fileName;

		//检测文件尺寸大小
		//图片相关的对象有：Image、Icon、ImageIcon、BufferedImage、ImageIO
		ImageIcon imageIcon = new ImageIcon(IOUtils.toByteArray(fileItem.getInputStream()));
		Image image = imageIcon.getImage();
		if (image.getWidth(null) > 350 || image.getHeight(null) > 350) {
			error("图书的大图大小不能大于350*350", request, response);
			return;
		}


		//保存图片文件到指定路径
		String savePath = this.getServletContext().getRealPath("/book_img");
		File destFile = new File(savePath, fileName);
		try {
			fileItem.write(destFile);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		//把文件路径赋给Book
		book.setImage_w("book_img/" + fileName);
		

		/*处理小图*/
		//对文件名进行截取
		fileItem = fileItemList.get(2);
		fileName = fileItem.getName();
		index = fileName.lastIndexOf("\\");
		if (index != -1) {
			fileName = fileName.substring(index + 1);
		}

		//对文件拓展名进行检测
		lowerCaseFileName = fileName.toLowerCase();
		if (!lowerCaseFileName.endsWith("jpg") && !lowerCaseFileName.endsWith("png")) {
			error("上传的图片必须为jpg或者png类型！", request, response);
			return;
		}

		//给文件名加前缀uuid
		fileName = CommonUtils.uuid() + fileName;

		//检测文件尺寸大小
		//图片相关的对象有：Image、Icon、ImageIcon、BufferedImage、ImageIO
		imageIcon = new ImageIcon(IOUtils.toByteArray(fileItem.getInputStream()));
		image = imageIcon.getImage();
		if (image.getWidth(null) > 350 || image.getHeight(null) > 350) {
			error("图书的大图大小不能大于350*350", request, response);
			return;
		}


		//保存图片文件到指定路径
		savePath = this.getServletContext().getRealPath("/book_img");
		destFile = new File(savePath, fileName);
		try {
			fileItem.write(destFile);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		//把文件路径赋给Book
		book.setImage_b("book_img/" + fileName);



		//调用bookService.add
		bookService.add(book);

		//保存成功信息，转发到msg
		request.setAttribute("msg", "添加图书成功");
		request.getRequestDispatcher("/adminjsps/msg.jsp").forward(request, response);
	}

	/**
	 * 错误处理函数
	 * @param string
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void error(String string, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("msg", string);
		request.setAttribute("parents", categoryService.findParents());
		request.getRequestDispatcher("/adminjsps/admin/book/add.jsp").forward(request, response);
	}
}
