package com.xxxxx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxxxx.entity.Student;
import com.xxxxx.servce.IStudentServce;
import com.xxxxx.servce.impl.StudentServceImpl;

/**
 * Servlet implementation class QueryOneStudentServlet
 */
@WebServlet("/QueryOneStudentServlet")
public class QueryOneStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryOneStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
//		StudentDao studentDao = new StudentDao();
		IStudentServce servce = new StudentServceImpl();
		String Sno = request.getParameter("sno");
//		Student student = studentDao.queryStudentBySno(Sno);
		Student student = servce.queryOneStudent(Sno);
		request.setAttribute("student", student);
		request.getRequestDispatcher("QueryOneSyudent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
