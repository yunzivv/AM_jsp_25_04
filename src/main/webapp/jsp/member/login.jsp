<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member join</title>
<script type="text/javascript">
//    function validate() {
//         let re = /^[a-zA-Z0-9]{4,12}$/ // 아이디와 패스워드가 적합한지 검사할 정규식
//    		let re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; // 이메일이 적합한지 검사할 정규식

//    		var loginId = document.getElementById("loginId");
//    		var loginPw = document.getElementById("loginPw");

//        if(!check(re, loginId,"아이디는 4~12자의 영문 대소문자와 숫자로만 입력")) {
//        	   return false;
//        }

//        if(!check(re, loginPw,"패스워드는 4~12자의 영문 대소문자와 숫자로만 입력")) {
//            return false;
//        }
//    }
//    function check(re, what, message) {
//        if(re.test(what.value)) {
//            return true;
//        }
//        alert(message);
//        what.value = "";
//        what.focus();
//    }
</script>
</head>
<body>

	<h2 style="text-align: center;">
		로그인
	</h2>

	<form name="login" action="doLogin" method="POST">  <!-- onsubmit="return validate();" -->
		
		<div style="display:flex; flex-direction:column; justify-content: center;">
  			<section> 아이디 : <input type="text" name="loginId" id="loginId" /></section>
  			<br>
  			<section> 비밀번호 : <input type="password" autocomplete="off" name="loginPw" id="loginPw" /></section>
 		</div>
  		<button type="submit">작성하기</button>
  		
	</form>
</body>
</html>