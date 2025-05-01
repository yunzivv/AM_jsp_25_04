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
<script src="https://cdn.tailwindcss.com"></script>
<style>
body, li, ul {
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
	<%@ include file="../part/top-bar.jspf"%>
	<div class="header"
		style="display: flex; align-items: flex-end; background-color: red;">
		<h1 style="flex-grow: 1; text-align: center">메인 페이지</h1>
	</div>

	<div style="text-align: center;">
		<button>
			<a href="../article/list">리스트</a>
		</button>
	</div>
	
<!-- 	 sm:text-center  md:flex md:items-center md:justify-between-->

<!-- <footer class="bg-white rounded-lg shadow-sm m-4 dark:bg-gray-100"> -->
<!--     <div class="flex flex-col justify-start w-full mx-auto max-w-screen-xl p-6"> -->
<!-- 	    <ul class="flex flex-wrap items-center mt-3 text-sm font-medium text-gray-500 dark:text-gray-400 sm:mt-0"> -->
<!-- 	        <li> -->
<!-- 	            <a href="#" class="hover:underline me-4 md:me-6">About</a> -->
<!-- 	        </li> -->
<!-- 	        <li> -->
<!-- 	            <a href="https://onesquareminesweeper.com/" class="hover:underline me-4 md:me-6">Nothing</a> -->
<!-- 	        </li> -->
<!-- 	        <li> -->
<!-- 	            <a href="#" class="hover:underline me-4 md:me-6">FAQ</a> -->
<!-- 	        </li> -->
<!-- 	        <li> -->
<!-- 	            <a href="#" class="hover:underline">Contact</a> -->
<!-- 	        </li> -->
<!-- 	    </ul> -->
<!--       <span class="text-sm text-gray-800 dark:text-gray-400 mt-3">Created by <strong>yunzi</strong> © 2025 – No rights reserved -->
<!--     </span> -->
<!--     </div> -->
<!-- </footer> -->

<%@ include file="../part/footer.jspf"%>
	

</body>
</html>