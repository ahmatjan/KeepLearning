package cn.itcast.goods.cart.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.cart.dao.CartItemDao;
import cn.itcast.goods.cart.domain.CartItem;

/**
 * 购物车模块业务层
 * @author jason
 *
 */
public class CartItemService {
	private CartItemDao cartItemDao = new CartItemDao();

	/**
	 * 我的购物车
	 * @param uid 
	 * @return
	 */
	public List<CartItem> myCart(String uid) {
		try {
			return cartItemDao.findByUser(uid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 添加购物车条目
	 */
	public void add(CartItem cartItem) {
		/*
		 * 1.调用cartItemDao.findByBidAndUid(bid, uid)查询cartItem是否存在于数据库中
		 * 2.如果返回值不为null，把cartItem中的quantity和新添加的数量相加后，调用cartItemDao.updateQuantity(cartItemId, quantity)修改数据库中该购物车条目的数量。
		 * 3.如果返回值为null，则先给cartItem添加一个cartItemId，然后调用 cartItemDao.addCartItem()在数据库中添加一条购物车条目
		 */
		try {
			CartItem temp = cartItemDao.findByBidAndUid(cartItem.getBook().getBid(), cartItem.getUser().getUid());
			if (temp != null) {
				int quantity = cartItem.getQuantity() + temp.getQuantity();
				cartItemDao.updateQuantity(temp.getCartItemId(), quantity);
			} else {
				cartItem.setCartItemId(CommonUtils.uuid());
				cartItemDao.addCartItem(cartItem);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 批量删除功能
	 * @param cartItemIds
	 */
	public void batchDelete(String cartItemIds) {
		try {
			cartItemDao.batchDelete(cartItemIds);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改购物车条目数量
	 * @param cartItemId
	 * @param quantity
	 * @return
	 */
	public CartItem updateQuantity(String cartItemId, int quantity) {
		/*
		 * 调用cartItemDao.updateQuantity(cartItemId, quantity)修改数量
		 * 调用cartItemDao.findByCartItemId查找CartItem
		 * 返回CartItem
		 */
		try {
			cartItemDao.updateQuantity(cartItemId, quantity);
			return cartItemDao.findByCartItemId(cartItemId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 结算，查询被勾选条目
	 * @param cartItemIds
	 * @return
	 */
	public List<CartItem> loadCartItems(String cartItemIds) {
		try {
			return cartItemDao.loadCartItems(cartItemIds);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
