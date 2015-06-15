package cn.itcast.goods.admin.order.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.goods.order.domain.Order;
import cn.itcast.goods.order.service.OrderService;
import cn.itcast.goods.pager.PageBean;
import cn.itcast.servlet.BaseServlet;

public class AdminOrderServlet extends BaseServlet {
	private OrderService orderService = new OrderService();

	/**
	 * 查找所有订单
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 获取参数 pc、url(request.getRequestURI + request.getRequestQueryString - pc)
		 * 调用orderService.findAll()获得pageBean
		 * 为pageBean设置url
		 * pageBean存入request域，转发到list.jsp
		 */
		int pc = getPc(request);
		String url = getUrl(request);

		PageBean<Order> pageBean = orderService.findAll(pc);

		pageBean.setUrl(url);

		request.setAttribute("status", "0");
		request.setAttribute("pb", pageBean);

		return "f:/adminjsps/admin/order/list.jsp";
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
	 * 按状态查找所有订单
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByStatus(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 获取参数 status、pc、url(request.getRequestURI + request.getRequestQueryString - pc)
		 * 调用orderService.findByStatus()获得pageBean
		 * 为pageBean设置url
		 * pageBean存入request域，转发到list.jsp
		 */
		int pc = getPc(request);
		String url = getUrl(request);
		int status = Integer.parseInt(request.getParameter("status"));


		PageBean<Order> pageBean = orderService.findByStatus(pc, status);

		pageBean.setUrl(url);

		request.setAttribute("status", status+"");
		request.setAttribute("pb", pageBean);

		return "f:/adminjsps/admin/order/list.jsp";
	}

	/**
	 * 加载订单
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String load(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 获取参数oid和btn
		 * 调用orderService#load(oid)
		 * 把返回的Order和btn存入request域中
		 * 转发至desc.jsp
		 */
		String oid = request.getParameter("oid");
		String btn = request.getParameter("btn");

		Order order = orderService.load(oid);

		request.setAttribute("order", order);
		request.setAttribute("btn", btn);

		return "f:/adminjsps/admin/order/desc.jsp";
	}

	/**
	 * 取消订单
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String cancel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oid = request.getParameter("oid");

		int status = orderService.findStatusByOid(oid);
		if (status != 1) {
			request.setAttribute("msg", "状态不对，不能取消！");
			return "f:/adminjsps/msg.jsp";
		}

		orderService.updateStatus(oid, 5);

		request.setAttribute("msg", "您的订单已取消！");
		return "f:/adminjsps/msg.jsp";
	}

	/**
	 * 发货
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String deliver(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oid = request.getParameter("oid");

		int status = orderService.findStatusByOid(oid);
		if (status != 2) {
			request.setAttribute("msg", "状态不对，不能发货！");
			return "f:/adminjsps/msg.jsp";
		}

		orderService.updateStatus(oid, 3);

		request.setAttribute("msg", "发货完成～！");
		return "f:/adminjsps/msg.jsp";
	}
}
