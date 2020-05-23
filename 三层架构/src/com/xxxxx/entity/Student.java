package com.xxxxx.entity;

import java.sql.Date;

public class Student {
	private String sno;
	private String name;
	private String sex;
	private int age;
	private String sdept;
	private Date date;
	public String getSdept() {
		return sdept;
	}

	public void setSdept(String sdept) {
		this.sdept = sdept;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Student(String sno, String name, String sex, int age, String sdept, Date date) {
		super();
		this.sno = sno;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.sdept = sdept;
		this.date = date;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + name + ", sex=" + sex + ", age=" + age + ", sdept=" + sdept
				+ ", date=" + date + "]";
	}

	public Student() {
		super();
	}

}
