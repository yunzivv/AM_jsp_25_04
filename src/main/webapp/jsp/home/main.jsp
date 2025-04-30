<%@page import="java.util.*"%>
<%@page import="com.KoreaIT.java.AM_jsp.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
boolean isLogined = (boolean) request.getAttribute("isLogined");
String loginedMemberLoginId = (String) request.getAttribute("loginedMemberLoginId");
Member loginedMember = (Member) request.getAttribute("loginedMember");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
body, li, ul {
	text-align: center;
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
	<div class="header" style="display:flex; background-color: red;">
	<h1 style="flex-grow:1; text-align: center">메인 페이지</h1>
		<%@ include file="../part/top-bar.jspf"%>	
	</div>

	<div style="text-align: center;">
		<button>
			<a href="../article/list">리스트</a>
		</button>
	</div>

</body>
</html>