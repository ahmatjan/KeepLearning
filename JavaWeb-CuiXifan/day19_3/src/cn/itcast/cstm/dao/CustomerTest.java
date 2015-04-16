package cn.itcast.cstm.dao;

import org.junit.Test;

import cn.itcast.commons.CommonUtils;
import cn.itcast.cstm.domain.Customer;

public class CustomerTest {
	@Test
	public void addTestCustomer() {
		CustomerDao dao = new CustomerDao();

		for (int i = 0; i < 300; i++) {
			Customer customer = new Customer();
			customer.setCid(CommonUtils.uuid());
			customer.setCname(i + "");
			customer.setGender(i%2==0 ? "男":"女");
			customer.setBirthday("2015-04-16");
			customer.setCellphone("1300000" + i);
			customer.setEmail(i + "@163.com");
			customer.setDescription("我是" + i);
			dao.add(customer);
		}
	}
}
