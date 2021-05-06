<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
 <script type="text/javascript">

 	function goLogin(){
 			
 			findForm.userID.value=$('#userID').val();
 			//console.log(findForm.userID.value);
 			//location.href="${pageContext.servletContext.contextPath}/login";
 			document.findForm.action ="${pageContext.servletContext.contextPath}/login";
 			document.findForm.submit();
 	}
	
 	function findPw(){
 		findForm.userID.value=$('#userID').val();
 		document.findForm.action ="${pageContext.servletContext.contextPath}/login/findPw";
		document.findForm.submit();
 	}
 
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

	.form-margin{
		margin:2% 0 10% 0;
	
	}
	
	.btn-margin{
	
		padding:10% 0 5% 0;
	}
</style>
 
 
 <div class="findId_container">
	<hr>
	<h2 class="text_find">Find ID</h2>
	<div class="mypage_funcion ">
		<div class="row">
			<div class="col-md-offset-3 col-md-6 find_back">		
				<div class="form-group" >
					<form id="findForm" name="findForm" method="post" >
						<c:choose>
					    	<c:when test="${userId!=null}">
					    		<label>회원아이디</label>		    		
									<input type="text" class="form-control" id="userID" name="userID" value="${userId}" readonly="readonly" >   		
					    	</c:when>
					    	<c:otherwise>
					   			<h3 style="color:red;"> 일치하는 회원정보가 없습니다.</h3>
					   		 </c:otherwise>
    
    					</c:choose>
					</form>
						<div class="text-center btn-margin">
							<button class="btn btn-warning" id="login" name="login" onclick="goLogin()">Login</button>
							<button class="btn btn-warning" id="findPw" name="findPw" onclick="findPw()">Find PW</button>
						</div>
				
				</div>

				</div>
			</div>
	</div>
		
</div>
   
    