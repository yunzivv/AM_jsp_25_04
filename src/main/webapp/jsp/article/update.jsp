<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.KoreaIT.java.AM_jsp.dto.Article"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Article article = (Article) request.getAttribute("article");
int id = (int) request.getAttribute("id");
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