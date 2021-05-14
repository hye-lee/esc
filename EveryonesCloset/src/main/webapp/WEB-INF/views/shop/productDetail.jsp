<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
	.text_shop {
	text-align: center;
	color: #696763;
	font-family: 'Quicksand', sans-serif;
	font-size: 5em;
	font-weight: 300;
	padding: 1% 0 3% 0;
}

</style>

<div class="shop_width">

	<hr>
	<h2 class="text_shop">Shop</h2>
	<div class="row">
		<div class="col-sm-3">
			<img src="${pageContext.servletContext.contextPath }/${pro.proImgPath}" style="width:60%;">
		</div>
		<div class="col-sm-3">
			상품이름:
			<h2>${pro.proName}</h2>
			상품가격:
			<h2>${pro.proPrice}</h2>
			상품브랜드:
			<h2>${pro.proBrand}</h2>
			상품재고:
			<h2>${pro.proStock}</h2>
			상품카테고리:
			<h2>${pro.proCateSeq}</h2>
			상품사이즈:
			<h2>${pro.sizeSeq}</h2></div>
			<div class="col-sm-3">
			
			</div>
	</div>
</div>
