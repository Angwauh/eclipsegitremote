package com.xxxxx.dao.impl;

import java.util.List;

import com.xxxxx.entity.Student;

public class Test {
	public static void main(String[] args) {
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		List<Student> list = studentDaoImpl.queryAllStudent();
		list.stream().forEach(name->System.out.println(name));
		studentDaoImpl.deleteStudent("201215125");
		System.out.println("---------------------");
		List<Student> list1 = studentDaoImpl.queryAllStudent();
		list1.stream().forEach(name->System.out.println(name));
	}
}
