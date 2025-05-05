<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String methodName = (String) request.getAttribute("methodName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.tailwindcss.com"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
<title>My Page</title>
<style>

</style>
</head>
<body>
	<%@ include file="../part/top-bar.jspf"%>

	<div class="title text-neutral-800 text-8xl font-bold my-8 px-10 bg-red-300">
		<span>
		NINZA PROFILE
		</span>
	</div>
</body>
</html>