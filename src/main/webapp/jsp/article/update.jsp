<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Map<String, Object> articleRow = (Map<String, Object>) request.getAttribute("articleRow");
int id = (int)request.getAttribute("id");
request.setAttribute("id", id);
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
		<%=id %>
		Modify
	</h2>
	<form action="doModify" method="GET">
	<div style="display:flex; flex-direction:column; justify-content: center;">
		<input type="hidden" name="id" value="<%=id%>">
  		<section><input type="text" name="title" value="<%=articleRow.get("title") %>"></section>
  		<br>
  		<section><textarea name="body"><%=articleRow.get("body") %></textarea></section>
  		<br>
  		<section><button type="submit">수정하기</button></section>
  	</div>
	</form>
	

</body>
</html>