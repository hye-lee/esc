<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">

	$().ready(function(){
		
		//상품체크박스 해제시 전체체크박스 해제, 모두 선택시 전체체크박스 선택
		$('input[name=choosePro]').click(function(){ 
			console.log("갯수: "+${list.size()});
			   if($('input[name=choosePro]:checked').length==${list.size()}){ 
			       $('#checkAll').prop("checked",true); 
			    }else{ 
			       $('#checkAll').prop("checked",false); 
			    } 
			});

		
		
		
		$('#deleteCart').click(function(){
			var confirm=window.confirm('삭제하시겠습니까?');
			var userID=$('#userID').val();
			var cartSeq=$('#cartSeq').val();
			
			if(confirm){
				$.ajax({
					type: "post",
					url: "cart/deleteOne",
					data: { userID: userID, cartSeq: cartSeq},
					success: function(result){
						if(result==1){
							alert("삭제 성공!");
							location.href="cart";
						}
						else{
							console.log('fail delete cart');
						}
					}
				});
			}
		});
		
	});

	function checkAll(){
		if($('#checkAll').is(':checked')){
			$('input[name=choosePro]').prop("checked",true);
		}else
		{
			$('input[name=choosePro]').prop("checked",false);
		}
	}
	
</script>

<style>
	.text_cart{
		text-align:center;
		color: #696763;
  		font-family: 'Quicksand', sans-serif;
 	 	font-size: 5em;
 		font-weight: 300;
 		padding: 1% 0 3% 0;	
	}
	
	.cart_container{
		width: 80%;
		margin: 0 auto;
		font-size: 1em;
		padding-bottom: 5%;
		padding-top:3%;
	}
	
	.cart_item{
		height:60px;
		
	}
	
	.cart_head th{
		text-align:center;
		font-size: 1.3em;
		font-family: 'Noto+Sans+KR', sans-serif;
		
	}
	
	.cart_body td{
		text-align:center;
		font-size: 1em;
	}

	.cart_foot td{
		text-align:center;
	}

</style>

<div class="cart_container">
	<hr>
	<h2 class="text_cart">Cart</h2>
		<table  class="table">
			<colgroup>
				<col width="5%"/> <!-- 체크박스 -->
				<col width="15%"/> <!-- 상품이미지 -->
				<col width="*%"/> <!-- 브랜드+이름 -->
				<col width="15%"/> <!-- 상품가격 -->
				<col width="10%"/> <!-- 대여기간 -->
				<col width="3%"/> <!-- 삭제박스 -->
			</colgroup>
			
			<thead>
				<tr class="cart_head">
					<th><div class="checkbox">
						  <label>
						    <input type="checkbox" id="checkAll" onclick="checkAll();" aria-label="...">
						  </label>
						</div></th>
					<th>&nbsp;</th>
					<th>상품정보</th>
					<th>상품가격</th>
					<th>대여기간</th>
					<th>&nbsp;</th>
			</thead>
			
			<tbody>
			<c:choose><c:when test="${list.size()!=0}">

				<c:forEach var="list" items="${list}" varStatus="status">
					<c:url var="link" value="productDetail/${list.proSeq}">
	                    <c:param name="proSeq" value="${list.proSeq}"/>
	                </c:url>
					
					<c:if test="${sessionScope.login!=null}">
					 	<input type="hidden" id="userID" value="${sessionScope.login }"/>
					</c:if>
					<input type="hidden" id="cartSeq" value="${list.cartSeq}"/>
					
					<tr class="cart_body">
						<td>
							<div class="checkbox">
								<input type="checkbox"  id="choosePro" name="choosePro" value="option1" aria-label="...">
							</div>
						</td>
						
						<td><img src="${pageContext.servletContext.contextPath}/${list.proImgPath}" style="height:100px;"></td>
						
						<td style="text-align:left;">					
							<h3><a href="${link}" style="color:gray;">[<c:out value="${list.proBrand}"/>] <c:out value="${list.proName}"/></a></h3>
						</td>
					
						<td><h3><fmt:formatNumber value="${list.proPrice}" pattern="#,###,###" />원</h3></td>
						
						<td><h3>3일</h3></td>
						<td><button type="button" class="close" id="deleteCart" aria-label="Close"><span aria-hidden="true" style="color:red; "><h2>&times;</h2></span></button></td>
		
					</tr>
				</c:forEach>
				</c:when>
					<c:otherwise>
						<tr>
							<td colspan="6"><h3 style="text-align:center; margin:10%;">장바구니가 비었습니다.</h3></td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>

		</table>
		<div class="row">
			<div class="col-md-8"></div>
				<div class="col-md-4">
					<c:if test="${ list.size()!=0}">
						<h3>배송비 
							<c:choose>
								<c:when test="${total>50000}">0원</c:when>
								<c:otherwise>3,000원</c:otherwise>
							</c:choose>
						</h3>
					
						<h3>총 가격 <fmt:formatNumber value="${total}" pattern="#,###,###" />원</h3>
					</c:if>
			</div>
		<div class="row">
			<div class="col-md-8"><button type="button" class="btn btn-warning" id="goShop" name="goShop" style="float:right;">쇼핑하러 가기</button></div>
			<c:if test="${list.size()!=0}"><div class="col-md-4"><button type="button" class="btn btn-warning" id="orderCart" name="orderCart">선택상품 주문하기</button></div></c:if>
		</div>
			
		</div>
		
					
					
				
				
					
				
</div>



