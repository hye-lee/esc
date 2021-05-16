<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.util.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<script type="text/javascript">

	$(function(){
		$('#addProduct').click(function(){
			document.location.href="${pageContext.servletContext.contextPath}/addProduct";
		});
		
	
	
	});

</script>

<style>
	.table_center th{
	text-align: center;
}

.table_center td{
	text-align: center;
}
</style>

<div>
<button type="button" style="float:right;" class="btn btn-warning" id="addProduct" > 상품 추가하기</button>
<table class="table table-hover">
		        <colgroup>
                            <col width='10%'/>   <%-- 사진 --%>
                            <col width='8%'/>   <%-- 상품번호 --%>
                            <col width='12%'/>   <%-- 카테고리 --%>
                            <col width='10%'/>   <%-- 사이즈 --%>
                            <col width='15%'/>   <%-- 브랜드 --%>
                            <col width='*%'/>   <%-- 이름 --%>
                            <col width='8%'/>   <%-- 재고 --%>
                            <col width='8%'/>   <%-- 판매갯수 --%>
                            <col width='15%'/>  <%--수정 삭제 버튼 --%>
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
                            <th> </th>
                        </tr>
                        </thead>
                        
                         <tbody class="table_center">
	                         <c:forEach var="list" items="${list}" varStatus="status">
	                        	<input type="hidden" id="proSeq" name="proSeq">
	                        	<tr>
	                        		<td><img src="${pageContext.servletContext.contextPath}/${list.proImgPath}" style= "height:100px; object-fit:cover;" /></td>
	                        		<td><h3><c:out value="${list.proSeq}"></c:out></h3></td>
	                        		<td><h3>
	                        			<select id="proCateSeq" name="proCateSeq">
	                        				<option value=1  <c:if test="${list.proCateSeq}==1">selected</c:if>>Outer</option>
	                        				<option value=2  <c:if test="${list.proCateSeq} ==2">selected</c:if>>Top</option>
	                        				<option value=3  <c:if test="${list.proCateSeq}==3">selected</c:if>>Dress</option>
	                        				<option value=4  <c:if test="${list.proCateSeq} ==4 ">selected</c:if>>Pants</option>
	                        				<option value=5  <c:if test="${list.proCateSeq} ==5 ">selected</c:if>>Skirt</option>
	                        				<option value=6  <c:if test="${list.proCateSeq} ==6">selected</c:if>>Shoes</option>
	                        				<option value=7  <c:if test="${list.proCateSeq} ==7">selected</c:if>>Bag</option>
	                        			</select>
	                        		</h3></td>
	                        		<td><h3><c:out value="${list.sizeName }"/></h3></td>
	                        		<td><h3><input type="text" id="proBrand" name="proBrand" value="<c:out value='${list.proBrand }'/>"/></h3></td>
	                        		<td><h3><input type="text" id="proName" name="proName" value="<c:out value='${list.proName }' />" size="10"/></h3></td>
	                        		<td><h3><input type="text" id="proStock" name="proStock" value="<c:out value='${list.proStock }'/>" size="2"/></h3></td>
	                        		<td><h3><c:out value="${list.proSellCount }"/></h3></td>
	                        		<td><button type="button" class="btn btn-warning" id="modify" >수정</button>
	                        		<button type="button" class="btn btn-warning" id="delete" >삭제</button></td>
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


</div>