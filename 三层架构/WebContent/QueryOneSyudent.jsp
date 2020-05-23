<%@page import="com.xxxxx.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Student student = (Student)request.getAttribute("student");
%>
<form action="UpdateStudent" method="post">
		学号：<input type="text" name="sno" value="${requestScope.student.sno }" readonly="readonly"><br /> 
		姓名：<input type="text" name="name" value="${requestScope.student.name }"><br /> 
		性别：<input type="text" name="sex" value="${requestScope.student.sex }"><br /> 
		年龄：<input type="number" name="age" value="${requestScope.student.age }"><br /> 
		院系：<input type="text" name="sdept" value="${requestScope.student.sdept }"><br /> 
	 	日期：<input type="date" name="date" value="${requestScope.student.date }"><br />
		<input type="submit" value="修改信息"><a href="queryStudentByPageServlet">返回</a>
	
</form>
</body>
</html>