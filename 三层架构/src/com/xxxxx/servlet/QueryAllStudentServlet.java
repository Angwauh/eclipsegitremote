package com.xxxxx.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxxxx.entity.Student;
import com.xxxxx.servce.IStudentServce;
import com.xxxxx.servce.impl.StudentServceImpl;

/**
 * Servlet implementation class QueryAllStudentServlet
 */
//@WebServlet("/QueryAllStudentServlet")
public class QueryAllStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryAllStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IStudentServce servce = new StudentServceImpl();
		List<Student> list = servce.queryAllStudents();
		request.setAttribute("students", list);
		request.getRequestDispatcher("queryStudentByPageServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
