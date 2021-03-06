<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src='https://www.google.com/recaptcha/api.js'></script>
<script type="text/javascript">

$(document).ready(function(){
	
	$('#findId').click(function(){
		location.href="${pageContext.servletContext.contextPath}/login/findId";
	});
	
	$('#findPw').click(function(){
		location.href="${pageContext.servletContext.contextPath}/login/findPw";
	});

});

function login(){
	var userID=$("#userID").val();
	var userPw=$("#userPw").val();
	console.log(userID);
	console.log(userPw);
	
	if(userID=="" || userPw==""){
			alert("아이디 혹은 비밀번호가 누락되었습니다.");
		}else{
			$.ajax({
				type: 'post',
				url: '${pageContext.servletContext.contextPath}'+'/trylogin',
				data: {
					userID:$('#userID').val(), userPw:$('#userPw').val()
				},
				error: function(request, status, error){
					console.log("code:"+request.status+"messege:"+request.responseText+"\n"+"error:"+error);
					}
				},1000)
				.done(function(msg){
					if(msg=="success"){
						console.log("로그인성공");
						window.location.reload();
					}else{
						alert("로그인실패!");
						$('#userID').val("");
						$('#userPw').val("");
					}
				})
				.fail(function(){
					alert("로그인실패!");
					$('#userID').val("");
					$('#userPw').val("");
				})
}
}

</script>

<style>
.bottom-text{
font-size: 16pt;
font-family: 'Roboto', sans-serif;
 margin-top: 30px;
  text-align : center;
}
.bottom-text a {
  color : #F15F79;
}

.text_login{
	text-align:center;
	color: #696763;
  	font-family: 'Roboto', sans-serif;
 	 font-size: 5em;
 	 font-weight: 300;
 	 margin-bottom: 30px;}


.form_idpw{
	width: 30%;
	margin: 0 auto;
}
.form_idpw2{
	height:50px;
	margin-bottom:10px;
	font-size: 1.5em;
 	font-weight: 300;
}

.btn-center{
		position: absolute; 
		left: 0;
		right: 0; 
		margin:0 auto;
}

.btn-padding{
	padding:5% 0 0 0;
}

</style>


<section id="form">

	<!--form-->
	<div class="container">
			<div class="col">
					<!--login form-->				
					<h2 class="text_login">Login</h2>
					
					<div class="form_idpw">
						<c:choose>
							<c:when test="${userID!=null }">
								<input type="text" id="userID" name="userID" value="${userID}" class="form-control form_idpw2" placeholder="ID" /> 	
							</c:when>
							<c:otherwise>
								<input type="text" id="userID" name="userID" class="form-control form_idpw2" placeholder="ID" /> 	
							</c:otherwise>
						</c:choose>

						<input type="password" id="userPw" name="userPw" class="form-control form_idpw2" onkeypress="if(event.keyCode==13) {login(); return false;}" placeholder="Password" /> 

						<button type="button" name="btnLogin" class="btn waves-effect waves-light btn-block btn-warning form_idpw2" onclick="login();">로그인</button>
						<div class="bottom-text"> 아이디가 없으세요? <a href="${pageContext.servletContext.contextPath}/registerForm"> 회원가입하기 </a></div>
						<h2 style="text-align:center;">or</h2>
						<div class="text-center btn-margin btn-padding">
							<button type="button" id="findId" class="btn btn-warning">ID찾기</button>
							<button type="button" id="findPw" class="btn btn-warning">PW찾기</button>
						</div>
					</div>
				</div>
				<!--/login form-->
	</div>
</section>
<!--/form-->