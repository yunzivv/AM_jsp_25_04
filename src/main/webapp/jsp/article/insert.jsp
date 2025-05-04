<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String site = (String) request.getAttribute("site");
%>
<!-- ctrl shift c -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.tailwindcss.com"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
<title>Write Article</title>
<style>
form {
	max-width: 800px;
	margin: auto;
}

section {
	text-align: center;
}

input, textarea {
	width: 100%;
}
</style>
</head>
<body>

	<button onclick="history.back()" class="block text-4xl pl-10 pt-6 cursor-pointer">
		<i class="fa-solid fa-angle-left"></i>
	</button>
		
	<div class="container mx-auto mt-8 w-3/5">


		<div class="text-4xl text-neutral-800 px-14 py-6">Article Write</div>


		<form action="doWrite" method="POST" class="w-full">
			<div style="display: flex; flex-direction: column; justify-content: center;">
				<section>
					<input class="p-2 border border-neutral-200 border-solid rounded-md" type="text" name="title" placeholder="제목을 입력하세요" />
				</section>
				<br>
				<section>
					<textarea class="p-2 h-96 border border-neutral-200 border-solid rounded-md" name="body"
						placeholder="내용을 입력하세요"></textarea>
				</section>
				<br>
			</div>
			
			<div class="text-right px-2 pb-2">
			<button type="submit" class="py-2.5 px-5 w-32 text-base font-large bg-neutral-800 text-neutral-200 rounded-lg hover:bg-neutral-700">Write</button>
			</div>

		</form>
	</div>
</body>
</html>