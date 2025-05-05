<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.KoreaIT.java.AM_jsp.dto.Article"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Article article = (Article) request.getAttribute("article");
int id = (int) request.getAttribute("id");
String methodName = (String) request.getAttribute("methodName");
%>

<!-- ctrl shift c -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.tailwindcss.com"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
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
	<a class="block text-2xl pt-2 pl-2" href="detail?id=<%=id%>"><i class="fa-solid fa-angle-left"></i></a>
	<h2>
		Article
		<%=id%>
		Modify
	</h2>
	<form action="doModify" method="POST">
		<div
			style="display: flex; flex-direction: column; justify-content: center;">
			<input type="hidden" name="id" value="<%=id%>">
			<section>
				<input type="text" name="title" value="<%=article.getTitle()%>">
			</section>
			<br>
			<section>
				<textarea name="body"><%=article.getBody()%></textarea>
			</section>
			<br>
			<section>
				<button type="submit">수정하기</button>
			</section>
		</div>
	</form>


</body>
</html>