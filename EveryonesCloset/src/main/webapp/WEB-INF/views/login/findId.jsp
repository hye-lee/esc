<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	$(function(){
		
		$('#findId').click(function(){
			
			var userName=$('#userName').val();
			var userEmail=$('#userEmail').val();
			
			if(userName==null|| userName==""){
				alert("이름을 입력하세요.");
			}else if(userEmail==null|| userEmail==""){
				alert("이메일을 입력하세요.");
			}else{
				document.formFindId.submit();
			}
		});
	});

</script>

<style>
	.findId_container{
		width: 70%;
		margin: 0 auto;
		font-size: 1em;
		padding-bottom: 5%;
		padding-top: 3%;
	}
	.text_find{
		text-align: center;
		color: #696763;
		font-family: 'Quicksand', sans-serif;
		font-size: 5em;
		font-weight: 300;
		padding: 3% 0 1% 0;
	}
	.form_idEmail{
	width: 30%;
	margin: 0 auto;
}

	.form_idEmail2{
		height:50px;
		margin-bottom:10px;
		font-size: 1.5em;
	 	font-weight: 300;
	}
	.find_back {
	background: #f7f7f7;
	padding: 2% 5%;
}
</style>


<div class="findId_container">
	<hr>
	<h2 class="text_find">Find ID</h2>
	<div class="mypage_funcion">
		<h3 style="text-align: center;">가입하신 이름과 이메일을 입력하세요</h3>
		<div class="row">
			<div class="col-md-offset-3 col-md-6 find_back">		
				<form id="formFindId" action="reFindId" method="post">	
					<div class="form-group" >
							<label>회원이름</label>
							<input type="text" class="form-control" class="form_idEmail2" id="userName" name="userName"  placeholder="이름을 입력해주세요" required="required" >
					</div>
							
					<div class="form-group ">
							<label>이메일</label>
							<input type="text" class="form-control" class="form_idEmail2" id="userEmail" name="userEmail"  placeholder="example@gmail.com" required="required">
					</div>
					<div class="text-center btn-margin">
						<button class="btn btn-warning" id="findId" name="findId">ID찾기</button>
						
					</div>
				</form>
				</div>
			</div>
	</div>
		
</div>