<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
	$().ready(function (){
		$('#inquiryContext').html('${info.inquiryContent}');
		
		$('#reWrite').click(function(){
			reWrite();
		});
		
		$('#updateInq').click(function(){
			document.updateInquiry.submit();
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
		font-size: 1em;
		padding:4% 0 8% 0;
		font-family: 'Noto Sans KR', sans-serif;
    }
	.title{
		color: #696763;
	}
</style>


<div class="editor">
	<div class="row">
		<div class="col-md-2 title">
			<h4>제목</h4>
		</div>
		<div class="col-md-10">
			<h2 style="margin:0;"><c:out value="${info.inquiryTitle}"/></h2>
		</div>
	</div>
    <div class="row">
		<div class="col-md-2 title">
			<h4>작성자</h4>
		</div>
		<div class="col-md-10">
			<h4><c:out value="${info.userID}"/> </h4>
		</div>
	</div>
    <div class="row">
		<div class="col-md-2 title">
			<h4>작성일</h4>
		</div>
		<div class="col-md-10">
			<h4><c:out value="${info.inquiryRegDate}"/> </h4>
		</div>
	</div>		
       
    <hr>
    <div class="row">
		<div class="col-md-2 title">
			<h4>내용</h4>
		</div>
		<div class="col-md-10" style="font-size:1em;">
			<div style=" height:100%;" id="inquiryContext"></div>
		</div>
	</div>		
  	<form name="reWhiteForm" id="reWhiteForm" method="post" action="reply">
  				 <input type="hidden" name="inquirySeq" value="${info.inquirySeq}">
	             <input type="hidden" name="inquiryParent" value="${info.inquiryParent}"/>
	    		 <input type="hidden" name="inquirySeqOrd" value="${info.inquirySeqOrd}"/>
	    		 <input type="hidden" name="inquiryIndent" value="${info.inquiryIndent}"/>
	    		 <input type="hidden" name="userID" value="${sessionScope.login}"/>
	    		
           </form>
           
           <form name="updateInquiry" id="updateInquiry" method="post" action="modify">
        	   	<input type="hidden" name="inquirySeq" value="${info.inquirySeq}">
           </form>
			 <input type="hidden" name="inquirySeq" value="${info.inquirySeq}">
<%--     		seq:<c:out value="${info.inquirySeq}"/>
    		 parent: <c:out value="${info.inquiryParent}"/>
    		 seqOrd: <c:out value="${info.inquirySeqOrd}"/>
    		 indent: <c:out value="${info.inquiryIndent}"/> --%>
    		 <div style="float:right;">
    		 <c:if test="${sessionScope.login!=null}">
    		 	<button type="button" class="btn btn-info" id="reWrite">답글</button>
    		 </c:if>
    		 <c:if test="${info.userID == sessionScope.login}">
				<button type="button" class="btn btn-warning" id="updateInq">수정</button>	
                <button type="button" class="btn btn-danger" onclick="document.location='${pageContext.servletContext.contextPath}/delete?inquirySeq=<c:out value="${info.inquirySeq}"/>'" id="deleteInq">삭제</button>	            
          	</c:if>
    			<button type="button" class="btn btn-default" onclick="document.location='${pageContext.servletContext.contextPath}/inquiry'" id="updateInq">목록</button>	 
    			</div>
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