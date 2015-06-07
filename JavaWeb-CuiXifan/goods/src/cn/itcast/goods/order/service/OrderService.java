package cn.itcast.goods.order.service;

import java.sql.SQLException;

import cn.itcast.goods.order.dao.OrderDao;
import cn.itcast.goods.order.domain.Order;
import cn.itcast.goods.pager.PageBean;
import cn.itcast.jdbc.JdbcUtils;

/**
 * 订单模块业务层
 * @author jason
 *
 */
public class OrderService {
	private OrderDao orderDao = new OrderDao();

	/**
	 * 我的订单
	 * @param pc 
	 * @param uid 
	 * @return
	 */
	public PageBean<Order> myOrder(int pc, String uid) {
		try {
			JdbcUtils.beginTransaction();

			PageBean<Order> pb = orderDao.myOrder(pc, uid);

			JdbcUtils.commitTransaction();

			return pb;
		} catch (SQLException e) {
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {}
			throw new RuntimeException(e);
		}
	}

	/**
	 * 添加订单
	 * @param order 
	 */
	public void createOrder(Order order) {
		try {
			JdbcUtils.beginTransaction();

			orderDao.add(order);

			JdbcUtils.commitTransaction();
		} catch (SQLException e) {
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) { }
		}
		
	}

	/**
	 * 查看订单详细
	 * @param oid
	 * @return
	 */
	public Order load(String oid) {
		try {
			return orderDao.load(oid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 按订单号查询状态
	 * @param oid
	 * @return
	 */
	public int findStatusByOid(String oid) {
		try {
			return orderDao.findStatusByOid(oid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改订单状态
	 * @param oid
	 * @param i
	 */
	public void updateStatus(String oid, int status) {
		try {
			orderDao.updateStatus(oid, status);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
