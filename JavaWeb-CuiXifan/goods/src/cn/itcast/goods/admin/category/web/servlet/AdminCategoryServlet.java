package cn.itcast.goods.admin.category.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.category.domain.Category;
import cn.itcast.goods.category.service.CategoryService;
import cn.itcast.servlet.BaseServlet;

/**
 * 分类模块的WEB层数据
 * @author jason
 *
 */
public class AdminCategoryServlet extends BaseServlet {
	private CategoryService categoryService = new CategoryService();

	/**
	 * 查看所有分类
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> categoryList = categoryService.findAll();

		request.setAttribute("categoryList", categoryList);
		return "f:/adminjsps/admin/category/list.jsp";
	}

	/**
	 * 添加一级分类
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String addParent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Category parent = CommonUtils.toBean(request.getParameterMap(), Category.class);

		parent.setCid(CommonUtils.uuid());

		categoryService.add(parent);

		return findAll(request, response);
	}

	/**
	 * 准备添加二级分类
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String preAddChild(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 获取参数pid
		 * 调用categoryService#findParents()获取所有一级分类 parents
		 * 把parents\pid存入request域中，转发到add2.jsp
		 */
		String pid = request.getParameter("pid");

		List<Category> parents = categoryService.findParents();

		request.setAttribute("parents", parents);
		request.setAttribute("pid", pid);

		return "/adminjsps/admin/category/add2.jsp";
	}

	/**
	 * 添加二级分类
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String addChild(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 把参数封装进Category child中；获取pid，封装为一个Category parent；child设置parent
		 * 调用categoryService#addChild()完成添加二级分类
		 * return findAll();
		 */
		Category child = CommonUtils.toBean(request.getParameterMap(), Category.class);
		child.setCid(CommonUtils.uuid());
		String pid = request.getParameter("pid");

		Category parent = new Category();
		parent.setCid(pid);

		child.setParent(parent);

		categoryService.add(child);

		return findAll(request, response);
	}


	/**
	 * 准备编辑一级分类
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String preEditParent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");

		Category parent = categoryService.load(cid);

		request.setAttribute("parent", parent);

		return "f:/adminjsps/admin/category/edit.jsp";
	}

	/**
	 * 编辑一级分类
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String editParent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Category category = CommonUtils.toBean(request.getParameterMap(), Category.class);

		categoryService.update(category);

		return findAll(request, response);
	}

	/**
	 * 准备编辑二级分类
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String preEditChild(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");

		Category category = categoryService.load(cid);
		List<Category> parents = categoryService.findParents();

		request.setAttribute("category", category);
		request.setAttribute("parents", parents);

		return "f:/adminjsps/admin/category/edit2.jsp";
	}


	/**
	 * 修改子分类
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String editChild(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * 参数封装为Category对象
		 * 调用categoryService.update()修改
		 * return findAll()
		 */
		Category category = CommonUtils.toBean(request.getParameterMap(), Category.class);
		Category parent = new Category();
		parent.setCid(request.getParameter("pid"));
		category.setParent(parent);

		categoryService.update(category);
		return findAll(request, response);
	}

	/**
	 * 删除一级分类
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String deleteParent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 获取cid
		 * 查询该分类下是否有二级分类(categoryService.findChildrenCountByParent(cid))
		 *   * 如果有，request域中保存错误信息，转发到msg.jsp中
		 *   * 如果没有，删除该分类；return findAll();
		 */
		String cid = request.getParameter("cid");
		if (categoryService.findChilrenCountByParent(cid) > 0) {
			request.setAttribute("msg", "该一级分类下还有子分类，不能删除该分类！");
			return "/adminjsps/admin/msg.jsp";
		} else {
			categoryService.delete(cid);
			return findAll(request, response);
		}
	}

	/**
	 * 删除二级分类
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String deleteChild(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 获取cid
		 * 查询该分类下是否有二级分类(categoryService.findBookCountByCategory(cid))
		 *  * 如果有，request域中保存错误信息，转发到msg.jsp中
		 *  * 如果没有，删除该分类；return findAll();
		 */
		String cid = request.getParameter("cid");
		if (categoryService.findBookCountByCategory(cid) > 0) {
			request.setAttribute("msg", "该二级分类下还有图书，不能删除该分类！");
			return "/adminjsps/admin/msg.jsp";
		} else {
			categoryService.delete(cid);
			return findAll(request, response);
		}

	}

}
