<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/esc/mypage.css">

<script type="text/javascript">
	
	$(function(){

		$('#cancelBtn').click(function() {
			location.href = "${pageContext.servletContext.contextPath}/mypage";
		});
		
		$('#modalCancel').click(function() {
			$('#confirmModal').modal("hide");
		});
		
		$('#userDeleteSubmit').click(function() {
			document.deleteUser.submit();
		});
		
		$('#withdrawal').click(function(){
			var userPw=$('#userPw').val();
			var num = userPw.search(/[0-9]/g);
			var eng = userPw.search(/[a-z]/ig);
			var spe = userPw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
			var msg='#failMsg';
			if(userPw==null || userPw==''){
				alert("비밀번호를 입력해주세요.");
				return false;
			}else if(userPw.length < 8 || userPw.length > 15){
				$(msg).html("비밀번호는 8자 ~15자 이내입니다.");
				return false;
			}else if(num < 0 || eng < 0 || spe < 0 ){
				$(msg).html("비밀번호는 영문,숫자,특수문자를 혼합해야 합니다.");
				return false;
			}else{
				$(msg).html("&nbsp;");
				checkPw(userPw);
			}
			
		});
	});
	
	function checkPw(userPw){
		$.ajax({
			type:"post",
			url:"checkPw",
			data:{ userPw: userPw},
			success: function(res, status, xhr) {
				if(res==='Y'){$("#confirmModal").modal();}
				else if(res==='N'){ alert('비밀번호가 일치하지 않습니다.');}
			},
			error: function(xhr, status, error){
				console.log("error::"+error);
			}
			
		});
	}
</script>

<style>
.withdrawal_container{
	width: 70%;
	margin: 0 auto;
	font-size: 1em;
	padding-bottom: 5%;
	padding-top: 3%;

}

.withdrawal_back {
	background: #f7f7f7;
	padding: 2% 5%;
}

.btn-margin {
	margin: 7% 0 3% 0;
}

<!--모달 뒷배경 반투명 회색빛-->
.modal-back {
	display: none;
	background-color: rgba(0, 0, 0, 0.4);
}

<!--모달 뒷배경 투명화를 위해 사용-->
.modal-backdrop {
	background-color: rgba(0, 0, 0, .0001) !important;
}
</style>

<div class="withdrawal_container">
	<hr>
	<h2 class="mypage_title">Withdrawal</h2>
	<h5 class="text_mypage_small">회원 탈퇴를 위한 공간입니다.</h5>
	<div class="mypage_funcion">
		<h3 style="text-align: center;">그동안 이용해 주셔서 감사합니다.</h3>
		<div class="row">
			<div class="col-md-offset-4 col-md-4 withdrawal_back">
			<c:if test="${sessionScope.login!=null}">
				<form id="deleteUser" name="deleteUser" method="post" action="deleteUser">
					<div class="form-group">
						<label for="exampleInputEmail1">아이디</label> <input type="text"
							class="form-control" id="userID" value="${sessionScope.login}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">비밀번호</label> <input
							type="password" class="form-control" id="userPw"
							placeholder="비밀번호를 입력하세요">
						<div style="color: red;" id="failMsg" name="failMsg">&nbsp;</div>
					</div>

					<div class="text-center btn-margin">
						<button type="button" onclick="cancelBtn" id="cancelBtn"
							class="btn btn-danger">취소</button>
						<button type="button" class="btn btn-warning" data-toggle="modal"
							id="withdrawal" data-whatever="@mdo">탈퇴</button>
					</div>
				</form>
			</c:if>
		
		</div>

		</div>
		<hr>
	</div>
</div>


	<div class="modal modal-back" id="confirmModal" role="dialog" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content" style="padding: 0px">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close" style="padding-bottom:20px;">
								×
							</button>
							<h4 class="modal-title" id="modalTitle" style="color: red;">
								<strong>정말로 탈퇴하시겠습니까?</strong>
							</h4>
							
						</div>
						<div class="modal-body" id="modalBody">
							<h5 style="margin-top: 10px; color: DimGray;">탈퇴한 아이디/이메일은 다시 사용할 수 없습니다.</h5>
							<br>

						</div>
						<div class="modal-footer">
							<button type="button" id="modalCancel"
								class="btn btn-danger">취소</button>
							<button type="button" id="userDeleteSubmit"
								class="btn btn-warning">확인</button>
						</div>
					</div>
				</div>
			</div> 