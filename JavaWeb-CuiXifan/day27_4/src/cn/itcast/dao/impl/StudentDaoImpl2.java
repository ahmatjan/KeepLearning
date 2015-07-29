package cn.itcast.dao.impl;

import cn.itcast.dao.StudentDao;
import cn.itcast.domain.Student;

public class StudentDaoImpl2 implements StudentDao {

	@Override
	public void addStudent(Student stu) {
		System.out.println("StudentDaoImpl2.addStudent()");
	}

	@Override
	public void updateStudent(Student stu) {
		System.out.println("StudentDaoImpl2.updateStudent()");
	}
}
