<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<style>
	.outer {
                margin: 0 auto;  /* 세로 가로 */
                width: 50%;
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
								<li><a href="cart.html"><i class="fa fa-shopping-cart"></i> Cart</a></li>
								
								<c:if test="${sessionScope.login == null}" >
								<li><a href="${pageContext.servletContext.contextPath}/login"><i class="fa fa-lock"></i> Login</a></li>
								</c:if>
								<c:if test="${sessionScope.login != null}" >
								<li><a href="#"><i class="fa fa-user"></i> Account</a></li>
								<li><a href="${pageContext.servletContext.contextPath}/logout"><i class="fa fa-unlock"></i> Logout</a></li>
								</c:if>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
		
			<div class="container">
				<div class="title-header">
					<img src="${pageContext.servletContext.contextPath}/resources/images/logo/title4.jpg" alt="" />
				</div>
				
			
			</div>
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row outer">
						<div class="mainmenu">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="index.html" class="active">Home</a></li>
								<li class="dropdown"><a href="#">Shop<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu pull-left">
                                        <li><a href="shop.html">Products</a></li>
										<li><a href="product-details.html">Product Details</a></li> 
										<li><a href="checkout.html">Checkout</a></li> 
										<li><a href="cart.html">Cart</a></li> 
										<li><a href="login.html">Login</a></li> 
                                    </ul>
                                </li> 
								<li class="dropdown"><a href="#">Blog<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu pull-left">
                                        <li><a href="blog.html">Blog List</a></li>
										<li><a href="blog-single.html">Blog Single</a></li>
                                    </ul>
                                </li> 
								<li><a href="404.html">404</a></li>
								<li><a href="contact-us.html">Contact</a></li>
							</ul>
						</div>
					
					
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->