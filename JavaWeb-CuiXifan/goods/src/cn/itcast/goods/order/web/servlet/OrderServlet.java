package cn.itcast.goods.order.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.cart.domain.CartItem;
import cn.itcast.goods.cart.service.CartItemService;
import cn.itcast.goods.order.domain.Order;
import cn.itcast.goods.order.domain.OrderItem;
import cn.itcast.goods.order.service.OrderService;
import cn.itcast.goods.pager.PageBean;
import cn.itcast.goods.user.domain.User;
import cn.itcast.goods.utils.PaymentUtil;
import cn.itcast.servlet.BaseServlet;

/**
 * 订单模块WEB层
 * @author jason
 *
 */
public class OrderServlet extends BaseServlet {
	private OrderService orderService = new OrderService();
	private CartItemService cartItemService = new CartItemService();

	/**
	 * 我的订单
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String myOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 获取参数 pc、url(request.getRequestURI + request.getRequestQueryString - pc)
		 * 获取sessionUser.getUid()
		 * 调用orderService.myOrder()获得pageBean
		 * 为pageBean设置url
		 * pageBean存入request域，转发到list.jsp
		 */
		int pc = getPc(request);
		String url = getUrl(request);

		User sessionUser = (User)request.getSession().getAttribute("sessionUser");
		String uid = sessionUser.getUid();

		PageBean<Order> pageBean = orderService.myOrder(pc, uid);

		pageBean.setUrl(url);

		request.setAttribute("pb", pageBean);

		return "f:/jsps/order/list.jsp";
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
	 * 生成订单
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String createOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * 根据 address\sessionUser等信息创建Order
		 * 根据cartItemIds获得List<CartItemOrder>，进而创建List<OrderItem>
		 * 把List<OrderItem>添加到CartItemOrder上去
		 * 调用OrderService#createOrder()来向数据库中插入数据
		 * request域中保存order，转发到 /order/ordersucc.jsp去
		 */
		String cartItemIds = request.getParameter("cartItemIds");
		List<CartItem> cartItemList = cartItemService.loadCartItems(cartItemIds);
		String address = request.getParameter("address");


		String oid = CommonUtils.uuid();
		String ordertime = String.format("%tF %<tT", new Date());
		BigDecimal total = new BigDecimal("0");
		for (CartItem cartItem : cartItemList) {
			total = total.add(new BigDecimal(cartItem.getSubtotal() + ""));
		}
		User owner = (User) request.getSession().getAttribute("sessionUser");
		Order order = new Order(oid, ordertime, total.doubleValue(), 1, address, owner, null);

		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		for (CartItem cartItem : cartItemList) {
			orderItemList.add(new OrderItem(CommonUtils.uuid(), cartItem.getQuantity(), cartItem.getSubtotal(), cartItem.getBook(), order));
		}

		order.setOrderItemList(orderItemList);

		orderService.createOrder(order);

		cartItemService.batchDelete(cartItemIds);	//删除购物车中对应的条目

		request.setAttribute("order", order);
		return "f:/jsps/order/ordersucc.jsp";
	}

	/**
	 * 查看订单详细
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

		return "f:/jsps/order/desc.jsp";
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
			request.setAttribute("code", "error");
			request.setAttribute("msg", "状态不对，不能取消！");
			return "f:/jsps/msg.jsp";
		}

		orderService.updateStatus(oid, 5);

		request.setAttribute("code", "success");
		request.setAttribute("msg", "您的订单已取消！");
		return "f:/jsps/msg.jsp";
	}

	/**
	 * 确认收货
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String confirm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oid = request.getParameter("oid");

		int status = orderService.findStatusByOid(oid);
		if (status != 3) {
			request.setAttribute("code", "error");
			request.setAttribute("msg", "状态不对，不能确认收货！");
			return "f:/jsps/msg.jsp";
		}

		orderService.updateStatus(oid, 4);

		request.setAttribute("code", "success");
		request.setAttribute("msg", "您的订单已确认收货！");
		return "f:/jsps/msg.jsp";

	}

	/**
	 * 准备支付
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String paymentPrepare(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oid = request.getParameter("oid");

		Order order = orderService.load(oid);

		request.setAttribute("order", order);
		return "f:/jsps/order/pay.jsp";
	}

	/**
	 * 支付
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String payment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 获取oid和yh
		 * 准备13个参数，生成第14个参数
		 * 重定向到易宝（易宝支付url + 14个参数）
		 */
		String oid = request.getParameter("oid");
		String yh = request.getParameter("yh");
		Properties props = new Properties();
		props.load(this.getClass().getClassLoader().getResourceAsStream("payment.properties"));

		String p0_Cmd = "Buy";	//业务类型，固定值Buy
		String p1_MerId = props.getProperty("p1_MerId");//商号编码，在易宝的唯一标识
		String p2_Order = oid;	//订单编码
		String p3_Amt = "0.01";	//支付金额
		String p4_Cur = "CNY";	//交易币种，固定值CNY
		String p5_Pid = "";		//商品名称
		String p6_Pcat = "";	//商品种类
		String p7_Pdesc = "";	//商品描述
		String p8_Url = props.getProperty("p8_Url");	//在支付成功后，易宝会访问这个地址。
		String p9_SAF = "";		//送货地址
		String pa_MP = "";		//扩展信息
		String pd_FrpId = yh;	//支付通道
		String pr_NeedResponse = "1";					//应答机制，固定值1

		String keyValue = props.getProperty("keyValue");
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, 
				p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, 
				pa_MP, pd_FrpId, pr_NeedResponse, keyValue);

		StringBuilder sb = new StringBuilder("https://www.yeepay.com/app-merchant-proxy/node");
		sb.append("?").append("p0_Cmd=").append(p0_Cmd);
		sb.append("&").append("p1_MerId=").append(p1_MerId);
		sb.append("&").append("p2_Order=").append(p2_Order);
		sb.append("&").append("p3_Amt=").append(p3_Amt);
		sb.append("&").append("p4_Cur=").append(p4_Cur);
		sb.append("&").append("p5_Pid=").append(p5_Pid);
		sb.append("&").append("p6_Pcat=").append(p6_Pcat);
		sb.append("&").append("p7_Pdesc=").append(p7_Pdesc);
		sb.append("&").append("p8_Url=").append(p8_Url);
		sb.append("&").append("p9_SAF=").append(p9_SAF);
		sb.append("&").append("pa_MP=").append(pa_MP);
		sb.append("&").append("pd_FrpId=").append(pd_FrpId);
		sb.append("&").append("pr_NeedResponse=").append(pr_NeedResponse);
		sb.append("&").append("hmac=").append(hmac);

		response.sendRedirect(sb.toString());
		return null;
	}


	/**
	 * 支付返回
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String paymentBack(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 获取前12个参数
		 * 校验第13个参数，如果没有校验通过，保存错误信息到request域，转发到msg.jsp
		 * 调用orderService.updateStatus()修改订单状态
		 * 检查r9这个参数，
		 * 	* 如果是2，返回一个"success"
		 * 	* 否则，request域中存入成功信息，转发到msg.jsp中
		 */

		String p1_MerId = req.getParameter("p1_MerId");
		String r0_Cmd = req.getParameter("r0_Cmd");
		String r1_Code = req.getParameter("r1_Code");
		String r2_TrxId = req.getParameter("r2_TrxId");
		String r3_Amt = req.getParameter("r3_Amt");
		String r4_Cur = req.getParameter("r4_Cur");
		String r5_Pid = req.getParameter("r5_Pid");
		String r6_Order = req.getParameter("r6_Order");
		String r7_Uid = req.getParameter("r7_Uid");
		String r8_MP = req.getParameter("r8_MP");
		String r9_BType = req.getParameter("r9_BType");
		String hmac = req.getParameter("hmac");

		Properties props = new Properties();
		props.load(this.getClass().getClassLoader().getResourceAsStream("payment.properties"));
		String keyValue = props.getProperty("keyValue");

		boolean bool = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd, 
				r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, 
				r6_Order, r7_Uid, r8_MP, r9_BType, keyValue);
		if (!bool) {
			req.setAttribute("code", "error");
			req.setAttribute("msg", "签名错误，支付失败！（你不是好人！）");
			return "f:/jsps/msg.jsp";
		}

		orderService.updateStatus(r6_Order, 2);

		if (r9_BType.equals("2")) {
			response.getWriter().print("success");
			return null;
		} else {
			req.setAttribute("code", "success");
			req.setAttribute("msg", "恭喜，支付成功！");
			return "f:/jsps/msg.jsp";
		}
	}
}
