package com.xxxxx.servce;

import java.util.List;

import com.xxxxx.entity.Student;

public interface IStudentServce {

	// 查询当前页面下的学生
	public List<Student> queryStudentByPage(int countPage, int pageSize);

	// 查询总数
	public int getTotalCount();

	public boolean addStudent(Student student);

	public boolean deleteStudent(String Sno);

	public boolean updateStudent(String Sno, Student student);

	public Student queryOneStudent(String Sno);

	public List<Student> queryAllStudents();

}
