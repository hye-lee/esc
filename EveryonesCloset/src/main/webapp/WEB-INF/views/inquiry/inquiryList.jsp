<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">

	$().ready(function(){
		 $('#inquiryAdd').click(function(){
			 document.location.href="${pageContext.servletContext.contextPath}/inquiryWrite";
		 });
	})

</script>

<button id="inquiryAdd">문의하기</button>