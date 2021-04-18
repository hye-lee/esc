<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
	$().ready(function (){
		$('#inquiryContext').html('${info.inquiryContent}');
		
		$('#reWrite').click(function(){
			reWrite();
		});
	});
	
	function reWrite(){
		var inquiryParent=${info.inquiryParent};
		var inquyirySeqOrd=${info.inquirySeqOrd};
		var inquiryIndent=${info.inquiryIndent};
		console.log("inquiryParent: "+ inquiryParent);
		
		document.reWhiteForm.submit();
	}

</script>

<style>
   .editor{
    	width: 50%;
		margin: 0 auto;
    }

</style>


<div class="editor">
    		<h3><c:out value="${info.inquiryTitle}"/></h3>
            <p><c:out value="${info.userID}"/> | <c:out value="${info.inquiryRegDate}"/></p>
    		
    		<hr>
    		<div id="inquiryContext"></div>
    		
    		<form name="reWhiteForm" id="reWhiteForm" method="post" action="inquiryWrite">
    			
	             <input type="hidden" name="inquiryParent" value="${info.inquiryParent}"/>
	    		 <input type="hidden" name="inquirySeqOrd" value="${info.inquirySeqOrd}"/>
	    		 <input type="hidden" name="inquiryIndent" value="${info.inquiryIndent}"/>
	    		 <input type="hidden" name="userID" value="${sessionScope.login}"/>
           </form>
			 <input type="hidden" name="inquirySeq" value="${info.inquirySeq}">
    		 parent: <c:out value="${info.inquiryParent}"/>
    		 seqOrd: <c:out value="${info.inquirySeqOrd}"/>
    		 indent: <c:out value="${info.inquiryIndent}"/>
    		 <c:if test="${info.userID == sessionScope.login}">
    		 			<button type="button" id="reWrite">답글</button>
    		 				<a href="inquiryWrite<c:out value="${info.inquirySeq}"/>" class="w3-button">수정</a>
                            <a href="inquiryWrite?inquirySeq=<c:out value="${info.inquirySeq}"/>" class="w3-button">수정</a>
                            <a href="delete?inquirySeq=<c:out value="${info.inquirySeq}"/>" class="w3-button">삭제</a>
                            <%--<a href="#" id="delBtn" name="delBtn" class="del w3-button">삭제</a>--%>
                        </c:if>
    			 <a href="#" onclick="document.location='${pageContext.servletContext.contextPath}/inquiry'">목록</a>
</div>



<%-- <div class="card">
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
                            <a href="inquiryWrite?inquirySeq=<c:out value="${info.inquirySeq}"/>" class="w3-button">수정</a>
                            <a href="delete?inquirySeq=<c:out value="${info.inquirySeq}"/>" class="w3-button">삭제</a>
                            <a href="#" id="delBtn" name="delBtn" class="del w3-button">삭제</a>
                        </c:if>

                        <a href="#" onclick="document.location='${pageContext.servletContext.contextPath}/inquiry'">목록</a>
                        
                    </div>
                </div>
            </div>
        </div> --%>