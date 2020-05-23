package com.xxxxx.dao;

import java.util.List;

import com.xxxxx.entity.Student;

public interface IStudentDao {
	
	//查询总数
	public int getTotalCount();

	// 根据Sno判断学生是否存在
	public boolean exitStudentByID(String Sno);

	// 根据Sno查询学生
	public Student queryStudentBySno(String Sno) ;
	
	// 查询当前页面下的学生
	public List<Student> queryStudentByPage(int countPage,int pageSize) ;

	// 查询所有学生
	public List<Student> queryAllStudent() ;//当前页，

	// 添加新的学生
	public boolean AddStudent(Student student);

	// 删除一个学生
	public boolean deleteStudent(String Sno) ;
	
	//根据Sno修改一个学生的信息
	public boolean updateStudent(String Sno ,Student student);


}
