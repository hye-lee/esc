<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/esc/mypage.css">

<script type="text/javascript">
	$(function(){
		$('#joinBtn').click(function(){
			if($('#userPw').val()==null|| $('#userPw').val()==""){
				alert('비밀번호를 입력하세요');
				return;
			}
			if($('#userName').val()==null|| $('#userName').val()=="")
			{
				alert('이름을 입력하세요');
				return;
			}
			
			if($('#postcode').val()==null|| $('#postcode').val()=="")
			{
				alert('주소를 입력하세요');
				return;
			}
			
			$('#registerForm').attr("action","mypage/userInfoUpdata");
			$('#registerForm').submit();
			
		});
	});
</script>

<style>
	.updateInfo_con{
		width: 70%;
		margin: 0 auto;
		font-size: 1em;
		padding-bottom: 5%;
		padding-top: 3%;
	}
	
	.form_reg {
	width: 50%;
	margin: 0 auto;
	}
	
	.form_reg2{
		margin-bottom: 5%;
		font-size: 1.5em;
		font-weight: 300;
	
	}
</style>

<div class="updateInfo_con">
	<hr>
	<h2 class="mypage_title">My Info</h2>
	
	<form id="registerForm" method="post" class="form_reg">
			<label>회원아이디</label>
			<div class="input-group input-group-lg form_reg2">
				<span class="input-group-addon" id="sizing-addon1"> <span class="glyphicon glyphicon-star" aria-hidden="true"></span></span> 
					<input type="text" class="form-control" id="userID" name="userID" value="${user.userID}" placeholder="아이디(ID)를 입력하세요" readonly="readonly" >
			</div>
			<div class="val_tag" id="userIDcheckMsg" name="userIDcheckMsg">&nbsp;</div>
			<label>이메일</label>
			<div class="input-group input-group-lg form_reg2">
				<span class="input-group-addon" id="sizing-addon1"><span
					class="glyphicon glyphicon-envelope" aria-hidden="true"></span></span> <input
					type="text" class="form-control" id="userEmail" name="userEmail" value="${user.userEmail }"
					placeholder="example@gmail.com" 
					readonly="readonly" />
			</div>
			<div class="val_tag" id="emailCheckMsg" name="emailCheckMsg">&nbsp;</div>

			<label>이름</label>
			<div class="input-group input-group-lg form_reg2">
				<span class="input-group-addon" id="sizing-addon1"><span
					class="glyphicon glyphicon-user" aria-hidden="true"></span></span> <input
					type="text" class="form-control" id="userName" name="userName" value="${user.userName}" placeholder="이름(Name)을 입력하세요"  required="required" />
			</div>
			<div class="val_tag" id="userNameCheckMsg" name="userNameCheckMsg">&nbsp;</div>

			<label>비밀번호</label>
			<div class="input-group input-group-lg form_reg2">
				<span class="input-group-addon" id="sizing-addon1"><span
					class="glyphicon glyphicon-lock" aria-hidden="true"></span></span> <input
					type="password" class="form-control" id="userPw" name="userPw"
					placeholder="비밀번호(Pw)를 입력하세요"
					required="required" />
			</div>
			<div class="val_tag" id="userPwcheckMsg" name="userPwcheckMsg">&nbsp;</div>

			<label>비밀번호확인</label>
			<div class="input-group input-group-lg form_reg2">
				<span class="input-group-addon" id="sizing-addon1"><span
					class="glyphicon glyphicon-lock" aria-hidden="true"></span></span> 
					<input type="password" class="form-control" id="userPwc" name="userPwc" placeholder="비밀번호(Pw)를 다시 입력하세요" />
			</div>
			<div class="val_tag" id="pwCheckMsg" name="pwCheckMsg">&nbsp;</div>
			
			<label>주소</label>
			<div class="input-group input-group-lg form_reg2" id="userAddrForm">
				<span class="input-group-addon" id="sizing-addon1"><span
					class="glyphicon glyphicon-envelope" aria-hidden="true"></span></span> 
					
					<div class="form-inline">
						<div class="col-lg-6" style="padding:0;"><input type="text" style="font-size: 1em;" class="form-control " id="postcode" name="postcode" disabled="true" value="${user.userPostCode }" placeholder="우편번호"></div>
						<div class="col-lg-6" style="padding:0;"><button type="button" style="font-size: 0.8em;" class="btn waves-effect waves-light btn-block btn-warning" id="searchAddr" >우편번호 찾기</button></div>
					</div>
					
					<input type="text" class="form-control" id="roadAddress" name="roadAddress" value="${user.userAddr }" disabled="true" placeholder="도로명주소">
					<input type="text" class="form-control" id="detailAddress" name="detailAddress" value="${user.userAddrDetail }" placeholder="상세주소">
					<input type="text" class="form-control" id="extraAddress" name="extraAddress" disabled="true" value="${user.userExAddr}" placeholder="참고항목">
			</div>
			
			<div class="val_tag" id="userAddrCheck" name="userAddrCheck">&nbsp;</div>
			

			<button type="button" id="joinBtn" class="btn waves-effect waves-light btn-block btn-warning form_reg2">회원정보수정</button>
		</form>

</div>