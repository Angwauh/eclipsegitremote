package com.xxxxx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxxxx.dao.ITimeDao;
import com.xxxxx.dao.impl.TimeDaoImpl;
import com.xxxxx.entity.Student;
import com.xxxxx.servce.IStudentServce;
import com.xxxxx.servce.impl.StudentServceImpl;

/**
 * Servlet implementation class RegisterrServlet
 */
@WebServlet("/RegisterrServlet")
public class RegisterrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterrServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		String sno = request.getParameter("sno");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		int age = Integer.parseInt(request.getParameter("age"));
		String sdept = request.getParameter("sdept");
		String dateString = request.getParameter("date");
		ITimeDao time = new TimeDaoImpl();
		Student student = new Student(sno, name, sex, age,sdept,time.StringToSqlDate(dateString));


		IStudentServce servce = new StudentServceImpl();
		boolean b = servce.addStudent(student);

		PrintWriter out = response.getWriter();
		if (b) {
			response.sendRedirect("queryStudentByPageServlet");
		} else {
			out.print("添加失败");
		}

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
