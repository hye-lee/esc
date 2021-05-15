<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<script type="text/javascript">
	function proList(proCateSeq) {
		$.ajax({
			type : "post",
			url : "proList",
			data : {
				proCateSeq : proCateSeq
			},
			dataType : "json",
			success : function(response, status, xhr) {
				console.log("성공: " + response);
				arrayProList(response);
			},
			error : function(xhr, status, error) {
				console.log("error:: " + error);
			}
		});
	}
	
	function paging(page) {
		var proCateSeq=$('#proCateSeq').val();
		location.href = "${pageContext.servletContext.contextPath}/shop?proCateSeq=" + proCateSeq+"&page="+page;
}
	
	function arrayProList(response) {

		$
				.each(
						response,
						function(index, item) {

							var str = '<div class="col-sm-4 appendbody"><div class="product-image-wrapper"><div class="productinfo text-center"><a href="${pageContext.servletContext.contextPath}/productDetail/'+item.proSeq+'"><img src="${pageContext.servletContext.contextPath}/'+item.proImgPath+'" style= "height:250px; object-fit:cover" /><h2>'
									+ item.proBrand
									+ '</h2><h3>'
									+ item.proName
									+ '</h3><p>'
									+ item.proPrice
									+ '원</p></a></div><div class="choose"><ul class="nav nav-pills nav-justified">';

							if (item.proStock == 0) {
								str += '<li><a href=""><i class="fa fa-ban"></i>대여불가</a></li><li><a href=""><i class="fa fa-bell"></i>예약하기</a></li>';

							} else {
								str += '<li><a href=""><i class="fa fa-plus-square"></i>대여가능['
										+ item.proStock
										+ ']</a></li><li><a href="${pageContext.servletContext.contextPath}/cart/insert?proSeq='
										+ item.proSeq
										+ '"><i class="fa fa-shopping-cart"></i>장바구니</a></li>';
							}

							$('#probody').append(str);

						});

	}

	$().ready(
					function() {

						$('#addProduct')
								.click(
										function() {
											document.location.href = "${pageContext.servletContext.contextPath}/addProduct";
										});

						/* var proCateSeq=$("#proCateSeq").val();
						
						if(proCateSeq==0){
							console.log("proCateSeq:: "+proCateSeq);
							//proCateSeq=0;
							proList(proCateSeq);
						}
						
						$('#proCateSeq').change(function(){
							$('.appendBody').remove();
							var proCateSeq1=$("#proCateSeq").val();
							
							proList(proCateSeq1);
						}); */

					});
</script>



<style>
.text_shop {
	text-align: center;
	color: #696763;
	font-family: 'Quicksand', sans-serif;
	font-size: 5em;
	font-weight: 300;
	padding: 1% 0 3% 0;
}

.shop_width {
	width: 80%;
	margin: 0 auto;
	font-size: 1em;
	padding-bottom: 5%;
	padding-top: 3%;
}

.product-image-wrapper {
	border: 1px solid #F7F7F5;
	overflow: hidden;
	margin-bottom: 5%;
}

.productinfo h2 {
	color: #FE980F;
	font-family: 'Roboto', sans-serif;
	font-size: 1.5em;
	font-weight: 700;
	margin-bottom: 1%;
}

.productinfo h3 {
	color: #999999;
	font-family: 'Roboto', sans-serif;
	font-size: 1.2em;
	font-weight: 400;
	margin: 3% 0 5% 0;
}

.pagination {
	display: -ms-flexbox;
	display: flex;
	padding-left: 0;
	list-style: none;
	border-radius: 0.25rem;
}
</style>
<div class="shop_width">
	<hr>
	<h2 class="text_shop">Shop</h2>
	<div class="row">
		<div class="col-sm-3">
			<div class="left-sidebar">
				<h2>Category</h2>
				<div class="panel-group category-products" id="accordian">
					<!--category-productsr-->
					<form id="proListForm" method="post">
						<input type="hidden" id="proCateSeq" name="proCateSeq"
							value="${proCateSeq}">


						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a
										href="${pageContext.servletContext.contextPath }/shop?proCateSeq=0">ALL</a>
								</h4>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a
										href="${pageContext.servletContext.contextPath }/shop?proCateSeq=1">Outer</a>
								</h4>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a
										href="${pageContext.servletContext.contextPath }/shop?proCateSeq=2">Top</a>
								</h4>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a
										href="${pageContext.servletContext.contextPath }/shop?proCateSeq=3">Dress</a>
								</h4>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a
										href="${pageContext.servletContext.contextPath }/shop?proCateSeq=4">Pants</a>
								</h4>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a
										href="${pageContext.servletContext.contextPath }/shop?proCateSeq=5">Skirt</a>
								</h4>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a
										href="${pageContext.servletContext.contextPath }/shop?proCateSeq=6">Shoes</a>
								</h4>
							</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a
										href="${pageContext.servletContext.contextPath }/shop?proCateSeq=7">Bags</a>
								</h4>
							</div>
						</div>

					</form>
				</div>
				<!--/category-productsr-->

				<!-- <div class="brands_products">brands_products
							<h2>Brands</h2>
							<div class="brands-name">
								<ul class="nav nav-pills nav-stacked">
									<li><a href=""> <span class="pull-right">(50)</span>Acne</a></li>
									<li><a href=""> <span class="pull-right">(56)</span>Grüne Erde</a></li>
									<li><a href=""> <span class="pull-right">(27)</span>Albiro</a></li>
									<li><a href=""> <span class="pull-right">(32)</span>Ronhill</a></li>
									<li><a href=""> <span class="pull-right">(5)</span>Oddmolly</a></li>
									<li><a href=""> <span class="pull-right">(9)</span>Boudestijn</a></li>
									<li><a href=""> <span class="pull-right">(4)</span>Rösch creative culture</a></li>
								</ul>
							</div>
						</div>/brands_products
						 -->


			</div>
		</div>

		<div class="col-sm-9 padding-right">
			<div class="features_items">
				<!--features_items-->
				<h2 class="title text-center">
					★
					<c:out value="${title }"></c:out>
					★
				</h2>

				<div id="probody">
					<c:choose>
						<c:when test="${ list!=null}">
							<c:forEach var="list" items="${list}" varStatus="status">

								<div class="col-sm-4 appendbody">
									<div class="product-image-wrapper">

										<div class="productinfo text-center">


											<a
												href="${pageContext.servletContext.contextPath}/productDetail/${list.proSeq}">
												<img
												src="${pageContext.servletContext.contextPath}/${list.proImgPath}"
												style="height: 250px; object-fit: cover" />
												<h2>
													<c:out value="${ list.proBrand}"></c:out>
												</h2>
												<h3>
													<c:out value="${ list.proName}"></c:out>
												</h3>
												<p>
													<fmt:formatNumber value="${list.proPrice}"
														pattern="#,###,###" />
													원
												</p>
											</a>
										</div>

										<div class="choose">
											<ul class="nav nav-pills nav-justified">
												<c:choose>
													<c:when test="${ list.proStock==0}">
														<li><a><i class="fa fa-ban"></i>대여불가</a></li>
														<li><a href=""><i class="fa fa-bell"></i>예약하기</a></li>
													</c:when>
													<c:otherwise>
														<li><a href=""><i class="fa fa-plus-square"></i>대여가능[${list.proStock}]</a></li>
														<li><a
															href="${pageContext.servletContext.contextPath}/cart/insert?proSeq=${list.proSeq}"><i
																class="fa fa-shopping-cart"></i>장바구니</a></li>
													</c:otherwise>
												</c:choose>

											</ul>
										</div>


									</div>
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							상품없음
							</c:otherwise>

					</c:choose>


				</div>

			</div>
			<!--features_items-->
			<nav aria-label="Page navigation example" style="padding-top: 3%;">
					<ul class="pagination" style="justify-content: center;">
						<li class="page-item"><c:if test="${pageDto.block != 1 }">
								<a class="page-link" href="#" tabindex="-1" aria-disabled="true"
									onClick="paging(1)">Start</a>
							</c:if> <c:if test="${pageDto.page != 1}">
								<a class="page-link" href="#" tabindex="-1" aria-disabled="true"
									onClick="paging('${pageDto.pre }')">Previous</a>
							</c:if></li>

						<c:forEach var="pageNum" begin="${pageDto.startPage}"
							end="${pageDto.endPage}">
							<c:choose>
								<c:when test="${pageNum == pageDto.page}">
									<li class="page-item active" aria-current="page"><a
										class="page-link" onClick="paging('${pageNum}')">${pageNum}</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										onClick="paging('${pageNum}')">${pageNum}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<li class="page-item"><c:if
								test="${pageDto.page != pageDto.totalPage && pageDto.totalPage > 0}">
								<a class="page-link" onClick="paging('${pageDto.next }')">Next</a>
							</c:if> <c:if
								test="${pageDto.block ne pageDto.totalBlock && pageDto.totalBlock > 0}">
								<a class="page-link" onClick="paging('${pageDto.totalPage }')">End</a>
							</c:if></li>
					</ul>
				</nav>
		</div>
	</div>
</div>
