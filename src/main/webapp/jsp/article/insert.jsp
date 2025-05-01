<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- ctrl shift c -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.tailwindcss.com"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
<title>Write Article</title>
<style>
  
form {
	max-width: 800px; 
	margin: auto;
	
}
section {
	text-align: center;
}
input, textarea {
	width: 100%;
}
</style>
</head>
<body>

	<h2 style="text-align: center;">
		Article Write
	</h2>



	<form action="doWrite" method="POST">
		
		<div style="display:flex; flex-direction:column; justify-content: center;">
  			<section><input type="text" name="title" placeholder="제목을 입력하세요" /></section>
  			<br>
  			<section><textarea  style="height:400px;" name="body" placeholder="내용을 입력하세요"></textarea></section>
  			<br>
 		</div>
  		<button type="submit">작성하기</button>
  		
	</form>

</body>
</html>