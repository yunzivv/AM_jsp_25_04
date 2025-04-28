<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<Map<String, Object>> articleRows = (List<Map<String, Object>>) request.getAttribute("articleRows");

int cPage = (int) request.getAttribute("page");
int totalPage = (int) request.getAttribute("totalPage");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<style>
body {
	text-align: center;
}

table {
	margin: 10px auto;
}
a {
	color: inherit;
	text-decoration: none;
	margin: 2px;
}

a:hover {
	font-weight: bold;
	text-decoration: underline;
}
table>thead>tr>th, table>tbody>tr>td {
	padding: 10px;
}
</style>
</head>
<body>
	<h2>게시글 목록</h2>

	<button>
		<a href="../home/main">메인으로 이동</a>
	</button>
	<button>
		<a href="writeForm">새 글 작성</a>
	</button>

	<table style="border-collapse: collapse;"
		border="1px">
		<thead>
			<tr>
				<th>번호</th>
				<th>날짜</th>
				<th>제목</th>
				<th>내용</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Map<String, Object> articleRow : articleRows) {
			%>
			<tr style="text-align: center;">
				<td><%=articleRow.get("id")%>번</td>
				<td><%=articleRow.get("regDate").toString().substring(0, 10) %></td>
				<td><a href="detail?id=<%=articleRow.get("id")%>"><%=articleRow.get("title")%></a></td>
				<td><%=articleRow.get("body")%></td>
				<td><a
						onclick="if ( confirm('정말 삭제하시겠습니까?') == false ) { return false; }"
						href="doDelete?id=<%=articleRow.get("id")%>">delete</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<style type="text/css">
	.page {
		font-size: 1rem;
	}

	.page > a {
		color: gray;
		text-decoration: none;
	}

.page>a.cPage {
	color: black;
	font-weight: bold;
}
</style>

	<div class="page">
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