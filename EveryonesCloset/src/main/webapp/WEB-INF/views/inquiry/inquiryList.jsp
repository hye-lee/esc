<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">

	$().ready(function(){
		
		 var session='${checkSession}';
		if(session==null||session=="")
			{
			$('#inquiryAdd').prop('disabled','disabled');
			}
		
		 $('#inquiryAdd').click(function(){
			 document.location.href="${pageContext.servletContext.contextPath}/inquiryWrite";
		 });
		 
		
		 
	});
	
	function paging(page) {
			location.href = "${pageContext.servletContext.contextPath}/inquiry?page=" + page;
	}

</script>

<style>
.table_width{
    	width: 70%;
		margin: 0 auto;
		font-size: 1em;
    }
    
.table_center th{
	text-align: center;
}

.table_center td{
	text-align: center;
}
</style>

<div class="table_width" >
	 <button type="button" class="btn btn-warning" style="float:right; margin:3% 0 3% 0;"  id="inquiryAdd" > 문의하기</button>
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
	                        		<td style="text-align: left;"><a href="${link}" style="color : grey;"><c:out value="${list.inquiryTitle }"/></a></td>
	                        		<td><c:out value="${list.userID }"/></td>
	                        		<td><c:out value="${list.inquiryRegDate }"/></td>
	                        		<td><c:out value="${list.inquiryCnt }"/></td>
	                        	</tr>
	                        	
	                        </c:forEach>
                  
                        </tbody>
                        
                        <tfoot>
                       
                    <c:if test="${pageDto.block != 1 }">
                        <a href="#" onClick="paging(1)">[처음]</a> 
                    </c:if>
                    <c:if test="${pageDto.page != 1}">
                        <a href="#" onClick="paging('${pageDto.pre }')">[이전]</a> 
                    </c:if>
                    <c:forEach var="pageNum" begin="${pageDto.startPage }" end="${pageDto.endPage }">
                        <c:choose>
                            <c:when test="${pageNum == pageDto.page}">
                                <span style="font-weight: bold;"><a href="#" onClick="paging('${pageNum }')">${pageNum }</a></span> 
                            </c:when>
                            <c:otherwise>
                                <a href="#" onClick="paging('${pageNum }')">${pageNum }</a> 
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${pageDto.page != pageDto.totalPage && pageDto.totalPage > 0}">
                        <a href="#" onClick="paging('${pageDto.next }')">[다음]</a> 
                    </c:if>
                    <c:if test="${pageDto.block ne pageDto.totalBlock && pageDto.totalBlock > 0}">
                        <a href="#" onClick="paging('${pageDto.totalPage }')">[끝]</a> 
                    </c:if>
             
                        </tfoot>
		

</table>

</div>

