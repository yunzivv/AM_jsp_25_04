<%@page import="java.util.List"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Map<String, Object> articleRow = (Map<String, Object>) request.getAttribute("articleRow");
%>

<!-- ctrl shift c -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>Article <%=articleRow.get("id")%></title>
</head>
<body>

	<div class="container"
		style="border: gray solid 1px; border-radius: 30px; padding: 20px 30px;">

		<div class="header" style="padding: 10px;">
			<div class="title" style="font-size: 1.7rem; font-weight: 500;"><%=articleRow.get("title")%></div>

			<div class="articleInfo"
				style="display: flex; justify-content: space-between;">
				
				<div class="writeInfo" style="color: gray;">
					<span> 작성 일자 : <%=articleRow.get("regDate").toString().substring(0, 10)%></span>
					<span> 작성자 : <%=articleRow.get("loginId")%></span>
				</div>
				
				<div class="articleBtn">
					<button>
						<a href="modifyForm?id=<%=articleRow.get("id")%>">modify</a>
					</button>
					<button>
						<a onClick="if ( confirm('정말 삭제할거야? ㅠㅠ😢?') == false ) { return false; })"
							href="doDelete?id=<%=articleRow.get("id")%>">delete</a>
					</button>
				</div>
				
			</div>
		</div>
		<hr style="color: gray;"/>

		<div class="content" style="padding: 10px;">
			<%=articleRow.get("body")%>
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