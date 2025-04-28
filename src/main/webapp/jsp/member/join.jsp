<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
List<Map<String, Object>> memberRows = (List<Map<String, Object>>) request.getAttribute("memberRows");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member join</title>
<script language="javascript">
   function validate() {
        let re = /^[a-zA-Z0-9]{4,12}$/ // 아이디와 패스워드가 적합한지 검사할 정규식
   		let re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; // 이메일이 적합한지 검사할 정규식

   		var loginId = document.getElementById("loginId");
   		var loginPw = document.getElementById("loginPw");
   		var checkLoginPw = document.getElementById("checkLoginPw");
   		var email = document.getElementById("email");

       if(!check(re, loginId,"아이디는 4~12자의 영문 대소문자와 숫자로만 입력")) {
       	   return false;
       }

       if(!check(re, loginPw,"패스워드는 4~12자의 영문 대소문자와 숫자로만 입력")) {
           return false;
       }
       
       for(Map member : memberRows){
      	  if(member.get(loginId).equals((String)join.loginId.value)){
      	  	alert("중복된 아이디이빈다.");
      	    join.loginId.value = "";
      	    join.loginId.focus();
      	   return false;
      	  }
       }

       if(join.loginPw.value != join.checkLoginPw.value) {
           alert("비밀번호가 다릅니다. 다시 확인해 주세요.");
           join.checkLoginPw.value = "";
           join.checkLoginPw.focus();
           return false;
       }

       if(email.value=="") {
           alert("이메일을 입력해 주세요");
           email.focus();
           return false;
       }

       if(!check(re2, email, "적합하지 않은 이메일 형식입니다.")) {
           return false;
       }

       if(join.name.value=="") {
           alert("이름을 입력해 주세요");
           join.name.focus();
           return false;
       }
   }
   function check(re, what, message) {
       if(re.test(what.value)) {
           return true;
       }
       alert(message);
       what.value = "";
       what.focus();
           //return false;
   }
</script>
</head>
<body>

	<h2 style="text-align: center;">
		회원가입
	</h2>

	<form onsubmit="return validate();" name="join" action="doJoin" method="POST">
		
		<div style="display:flex; flex-direction:column; justify-content: center;">
  			<section><input type="text" name="loginId" id="loginId" placeholder="아이디 입력" /></section>
  			<br>
  			<section><input type="password" name="loginPw" id="loginPw" placeholder="비밀번호 입력" /></section>
  			<br>
  			<section><input type="password" name="checkLoginPw" id="checkLoginPw" placeholder="비밀번호 확인" /></section>
  			<br>
  			<section><input type="email" name="email" id="email" placeholder="이메일 입력" /></section>
  			<br>
  			<section><input type="text" name="name" id="name" placeholder="이름 입력" /></section>
  			<br>
 		</div>
  		<button type="submit">작성하기</button>
  		
	</form>
</body>
</html>