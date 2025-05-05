<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String methodName = (String) request.getAttribute("methodName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo</title>
<%-- <script src="${pageContext.request.contextPath}/resources/js/index.global.min.js"></script> --%>

</head>
<body>
	<%@ include file="../part/top-bar.jspf"%>
	
	<div class="title text-neutral-800 text-8xl font-bold my-8 px-10 bg-red-300">
		<span>
		Dojo
		</span>
	</div>
		
	<div id="calendar"></div>

<!-- <script> -->
//   document.addEventListener('DOMContentLoaded', function () {
//     var calendarEl = document.getElementById('calendar');
//     var calendar = new FullCalendar.Calendar(calendarEl, {
//       plugins: [FullCalendar.dayGridPlugin],
//       initialView: 'dayGridMonth'
//     });
//     calendar.render();
//   });
<!-- </script> -->
</body>
</html>