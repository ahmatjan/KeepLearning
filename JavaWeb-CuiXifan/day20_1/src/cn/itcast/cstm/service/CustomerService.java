package cn.itcast.cstm.service;

import java.util.List;

import cn.itcast.cstm.dao.CustomerDao;
import cn.itcast.cstm.domain.Customer;
import cn.itcast.cstm.domain.PageBean;

public class CustomerService {
	private CustomerDao customerDao = new CustomerDao();

	public void add(Customer customer) {
		customerDao.add(customer);
		
	}

	public PageBean<Customer> findAll(int pc, int ps) {
		return customerDao.findAll(pc, ps);
	}

	public Customer load(String cid) {
		return customerDao.load(cid);
	}

	public void edit(Customer customer) {
		customerDao.edit(customer);
	}

	public void delete(String cid) {
		customerDao.delete(cid);
	}

	public PageBean<Customer> query(Customer criteria, int pc, int ps) {
		return customerDao.query(criteria, pc, ps);
	}

}
