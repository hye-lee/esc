<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.util.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<table class="table table-hover">
				
			
                        <colgroup>
                            <col width='8%'/>   <%-- 번호 --%>
                            <col width='*%'/>   <%-- 제목 --%>
                            <col width='18%'/>   <%-- 작성자 --%>
                            <col width='15%'/>   <%-- 작성일 --%>
                            <col width='8%'/>   <%-- 조회수 --%>
                        </colgroup>

                        <thead>
                        <tr class="table_center">
                            <th>번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>날짜</th>
                            <th>조회</th>
                        </tr>
                        </thead>
                        
                       <%--  <tbody class="table_center">
	                        <c:forEach var="list" items="${list}" varStatus="status">
	                        	<c:url var="link" value="read">
	                        		<c:param name="inquirySeq" value="${list.inquirySeq}"/>
	                       		 </c:url>
	                        	
	                        	<tr>
	                        		<td><c:out value="${pageDto.total-((pageDto.page-1)*pageDto.rowCount+status.index)}"/></td>
	                        		<td style="text-align: left;">
	                        			<c:if test="${list.inquiryIndent!=0}"><span style="color:red; font-style:italic; padding-left:${list.inquiryIndent*20}px;">Re:&nbsp;</span></c:if>	
	                        		<a href="${link}" style="color : grey;"><c:out value="${list.inquiryTitle }"/></a></td>
	                        		<td><c:out value="${list.userID }"/></td>
	                        		<td><c:out value="${list.inquiryRegDate }"/></td>
	                        		<td><c:out value="${list.inquiryCnt }"/></td>
	                        	</tr>
	                        	
	                        </c:forEach>
                  
                        </tbody> --%>
                        
                       
</table>