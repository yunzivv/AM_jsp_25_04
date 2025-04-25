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
		Modify
	</h2>

	<form>
 		Title :<br>
  		<input type="text" name="title" placeholder="수정할 제목 입력"><br>
  		Body :<br>
  		<input type="textarea" name="body" placeholder="수정할 내용 입력"><br>
	</form>


	<button><a onClick="if ( confirm('수정하시겠습니까?') == false ) { return false; })" 
	href="#">수정</a></button>
	
	

</body>
</html>