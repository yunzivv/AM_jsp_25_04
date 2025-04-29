<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
boolean isLogined = (boolean) request.getAttribute("isLogined");
String loginedMemberLoginId = (String) request.getAttribute("loginedMemberLoginId");
Map<String, Object> loginedMember = (Map<String, Object>) request.getAttribute("loginedMember");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
body, li, ul {
	text-align : center;
	list-style: none;
}

a {
	text-decoration: none;
	color: black;
}
</style>
<title>Article Manager</title>
</head>
<body>
	<h1>메인 페이지</h1>

	<div style="text-align:center;">
		<button><a href="../article/list">리스트</a></button>
		<button><a href="<%=isLogined ? "../member/mypage" : "../member/loginForm"%>">마이페이지</a></button>
		<%if(!isLogined) {%> 
		<button><a href="../member/joinForm">회원가입</a></button>
		<button><a href="../member/loginForm">로그인</a></button>
		<%} %>	
		
		<%if(isLogined) {%> 
		<button><a href="../member/logout">로그아웃</a></button>
		<%} %>	
	</div>
	
</body>
</html>