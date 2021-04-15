<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
	var check= new Map();
	
	$(document).ready(function() {
		
		//입력확인플래그 미입력시 false
		check.set("userID",false);
		check.set("userEmail",false);
		check.set("userName",false);
		check.set("userPw",false);
		check.set("userPwc",false);
		
	
		//ID검사
		$('#registerForm [name="userID"]').keyup(function(event) {
			var msgID="#userIDcheckMsg";
			var id='#registerForm [name="userID"]';
			
			if(!(event.keyCode>=37 && event.keyCode<=40)) //한글
				{
				var input= $(this).val();
				var reg_english_num = /[^a-z0-9]/gi;
				
				$(this).val(input.replace(reg_english_num,''));
				
				if($(this).val().length==0)
					return false;
				}
			
			check.set("userID",false);
			if( $(this).val().length<4|| $(this).val().length>10)
				{
				$(msgID).html("아이디는 4자 이상 10자 이하");
				}
			else{
				$.ajax({
					type: 'post',
					url:'${pageContext.servletContext.contextPath}'+'/checkID',
					data: {userID:$(id).val()}
					
				},1000).done(function(msg){
					if(msg==" ")
						{	check.set("userID",true);
							blueLine(id);
						    msg="&nbsp;";
						}else{
							redLine(id);
						}
					$(msgID).css({'color': 'red','margin-bottom': '3%'});
					$(msgID).html(msg);
					
				}).fail(function(xhr, status, errorThrown){})
			}
		});
		
		//비밀번호 검사
		$('#registerForm [name="userPw"]').keyup(function() {
			
			check.set("userPw",false);

			var pw = $('#registerForm [name="userPw"]').val();
			var num = pw.search(/[0-9]/g);
			var eng = pw.search(/[a-z]/ig);
			var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
			var msgID = '#userPwcheckMsg';
			var id='#registerForm [name="userPw"]';

			if(pw.length < 8 || pw.length > 15){
				 $(msgID).html("8자 ~15자 이내로 입력해주세요.");
				 redLine(id);
				 return false;
			}else if(pw.search(/\s/) != -1){
				$(msgID).html("비밀번호는 공백 없이 입력해주세요.");
				redLine(id);
				return false;
			}else if(num < 0 || eng < 0 || spe < 0 ){
				$(msgID).html("영문,숫자,특수문자를 혼합하여 입력해주세요.");
				redLine(id);
				return false;
			}else {
				check.set("userPw", true);
				blueLine(id);
				$(msgID).html("&nbsp");
			}
		});

		//비밀번호 일치검사
		$('#registerForm [name="userPwc"]').keyup(function() {
			check.set("userPwc",false);
			var id='#registerForm [name="userPwc"]';
			if($(this).val()==$('#registerForm [name="userPw"]').val()){
				check.set("userPwc",true);
				$("#pwCheckMsg").html("&nbsp");
				blueLine(id);
				return false;
			}else{
				redLine(id);
			}
			check.set("userPwc",false);
			$("#pwCheckMsg").html("위와 동일하게 입력해주세요");
			
		});
		//이메일검사
		$('#registerForm [name="userEmail"]').keyup(function() {
			
			check.set("userEmail",false);
			var id="#registerForm [name='userEmail']";
			var userEmail=$(id).val();
			
			if(!validateEmail($(this).val())){
				$("#emailCheckMsg").html("올바른 이메일을 입력해주세요");
				redLine(id);
			}
			else if($(this).val().length!=0){
				console.log('userEmail'+userEmail);
				$.ajax({
					type: 'post',
					url: '${pageContext.servletContext.contextPath}' + '/checkEmail',
					data: {userEmail:userEmail}
				},1000).done(function(msg){
					if(msg==" ")
						{	check.set("userEmail",true);
							blueLine(id);
							msg="&nbsp;";
						}else{
							redLine(id);
						}
					$("#emailCheckMsg").css({'color': 'red','margin-bottom': '3%'});
					$("#emailCheckMsg").html(msg);
				}).fail(function(xhr, status, errorThrown){
				
				})
			}
		});

		//이름검사
		$('#registerForm [name="userName"]').keyup(function() {
			var id='#registerForm [name="userName"]';
			var msgID = '#userNameCheckMsg';

			if( $(this).val().length<2 || $(this).val().length>10)
			{
				$(msgID).html("이름은  2자 이상 10자 이하");
				redLine(id);
			}else{
				blueLine(id);
				$(msgID).html("&nbsp;");
				check.set("userName",true);
			}
			spaceCheck(id, msgID);
			specialPatternCheck(id, msgID);
		});
		
		
		$("#joinBtn").click(function(){
			registerSubmit();
		})

	});
	
	function blueLine(id){
		$(id).css("border","1px solid #3333FF");
	}
	
	function redLine(id){
		$(id).css("border","1px solid #FF0000");
	}
	
	function chkPW(){

		 var pw = $("#password").val();
		 var num = pw.search(/[0-9]/g);
		 var eng = pw.search(/[a-z]/ig);
		 var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

		 if(pw.length < 8 || pw.length > 20){

		  alert("8자리 ~ 20자리 이내로 입력해주세요.");
		  return false;
		 }else if(pw.search(/\s/) != -1){
		  alert("비밀번호는 공백 없이 입력해주세요.");
		  return false;
		 }else if(num < 0 || eng < 0 || spe < 0 ){
		  alert("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
		  return false;
		 }else {
			console.log("통과"); 
		    return true;
		 }

		}
	
	function validateEmail(email){
		if(email==null){	return false; }
		//abc@gmail.com
		var reg=/^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		return reg.test(email);
	}

	function falseMsg(msgID, id, msg) {
		$(msgID).empty();
		$(msgID).html(msg);
		$(msgID).css('color', 'red');
		redLine(id);
		check.set(id,false);
		$(id).focus();
		$('button#joinBtn').attr("disabled", true);

	}

	function trueNotMsg(msgID) {
		$(msgID).empty();
		$(msgID).html("&nbsp;");
		$(msgID).css('margin-bottom', '3%');
		$('button#joinBtn').attr("disabled", false);
	}

	function trueMsg(msgID, id, msg) {
		$(msgID).empty();
		$(msgID).html(msg);
		$(msgID).css('color', 'blue');
		blueLine(id);
		$('button#joinBtn').attr("disabled", false);
	}

	function spaceCheck(id, msgID) {
		var item = $(id).val();
		if (item.search(/\s/) != -1) {
			msg = "공백을 포함할수 업습니다.";
			falseMsg(msgID, id, msg);
		}else{
			check.set(id,true);
		}
	}

	//정규식 특수문자검사
	function specialPatternCheck(id, msgID) {
		var item = $(id).val();
		var reg_special = /[`~!@#$%^&*|\\\'\";:\/?]/gi;

		if (reg_special.test(item) == true) {
			msg = "특수문자는 입력할 수 없습니다.";
			falseMsg(msgID, id, msg);
		}else{

			check.set(id,true);
		}
	}

	function lengthCheck(id, min, max, msgID) {
		var item = $(id).val();
		msg = min + '자 ~ ' + max + '이내로 입력하세요';

		if (item.length<min || item.length>max) {
			falseMsg(msgID, id, msg);
		}else{
			$(msgID).html("&nbsp;");
			$(msgID).css('margin-bottom', '3%');
			$('button#joinBtn').attr("disabled", false);

	}
	}

	function englishNumberPatternCheck(id, msgID) {
		var item = $(id).val();
		var reg_english_num = /^[a-z|A-Z|0-9|\*]+$/;

		
		if (/(\w)\1\1\1/.test(item)) {
			msg = "같은 문자를 4번이상 입력할 수 없습니다.";
			falseMsg(msgID, id, msg);
		} 
		if (reg_english_num.test(item) == false) {
			msg = "영어와 숫자만 입력가능합니다.";
			falseMsg(msgID, id, msg);
		}
		
	}

	function registerSubmit() {
		$(this).prop("disabled",true);
		let inputCheck=false;
		
		$('#registerForm input').each(function(){
			if($(this).val()==""||$(this).val()==null){
				inputCheck=false;
				//$(this).prop("disabled",false);
				return false;
			}else{
				inputCheck=true;
			}
		});
		
		//입력확인플래그 확인용
		for(var [key,value] of check){
			if(!value){
				$(this).prop("disabled",false); 
				inputCheck=false;
				$("#registerForm [name="+key+"]").css("border","1px solid #FF0000");		
			}
		}
		//값이 다 입력됬을시
		if(inputCheck){
			$('#registerForm input').prop("disabled", true);
			
			$.ajax({
				type:'post',
				url:'${pageContext.servletContext.contextPath}' + '/register',
				data:{
					userID:$('#userID').val(),
					userEmail:$('#userEmail').val(),
					userName:$('#userName').val(),
					userPw:$('#userPw').val()
				}
			},1000).done(function (redirect){
				document.location.href='${pageContext.servletContext.contextPath}'+redirect;
			}).fail(function(xhr, status, errorThrown) {})
			
		}
		
	}
</script>



<style>
.bottom-text {
	font-size: 16pt;
	font-family: 'Roboto', sans-serif;
	margin-top: 30px;
	text-align: center;
}

.bottom-text a {
	color: #F15F79;
}

.text_login {
	text-align: center;
	color: #696763;
	font-family: 'Quicksand', sans-serif;
	font-size: 5em;
	font-weight: 300;
	margin-bottom: 30px;
}

.form_reg {
	width: 35%;
	margin: 0 auto;
}

.form_reg2 {
	margin-bottom: 5%;
	font-size: 1.5em;
	font-weight: 300;
}

.val_tag{
	margin-bottom: 3%;
	color: red;
}
</style>


<section id="form">
	<!--form-->
	<div class="container">
		<!--register form-->
		<h2 class="text_login">Register</h2>

		<form id="registerForm" method="post" class="form_reg">
			<label>회원아이디</label>
			<div class="input-group input-group-lg form_reg2">
				<span class="input-group-addon" id="sizing-addon1"> <span class="glyphicon glyphicon-star" aria-hidden="true"></span></span> 
					<input type="text" class="form-control" id="userID" name="userID" placeholder="아이디(ID)를 입력하세요" required="required">
			</div>
			<div class="val_tag" id="userIDcheckMsg" name="userIDcheckMsg">&nbsp;</div>
			<label>이메일</label>
			<div class="input-group input-group-lg form_reg2">
				<span class="input-group-addon" id="sizing-addon1"><span
					class="glyphicon glyphicon-envelope" aria-hidden="true"></span></span> <input
					type="text" class="form-control" id="userEmail" name="userEmail"
					placeholder="example@gmail.com" 
					required="required" />
			</div>
			<div class="val_tag" id="emailCheckMsg" name="emailCheckMsg">&nbsp;</div>

			<label>이름</label>
			<div class="input-group input-group-lg form_reg2">
				<span class="input-group-addon" id="sizing-addon1"><span
					class="glyphicon glyphicon-user" aria-hidden="true"></span></span> <input
					type="text" class="form-control" id="userName" name="userName" placeholder="이름(Name)을 입력하세요"  required="required" />
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

			<button type="button" id="joinBtn" class="btn waves-effect waves-light btn-block btn-warning form_reg2">회원가입</button>
		</form>

	</div>
</section>
<!--/form-->