package com.xxxxx.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xxxxx.dao.IStudentDao;
import com.xxxxx.entity.Student;
import com.xxxxx.util.DBUtil;

public class StudentDaoImpl implements IStudentDao {

	// 根据Sno判断学生是否存在
	public boolean exitStudentByID(String Sno) {
		if (this.queryStudentBySno(Sno) != null)
			return true;
		else {
			return false;
		}
	}

	// 根据Sno查询学生

	public Student queryStudentBySno(String Sno) {
		String sql = "select * from student where Sno=?";
		ResultSet set = null;
		Student student = null;
		try {
			Object objects[] = { Sno };
			set = DBUtil.executeQuery(sql, objects);
			if (set.next()) {
				String sno = set.getString("Sno");
				String name = set.getString("Sname");
				String sex = set.getString("Ssex");
				int age = set.getInt("Sage");
				String sdept = set.getString("sdept");
				Date date = set.getDate("Date");
				student = new Student(sno, name, sex, age, sdept, date);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close();
			try {
				if (set != null)
					set.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return student;
	}

	// 查询所有学生
	public List<Student> queryAllStudent() {
		String sql = "SELECT * FROM student";
		Object objects[] = {};
		List<Student> list = new ArrayList<Student>();
		ResultSet set = null;
		try {
			set = DBUtil.executeQuery(sql, objects);// ResultSet 集合中从下标为 1 的开始存储信息
			while (set.next()) {

				Student student = new Student();
				student.setSno(set.getString("Sno"));
				student.setName(set.getString("Sname"));
				student.setSex(set.getString("Ssex"));
				student.setAge(set.getInt("Sage"));
				student.setSdept(set.getString("sdept"));
				student.setDate(set.getDate("Date"));
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close();
			try {
				if (set != null)
					set.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	// 添加新的学生
	public boolean AddStudent(Student student) {
		String sql = "insert into student(Sno,Sname,Ssex,Sage,sdept,Date) values(?,?,?,?,?,?)";
		Object objects[] = { student.getSno(), student.getName(), student.getSex(), student.getAge(),
				student.getSdept(), student.getDate() };
		boolean b = DBUtil.executeUpdate(sql, objects);
		DBUtil.close();
		return b;
	}

	// 删除一个学生
	public boolean deleteStudent(String Sno) {
		String sql = "delete from student where Sno=?";
		Object objects[] = { Sno };
		boolean b = DBUtil.executeUpdate(sql, objects);
		DBUtil.close();
		return b;
	}

	// 根据Sno修改一个学生的信息
	public boolean updateStudent(String Sno, Student student) {
		String sql = "update student set Sname=?,Ssex=?,Sage=?,sdept=?,Date=? where Sno=?";
		Object objects[] = { student.getName(), student.getSex(), student.getAge(), student.getSdept(),
				student.getDate(), student.getSno() };
		boolean b = DBUtil.executeUpdate(sql, objects);
		DBUtil.close();
		return b;
	}

	@Override
	public int getTotalCount() {
		String sql = "select count(1) from student";
		return DBUtil.getTotalCount(sql);
	}

	@Override
	public List<Student> queryStudentByPage(int countPage, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "select * from student limit ?,?";
		
		Object objs[] = { (countPage - 1) * pageSize, pageSize };
		List<Student> list = new ArrayList<Student>();
		ResultSet set = DBUtil.executeQuery(sql, objs);
		try {
			while (set.next()) {
				Student student = new Student();
				student.setSno(set.getString("Sno"));
				student.setName(set.getString("Sname"));
				student.setSex(set.getString("Ssex"));
				student.setAge(set.getInt("Sage"));
				student.setSdept(set.getString("sdept"));
				student.setDate(set.getDate("Date"));
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close();
			try {
				if (set != null)
					set.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

}
