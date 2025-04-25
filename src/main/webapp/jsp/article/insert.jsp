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
input {
	width: 800px;
}
</style>
</head>
<body>

	<h2>
		Article Write
	</h2>

	<button>
		작성하기
	</button>

	<form>
 		Title :<br>
  		<input type="text" name="title" placeholder="제목 입력"><br>
  		Body :<br>
  		<input type="textarea" name="body" placeholder="내용 입력"><br>
	</form>

</body>
</html>