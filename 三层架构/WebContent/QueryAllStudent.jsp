<%@page import="com.xxxxx.entity.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	/*居中对齐*/
	text-align: center;
}
</style>
</head>
<body>
<% 
	Page page1=(Page)request.getAttribute("page");
	/*
		在分页显示的前提下:显示数据jsp需要哪些数据:
		当前页  currentPage
		页面大小  pageSize 
		当前页的数据集合  students
		总数据  totalCount
		总页数  totalPage 
		新建Page类，用于封装以上5个字段
	*/
%>

	<table border="2px" width="50%" cellspacing="0" cellpadding="6">
		<caption>用户信息</caption>
		<tr>
			<td>学号</td>
			<td>名字</td>
			<td>性别</td>
			<td>年龄</td>
			<td>院系</td>
			<td>入学日期</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${requestScope.page.student }" var="stu">
			<tr>
				<td><a href="QueryOneStudentServlet?sno=${stu.sno }">${stu.sno }</a></td>
				<td>${stu.name }</td>
				<td>${stu.sex }</td>
				<td>${stu.age }</td>
				<td>${stu.sdept }</td>
				<td>${stu.date }</td>
				<td><a href="DeleteServlet?sno=${stu.sno }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="Register.jsp">添加</a>
	<a href="queryStudentByPageServlet?countPage=1">首页</a>
	<a href="queryStudentByPageServlet?countPage=<%=page1.getCurrentPage()-1%>">
		<c:if test="${requestScope.page.currentPage!=1 }">
			上一页
		</c:if>
	</a>
	<a href="queryStudentByPageServlet?countPage=<%=page1.getCurrentPage()+1%>">
		<c:if test="${requestScope.page.currentPage!=requestScope.page.totalPage }">
			下一页
		</c:if>
	</a>
	<a href="queryStudentByPageServlet?countPage=<%=page1.getTotalPage()%>">尾页</a>
	&emsp;<%=page1.getCurrentPage() %>/<%=page1.getTotalPage()%>
</body>
</html>