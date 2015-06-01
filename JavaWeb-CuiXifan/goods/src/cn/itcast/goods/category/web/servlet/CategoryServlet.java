package cn.itcast.goods.category.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.goods.category.domain.Category;
import cn.itcast.goods.category.service.CategoryService;
import cn.itcast.servlet.BaseServlet;

/**
 * 分类模块WEB层
 * @author jason
 *
 */
public class CategoryServlet extends BaseServlet {
	private CategoryService categoryService = new CategoryService();

	/**
	 * 查询显示所有分类
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 1. 调用categoryService#findAll的返回值
		 * 2. 返回值存入request域中[parents“所有一级分类”]
		 * 3. 转发到left.jsp
		 */
		List<Category> parents = categoryService.findAll();
		req.setAttribute("parents", parents);
		return "f:/jsps/left.jsp";
	}
}
