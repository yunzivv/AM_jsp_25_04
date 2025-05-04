<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.tailwindcss.com"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
<title>Member join</title>
<style>
</style>
<script type="text/javascript">
   function validate() {
        let re = /^[a-zA-Z0-9]{4,12}$/ // 아이디와 패스워드가 적합한지 검사할 정규식
   		let re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; // 이메일이 적합한지 검사할 정규식

   		var loginId = document.getElementById("loginId");
   		var loginPw = document.getElementById("loginPw");
   		var checkLoginPw = document.getElementById("checkLoginPw");

       if(!check(re, loginId,"아이디는 4~12자의 영문 대소문자와 숫자로만 입력")) {
       	   return false;
       }

       if(!check(re, loginPw,"패스워드는 4~12자의 영문 대소문자와 숫자로만 입력")) {
           return false;
       }

       if(join.loginPw.value != join.checkLoginPw.value) {
           alert("비밀번호가 다릅니다. 다시 확인해 주세요.");
           join.checkLoginPw.value = "";
           join.checkLoginPw.focus();
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

<!-- 	<form onsubmit="return validate();" name="join" action="doJoin" method="POST"> -->
		
<!-- 		<div style="display:flex; flex-direction:column; justify-content: center;"> -->
<!--   			<section> 아이디 : <input type="text" name="loginId" id="loginId" placeholder="4~12자의 영문 대소문자와 숫자" /></section> -->
<!--   			<br> -->
<!--   			<section> 비밀번호 : <input type="password" autocomplete="off" name="loginPw" id="loginPw" placeholder="4~12자의 영문 대소문자와 숫자" /></section> -->
<!--   			<br> -->
<!--   			<section> 비밀번호 확인 : <input type="password" autocomplete="off" name="checkLoginPw" id="checkLoginPw" placeholder="비밀번호 확인" /></section> -->
<!--   			<br> -->
<!--   			<section> 이름 : <input type="text" name="name" id="name" placeholder="이름 입력" /></section> -->
<!--   			<br> -->
<!--  		</div> -->
<!--   		<button type="submit">작성하기</button> -->
  		
<!-- 	</form> -->
	
	<div class="container mx-auto mt-32 max-w-min p-4 bg-neutral-200 border border-solid border-neutral-300 rounded-lg">
		<div class="title mt-4 mb-8 text-center text-2xl font-semibold">
			 Join Ninza
		</div>
		<form onsubmit="return validate();" name="join" action="doJoin" method="POST">
			
			<div style="display:flex; flex-direction:column; justify-content: center;">
	  			
				<input type="text" name="loginId" id="loginId" class="bg-neutral-50 border border-neutral-300 text-neutral-800 text-sm rounded-lg block w-96 p-2.5" placeholder="Ninza ID">
				<div class="text-neutral-400 mb-6 px-2">Enter at least 4 letters and numbers</div>
				<input type="password" name="loginPw" id="loginPw" class="bg-neutral-50 border border-neutral-300 text-neutral-800 text-sm rounded-lg block w-96  p-2.5" placeholder="Ninza Password">
				<div class="text-neutral-400 mb-6 px-2">Enter at least 4 letters and numbers</div>
				<input type="password" name="checkLoginPw" id="checkLoginPw" class="bg-neutral-50 border border-neutral-300 text-neutral-800 text-sm rounded-lg block w-96  p-2.5" placeholder="Ninza Password Check">
				<div class="text-neutral-400 mb-6 px-2">Enter your password again to confirm it</div>
				<input type="text" name="name" id="name" class="mb-6 bg-neutral-50 border border-neutral-300 text-neutral-800 text-sm rounded-lg block w-96  p-2.5" placeholder="Ninza Name">
	 		</div>
	 		<button type="submit" class="py-2.5 px-5 me-2 mb-2 w-96 text-sm font-large bg-neutral-800 text-neutral-200 rounded-lg hover:bg-neutral-700">Join</button>
		</form>
		<div class="sub-menu text-center my-4 flex justify-center">
			<a class="hover:text-underline" href="login">Ninja Login</a>	
		</div>
	</div>
</body>
</html>