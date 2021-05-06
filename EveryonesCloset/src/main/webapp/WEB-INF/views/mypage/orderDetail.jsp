<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/esc/mypage.css">

<script type="text/javascript">

</script>

<style>

	.mypage_container {
	width: 70%;
	margin: 0 auto;
	font-size: 1em;
	padding-bottom: 5%;
	padding-top: 3%;
}
	.table_top{ margin:5% 0 5% 0; }
	.order_head th{ text-align:center; font-size: 1.3em; font-family: 'Noto+Sans+KR', sans-serif;}
	.order_body td { text-align:center; font-size: 1em;}
	
	.pagination {
  display: -ms-flexbox;
  display: flex;
  padding-left: 0;
  list-style: none;
  border-radius: 0.25rem;
}
</style>


<div class="mypage_container">
	<hr>
	<h2 class="mypage_title">Order Detail</h2>
	<table class="table table_top">
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
		</div>
		
		
		<div class="order_form">
			<h3><label>수령인정보</label></h3>	
			<hr>	
			<form class="form-horizontal" id="recOrder" name="recOrder" method="post" >
				
				<div class="form-group">
					<label class="col-md-2">수령인</label>
					 <div class="col-md-5">
						<input type="text" class="form-control" id="recUser" name="recUser" value="<c:out value='${ order.recUser}'/>" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2">수령인연락처</label>
					<div class="col-md-5">
						<input type="text"class="form-control" id="recPhone" name="recPhone" value="<c:out value='${ order.recPhone}'/>" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2">수령인주소</label>
					<div class="col-md-5">
						<input type="text" class="form-control" id="recPostCode" name="recPostCode" value="<c:out value='${ order.recPostCode}'/>" readonly="readonly">
						<input type="text" class="form-control" id="recAddr" name="recAddr" value="<c:out value='${ order.recAddr}'/>" readonly="readonly">
						<input type="text" class="form-control" id="recExAddr" name="recExAddr" value="<c:out value='${ order.recExAddr}'/>" readonly="readonly">
					</div>
					
				</div>
				<div class="form-group">
					<label class="col-md-2">결제수단</label>
					<div class="col-md-5">
						<input type="text" class="form-control" id="ordPayment" name="ordPayment" value="<c:out value='${ order.ordPayment}'/>" readonly="readonly">
					</div>
					
				</div>

			</form>
	</div>
		
		
		
</div>