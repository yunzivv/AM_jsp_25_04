<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.tailwindcss.com"></script>
<title>Member join</title>

</head>
<body>
	<h2 style="text-align: center;">
		로그인
	</h2>

	<form name="login" action="doLogin" method="POST">
		
		<div style="display:flex; flex-direction:column; justify-content: center;">
  			<section> 아이디 : <input type="text" name="loginId" id="loginId" /></section>
  			<br>
  			<section> 비밀번호 : <input type="password" autocomplete="off" name="loginPw" id="loginPw" /></section>
 		</div>
  		<button type="submit">작성하기</button>
  		
	</form>
</body>
</html>