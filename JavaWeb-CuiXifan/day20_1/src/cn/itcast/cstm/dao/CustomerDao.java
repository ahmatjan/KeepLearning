package cn.itcast.cstm.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.cstm.domain.Customer;
import cn.itcast.cstm.domain.PageBean;
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

	public PageBean<Customer> findAll(int pc, int ps) {
		try {
			PageBean<Customer> pageBean = new PageBean<Customer>();
			pageBean.setPc(pc);
			pageBean.setPs(ps);

			String cntSql = "SELECT COUNT(*) FROM t_customer";
			Number num = (Number) qr.query(cntSql, new ScalarHandler());
			pageBean.setTr(num.intValue());

			String listSql = "SELECT * FROM t_customer LIMIT ?,?";
			Object[] params = {(pc-1)*ps, ps};
			List<Customer> beanList = qr.query(listSql, new BeanListHandler<Customer>(Customer.class), params);
			pageBean.setBeanList(beanList);

			return pageBean;
		} catch (SQLException e) {
			throw new RuntimeException(e);
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

	public PageBean<Customer> query(Customer criteria, int pc, int ps) {
		PageBean<Customer> pageBean = new PageBean<Customer>();
		pageBean.setPc(pc);
		pageBean.setPs(ps);

		StringBuilder cntSql = new StringBuilder("SELECT COUNT(*) FROM t_customer WHERE '1'='1' ");
		StringBuilder listSql = new StringBuilder("SELECT * FROM t_customer WHERE '1'='1' ");
		StringBuilder whereSql = new StringBuilder();
		StringBuilder limitSql = new StringBuilder("LIMIT ?,?");

		ArrayList<Object> params = new ArrayList<Object>();
		String cname = criteria.getCname();
		String gender = criteria.getGender();
		String cellphone = criteria.getCellphone();
		String email = criteria.getEmail();

		if (cname != null && !cname.trim().isEmpty()) {
			whereSql.append(" AND cname LIKE ?");
			params.add("%" + cname + "%");
		}
		if (gender != null && !gender.trim().isEmpty()) {
			whereSql.append(" AND gender LIKE ?");
			params.add("%" + gender + "%");
		}
		if (cellphone != null && !cellphone.trim().isEmpty()) {
			whereSql.append(" AND cellphone LIKE ?");
			params.add("%" + cellphone + "%");
		}
		if (email != null && !email.trim().isEmpty()) {
			whereSql.append(" AND email LIKE ?");
			params.add("%" + email + "%");
		}

		try {
			Number num = (Number) qr.query(cntSql.append(whereSql).toString(), 
					new ScalarHandler(), params.toArray());
			pageBean.setTr(num.intValue());

			params.add((pc - 1) * ps);
			params.add(ps);
			List<Customer> beanList = qr.query(listSql.append(whereSql).append(limitSql).toString(), 
					new BeanListHandler<Customer>(Customer.class), params.toArray());
			pageBean.setBeanList(beanList);

			return pageBean;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
