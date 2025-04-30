<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.KoreaIT.java.AM_jsp.dto.Article"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
boolean isLogined = (boolean) request.getAttribute("isLogined");
List<Article> articles = (List<Article>) request.getAttribute("articles");
Map<String, Object> loginedMember = (Map<String, Object>) request.getAttribute("loginedMember");

int cPage = (int) request.getAttribute("page");
int totalPage = (int) request.getAttribute("totalPage");
int totalCnt = (int) request.getAttribute("totalCnt");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<style>
body {
	text-align: center;
}

table {
	margin: 10px auto;
}

a {
	color: inherit;
	text-decoration: none;
	margin: 2px;
}

a:hover {
	text-decoration: underline;
}

table>thead>tr>th, table>tbody>tr>td {
	padding: 10px;
}

.page {
	font-size: 1rem;
}

.page > a {
	color: gray;
	text-decoration: none;
}

.page>a.cPage {
	color: black;
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="header" style="max-width: 1000px; margin:auto; padding:20px;">
		<div class="title"><h2>게시글 목록</h2></div>
		<%@ include file="../part/top-bar.jspf" %>
		<div style="display:flex; background-color: red;">
			<button><a href="../home/main">메인으로 이동</a></button>
			<form action="" style="flex-grow:1;" >
				<input type="text" place-holder="search keyword" style="height:30px; margin: 0 10px; width: 100%;"/>
			</form>
<!-- 			<div class="searchBox" style="border:1px solid black; boder-ladius:10px; height: 30px; flex-grow:1;"></div> -->
			<button><a href="write" >새 글 작성</a></button>
		</div>
	</div>

	
	<div class="container">
	총 게시물 : <%=totalCnt %>개
	</div>
	
	<table style="border-collapse: collapse;"
		border="1px">
		<thead>
			<tr>
				<th>번호</th>
				<th>날짜</th>
				<th>제목</th>
<!-- 				<th>내용</th> -->
				<th>작성자</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Article article : articles) {
			%>
			<tr style="text-align: center;">
				<td><%=article.getId()%>번</td>
				<td><%=article.getRegDate().toString().substring(0,10) %></td>
				<td><a href="detail?id=<%=article.getId()%>"><%=article.getTitle()%></a></td>
				<td><%=article.getRegDate()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<div class="page">
		<%
		for (int i = 1; i <= totalPage; i++) {
		%>
		<a class="<%=cPage == i ? "cPage" : ""%>" href="list?page=<%=i%>"><%=i%></a>
		<%
		}
		%>

	</div>

</body>
</html>