<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
    <script src="lang/summernote-ko-KR.js"></script>
	<script src="https://github.com/summernote/summernote/tree/master/lang/summernote-ko-KR.js"></script>

   <script>
   $().ready(function(){
	   $('#summernote').summernote({
	        placeholder: '내용을 입력하세요.',
	        tabsize: 10,
	        height: 300,
	        toolbar: [
	          ['style', ['style']],
	          ['font', ['bold', 'underline', 'clear']],
	          ['color', ['color']],
	          ['para', ['ul', 'ol', 'paragraph']],
	          ['table', ['table']],
	          ['insert', ['link', 'picture', 'video']],
	          ['view', ['fullscreen', 'codeview', 'help']]
	        ],
	        lang: 'ko-KR' 
	     //   
	      });
	  
	   var markupStr = '${info.inquiryContent}'
	   console.log("markupStr: "+markupStr);
	   $('#summernote').summernote('code', markupStr);
	   
	  // $('#summernote').summernote();
	  
	   $("#btnSave").click(function () {
		 	 var form=document.writeForm;
		 	console.log("form: "+form);
		 	 var userID=form.userIDs.value;
	          var inquiryTitle=form.inquiryTitle.value;
	          var inquiryContent=form.inquiryContent.value;
	          var inquiryParent=form.inquiryParent.value;
	          console.log("userID: "+userID);
	          console.log("inquiryTitle: "+inquiryTitle);
	          console.log("inquiryContent: "+inquiryContent);
	          console.log("info.inquiryParent: "+inquiryParent);
	          if(inquiryTitle.trim()=='')
	        	  {
	        	  	alert("제목을 입력하세요");
	        	  	return false;
	        	  }
	          if(userID.trim()==''){alert("로그인을 해주세요"); return false;}
	          if(inquiryContent.trim()==''){alert("내용을 입력하세요"); return false;}
	          form.submit();
	      });
	   
	})
	
	

     
    </script>
    
    <style>
    .editor{
    	width: 50%;
		margin: 0 auto;
    }
    
    .contextPadding{
    	padding-bottom:3%;
    }
    
    .contextFont{
    	font-size: 1.5em;
		font-weight: 200;
		padding:2%;
    }
  
    </style>
    
    <div class="editor">
    		<div style="margin-bottom:20px">
    			 <h3 class="text-themecolor contextPadding">질문작성</h3>
    		</div>
    		<form id="writeForm" name="writeForm" method="post" action="inquirySave">
    			<div class="form-inline contextPadding">
    				<h4>작성자</h4>
    						<input type="text" id="userIDs" name="userIDs" class="form-control contextFont" value="<c:out value='${sessionScope.login}'/>" disabled="true">
    						<input type="hidden" id="userID" name="userID" value="${sessionScope.login}">
    				
    				    				
    			</div>
    			
    			<div class="form-group contextPadding">
                        <h4>제목</h4> 
                        <input type="text" id="inquiryTitle" name="inquiryTitle" class="form-control contextFont" value="<c:out value="${info.inquiryTitle}"/>" placeholder="제목을 입력하세요.">
                </div>
           
                <div class="form-group">
                    	<h4>내용</h4>
                        <textarea class="contextFont" id="summernote" name="inquiryContent"></textarea>
                      <!--  <input type="hidden" name="inquiryContent" value="<c:out value='${info.inquiryContent}'/>">
                       --> 
                </div>
                
                 <div class="text-center">
                        <input type="hidden" name="inquirySeq" value="<c:out value='${info.inquirySeq}'/>">
                        <input type="hidden" id="inquiryParent" name="inquiryParent" value="<c:out value='${info.inquiryParent}'/>">
                        <input type="hidden" id="inquirySeqOrd" name="inquirySeqOrd" value="<c:out value='${info.inquirySeqOrd}'/>">
                        <input type="hidden" id="inquiryIndent" name="inquiryIndent" value="<c:out value='${info.inquiryIndent}'/>">
                        <button type="button" name="btnSave" id="btnSave"
                                class="btn waves-effect waves-light btn-block btn-warning">저장</button>
                        <a href="#" onclick="history.back(-1)" data-role="button"
                           class="btn waves-effect waves-light btn-block btn-warning">취소</a>
                    </div>
    		</form>	 
    	
</div>

