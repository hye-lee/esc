<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.util.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<style>
	.table_center th{
	text-align: center;
}
</style>

<div>
<table class="table table-hover">
		        <colgroup>
                            <col width='10%'/>   <%-- 사진 --%>
                            <col width='10%'/>   <%-- 상품번호 --%>
                            <col width='15%'/>   <%-- 카테고리 --%>
                            <col width='10%'/>   <%-- 사이즈 --%>
                            <col width='15%'/>   <%-- 브랜드 --%>
                            <col width='*%'/>   <%-- 이름 --%>
                            <col width='10%'/>   <%-- 재고 --%>
                            <col width='10%'/>   <%-- 판매갯수 --%>
                        </colgroup>

                        <thead>
                        <tr class="table_center">
                            <th>&nbsp;</th>
                            <th>상품번호</th>
                            <th>카테고리</th>
                            <th>사이즈</th>
                            <th>브랜드</th>
                            <th>이름</th>
                            <th>재고</th>
                            <th>판매수</th>
                        </tr>
                        </thead>
                        
                         <tbody class="table_center">
	                      <%--   <c:forEach var="list" items="${list}" varStatus="status">
	                        	<input type="hidden" id="userID" value="${list.proSeq}">
	                        	<tr>
	                        		<td><img src="${pageContext.servletContext.contextPath}/${list.proImgPath}" style= " object-fit:cover" /></td>
	                        		<td><c:out value="${list.proSeq}"></c:out></td>
	                        		<td><c:out value="${list.proCateSeq }"/></td>
	                        		<td><c:out value="${list.sizeSeq }"/></td>
	                        		<td><c:out value="${list.proBrand }"/></td>
	                        		<td><c:out value="${list.proName }"/></td>
	                        		<td><c:out value="${list.proStock }"/></td>
	                        		<td><c:out value="${list.proSellCount }"/></td>
	                        		
	                        	</tr>
	                        	
	                        </c:forEach> --%>
                  
                        </tbody> 
                        
                       
</table>

</div>