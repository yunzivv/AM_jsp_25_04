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
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.tailwindcss.com"></script>
<style>
body, li, ul {
	list-style: none;
}
.main {
 height: 100vh;
 border: red solid 1px;
}

a {
	text-decoration: none;
}
</style>
<script type="text/javascript">
function black(){
$("div").click(fuction(){
	$(this).css("background-color", "black");
});
}

black();
</script>
<title>Article Manager</title>
</head>
<body>
	<%@ include file="../part/top-bar.jspf"%>
	<div class="main text-9xl font-bold text-left text-neutral-800 pl-20 pt-20">
		<span class="block">NINZA</span>
		<span class="block">ACADEMY</span>
	</div>

	<div class="text-center text-neutral-400;">
		<button>
			<a href="../article/list">리스트</a>
		</button>
	</div>

<%@ include file="../part/footer.jspf"%>
<%@ include file="../part/member.jspf"%>

</body>
</html>