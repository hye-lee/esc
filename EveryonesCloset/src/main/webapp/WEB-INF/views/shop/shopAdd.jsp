<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
	$().ready(function(){
		
	// ******dropify******* 시작
	// Basic
       $('.dropify').dropify({
    	    messages: {
    	        'default': 'Drag and drop a file here or click',
    	        'replace': 'Drag and drop or click to replace',
    	        'remove':  '삭제',
    	        'error':   '에러가 발생했어요!'
    	    }
    	}).on('dropify.beforeClear', function(event, element) {
            return confirm("\"" + element.file.name + "\" 을/를 삭제하시겠습니까?");
        }).on('dropify.afterClear', function(event, element) {
            alert('삭제되었습니다.');
        }).on('dropify.errors', function(event, element) {
            console.log('에러발생');
        });

    
       // ******dropify******* 끝
		
	});
</script>


<form method="post" action="addGoods" enctype="multipart/form-data">
	상품이름: <input type="text" name="proName">
	상품가격:<input type="text" name="proPrice">
	상품재고: <input type="text" name="proStock">
	상품브랜드:<input type="text" name="proBrand">
	 상품사이즈: <input type="text" name="sizeSeq">
	상품카테고리:<input type="text" name="proCateSeq">
	상품이미지: <input type="file"  class="dropify" name="proImgPath"/>
	<br/>
  			  <input type="submit" value="저장">
</form>