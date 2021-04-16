<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">

	$().ready(function(){
		 $('#inquiryAdd').click(function(){
			 document.location.href="${pageContext.servletContext.contextPath}/inquiryWrite";
		 });
	})
	
	function fn_paging(page) {
			location.href = "${pageContext.servletContext.contextPath}/inquiry?page=" + page;
	}

</script>

<style>
.table_width{
    	width: 70%;
		margin: 0 auto;
		font-size: 1em;
    }
    
.table_center{
	text-align: center;
}

</style>

<button id="inquiryAdd">문의하기</button>

		<table class="table table-hover table_width">
                        <colgroup>
                            <col width='8%'/>   <%-- 번호 --%>
                            <col width='*%'/>   <%-- 제목 --%>
                            <col width='10%'/>   <%-- 작성자 --%>
                            <col width='20%'/>   <%-- 작성일 --%>
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
                        
                        <tbody>
	                        <c:forEach var="list" items="${list}" varStatus="status">
	                        	<c:url var="link" value="read">
	                        		<c:param name="inquirySeq" value="${list.inquirySeq}"/>
	                       		 </c:url>
	                        	
	                        	<tr>
	                        		<td><c:out value="${list.inquirySeq}"/></td>
	                        		<td><a href="${link}"><c:out value="${list.inquiryTitle }"/></a></td>
	                        		<td><c:out value="${list.userID }"/></td>
	                        		<td><c:out value="${list.inquiryRegDate }"/></td>
	                        		<td><c:out value="${list.inquiryCnt }"/></td>
	                        	</tr>
	                        	
	                        </c:forEach>
                  
                        </tbody>
				<div>
                    <c:if test="${pageDto.block != 1 }">
                        <a href="#" onClick="fn_paging(1)">[처음]</a> 
                    </c:if>
                    <c:if test="${pageDto.page != 1}">
                        <a href="#" onClick="fn_paging('${pageDto.pre }')">[이전]</a> 
                    </c:if>
                    <c:forEach var="pageNum" begin="${pageDto.startPage }" end="${pageDto.endPage }">
                        <c:choose>
                            <c:when test="${pageNum == pageDto.page}">
                                <span style="font-weight: bold;"><a href="#" onClick="fn_paging('${pageNum }')">${pageNum }</a></span> 
                            </c:when>
                            <c:otherwise>
                                <a href="#" onClick="fn_paging('${pageNum }')">${pageNum }</a> 
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${pageDto.page != pageDto.totalPage && pageDto.totalPage > 0}">
                        <a href="#" onClick="fn_paging('${pageDto.next }')">[다음]</a> 
                    </c:if>
                    <c:if test="${pageDto.block ne pageDto.totalBlock && pageDto.totalBlock > 0}">
                        <a href="#" onClick="fn_paging('${pageDto.totalPage }')">[끝]</a> 
                    </c:if>
                </div>
                
                <div>
                    총 게시글 수 : ${pageDto.total } /    총 페이지 수 : ${pageDto.totalPage } / 현재 페이지 : ${pageDto.page } / 현재 블럭 : ${pageDto.block } / 총 블럭 수 : ${pageDto.totalBlock }
                </div>

</table>

