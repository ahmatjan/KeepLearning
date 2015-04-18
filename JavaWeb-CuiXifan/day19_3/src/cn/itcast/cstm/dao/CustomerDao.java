package cn.itcast.cstm.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.cstm.domain.Customer;
import cn.itcast.jdbc.TxQueryRunner;

public class CustomerDao {
	private TxQueryRunner qr = new TxQueryRunner();

	public void add(Customer customer) {
		String sql = "INSERT INTO t_customer VALUES(?,?,?,?,?,?,?)";
		Object[] params = {customer.getCid(), customer.getCname(), customer.getGender(), 
				customer.getBirthday(), customer.getCellphone(), customer.getEmail(), customer.getDescription()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Customer> findAll() {
		try {
			String sql = "SELECT * FROM t_customer";
			return qr.query(sql, new BeanListHandler<Customer>(Customer.class));
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	public Customer load(String cid) {
		try {
			String sql = "SELECT * FROM t_customer WHERE cid=?";
			Object[] params = {cid};
			return qr.query(sql, new BeanHandler<Customer>(Customer.class), params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void edit(Customer customer) {
		try {
			String sql = "UPDATE t_customer SET cname=?,gender=?,birthday=?,cellphone=?,email=?,description=? WHERE cid=?";
			Object[]  params = {customer.getCname(), customer.getGender(), customer.getBirthday(), 
				customer.getCellphone(), customer.getEmail(), customer.getDescription(), customer.getCid()};
			System.out.println(qr.update(sql, params));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(String cid) {
		try {
			String sql = "DELETE FROM t_customer WHERE cid=?";
			Object[] params = {cid};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Customer> query(Customer criteria) {
		StringBuilder sql = new StringBuilder("SELECT * FROM t_customer WHERE '1'='1'");
		ArrayList<Object> params = new ArrayList<Object>();
		String cname = criteria.getCname();
		String gender = criteria.getGender();
		String cellphone = criteria.getCellphone();
		String email = criteria.getEmail();
		if (cname != null) {
			sql.append("AND cname LIKE ?");
			params.add("%" + cname + "%");
		}
		if (gender != null) {
			sql.append("AND gender LIKE ?");
			params.add("%" + gender + "%");
		}
		if (cellphone != null) {
			sql.append("AND cellphone LIKE ?");
			params.add("%" + cellphone + "%");
		}
		if (email != null) {
			sql.append("AND email LIKE ?");
			params.add("%" + email + "%");
		}

		try {
			return qr.query(sql.toString(), new BeanListHandler<Customer>(Customer.class), params.toArray());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
