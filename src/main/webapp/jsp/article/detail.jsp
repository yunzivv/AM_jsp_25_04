<%@page import="java.util.List"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

Map<String, Object> articleRow = (Map<String, Object>) request.getAttribute("articleRow");
String regDate = (String)articleRow.get("regDate");
%>

<!-- ctrl shift c -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
body {
	text-align: center;
}
a {
	color: inherit;
	text-decoration: none;
}

a:hover {
	font-weight: bold;
	text-decoration: underline;
}
</style>
<title>Detail Article</title>
</head>
<body>

	<div class="container" style="border:gray solid 1px; border-radius: 30px;">
	
		<div class="header">
			<div class="title"><%=articleRow.get("title") %></div>
			<div class="articleInfo"><%=regDate.substring(0,11) %></div>
		</div>
		<hr style="color:gray">
		<section class="body">
		
		</section>
	</div>
	<h2>
		Article
		<%=articleRow.get("id") %>
		Detail
	</h2>

	<button>
		<a href="modifyForm?id=<%=articleRow.get("id")%>">modify</a>
	</button>

	<button><a onClick="if ( confirm('정말 삭제할거야? ㅠㅠ😢?') == false ) { return false; })" 
	href="doDelete?id=<%=articleRow.get("id")%>">delete</a></button>
	
	<h3>
	regDate : 
	<%=articleRow.get("regDate") %>
	</h3>
	<h3>
	updateDate : 
	<%=articleRow.get("updateDate") %>
	</h3>
	<h3>
	writer : 
	<%=articleRow.get("loginId") %>
	</h3>
	<h3>
	title : 
	<%=articleRow.get("title") %>
	</h3>
	<h3>
	body : 
	<%=articleRow.get("body") %>
	</h3>

</body>
</html>