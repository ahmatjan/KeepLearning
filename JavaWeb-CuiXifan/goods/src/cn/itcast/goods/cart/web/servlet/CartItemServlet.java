package cn.itcast.goods.cart.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.book.domain.Book;
import cn.itcast.goods.cart.domain.CartItem;
import cn.itcast.goods.cart.service.CartItemService;
import cn.itcast.goods.user.domain.User;
import cn.itcast.servlet.BaseServlet;

/**
 * 购物车模块web层
 * @author jason
 *
 */
public class CartItemServlet extends BaseServlet {
	private CartItemService cartItemService = new CartItemService();

	/**
	 * 我的购物车
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String myCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * 1.从session中提取uid
		 * 2.调用cartItemService#myCart()来获取CartItemList
		 * 3.cartItemList保存到request域中
		 * 4.转发到/jsps/cart/list.jsp
		 */
		User sessionUser = (User) request.getSession().getAttribute("sessionUser");
		String uid = sessionUser.getUid();

		List<CartItem> cartItemList = cartItemService.myCart(uid);

		request.setAttribute("cartItemList", cartItemList);

		return "f:/jsps/cart/list.jsp";
	}

	/**
	 * 添加购物车条目
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1.把quantity、bid、seesionUser.uid封装成一个CartItem
		 * 2.调用cartItemService.add(cartItem)方法完成添加购物条目
		 * 3.调用 myCart(req, resp)后跳转到 list.jsp
		 */
		Map map = request.getParameterMap();
		CartItem cartItem = CommonUtils.toBean(map, CartItem.class);
		Book book = CommonUtils.toBean(map, Book.class);
		User sessionUser = (User)request.getSession().getAttribute("sessionUser");
		cartItem.setBook(book);
		cartItem.setUser(sessionUser);

		cartItemService.add(cartItem);

		return myCart(request, response);
	}

	/**
	 * 批量删除
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String batchDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1.获取cartItemIds参数
		 * 2.调用cartItemService#batchDelete()完成删除功能
		 * 3.返回购物车页面
		 */
		String cartItemIds = request.getParameter("cartItemIds");

		cartItemService.batchDelete(cartItemIds);

		return myCart(request, response);
	}

	/**
	 * 修改购物条目数量
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String ajaxUpdateQuantity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 获取cartItemId和quantity
		 * 调用cartItemService.updateQuantity(cartItemId, quantity)修改数量
		 * 把返回值的quantity和subtotal转换成json格式发送给客户端
		 * 返回null
		 */
		String cartItemId = request.getParameter("cartItemId");
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		CartItem cartItem = cartItemService.updateQuantity(cartItemId, quantity);

		StringBuilder sb = new StringBuilder("{");
		sb.append("\"quantity\":").append(cartItem.getQuantity()).append(",");
		sb.append("\"subtotal\":").append(cartItem.getSubtotal());
		sb.append("}");
		response.getWriter().print(sb);

		return null;
	}


	/**
	 * 结算，查询被勾选条目
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String loadCartItems(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 获取参数cartItemIds、total
		 * 调用CartItemService.loadCartItems(cartItemIds)
		 * 将返回值 List<CartItem>、total存入request域中
		 * 转发到showitem.jsp中
		 */
		String cartItemIds = request.getParameter("cartItemIds");
		String total = request.getParameter("total");

		List<CartItem> cartItemList = cartItemService.loadCartItems(cartItemIds);

		request.setAttribute("cartItemList", cartItemList);
		request.setAttribute("total", total);
		request.setAttribute("cartItemIds", cartItemIds);

		return "f:/jsps/cart/showitem.jsp";
	}
}
