package cn.itcast.cstm.service;

import java.util.List;

import cn.itcast.cstm.dao.CustomerDao;
import cn.itcast.cstm.domain.Customer;

public class CustomerService {
	private CustomerDao customerDao = new CustomerDao();

	public void add(Customer customer) {
		customerDao.add(customer);
		
	}

	public List<Customer> findAll() {
		return customerDao.findAll();
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

	public List<Customer> query(Customer customer) {
		return customerDao.query(customer);
	}

}
