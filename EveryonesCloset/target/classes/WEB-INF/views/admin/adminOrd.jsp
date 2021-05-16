<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page import="java.util.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<table class="table table-hover">
	<colgroup>
		<col width="15%" />
		<!-- OrdSeq 주문번호 -->
		<col width="10%" />
		<!-- 주문날짜 -->
		<col width="8%" />
		<!-- 총결제금액 -->
		<col width="8%" />
		<!-- 결제수단-->
		<col width="10%" />
		<!-- 주문자-->
		<col width="10%" />
		<!-- 수령자-->
		<col width="10%" />
		<!-- 수령인연락처-->
		<col width="8%" />
		<!-- 우편번호-->
		<col width="*%" />
		<!-- 주소-->
	</colgroup>

	<thead>
		<tr class="order_head">
			<th>주문번호</th>
			<th>주문날짜</th>
			<th>총결제금액</th>
			<th>결제수단</th>
			<th>주문자</th>
			<th>수령자</th>
			<th>수령인연락처</th>
			<th>우편번호</th>
			<th>주소</th>
		</tr>
	</thead>

	<tbody class="table_center">
		<c:forEach var="list" items="${list}" varStatus="status">
			<input type="hidden" id="ordSeq" name="ordSeq" value="${list.ordSeq}">
			<c:url var="link" value="orderDetail/${list.ordSeq}">
			</c:url>

			<tr class="order_body">
				<td>${list.ordSeq}</td>
				<td>${list.ordDate}</td>
				<td><fmt:formatNumber value="${list.ordTotal}" pattern="#,###,###" />원</td>
				<td>${list.ordPayment }</td>
				<td>${list.userID }</td>
				<td>${list.recUser }</td>
				<td>${list.recPhone }</td>
				<td>${list.recPostCode }</td>
				<td>${list.recAddr}</td>
			</tr>
		</c:forEach>

	</tbody>



</table>