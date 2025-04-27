<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- ctrl shift c -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Article</title>
<style>

section {
	text-align: center;
}
input, textarea {
	width: 700px;
}
</style>
</head>
<body>

	<h2 style="text-align: center;">
		Article Write
	</h2>



	<form action="doInsert" method="GET">
		
		<div style="display:flex; flex-direction:column; justify-content: center;">
  			<section><input type="text" name="title" placeholder="제목을 입력하세요"></section>
  			<br>
  			<section><textarea  style="height:400px;" name="body" placeholder="내용을 입력하세요"></textarea></section>
  			<br>
  			<section><input type="submit" value="작성하기"></section>
 		</div>
  		
  		
	</form>

</body>
</html>