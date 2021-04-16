<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
	$().ready(function (){
		$('#inquiryContext').html('${info.inquiryContent}');
	});

</script>


<div class="card">
            <div class="card-body">
                <div class="card-title">
                    <h3><c:out value="${info.inquiryTitle}"/></h3>
                    <p><c:out value="${info.userID}"/> | <c:out value="${info.inquiryRegDate}"/></p>
                </div>
                <hr>
                <div class="card-text">
                    <div id="inquiryContext"></div>

                    <div class="card-body text-right" style="padding-bottom:0">
                        <input type="hidden" name="inquirySeq" value="${info.inquirySeq}">

                        <c:if test="${info.userID == sessionScope.login}">
                            <a href="writePage?inquirySeq=<c:out value="${info.inquirySeq}"/>" class="w3-button">수정</a>
                            <a href="delete?inquirySeq=<c:out value="${info.inquirySeq}"/>" class="w3-button">삭제</a>
                            <%--<a href="#" id="delBtn" name="delBtn" class="del w3-button">삭제</a>--%>
                        </c:if>

                        <a href="#" onclick="document.location='${pageContext.servletContext.contextPath}/inquiry'">목록</a>
                        
                    </div>
                </div>
            </div>
        </div>