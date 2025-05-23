<%@page import="java.util.*"%>
<%@page import="com.KoreaIT.java.AM_jsp.dto.Article"%>
<%@page import="com.KoreaIT.java.AM_jsp.dto.Member"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Article article = (Article) request.getAttribute("article");
int loginedMemberId = (int) request.getAttribute("loginedMemberId");
boolean writerCheck = (Integer)article.getLoginId() == loginedMemberId;
boolean isLogined = (boolean) request.getAttribute("isLogined");

Member loginedMember = (Member) request.getAttribute("loginedMember");
String loginedMemberLoginId = (String) request.getAttribute("loginedMemberLoginId");

String methodName = (String) request.getAttribute("methodName");
%>

<!-- ctrl shift c -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.tailwindcss.com"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
<style>
.container {
	max-width: 1000px;
	min-width: 300px;
	margin: 30px auto;
}

a {
	color: inherit;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}

span {
	margin-right: 20px;
}
</style>
<title>Article <%=article.getId()%></title>
</head>
<body>
	<%@ include file="../part/top-bar.jspf"%>
	<button onclick="history.back()" class="block text-4xl pl-10 pt-6 cursor-pointer">
		<i class="fa-solid fa-angle-left"></i>
	</button>
	<div class="container"
		style="border: gray solid 1px; border-radius: 30px; padding: 20px 30px;">

		<div class="header" style="padding: 10px;">
			<div class="title" style="font-size: 1.7rem; font-weight: 500;"><%= article.getTitle() %></div>

			<div class="articleInfo"
				style="display: flex; justify-content: space-between;">
				
				<div class="writeInfo" style="color: gray;">
					<span> 작성 일자 : <%=article.getRegDate().toString().substring(0, 10)%></span>
					<span> 작성자 : <%= article.getWriter() %></span>
					<span> 조회수 : <%=article.getHit() %></span>
				</div>
				<%if(writerCheck) { %>
				<div class="articleBtn">
					<button>
						<a href="modify?id=<%=article.getId()%>">modify</a>
					</button>
					<button>
						<a onClick="if ( confirm('정말 삭제할거야? ㅠㅠ😢?') == false ) { return false; })"
							href="doDelete?id=<%=article.getId()%>">delete</a>
					</button>
				</div>
				<%} %>
			</div>
		</div>
		<hr style="color: gray;"/>

		<div class="content" style="padding: 10px;">
			<%=article.getBody()%>
		</div>

	</div>

<!-- 	<h2> -->
<!-- 		Article -->
<%-- 		<%=articleRow.get("id")%> --%>
<!-- 		Detail -->
<!-- 	</h2> -->

<!-- 	<button> -->
<%-- 		<a href="modifyForm?id=<%=articleRow.get("id")%>">modify</a> --%>
<!-- 	</button> -->

<!-- 	<button> -->
<!-- 		<a -->
<!-- 			onClick="if ( confirm('정말 삭제할거야? ㅠㅠ😢?') == false ) { return false; })" -->
<%-- 			href="doDelete?id=<%=articleRow.get("id")%>">delete</a> --%>
<!-- 	</button> -->

<!-- 	<h3> -->
<!-- 		regDate : -->
<%-- 		<%=articleRow.get("regDate").toString().substring(0, 10)%> --%>
<!-- 	</h3> -->
<!-- 	<h3> -->
<!-- 		updateDate : -->
<%-- 		<%=articleRow.get("updateDate").toString().substring(0, 10)%> --%>
<!-- 	</h3> -->
<!-- 	<h3> -->
<!-- 		writer : -->
<%-- 		<%=articleRow.get("loginId")%> --%>
<!-- 	</h3> -->
<!-- 	<h3> -->
<!-- 		title : -->
<%-- 		<%=articleRow.get("title")%> --%>
<!-- 	</h3> -->
<!-- 	<h3> -->
<!-- 		body : -->
<%-- 		<%=articleRow.get("body")%> --%>
<!-- 	</h3> -->

</body>
</html>