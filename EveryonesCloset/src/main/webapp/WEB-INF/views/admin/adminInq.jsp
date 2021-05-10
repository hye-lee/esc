<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.util.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<script type="text/javascript">

function paging(page) {
	location.href = "${pageContext.servletContext.contextPath}/admin?page=" + page;
}
</script>



<style>

.table_center th{
	text-align: center;
}

.table_center td{
	text-align: center;
}


.pagination {
  display: -ms-flexbox;
  display: flex;
  padding-left: 0;
  list-style: none;
  border-radius: 0.25rem;
}

.page-link {
  position: relative;
  display: block;
  padding: 0.5rem 0.75rem;
  margin-left: -1px;
  line-height: 1.25;
  color: #007bff;
  background-color: #fff;
  border: 1px solid #dee2e6;
}

</style>

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
                        
                         <tbody class="table_center">
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
                  
                        </tbody> 
                        
                       
</table>

<nav aria-label="Page navigation example" style="padding-top:3%;">
	  <ul class="pagination" style="justify-content:center;">
		    <li class="page-item">
		    	<c:if test="${pageDto.block != 1 }">
		      		<a class="page-link" href="#" tabindex="-1" aria-disabled="true" onClick="paging(1)">Start</a>
		        </c:if>
		        
		        <c:if test="${pageDto.page != 1}">
		             <a class="page-link" href="#" tabindex="-1" aria-disabled="true" onClick="paging('${pageDto.pre }')">Previous</a> 
		        </c:if>
		    </li>
	    
	       <c:forEach var="pageNum" begin="${pageDto.startPage}" end="${pageDto.endPage}">
		        <c:choose>
		             <c:when test="${pageNum == pageDto.page}">
		            	 <li class="page-item active" aria-current="page">
		                  	<a class="page-link" onClick="paging('${pageNum}')">${pageNum}</a>
		                 </li>
		             </c:when>
		             <c:otherwise>
		                 <li class="page-item">
		                    <a class="page-link" onClick="paging('${pageNum}')">${pageNum}</a>
		                 </li>
		             </c:otherwise>
		        </c:choose>
	       </c:forEach>
	
		    <li class="page-item">
		    	 <c:if test="${pageDto.page != pageDto.totalPage && pageDto.totalPage > 0}">
		             <a class="page-link" onClick="paging('${pageDto.next }')">Next</a>
		         </c:if>
		         <c:if test="${pageDto.block ne pageDto.totalBlock && pageDto.totalBlock > 0}">
		            <a class="page-link" onClick="paging('${pageDto.totalPage }')">End</a> 
		         </c:if>
		    </li>
	    </ul>
	</nav>