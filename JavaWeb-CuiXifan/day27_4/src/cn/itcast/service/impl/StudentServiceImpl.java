package cn.itcast.service.impl;

import cn.itcast.dao.StudentDao;
import cn.itcast.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentDao stuDao;

	public void setStuDao(StudentDao stuDao) {
		this.stuDao = stuDao;
	}

	@Override
	public void login() {
		System.out.println("StudentServiceImpl.login()");
		stuDao.updateStudent(null);
	}
}
