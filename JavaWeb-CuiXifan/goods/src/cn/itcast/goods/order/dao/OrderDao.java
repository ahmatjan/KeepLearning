package cn.itcast.goods.order.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.book.domain.Book;
import cn.itcast.goods.order.domain.Order;
import cn.itcast.goods.order.domain.OrderItem;
import cn.itcast.goods.pager.Expression;
import cn.itcast.goods.pager.PageBean;
import cn.itcast.goods.pager.PageConstants;
import cn.itcast.jdbc.TxQueryRunner;

/**
 * 订单模块实体类
 * @author jason
 *
 */
public class OrderDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 我的购物车
	 * @param pc
	 * @param uid 
	 * @return
	 * @throws SQLException 
	 */
	public PageBean<Order> findByUser(int pc, String uid) throws SQLException {
		/*
		 * 获取ps
		 * 构造List<Expression>
		 * 调用findByCriteria得到pageBean并返回
		 */
		int ps = PageConstants.ORDER_PAGE_SIZE;

		List<Expression> criteria = new ArrayList<Expression>();
		criteria.add(new Expression("uid", "=", uid));

		return findByCriteria(pc, ps, criteria);
	}

	/*
	 * 多条件查询
	 */
	private PageBean<Order> findByCriteria(int pc, int ps, List<Expression> criteria) throws SQLException {
		/*
		 * 根据pc、ps、criteria构造SQL语句
		 * 执行SQL语句，得到tr、beanList
		 * 为beanList中每个Order，添加其所拥有的OrderItem
		 * 根据pc\ps\tr\beanList 构造PageBean对象，并返回
		 */
		StringBuilder sqlWhere = new StringBuilder(" WHERE 1=1");
		List<Object> params = new ArrayList<Object>();
		for (Expression criterion : criteria) {
			if (!criterion.getOperator().equalsIgnoreCase("IS NULL")) {
				sqlWhere.append(" AND ").append(criterion.getName()).append(" ")
					.append(criterion.getOperator()).append(" ?");
				params.add(criterion.getValue());
			} else {
				sqlWhere.append(" AND ").append(criterion.getName()).append(" ")
					.append(criterion.getOperator());
			}
		}


		String sql = "SELECT COUNT(*) FROM t_order" + sqlWhere;
		Number num = (Number) qr.query(sql, new ScalarHandler(), params.toArray());
		int tr = num.intValue();

		sql = "SELECT * FROM t_order" + sqlWhere + " ORDER BY ordertime DESC LIMIT ?,?";
		params.add((pc - 1) * ps);
		params.add(ps);
		List<Order> beanList = qr.query(sql, new BeanListHandler<Order>(Order.class), params.toArray());

		for (Order bean : beanList) {
			loadOrderItem(bean);
		}

		PageBean<Order> pageBean = new PageBean<Order>();
		pageBean.setBeanList(beanList);
		pageBean.setPc(pc);
		pageBean.setTr(tr);
		pageBean.setPs(ps);
		return pageBean;
	}

	/**
	 * 为Order加载其对应的OrderItem
	 * @param bean
	 * @throws SQLException
	 */
	private void loadOrderItem(Order bean) throws SQLException {
		String sql = "SELECT * FROM t_orderitem WHERE oid=?";
		List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler(), bean.getOid());
		List<OrderItem> orderItemList = toOrderItemList(mapList);
		bean.setOrderItemList(orderItemList);
	}

	/**
	 * 把MapList转换为OrderItemList
	 * @param mapList
	 * @return
	 */
	private List<OrderItem> toOrderItemList(List<Map<String, Object>> mapList) {
		ArrayList orderItemList = new ArrayList();
		for (Map<String, Object> map : mapList) {
			OrderItem orderItem = toOrderItem(map);
			orderItemList.add(orderItem);
		}
		return orderItemList;
	}

	/**
	 * 把Map转换为OrderItem
	 * @param map
	 * @return
	 */
	private OrderItem toOrderItem(Map<String, Object> map) {
		OrderItem orderItem = CommonUtils.toBean(map, OrderItem.class);
		Book book = CommonUtils.toBean(map, Book.class);
		orderItem.setBook(book);
		return orderItem;
	}

	/**
	 * 添加订单
	 * @param order
	 * @throws SQLException 
	 */
	public void add(Order order) throws SQLException {
		/*
		 * 在t_order表中添加数据
		 * 在t_orderitem表中添加数据，运用批处理来完成
		 */
		String sql = "INSERT INTO t_order VALUES(?,?,?,?,?,?)";
		Object[] params = {order.getOid(), order.getOrdertime(), order.getTotal(), 
				order.getStatus(), order.getAddress(), order.getOwner().getUid()};
		qr.update(sql, params);

		int len = order.getOrderItemList().size();
		Object[][] params2 = new Object[len][];
		sql = "INSERT INTO t_orderitem VALUES(?,?,?,?,?,?,?,?)";
		int i = 0;
		for (OrderItem orderItem : order.getOrderItemList()) {
			params2[i++] = new Object[] {orderItem.getOrderItemId(), orderItem.getQuantity(), 
					orderItem.getSubtotal(), orderItem.getBook().getBid(), orderItem.getBook().getBname(),
					orderItem.getBook().getCurrPrice(), orderItem.getBook().getImage_b(), 
					orderItem.getOrder().getOid()};
		}
		qr.batch(sql, params2);
	}

	/**
	 * 查看订单详细
	 * @param oid 
	 * @return
	 * @throws SQLException 
	 */
	public Order load(String oid) throws SQLException {
		/*
		 * 根据oid到数据库中查询Order
		 * 为Order填充OrderItem
		 * 返回Order
		 */
		String sql = "SELECT * FROM t_order WHERE oid=?";
		Order order = qr.query(sql, new BeanHandler<Order>(Order.class), oid);

		loadOrderItem(order);

		return order;
	}

	/**
	 * 按订单查询状态
	 * @param oid
	 * @return
	 * @throws SQLException 
	 */
	public int findStatusByOid(String oid) throws SQLException {
		String sql = "SELECT status FROM t_order WHERE oid=?";
		Number num = (Number)qr.query(sql, new ScalarHandler(), oid);
		return num.intValue();
	}

	/**
	 * 修改订单状态
	 * @param oid
	 * @param status
	 * @throws SQLException 
	 */
	public void updateStatus(String oid, int status) throws SQLException {
		String  sql = "UPDATE t_order SET status=? WHERE oid=?";
		qr.update(sql, status, oid);
	}

	/**
	 * 查找所有订单
	 * @param pc 
	 * @return
	 * @throws SQLException 
	 */
	public PageBean<Order> findAll(int pc) throws SQLException {
		/*
		 * 获取ps
		 * 构造List<Expression>
		 * 调用findByCriteria得到pageBean并返回
		 */
		int ps = PageConstants.ORDER_PAGE_SIZE;
		List<Expression> criteria = new ArrayList<Expression>();

		return findByCriteria(pc, ps, criteria);
	}

	/**
	 * 按状态查找订单
	 * @param pc
	 * @param status
	 * @return 
	 * @throws SQLException 
	 */
	public PageBean<Order> findByStatus(int pc, int status) throws SQLException {
		/*
		 * 获取ps
		 * 构造List<Expression>
		 * 调用findByCriteria得到pageBean并返回
		 */
		int ps = PageConstants.ORDER_PAGE_SIZE;

		List<Expression> criteria = new ArrayList<Expression>();
		criteria.add(new Expression("status", "=", status+""));

		return findByCriteria(pc, ps, criteria);
	}
}
