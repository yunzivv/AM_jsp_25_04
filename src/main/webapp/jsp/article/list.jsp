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
String keyword = (String) request.getAttribute("keyword");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.tailwindcss.com"></script>
<title>게시글 목록</title>
<style>
a {
	color: inherit;
	text-decoration: none;
	margin: 2px;
}

a:hover {
	text-decoration: underline;
}

form > div {
	border: 1px solid oklch(21.6% 0.006 56.043);
	border-radius: 5px;
	overflow: hidden;
}

table>tbody>tr:last-child {
	border: 0px;
}

.page {
	font-size: 1rem;
}

.page>a {
	text-decoration: none;
}

.page>a.cPage {
	color: black;
	font-weight: bold;
}

/* input[type='date']::before { */
/*   content: attr(data-placeholder); */
/*   width: 100%; */
/*   text-align: center; */
/*   color: inherit; */
/* } */
</style>
</head>
<body>
	<div class="">

		<%@ include file="../part/top-bar.jspf"%></div>

	<div class="no-pilyo">
		<button>
			<a href="../home/main">메인으로 이동</a>
		</button>
		<button>
			<a href="write">새 글 작성</a>
		</button>
	</div>

	<div class="header w-4/5 min-w-max m-auto p-10 bg-blue-300">
		<div class="title text-center text-4xl font-bold">
			<span>ARTICLES</span>
		</div>
		<div style="display: flex; background-color: red;"></div>
	</div>


	<div class="aboutArticle w-11/12 m-auto bg-green-200">
		<div class="articleCnt">
			TOTAL :
			<%=totalCnt%>
		</div>
		<button><a href="write">WRITE</a></button>
		<form class="search-box flex text-neutral-400 h-8" action="list" method="POST">
			<div class="mx-2">
				<input type="date" name="start" class="block h-full"/> 
			</div>
			<div class="mx-2">
				<input type="date"  name="end" class="block h-full"/> 
			</div>
			<section class="flex-grow"></section>
			<div class="bg-neutral-800 mx-2 w-60 flex">
				<input type="text" name="keyword" placeholder="search keyword" 
				<%if(keyword.length() != 0) { %>
				value=<%=keyword %>
				<%} %>
				class="block flex-grow px-2"/>
				<button type="submit">
					<i class="fa-solid fa-magnifying-glass text-neutral-200 text-xl px-1"></i>
				</button>
			</div>
		</form>
	</div>

	<div
		class="overflow-x-auto w-11/12 mx-auto my-4 border-solid border bg-red-300">
		<!-- rounded-xl -->
		<table
			class="w-full text-sm text-center rtl:text-right text-neutral-800 text-neutral-400">
			<thead class="text-base text-neutral-200 bg-neutral-800">
				<tr>
					<th scope="col" class="px-5 py-3">NO</th>
					<!-- <th scope="col" class="px-6 py-3">BOARD</th> -->
					<th scope="col" class="px-5 py-3 w-3/5">TITLE</th>
					<th scope="col" class="px-5 py-3">WRITER</th>
					<th scope="col" class="px-5 py-3">REGDATE</th>
					<th scope="col" class="px-5 py-3">HIT</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Article article : articles) {
				%>
				<tr
					class="border-b bg-neutral-100 border-neutral-300 text-neutral-500">
					<td class="px-5 py-3"><%=article.getId()%></td>
					<%-- 					<td class="px-6 py-4"><%=article.getBoard()%></td> --%>
					<td><a class="block text-left pl-6"
						href="detail?id=<%=article.getId()%>"><%=article.getTitle()%></td>
					<td class="px-5 py-3"><%=article.getWriter()%></td>
					<td class="px-5 py-3"><%=article.getRegDate().toString().substring(0, 10)%></td>
					<td class="px-5 py-3"><%=article.getHit()%></a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>

	<div class="page text-neutral-800 text-center mb-16">
		<%
		for (int i = 1; i <= totalPage; i++) {
		%>
		<a class="<%=cPage == i ? "cPage" : ""%> mx-1.5"
			href="list?page=<%=i%>"><%=i%></a>
		<%
		}
		%>

	</div>

	<%@ include file="../part/footer.jspf"%>

</body>
</html>