package cn.itcast.goods.cart.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.book.domain.Book;
import cn.itcast.goods.cart.domain.CartItem;
import cn.itcast.goods.user.domain.User;
import cn.itcast.jdbc.TxQueryRunner;

/**
 * 购物车模块持久层
 * @author jason
 *
 */
public class CartItemDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 按用户查找购物条目
	 * @param uid
	 * @return
	 * @throws SQLException 
	 */
	public List<CartItem> findByUser(String uid) throws SQLException {
		/*
		 * 1.数据库中查询当前用户对应的 购物车条目列表List<Map>  （注：多表组合查询）
		 * 2.把 购物车条目列表List<Map> 映射成 CartItem\Book\User，并进行组装
		 */
		String sql = "SELECT c.*, b.* FROM t_cartitem c, t_book b WHERE uid=? AND c.bid=b.bid ORDER BY c.orderBy";
		List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler(), uid);
		return toCartItemList(mapList);
	}

	/**
	 * 把mapList转换成cartItemList
	 * @param map
	 * @return
	 */
	private List<CartItem> toCartItemList(List<Map<String, Object>> mapList) {
		List<CartItem> cartItemList = new ArrayList<CartItem>();

		for (Map<String, Object> map : mapList) {
			CartItem cartItem = toCartItem(map);
			cartItemList.add(cartItem);
		}

		return cartItemList;
	}

	/**
	 * 把map转换成cartItem
	 * @param map
	 * @return
	 */
	private CartItem toCartItem(Map<String, Object> map) {
		if (map==null || map.size()==0)
			return null;

		CartItem cartItem = CommonUtils.toBean(map, CartItem.class);
		Book book = CommonUtils.toBean(map, Book.class);
		User user = CommonUtils.toBean(map, User.class);
		cartItem.setBook(book);
		cartItem.setUser(user);

		return cartItem;
	}

	/**
	 * 根据bid和uid在数据库中查找购物条目
	 * @return
	 * @throws SQLException 
	 */
	public CartItem findByBidAndUid(String bid, String uid) throws SQLException {
		String sql = "SELECT * FROM t_cartitem WHERE bid=? AND uid=?";
		Map<String, Object> map = qr.query(sql, new MapHandler(), bid, uid);
		CartItem cartItem = toCartItem(map);

		return cartItem;
	}

	/**
	 * 更改某个购物条目的数量
	 * @param cartItemId
	 * @param quantity
	 * @throws SQLException 
	 */
	public void updateQuantity(String cartItemId, int quantity) throws SQLException {
		String sql = "UPDATE t_cartitem SET quantity=? WHERE cartItemId=?";
		qr.update(sql, quantity, cartItemId);
	}

	/**
	 * 添加购物条目
	 * @throws SQLException 
	 */
	public void addCartItem(CartItem cartItem) throws SQLException {
		String sql = "INSERT INTO t_cartitem(cartItemId, quantity, bid, uid) VALUES(?, ?, ?, ?)";
		qr.update(sql, cartItem.getCartItemId(), cartItem.getQuantity(), 
				cartItem.getBook().getBid(), cartItem.getUser().getUid());
	}

	/**
	 * 删除和批量删除功能
	 * @param cartItemIds
	 * @throws SQLException 
	 */
	public void batchDelete(String cartItemIds) throws SQLException {
		/*
		 * 1.把 cartItemIds由字符串划分成数组
		 * 2.生成 whereSql子句
		 * 3.把Delete子句和whereSql子句连接在一起，执行之
		 */
		Object[] cartItemIdArray= cartItemIds.split(",");

		StringBuilder sb = toWhereSql(cartItemIdArray);

		String sql = "DELETE FROM t_cartitem WHERE 1=1" + sb.toString();
		qr.update(sql, cartItemIdArray);
	}

	/**
	 * 生成whereSql
	 * @param cartItemIdArray
	 * @return
	 */
	private StringBuilder toWhereSql(Object[] cartItemIdArray) {
		StringBuilder sb = new StringBuilder(" AND CartItemId in (");
		for (int i = 0; i < cartItemIdArray.length; i++) {
			sb.append("?");
			if (i != cartItemIdArray.length - 1)
				sb.append(",");
		}
		sb.append(")");
		return sb;
	}

	/**
	 * 根据cartItemId查找购物条目
	 * @param cartItemId
	 * @return
	 * @throws SQLException 
	 */
	public CartItem findByCartItemId(String cartItemId) throws SQLException {
		String sql = "SELECT * FROM t_cartitem c, t_book b WHERE cartItemId=? AND c.bid=b.bid";
		Map<String, Object> map = qr.query(sql, new MapHandler(), cartItemId);
		CartItem cartItem = toCartItem(map);

		return cartItem;
	}

	/**
	 * 结算查询被勾选条目
	 * @param cartItemIds
	 * @return
	 * @throws SQLException 
	 */
	public List<CartItem> loadCartItems(String cartItemIds) throws SQLException {
		/*
		 * 把cartItemIds划分成数组
		 * 构造where子句
		 * 把select子句和where子句连接后进行查询（多表联合查询）
		 * 查询的结果封装成List<CartItem>返回
		 */
		Object[] cartItemIdArray = cartItemIds.split(",");

		StringBuilder sb = toWhereSql(cartItemIdArray);

		String sql = "SELECT * FROM t_cartitem c, t_book b WHERE c.bid=b.bid" + sb;
		List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler(), cartItemIdArray);

		List<CartItem> cartItemList = toCartItemList(mapList);
		return cartItemList;
	}
}
