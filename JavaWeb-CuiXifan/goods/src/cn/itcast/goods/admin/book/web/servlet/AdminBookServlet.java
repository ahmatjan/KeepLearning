package cn.itcast.goods.admin.book.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.book.domain.Book;
import cn.itcast.goods.book.service.BookService;
import cn.itcast.goods.category.domain.Category;
import cn.itcast.goods.category.service.CategoryService;
import cn.itcast.goods.pager.PageBean;
import cn.itcast.servlet.BaseServlet;

/**
 * 后台管理员图书模块 WEB层
 * @author jason
 *
 */
public class AdminBookServlet extends BaseServlet {
	private BookService bookService = new BookService();
	private CategoryService categoryService = new CategoryService();
	
	/**
	 * 在手风琴式下拉菜单查询显示所有分类
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAllInLeft(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 1. 调用categoryService#findAll的返回值
		 * 2. 返回值存入request域中[parents“所有一级分类”]
		 * 3. 转发到left.jsp
		 */
		List<Category> parents = categoryService.findAll();
		req.setAttribute("parents", parents);
		return "f:/adminjsps/admin/book/left.jsp";
	}

	/**
	 * 按分类进行查询
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1.获取各种参数：pc（默认为1）、yy、url(req.getRequestURI + req.getQuery - pc)
		 * 2.根据参数调用userService#findByXxx获得PageBean
		 * 3.给返回的PageBean设置url
		 * 4.把pageBean存入request域，转发到list.jsp
		 */
		int pc = getPc(request);
		String url = getUrl(request);
		String cid = request.getParameter("cid");

		PageBean<Book> pageBean = bookService.findByCategory(pc, cid);
		pageBean.setUrl(url);

		request.setAttribute("pb", pageBean);
		return "f:/adminjsps/admin/book/list.jsp";
	}

	/**
	 * 根据书名进行模糊查询
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByBname(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1.获取各种参数：pc（默认为1）、yy、url(req.getRequestURI + req.getQuery - pc)
		 * 2.根据参数调用userService#findByXxx获得PageBean
		 * 3.给返回的PageBean设置url
		 * 4.把pageBean存入request域，转发到list.jsp
		 */
		int pc = getPc(request);
		String url = getUrl(request);
		String bname = request.getParameter("bname");

		PageBean<Book> pageBean = bookService.findByBname(pc, bname);
		pageBean.setUrl(url);

		request.setAttribute("pb", pageBean);
		return "f:/adminjsps/admin/book/list.jsp";
	}

	/**
	 * 获取请求的参数
	 * @param request
	 * @return
	 */
	private String getUrl(HttpServletRequest request) {
		/*
		 * url = getRequestURI + getQueryStrign - pc;
		 */
		String temp;
		int index = request.getQueryString().indexOf("&pc=");
		if (index != -1)
			temp = request.getQueryString().substring(0, index);
		else
			temp = request.getQueryString();

		String url = request.getRequestURI() + "?" + temp;
		return url;
	}

	/**
	 * 获取请求中pc参数
	 * @param request
	 * @return
	 */
	private int getPc(HttpServletRequest request) {
		//pc默认为1
		int pc = 1;
		try {
			pc = Integer.parseInt(request.getParameter("pc"));
		} catch (RuntimeException e) {}
		return pc;
	}

	/**
	 * 根据作者进行查询
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByAuthor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1.获取各种参数：pc（默认为1）、yy、url(req.getRequestURI + req.getQuery - pc)
		 * 2.根据参数调用userService#findByXxx获得PageBean
		 * 3.给返回的PageBean设置url
		 * 4.把pageBean存入request域，转发到list.jsp
		 */
		int pc = getPc(request);
		String url = getUrl(request);
		String author = request.getParameter("author");

		PageBean<Book> pageBean = bookService.findByAuthor(pc, author);
		pageBean.setUrl(url);

		request.setAttribute("pb", pageBean);
		return "f:/adminjsps/admin/book/list.jsp";
	}

	/**
	 * 根据出版社进行查询
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByPress(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1.获取各种参数：pc（默认为1）、yy、url(req.getRequestURI + req.getQuery - pc)
		 * 2.根据参数调用userService#findByXxx获得PageBean
		 * 3.给返回的PageBean设置url
		 * 4.把pageBean存入request域，转发到list.jsp
		 */
		int pc = getPc(request);
		String url = getUrl(request);
		String press = request.getParameter("press");

		PageBean<Book> pageBean = bookService.findByPress(pc, press);
		pageBean.setUrl(url);

		request.setAttribute("pb", pageBean);
		return "f:/adminjsps/admin/book/list.jsp";
	}

	/**
	 * 组合查询
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByCombination(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1.获取各种参数：pc（默认为1）、yy、url(req.getRequestURI + req.getQuery - pc)
		 * 2.根据参数调用userService#findByXxx获得PageBean
		 * 3.给返回的PageBean设置url
		 * 4.把pageBean存入request域，转发到list.jsp
		 */
		int pc = getPc(request);
		String url = getUrl(request);
		Book book = CommonUtils.toBean(request.getParameterMap(), Book.class);

		PageBean<Book> pageBean = bookService.findByCombination(pc, book);
		pageBean.setUrl(url);

		request.setAttribute("pb", pageBean);
		return "f:/adminjsps/admin/book/list.jsp";
	}

	/**
	 * 加载图书（查看图书详细）
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String load(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		/*
		 * 获取bid
		 * 调用userService#load()
		 * 返回结果存入request，转发到desc.jsp
		 */
		String bid = request.getParameter("bid");

		Book book = bookService.load(bid);
		request.setAttribute("book", book);

		List<Category> parents = categoryService.findParents();
		request.setAttribute("parents", parents);
		List<Category> children = categoryService.findChildrenByParent(book.getCategory().getParent().getCid());
		request.setAttribute("children", children);

		return "f:/adminjsps/admin/book/desc.jsp";
	}


	/**
	 * 根据cid查找二级分类
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String ajaxFindChildrenByParent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		String pid = request.getParameter("pid");

		List<Category> children = categoryService.findChildrenByParent(pid);

		String json = toJson(children); 
		response.getWriter().println(json);

		return null;
	}

	/**
	 * 把 List<Category>转换成JSON
	 * @param children
	 * @return
	 */
	private String toJson(List<Category> children) {
		Category category;
		StringBuilder arr = new StringBuilder("[");
		for (int i = 0; i< children.size(); i++) {
			category = children.get(i);
			arr.append("{");
			arr.append("\"cid\":").append("\"").append(category.getCid()).append("\",");
			arr.append("\"cname\":").append("\"").append(category.getCname()).append("\"");
			arr.append("}");
			if (i < children.size()-1)
				arr.append(",");
		}
		arr.append("]");

		return arr.toString();
	}

	/**
	 * 编辑图书
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		/*
		 * 表单数据封装成Book，封装成Category，然后Category赋给Book
		 * 调用service编辑图书
		 */
		Map<String, Object> map = request.getParameterMap();
		Book book = CommonUtils.toBean(map, Book.class);
		Category category = CommonUtils.toBean(map, Category.class);
		book.setCategory(category);

		bookService.edit(book);

		request.setAttribute("msg", "图书编辑成功～！");
		return "f:/adminjsps/msg.jsp";

	}


	/**
	 * 准备添加图书
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String preAddBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		/*
		 * 调用categoryService.findParents()的到所有一级分类
		 * 把一级分类列表存入request域，转发到 add.jsp
		 */
		List<Category> parents = categoryService.findParents();
		request.setAttribute("parents", parents);

		return "f:/adminjsps/admin/book/add.jsp";
	}


	/**
	 * 删除图书
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		/*
		 * 根据bid，service加载图书
		 * 获取大小图，删除图片
		 * service.delete()删除图书
		 * 保存信息到msg.jsp
		 */
		String bid = request.getParameter("bid");
		Book book = bookService.load(bid);

		String parentPath = this.getServletContext().getRealPath("/");
		new File(parentPath, book.getImage_w()).delete();
		new File(parentPath, book.getImage_b()).delete();

		bookService.delete(bid);

		request.setAttribute("msg", "删除图书成功～！");
		return "f:/adminjsps/msg.jsp";
	}
}
