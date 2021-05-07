<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	$().ready(function(){
		
		$('#shopClick').click(function(){
			document.form.shop.submit();
		});
		
	});
</script>


<style>
	.outer {
                margin: 0 auto;  /* 세로 가로 */
                width: 60%;
                text-align: center;
            }
            
    .title-header{
    		 background: #FFFFFF;
 			 color: #696763;
   			 font-family: 'Roboto', sans-serif;
			 font-size: 100px;
 			 font-weight: 300;
 			 text-align: center;
    }
    
    .mainmenu ul li a {
	color: #696763;
	font-family: 'Roboto', sans-serif;
	font-size: 1.5em;
	font-weight: 400;
	padding: 0;
	padding-bottom: 10px;
}

    
 
</style>


<header id="header"><!--header-->
		<div class="header-middle"><!--header-middle-->

			<div class="container">
				
				<div class="row">
					<div class="col-sm-3">
						<div class="search_box pull-left">
							<input type="text" placeholder="Search"/>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								
								<!--  <li><a href="#"><i class="fa fa-star"></i> Wishlist</a></li>
								<li><a href="checkout.html"><i class="fa fa-crosshairs"></i> Checkout</a></li>-->
								
								<c:if test="${sessionScope.login != null}" >
								<li><a href=""><i class="glyphicon glyphicon-heart"></i><c:out value="${sessionScope.login}"/>님 환영합니다!</a></li>
								</c:if>
								<c:choose>
									<c:when test="${sessionScope.admin==null }">
										<li><a href="${pageContext.servletContext.contextPath}/cart"><i class="fa fa-shopping-cart"></i> Cart</a></li>
										<c:if test="${sessionScope.login == null}" >
										<li><a href="${pageContext.servletContext.contextPath}/login"><i class="fa fa-lock"></i> Login</a></li>
										</c:if>
										<c:if test="${sessionScope.login != null}" >
											<li><a href="${pageContext.servletContext.contextPath}/mypage"><i class="fa fa-user"></i> Account</a></li>
											<li><a href="${pageContext.servletContext.contextPath}/logout"><i class="fa fa-unlock"></i> Logout</a></li>
										</c:if>
									</c:when>
									<c:otherwise>
										<li><a href="${pageContext.servletContext.contextPath}/admin"><i class="fa fa-lock"></i> admin</a></li>
										<li><a href="${pageContext.servletContext.contextPath}/logout"><i class="fa fa-unlock"></i> Logout</a></li>
									</c:otherwise>
								</c:choose>

							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
		
			<div class="container">
				<div class="title-header">
					<a href="${pageContext.servletContext.contextPath}/">
						<img src="${pageContext.servletContext.contextPath}/resources/images/logo/title4.jpg" alt="Everyone's Closet" />
					</a>
				</div>
				
			
			</div>
	
		<div class="header-bottom"><!--header-bottom-->
			
			<div class="container">
				<div class="row outer">
						<div class="mainmenu">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li style="padding-left:30px"><a href="${pageContext.servletContext.contextPath}/" class="active">Home</a></li>
								<li class="dropdown" ><a  href="${pageContext.servletContext.contextPath}/shop?proCateSeq=0">Shop<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu pull-left">
                                        <li><a href="shop.html">Products</a></li>
										<li><a href="product-details.html">Product Details</a></li> 
										<li><a href="checkout.html">Checkout</a></li> 
										<li><a href="cart.html">Cart</a></li> 
                                    </ul>
                                </li> 
                                <li><a href="${pageContext.servletContext.contextPath}/inquiry">Inquiry</a></li>
								<li><a href="contact-us.html">Sharing</a></li>
								<li><a href="contact-us.html">Sharing</a></li>
							</ul>
						</div>
					<form id="shop" action="shop">
						<input type="hidden" id="proCateSeq" value="0">
					</form>
					
				</div>
			</div> 
		</div><!--/header-bottom-->
	</header><!--/header-->