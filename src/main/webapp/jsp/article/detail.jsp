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
</head>
<body>

	<h2>
		Article
		<%=articleRow.get("id") %>
		Detail
	</h2>

	<button>modify</button>
	<button onClick="alert('정말 삭제할거야? ㅠㅠ😢')">delete</button>
	
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
	<%=articleRow.get("memberId") %>
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