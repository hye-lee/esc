<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="ko">
	<head>
		<!-- 공통 meta -->
		<meta charset="utf-8">
		
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
   	 	<meta name="description" content="">
   	 	<meta name="author" content="">
    	<title>Everyone's Closet</title>
    	<link href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    	<link href="${pageContext.servletContext.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet">
	    <link href="${pageContext.servletContext.contextPath}/resources/css/prettyPhoto.css" rel="stylesheet">
	    <link href="${pageContext.servletContext.contextPath}/resources/css/price-range.css" rel="stylesheet">
	    <link href="${pageContext.servletContext.contextPath}/resources/css/animate.css" rel="stylesheet">
		<link href="${pageContext.servletContext.contextPath}/resources/css/main.css" rel="stylesheet">
		<link href="${pageContext.servletContext.contextPath}/resources/css/responsive.css" rel="stylesheet">
		
	
	    <!--[if lt IE 9]>
	    <script src="js/html5shiv.js"></script>
	    <script src="js/respond.min.js"></script>
	    <![endif]-->       
	    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.servletContext.contextPath}/resources/images/ico/apple-touch-icon-144-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.servletContext.contextPath}/resources/images/ico/apple-touch-icon-114-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.servletContext.contextPath}/resources/images/ico/apple-touch-icon-72-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" href="${pageContext.servletContext.contextPath}/resources/images/ico/apple-touch-icon-57-precomposed.png">
	
		
		 <!-- All Jquery -->
	    <!-- ============================================================== -->
	    <script src="${pageContext.servletContext.contextPath}/resources/assets/node_modules/jquery/jquery-3.2.1.min.js"></script>
	
	        <!-- Bootstrap tether Core JavaScript -->
    	<script src="${pageContext.servletContext.contextPath}/resources/assets/node_modules/popper/popper.min.js"></script>
    	<script src="${pageContext.servletContext.contextPath}/resources/assets/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
		
		
		<!-- Font Noto Sans -->
		<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Quicksand:300" rel="stylesheet">
		
		<style>
		html, body, div, span, object, iframe, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, ol, ul, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas, details, embed, figure, figcaption, footer, header, hgroup, menu, nav, output, ruby, section, summary, time, mark, audio, video, h2, h3, h4, h5, h6
		{
			font-family: 'Noto+Sans+KR', sans-serif;
		}
		</style> 
		
  		<tiles:insertAttribute name="header"/>
  	</head>
	<body class="mini-sidebar skin-default fixed-layout" >
   	 	<tiles:insertAttribute name="left"/>
		<tiles:insertAttribute name="nav"/>
		<tiles:insertAttribute name="content"/>
		<tiles:insertAttribute name="footer"/>
	</body>
</html>
