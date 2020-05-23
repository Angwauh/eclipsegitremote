package com.xxxxx.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxxxx.entity.Page;
import com.xxxxx.entity.Student;
import com.xxxxx.servce.IStudentServce;
import com.xxxxx.servce.impl.StudentServceImpl;

/**
 * Servlet implementation class queryStudentByPage
 */
@WebServlet("/queryStudentByPageServlet")
public class QueryStudentByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryStudentByPageServlet() {
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
		Page page = new Page();
		
		int count = servce.getTotalCount();
		page.setTotalCount(count);//总数据
		
		String string = request.getParameter("countPage");
		if (string == null) {
			string = "1";
		}
		int countPage = Integer.parseInt(string);
		page.setCurrentPage(countPage);//当前页
		
		int pageSize = 3;
		page.setPageSize(pageSize);//页面大小
		
		page.setTotalPage();//计算页面总数
		
		List<Student> list = servce.queryStudentByPage(countPage, pageSize);
		page.setStudent(list);//页面数据
		
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("QueryAllStudent.jsp").forward(request, response);
//		list.stream().forEach(name->System.out.println(name));
//		System.out.println(count);

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
