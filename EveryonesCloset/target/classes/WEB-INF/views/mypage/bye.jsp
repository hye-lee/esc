<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/esc/mypage.css">

<script>
	$(function(){
		$('#home').click(function(){
			location.href="/esc";
		});
		
	});

</script>




<div class="mypage_container">
	<hr>
	<h2 class="mypage_title">GOOD-BYE</h2>
	<div class="mypage_funcion">
		<h3 style="text-align: center;">탈퇴가 완료되었습니다.</h3>
		<h4 style="text-align: center;">이용해주셔서 감사합니다.</h4>
		</div>
		<div class="text-center btn-margin">
			<button class="btn btn-warning" id="home" name="home">HOME</button>
		</div>
</div>