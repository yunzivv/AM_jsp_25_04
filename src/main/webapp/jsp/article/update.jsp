<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

Map<String, Object> articleRow = (Map<String, Object>) request.getAttribute("articleRow");
%>

<!-- ctrl shift c -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail Article</title>
<style>

h2, section {
	text-align: center;
}
input, textarea {
	width: 700px;
}
</style>
</head>
<body>

	<h2>
		Article
		<%=articleRow.get("id") %>
		Modify
	</h2>
<%-- detail?id=<%=articleRow.get("id")%> --%>
	<form action="doModify" method="GET">
	<div style="display:flex; flex-direction:column; justify-content: center;">
  		<section><input type="text" name="title" value="<%=articleRow.get("title") %>"></section>
  		<br>
  		<section><textarea><%=articleRow.get("body") %></textarea></section>
  		<br>
  		<section><input type="submit" value="수정하기"></section>
  	</div>
	</form>
	

</body>
</html>