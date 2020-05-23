<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 引入jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	function check() {
		var sno = $("#sno").val();
		if(!(sno.length==9)){
			alert("学号格式不对")
			return false; 
		}
		return true;
	}

</script>
</head>
<body>
	<form action="RegisterrServlet" method="post" onsubmit="return check()">
		学号：<input type="text" name="sno" id="sno"><br /> 
		姓名：<input type="text" name="name" id="name"><br /> 
		性别：<input type="text" name="sex" id="sex"><br /> 
		年龄：<input type="number" name="age" id="age"><br /> 
		院系：<input type="text" name="sdept" id="sdept"><br /> 
		日期：<input type="date" name="date" id="date"><br />
		<input type="submit" value="提交">
	</form>
</body>
</html>