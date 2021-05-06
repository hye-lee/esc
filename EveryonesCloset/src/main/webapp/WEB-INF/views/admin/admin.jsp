<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
 	$(function(){
 		
 		var pageName= $(this).attr("id");
 		
 		if(!pageName){ blockPage("user");}
 		
 		$(".adminMenu").click(function(){
 			pageName= $(this).attr("id");
 			console.log("page::"+pageName);
 			blockPage(pageName);
 		})
 	});
 	
 	
 	function blockPage(pageName){
 		
 		var pageKorName= $("#"+pageName).text();
 		console.log(pageKorName);
 		$.ajax({
 			type: 'post',
 			url: 'admin/'+pageName,
 			dataType: 'html',
 			success: function(res,status, xhr){
 				$('#blockContext').html(res);
 				
 			},
 			error: function (xhr, status, error){
				console.log(error);
			}
 		});
 	}
</script>

<style>
.admin_width {
	width: 90%;
	margin: 0 auto;
	font-size: 1em;
	padding-bottom: 5%;
	padding-top: 3%;
}

.text_admin{
	text-align:center;
	color: #696763;
  	font-family: 'Quicksand', sans-serif;
 	 font-size: 5em;
 	 font-weight: 300;
 	 padding: 1% 0 3% 0;
}
</style>

<div class="admin_width">
	<hr>
	<h2 class="text_admin">Admin</h2>
	<div class="row">
		<div class="col-sm-2">
			<div class="left-sidebar">
				<h2>Menu</h2>
				<div class="panel-group category-products" id="accordian">
					<!--category-productsr-->
					<form id="proListForm" method="post">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a class="adminMenu" id="user" href="#">회원관리 User</a>
								</h4>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a class="adminMenu" id="product" href="#">상품관리 Product</a>
								</h4>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a class="adminMenu" id="order" href="#">주문관리 Order</a>
								</h4>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a class="adminMenu" id="inquiry" href="#">문의관리 Inquiry</a>
								</h4>
							</div>
						</div>
						
					</form>
				</div>

			</div>
		</div>
		
		<div class="col-sm-10" id="blockContext">
	
		</div>
		
	</div>
</div>
