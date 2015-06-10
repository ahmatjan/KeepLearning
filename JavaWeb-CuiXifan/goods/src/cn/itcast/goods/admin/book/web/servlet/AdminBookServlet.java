package cn.itcast.goods.admin.book.web.servlet;

import java.io.IOException;
import java.util.List;

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
		return "f:/adminjsps/admin/book/desc.jsp";
	}
}
