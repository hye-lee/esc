<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<c:choose>
	<c:when test="${msg!=null}">
		주문실패!
		
		<h4 style="color:red;"><c:out value="${msg}"></c:out></h4>
		
	</c:when>
	<c:otherwise>
		주문성공!
		${order.ordTotal}원
		수령자:${order.recUser}
		수령자연락처:${order.recPhone}
		수령주소:${order.recAddr}
	
	</c:otherwise>
</c:choose>

