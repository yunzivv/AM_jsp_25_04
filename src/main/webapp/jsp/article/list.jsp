<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.KoreaIT.java.AM_jsp.dto.Article"%>
<%@page import="com.KoreaIT.java.AM_jsp.dto.Member"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
boolean isLogined = (boolean) request.getAttribute("isLogined");
List<Article> articles = (List<Article>) request.getAttribute("articles");
Member loginedMember = (Member) request.getAttribute("loginedMember");

int cPage = (int) request.getAttribute("page");
int totalPage = (int) request.getAttribute("totalPage");
int totalCnt = (int) request.getAttribute("totalCnt");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.tailwindcss.com"></script>
<title>게시글 목록</title>
<style>
body {
	text-align: center;
}


a {
	color: inherit;
	text-decoration: none;
	margin: 2px;
}

a:hover {
	text-decoration: underline;
}

table > tbody >tr:last-child {
	border : 0px;
}


.page {
	font-size: 1rem;
}

.page>a {
	color: gray;
	text-decoration: none;
}

.page>a.cPage {
	color: black;
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="bg-yellow-200">
	<%@ include file="../part/top-bar.jspf"%></div>
	<div class="header w-4/5 min-w-max m-auto p-10 bg-blue-300">
		<div class="title">
			<h2>게시글 목록</h2>
		</div>
		<div style="display: flex; background-color: red;">
			<button>
				<a href="../home/main">메인으로 이동</a>
			</button>
			<form action=""
				style="display: flex; flex-grow: 1; background-color: blue;">
				<input type="text" place-holder="search keyword"
					style="display: block; flex-grow: 1;" />
			</form>
			<!-- 			<div class="searchBox" style="border:1px solid black; boder-ladius:10px; height: 30px; flex-grow:1;"></div> -->
			<button>
				<a href="write">새 글 작성</a>
			</button>
		</div>
	</div>


	<div class="container"
		style="width: 90vw; min-width: 500px; margin: auto; background-color: tomato;'">
		<div class="articleCnt">
			총 게시물 :
			<%=totalCnt%>개
		</div>
	</div>

	<div class="overflow-x-auto shadow-md sm:rounded-lg w-11/12 m-auto border-solid border">
		<table
			class="w-full text-sm text-left rtl:text-right text-gray-800 dark:text-gray-400">
			<thead
				class="text-base text-gray-200 bg-gray-800">
				<tr>
					<th scope="col" class="px-5 py-3">NO</th>
<!-- 					<th scope="col" class="px-6 py-3">BOARD</th> -->
					<th scope="col" class="px-5 py-3 w-3/5">TITLE</th>
					<th scope="col" class="px-5 py-3">REGDATE</th>
					<th scope="col" class="px-5 py-3">WRITER</th>
					<th scope="col" class="px-5 py-3">HIT</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Article article : articles) {
				%>
				<tr
					class="border-b bg-gray-200 border-gray-300 text-gray-500">
					<td class="px-5 py-3"><%=article.getId()%></td>
<%-- 					<td class="px-6 py-4"><%=article.getBoard()%></td> --%>
					<td class="px-5 py-3 text-gray-800"><a href="detail?id=<%=article.getId()%>"><%=article.getTitle()%></td>
					<td class="px-5 py-3"><%=article.getRegDate().toString().substring(0, 10)%></td>
					<td class="px-5 py-3"><%=article.getWriter()%></td>
					<td class="px-5 py-3"><%=article.getHit()%></a>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>

	<div class="page text-gray-800">
		<%
		for (int i = 1; i <= totalPage; i++) {
		%>
		<a class="<%=cPage == i ? "cPage" : ""%>" href="list?page=<%=i%>"><%=i%></a>
		<%
		}
		%>

	</div>

</body>
</html>