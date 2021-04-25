<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


상품이름: <h2>${pro.proName}</h2>
상품가격: <h2>${pro.proPrice}</h2>
상품브랜드: <h2>${pro.proBrand}</h2>
상품재고: <h2>${pro.proStock}</h2>
상품카테고리:  <h2>${pro.proCateSeq}</h2>
상품사이즈: <h2>${pro.sizeSeq}</h2>

상품이미지: <img src="${pageContext.servletContext.contextPath }/${pro.proImgPath}">