package cn.itcast.cstm.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.cstm.domain.Customer;
import cn.itcast.cstm.service.CustomerService;
import cn.itcast.servlet.BaseServlet;

public class CustomerServlet extends BaseServlet {
	private CustomerService customerService = new CustomerService();

	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Customer customer = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		customer.setCid(CommonUtils.uuid());
		customerService.add(customer);
		//----
		request.setAttribute("msg", "注册成功了！");
		return "/msg.jsp";
	}

	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("cstmList", customerService.findAll());
		return "list.jsp";
	}

	public String preEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");
		request.setAttribute("cstm", customerService.load(cid));
		return "edit.jsp";
	}

	public String edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Customer customer = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		customerService.edit(customer);

		request.setAttribute("msg", "修改成功");
		return "/msg.jsp";
	}

	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Customer customer = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		String cid = request.getParameter("cid");
		customerService.delete(cid);

		request.setAttribute("msg", "删除成功");
		return "/msg.jsp";
	}

	public String query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Customer criteria = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		request.setAttribute("cstmList", customerService.query(criteria));

		return "/list.jsp";
	}
}
