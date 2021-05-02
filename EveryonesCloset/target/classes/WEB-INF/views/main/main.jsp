<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<script>
$('#slider-carousel').carousel({
	  interval: 3000
	});


</script>

<style>
	.text_main{
	text-align:center;
	color: orange;
  	font-family: 'Quicksand', sans-serif;
 	 font-size: 4em;
 	 font-weight: 300;
 	 padding: 3% 0 3% 0;
}
	

</style>

<section id="slider"><!--slider-->
		<div class="container" style="width:70%;">
			<div class="row">
				<div class="col-sm-12">
				<hr>
					<h2 class="text_main">★HOT ITEM★</h2>
					<div id="slider-carousel" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators">
							<c:forEach var="list" items="${list}" varStatus="status">
								<c:choose>
									<c:when test="${status.first }">
										<li data-target="#slider-carousel" data-slide-to="${status.index }" class="active"></li>
									</c:when>
									<c:otherwise>
										<li data-target="#slider-carousel" data-slide-to="${status.index }"></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ol>
						
						<div class="carousel-inner" style="height: 100%;">
							<c:forEach var="list" items="${list}" varStatus="status">
								<c:choose>
									<c:when test="${status.first}">
										<div class="item active" style="height: 100%;">
									</c:when>
									<c:otherwise>
										<div class="item" style="height: 100%;">
									</c:otherwise>
								</c:choose>
									<a href="${pageContext.servletContext.contextPath}/productDetail/${list.proSeq}">
										<div class="col-md-6">	<h1><span>${list.proBrand}</span> </h1>
											<h2>${list.proName} </h2>
											<p><fmt:formatNumber value="${list.proPrice}" pattern="#,###,###" />원</p>
										</div>										
										<div class="col-md-6"><img src="${pageContext.servletContext.contextPath }/${list.proImgPath}" class="girl img-responsive" alt="" style="margin-left: auto; margin-right: auto; display: block; width:70%;" /></div>
									</a>
								</div>	
							</c:forEach>

		
						</div>
						
						<a href="#slider-carousel" class="left control-carousel hidden-xs" role="button" data-slide="prev">
							<i class="fa fa-angle-left"></i>
						</a>
						<a href="#slider-carousel" class="right control-carousel hidden-xs" role="button" data-slide="next">
							<i class="fa fa-angle-right"></i>
						</a>
					</div>
					
				</div>
			</div>
		</div>
	</section><!--/slider-->
	

	<!-- <section id="slider">slider
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div id="slider-carousel" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
							<li data-target="#slider-carousel" data-slide-to="1"></li>
							<li data-target="#slider-carousel" data-slide-to="2"></li>
						</ol>
						
						<div class="carousel-inner">
							<div class="item active">
								<div class="col-sm-6">
									<h1><span>S</span>usannnnn </h1>
									<h2>How are you</h2>
									<p>I am fine and you</p>
									<button type="button" class="btn btn-default get">Get it now</button>
								</div>
								<div class="col-sm-6">
									<img src="images/home/girl1.jpg" class="girl img-responsive" alt="" />
									<img src="images/home/pricing.png"  class="pricing" alt="" />
								</div>
							</div>
							<div class="item">
								<div class="col-sm-6">
									<h1><span>E</span>-SHOPPER</h1>
									<h2>100% Responsive Design</h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
									<button type="button" class="btn btn-default get">Get it now</button>
								</div>
								<div class="col-sm-6">
									<img src="images/home/girl2.jpg" class="girl img-responsive" alt="" />
									<img src="images/home/pricing.png"  class="pricing" alt="" />
								</div>
							</div>
							
							<div class="item">
								<div class="col-sm-6">
									<h1><span>E</span>-SHOPPER</h1>
									<h2>Free Ecommerce Template</h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
									<button type="button" class="btn btn-default get">Get it now</button>
								</div>
								<div class="col-sm-6">
									<img src="images/home/girl3.jpg" class="girl img-responsive" alt="" />
									<img src="images/home/pricing.png" class="pricing" alt="" />
								</div>
							</div>
							
						</div>
						
						<a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
							<i class="fa fa-angle-left"></i>
						</a>
						<a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
							<i class="fa fa-angle-right"></i>
						</a>
					</div>
					
				</div>
			</div>
		</div>
	</section>/slider
	
 -->