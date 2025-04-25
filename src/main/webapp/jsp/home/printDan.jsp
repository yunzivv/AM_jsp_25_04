<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
int dan = Integer.parseInt(request.getParameter("dan"));
int limit = Integer.parseInt(request.getParameter("limit"));
String color = request.getParameter("color");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>


</head>
<body>
	<h2>Main page 
	</h2>
	
	<ul>
		<li>
			<a href="../article/list">show list</a>
		</li>
	</ul>

</body>
</html>