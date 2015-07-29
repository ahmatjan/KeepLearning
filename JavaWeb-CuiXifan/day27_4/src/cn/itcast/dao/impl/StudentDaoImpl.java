package cn.itcast.dao.impl;

import cn.itcast.dao.StudentDao;
import cn.itcast.domain.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void addStudent(Student stu) {
		System.out.println("StudentDaoImpl.addStudent()");
	}

	@Override
	public void updateStudent(Student stu) {
		System.out.println("StudentDaoImpl.updateStudent()");
	}
}
