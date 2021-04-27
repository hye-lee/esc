<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">

	$().ready(function(){
		
		$('#sameUser').click(function(){
			
			if($('#sameUser').is(":checked")){
				
				$('#recUser').prop("value",$('#userID').val());
				$('#recPhone').prop("value",$('#userEmail').val());
				$('#recPostCode').prop("value",$('#userPostCode').val());
				$('#recAddr').prop("value",$('#userAddr').val());
				$('#recExAddr').prop("value",$('#userExAddr').val());
			}else{
				$('#recUser').prop("value","");
				$('#recPhone').prop("value","");
				$('#recPostCode').prop("value","");
				$('#recAddr').prop("value","");
				$('#recExAddr').prop("value","");
				
			}
		
		});
		
	});
	
	function order(){
		var recUser=$('#recUser').val();
		var recPhone=$('#recPhone').val();
		var recPostCode=$('#recPostCode').val();
		var recAddr=$('#recAddr').val();
		var ordPayment=$('input:radio[name="ordPayment"]:checked').val();
		console.log("orPayment"+ordPayment);
		
		if(recUser==""||recUser==null){ alert("수령인을 입력하세요."); return;}
		if(recPhone==""||recPhone==null){ alert("수령인 연락처을 입력하세요."); return;}
		if(recPostCode==""||recPostCode==null||recAddr==""||recAddr==null){ alert("수령인 주소를 입력하세요."); return;}
		if(ordPayment==""||ordPayment==null){ alert("결제방법을 선택하세요."); return;}
		
		document.recOrder.submit();
	}
	
	
</script>

<style>
	.order_Container{
		width: 80%;
		margin: 0 auto;
		font-size: 1em;
		padding-bottom: 5%;
		padding-top:3%;
	}

	.text_order{
		text-align:center;
		color: #696763;
  		font-family: 'Quicksand', sans-serif;
 	 	font-size: 5em;
 		font-weight: 300;
 		padding: 1% 0 3% 0;	
	}
	
	.order_head th{ text-align:center; font-size: 1.3em; font-family: 'Noto+Sans+KR', sans-serif;}
	.order_body td { text-align:center; font-size: 1em;}
	.font_control label{font-size:1.5m; font-family: 'Noto+Sans+KR', sans-serif;}
	
	.order_form {margin:5% 0 5% 0;}
	.order_btn{margin:5% 0 5% 0;}
</style>


<div class="order_Container">
	<h3 class="text_order">Order</h3>
		<table class="table">
			<colgroup>
				<col width="15%"/> <!-- 상품이미지 -->
				<col width="*%"/> <!-- 브랜드+이름 -->
				<col width="15%"/> <!-- 상품가격 -->
				<col width="10%"/> <!-- 대여기간 -->
			</colgroup>
				
			<thead>
				<tr class="order_head">
					<th>&nbsp;</th>
					<th>주문상품정보</th>
					<th>주문상품가격</th>
					<th>대여기간</th>
				</tr>
			</thead>
				
			<tbody>
				<c:set var="sum" value="0"></c:set>
				<c:forEach var="list" items="${list}" varStatus="status">
					<input type="hidden" id="proSeq" name="proSeq" value="${list.proSeq}">
					<c:url var="link" value="productDetail/${list.proSeq}">
		                    <c:param name="proSeq" value="${list.proSeq}"/>
		            </c:url>

				<tr class="order_body">
						<td><img src="${pageContext.servletContext.contextPath}/${list.proImgPath}" style="height:100px;"></td>
						<td style="text-align:left;">
							<h3><a href="${link}" style="color:gray;">[<c:out value="${list.proBrand}"/> ] <c:out value="${list.proName}"/></a></h3></td>		
						<td><h3><fmt:formatNumber value="${list.proPrice}" pattern="#,###,###" />원</h3></td>
						<td><h3>3일</h3></td>
					</tr>
					<c:set var="sum" value="${sum+ list.proPrice}"></c:set>
				</c:forEach>	
			</tbody>
			
			
		</table>
		총 금액: <fmt:formatNumber value="${sum}" pattern="#,###,###" />원
		
		<br>
		
		<div class="order_form ">
			<h3><label>주문자정보</label></h3>	
			<hr>	
			<form class="form-horizontal">
				<div class="form-group">
					<label for="userID" class="col-md-2">주문자</label>
					 <div class="col-md-5">
						<input type="text" class="form-control" id="userID" name="userID" value="<c:out value='${ user.userID}'/>" disabled="true">
					</div>
				</div>
				<div class="form-group">
					<label for="userEmail" class="col-md-2">주문자이메일</label>
					<div class="col-md-5">
						<input type="text" class="form-control" id="userEmail" name="userEmail" value="<c:out value='${ user.userEmail}'/>" disabled="true">
					</div>
				</div>
				<div class="form-group">
					<label for="userAddr" class="col-md-2">주문자주소</label>
					<div class="col-md-5">
						<input type="text" class="form-control" id="userPostCode" name="userPostCode" value="<c:out value='${ user.userPostCode}'/>" disabled="true">
						<input type="text" class="form-control" id="userAddr" name="userAddr" value="<c:out value='${ user.userAddr}'/>" disabled="true">
						<input type="text" class="form-control" id="userExAddr" name="userExAddr" value="<c:out value='${ user.userExAddr}'/>" disabled="true">
					</div>
				</div>
				
			</form>
			<h6 style="color:red;">*주문자정보 변경은 Mypage를 이용하세요</h6>
		</div>
		
		<div class="order_form">
			<h3><label>수령인정보</label></h3>	
			<hr>	
			<form class="form-horizontal" id="recOrder" name="recOrder" method="post" action="completeOrder">
				<div class="form-group">
					<div class="col-md-offset-2 col-md-10">
						<div class="checkbox"><input type="checkbox" id="sameUser">위와 동일</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2">수령인</label>
					 <div class="col-md-5">
						<input type="text" class="form-control" id="recUser" name="recUser">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2">수령인연락처</label>
					<div class="col-md-5">
						<input type="text"class="form-control" id="recPhone" name="recPhone">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2">수령인주소</label>
					<div class="col-md-5">
						<input type="text" class="form-control" id="recPostCode" name="recPostCode">
						<input type="text" class="form-control" id="recAddr" name="recAddr">
						<input type="text" class="form-control" id="recExAddr" name="recExAddr">
					</div>
					
				</div>
				
				<h3><label>결제수단</label></h3>
				<hr>
				<label class="radio-inline">
	  					<input type="radio" name="ordPayment" id="card" value="card"> 일반카드
				</label>	
				<label class="checkbox-inline">
	 				 <input type="radio"  name="ordPayment" id="kakao" value="kakao"> 카카오페이
				</label>
				<label class="checkbox-inline">
					 <input type="radio"  name="ordPayment" id="cash" value="cash"> 무통장입금
				</label>
				
				<div class="order_btn">
					<button type="button"  style="position: absolute; left: 0;right: 0; margin:0 auto;" class="btn btn-warning" onclick="order()">주문하기</button>
				</div>
				
				<c:forEach var="list" items="${list}">
					<input type="hidden" id="cartSeq" name="cartSeq" value="${list.cartSeq}">
					<input type="hidden" id="proSeq" name="proSeq" value="${list.proSeq}">
				</c:forEach>
				<input type="hidden" id="ordTotal" name="ordTotal" value="${sum }">
				
			</form>
	</div>
	<h4 style="color:red;"><c:out value="${msg}"/></h4>
</div>