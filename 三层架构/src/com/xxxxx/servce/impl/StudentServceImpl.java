package com.xxxxx.servce.impl;

import java.util.List;

import com.xxxxx.dao.IStudentDao;
import com.xxxxx.dao.impl.StudentDaoImpl;
import com.xxxxx.entity.Student;
import com.xxxxx.servce.IStudentServce;

public class StudentServceImpl implements IStudentServce {
	IStudentDao studentDao = new StudentDaoImpl();

	public boolean addStudent(Student student) {
		if (studentDao.exitStudentByID(student.getSno())) {
			return false;
		} else {
			boolean b = studentDao.AddStudent(student);
			if (b) {
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean deleteStudent(String Sno) {
		if (studentDao.exitStudentByID(Sno)) {
			boolean b = studentDao.deleteStudent(Sno);
			if (b) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean updateStudent(String Sno, Student student) {
		boolean b = studentDao.updateStudent(Sno, student);
		if (b) {
			return true;
		} else {
			return false;
		}
	}

	public Student queryOneStudent(String Sno) {
		return studentDao.queryStudentBySno(Sno);
	}

	public List<Student> queryAllStudents() {
		return studentDao.queryAllStudent();
	}

	@Override
	public List<Student> queryStudentByPage(int countPage, int pageSize) {
		return studentDao.queryStudentByPage(countPage, pageSize);
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return studentDao.getTotalCount();
	}
}
