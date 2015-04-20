package cn.itcast.cstm.web.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.cstm.domain.Customer;
import cn.itcast.cstm.domain.PageBean;
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
		int pc = getPc(request);
		int ps = 10;
		PageBean<Customer> pb = customerService.findAll(pc, ps);
		pb.setUrl(getUrl(request));
		request.setAttribute("pb", pb);

		return "list.jsp";
	}

	private int getPc(HttpServletRequest request) {
		String pc = request.getParameter("pc");
		if (pc == null)
			return 1;
		else
			return Integer.parseInt(pc);
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
		criteria = convertEncoding(criteria);
		int pc = getPc(request);
		int ps = 10;
		PageBean<Customer> pb = customerService.query(criteria, pc, ps);

		pb.setUrl(getUrl(request));
		request.setAttribute("pb", pb);
		return "/list.jsp";
	}

	private Customer convertEncoding(Customer criteria) {
		String cname = criteria.getCname();
		String gender = criteria.getGender();
		String description = criteria.getGender();
		try {
			if (cname!=null && !cname.trim().isEmpty())
				criteria.setCname(new String(cname.getBytes("ISO-8859-1"), "UTF-8"));
			if (gender!=null && !gender.trim().isEmpty())
				criteria.setGender(new String(gender.getBytes("ISO-8859-1"), "UTF-8"));
			if (description!=null && !description.trim().isEmpty())
				criteria.setDescription(new String(description.getBytes("ISO-8859-1"), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return criteria;
	}

	private String getUrl(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		String queryString = request.getQueryString();
		if (queryString.contains("&pc"))
			queryString = queryString.substring(0, queryString.indexOf("&pc"));

		return contextPath + servletPath + "?" + queryString;
	}
}
