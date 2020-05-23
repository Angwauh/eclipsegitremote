package com.xxxxx.entity;

import java.util.List;

public class Page {
//	当前页  currentPage
	private int currentPage;
//	页面大小  pageSize 
	private int pageSize;
//	当前页的数据集合  students
	List<Student> student;
// 总数据 totalCount
	private int totalCount;
//	总页数  totalPage
	private int totalPage;

	public Page() {
		super();
	}

	public Page(int currentPage, int pageSize, List<Student> student, int totalCount) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.student = student;
		this.totalCount = totalCount;
		this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage() {
		this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
	}
	
	
}
