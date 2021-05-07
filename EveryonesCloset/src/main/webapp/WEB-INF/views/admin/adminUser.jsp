<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.util.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<script>
	$(function(){
		$('#deleteUser').click(function(){
			var confirm=window.confirm('이 회원을 탈퇴처리 하시겠습니까?');
			var userID=$('#userID').val();
			console.log("userID::"+userID);
			if(confirm){
				$.ajax({
					type: "post",
					url: "admin/deleteUser",
					data: { userID: userID },
					success: function(result){
						if(result==1){
							alert("탈퇴성공!");
							location.href="${pageContext.servletContext.contextPath}/admin";
						}
						else{
							console.log('fail delete cart');
						}
					}
				});
			}
		});
	});

</script>


<style>
	.table_center th{
	text-align: center;
}
</style>

<div>
<table class="table table-hover">
		        <colgroup>
                            <col width='10%'/>   <%-- 회원아이디 --%>
                            <col width='15%'/>   <%-- 이메일 --%>
                            <col width='8%'/>   <%-- 이름 --%>
                            <col width='*%'/>   <%-- 주소 --%>
                            <col width='8%'/>   <%-- 우편번호 --%>
                            <col width='8%'/>   <%-- 탈퇴여부 --%>
                            <col width='12%'/>   <%-- 가입날짜 --%>
                            <col width='8%'/>   <%-- block --%>
                        </colgroup>

                        <thead>
                        <tr class="table_center">
                            <th>ID</th>
                            <th>이메일</th>
                            <th>이름</th>
                            <th>주소</th>
                            <th>우편번호</th>
                            <th>활성여부</th>
                            <th>가입날짜</th>
                            <th>&nbsp;</th>
                        </tr>
                        </thead>
                        
                         <tbody class="table_center">
	                        <c:forEach var="list" items="${list}" varStatus="status">
	                        	<input type="hidden" id="userID" value="${list.userID}">
	                        	<tr>
	                        		<td><c:out value="${list.userID}"></c:out></td>
	                        		<td><c:out value="${list.userEmail }"/></td>
	                        		<td><c:out value="${list.userName }"/></td>
	                        		<td><c:out value="${list.userAddr }"/></td>
	                        		<td><c:out value="${list.userPostCode }"/></td>
	                        		<td><c:out value="${list.userStat }"/></td>
	                        		<td><c:out value="${list.userRegDate }"/></td>
	                        		<td><button type="button" class="close" id="deleteUser" aria-label="Close"><span aria-hidden="true" style="color:red; "><h2>&times;</h2></span></button></td>
	                        	</tr>
	                        	
	                        </c:forEach>
                  
                        </tbody> 
                        
                       
</table>

</div>