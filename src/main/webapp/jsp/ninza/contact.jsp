<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo</title>

</head>
<style>
.contact-box {
	font-size: 10rem;
	font-weight: bold;
}
</style>
<body class="relative h-screen">
	<div class="contact-box absolute top-1/2 left-8 -translate-y-1/2 text-neutral-800">
		<div>
			<span class="You hidden">You</span>
			<span class="can hidden">can</span>
		</div>
		<div>
			<span class="never hidden">never</span>
			<span class="contact hidden">contact</span>
			<span class="a hidden">a</span>
			<span class="ninza hidden">ninza</span>
		</div>
	</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.tailwindcss.com"></script>
	
<script type="text/javascript">
	setTimeout(function() {
		$(".You").show();
	}, 500);
	setTimeout(function() {
		$(".can").show();	
	}, 900);
	setTimeout(function() {
		$(".never").show();
	}, 1200);
	setTimeout(function() {
		$(".contact").show();
	}, 1600);
	setTimeout(function() {
		$(".a").show();
	
	}, 2000);
	setTimeout(function() {
		$(".ninza").show();
	}, 2300);
	
	setTimeout(function() {
	    window.history.back();
	}, 3000);
</script>
</body>
</html>