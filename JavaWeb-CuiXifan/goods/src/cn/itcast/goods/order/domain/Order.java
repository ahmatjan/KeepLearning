package cn.itcast.goods.order.domain;

import java.util.List;

import cn.itcast.goods.user.domain.User;

/**
 * 订单实体类
 * @author jason
 *
 */
public class Order {
	private String oid;			//主键
	private String ordertime;	//下单时间
	private double total;		//总计
	private int status;		//订单状态：1.未付款 2.已付款，未发货 3.已发货，未确认收货 4.已收货，交易成功 5.已取消（只有未付款才可以取消）
	private String address;		//收货地址
	private User owner;			//订单所有者

	private List<OrderItem> orderItemList;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(String oid, String ordertime, double total, int status,
			String address, User owner, List<OrderItem> orderItemList) {
		super();
		this.oid = oid;
		this.ordertime = ordertime;
		this.total = total;
		this.status = status;
		this.address = address;
		this.owner = owner;
		this.orderItemList = orderItemList;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", ordertime=" + ordertime + ", total="
				+ total + ", status=" + status + ", address=" + address
				+ ", owner=" + owner + ", orderItemList=" + orderItemList + "]";
	}

}
