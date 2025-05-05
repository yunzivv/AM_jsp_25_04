<%@page import="java.util.*"%>
<%@page import="com.KoreaIT.java.AM_jsp.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
boolean isLogined = (boolean) request.getAttribute("isLogined");
String loginedMemberLoginId = (String) request.getAttribute("loginedMemberLoginId");
Member loginedMember = (Member) request.getAttribute("loginedMember");

String methodName = (String) request.getAttribute("methodName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
body, li, ul {
	list-style: none;
}

a {
	text-decoration: none;
}
</style>

<title>Article Manager</title>
</head>
<body>

	<%@ include file="../part/top-bar.jspf"%>
	<div class="main h-screen text-9xl font-bold text-left text-neutral-800 pl-20 pt-20">
		<span class="block">NINZA</span>
		<span class="block">ACADEMY</span>
	</div>


<%@ include file="../part/footer.jspf"%>
<%@ include file="../part/member.jspf"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.tailwindcss.com"></script>

</body>
</html>