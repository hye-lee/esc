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
	<h2 class="mypage_title">My Order</h2>
	<table class="table table_top">
			<colgroup>
				<col width="*%"/> <!-- OrdSeq 주문번호 -->
				<col width="25%"/> <!-- 주문날짜 -->
				<col width="15%"/> <!-- 총결제금액 -->
				<col width="10%"/> <!-- 결제수단-->
			</colgroup>
				
			<thead>
				<tr class="order_head">
					<th>주문번호</th>
					<th>주문날짜</th>
					<th>총결제금액</th>
					<th>결제수단</th>
				</tr>
			</thead>
				
			<tbody>
				<c:set var="sum" value="0"></c:set>
				<c:forEach var="list" items="${list}" varStatus="status">
					<input type="hidden" id="ordSeq" name="ordSeq" value="${list.ordSeq}">
					<c:url var="link" value="orderDetail/${list.ordSeq}">
		            </c:url>

				<tr class="order_body">
						<td><h3><a href="${link}" style="color:gray;">[<c:out value="${list.ordSeq}"/> ]</a></h3></td>
						<td><h3>${list.ordDate}</h3></td>	
						<td><h3><fmt:formatNumber value="${list.ordTotal}" pattern="#,###,###" />원</h3></td>
						<td><h3>${list.ordPayment }</h3></td>
					</tr>
				</c:forEach>	
			</tbody>
			
			
		</table>
		
		
		
		<nav aria-label="Page navigation example" style="padding-top: 3%;">
		<ul class="pagination" style="justify-content: center;">
			<li class="page-item"><c:if test="${pageDto.block != 1 }">
					<a class="page-link" href="#" tabindex="-1" aria-disabled="true"
						onClick="paging(1)">Start</a>
				</c:if> <c:if test="${pageDto.page != 1}">
					<a class="page-link" href="#" tabindex="-1" aria-disabled="true"
						onClick="paging('${pageDto.pre }')">Previous</a>
				</c:if></li>

			<c:forEach var="pageNum" begin="${pageDto.startPage}"
				end="${pageDto.endPage}">
				<c:choose>
					<c:when test="${pageNum == pageDto.page}">
						<li class="page-item active" aria-current="page"><a
							class="page-link" onClick="paging('${pageNum}')">${pageNum}</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							onClick="paging('${pageNum}')">${pageNum}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<li class="page-item"><c:if
					test="${pageDto.page != pageDto.totalPage && pageDto.totalPage > 0}">
					<a class="page-link" onClick="paging('${pageDto.next }')">Next</a>
				</c:if> <c:if
					test="${pageDto.block ne pageDto.totalBlock && pageDto.totalBlock > 0}">
					<a class="page-link" onClick="paging('${pageDto.totalPage }')">End</a>
				</c:if></li>
		</ul>
	</nav>
		
		
</div>