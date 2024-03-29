package cn.itcast.goods.order.domain;

import cn.itcast.goods.book.domain.Book;

/**
 * 订单条目实体类
 * @author jason
 *
 */
public class OrderItem {
	private String orderItemId;		//主键
	private int quantity;			//数量
	private double subtotal;		//小计
	private Book book;				//图书
	private Order order;			//所属订单
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItem(String orderItemId, int quantity, double subtotal,
			Book book, Order order) {
		super();
		this.orderItemId = orderItemId;
		this.quantity = quantity;
		this.subtotal = subtotal;
		this.book = book;
		this.order = order;
	}
	public String getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", quantity="
				+ quantity + ", subtotal=" + subtotal + ", book=" + book
				+ ", order=" + order + "]";
	}

}
