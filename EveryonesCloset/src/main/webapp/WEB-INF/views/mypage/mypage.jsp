<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/esc/mypage.css">

<script type="text/javascript">
$('#myModal').on('shown.bs.modal', function () {
	  $('#myInput').focus()
	})
</script>

<style>
	.mypage_container {
	width: 70%;
	margin: 0 auto;
	font-size: 1em;
	padding-bottom: 5%;
	padding-top: 3%;
}

	.info_container {
		text-align: center;
		height: 120px;
		border: 1px solid;
		border-radius: 5px;
		padding: 3% 1%;
		margin: 3% 1%;
		color: gray;
	}


</style>

<div class="mypage_container">
	<hr>
	<h2 class="mypage_title">My page</h2>
	<div class="mypage_funcion">
		<div class="row">
			<a href="${pageContext.servletContext.contextPath }/mypage/inquiry">
				<div class="col-md-4 col-md-offset-2">
					<div class="info_container">
						<h3>
							<span class="glyphicon glyphicon-pencil glyphicon_padding"></span>INQUIRY
						</h3>
						<h4 style="padding: 1%;">내 문의보기</h4>
					</div>
				</div>
			</a>
			<a href="${pageContext.servletContext.contextPath }/mypage/myInfo">
			<div class="col-md-4">
				<div class="info_container">
					<h3>
						<span class="glyphicon glyphicon-user glyphicon_padding"></span>PROFILE
					</h3>
					<h4 style="padding: 1%;">회원정보수정</h4>
				</div>
			</div>
			</a>
		</div>
		<div class="row">
			<a href="${pageContext.servletContext.contextPath }/mypage/order">
			<div class="col-md-4 col-md-offset-2">
				<div class="info_container">
					<h3>
						<span class="glyphicon glyphicon-shopping-cart glyphicon_padding"></span>ORDER
					</h3>
					<h4 style="padding: 1%;">내 주문내역 조회</h4>
				</div>
			</div>
			</a>
			<a href="${pageContext.servletContext.contextPath }/mypage/withdrawal">
			<div class="col-md-4">
				<div class="info_container">
					<h3>
						<span class="glyphicon glyphicon-trash glyphicon_padding"></span>GOOD-BYE
					</h3>
					<h4 style="padding: 1%;">회원탈퇴</h4>

				</div>
			</div>
			</a>
		</div>
	</div>
</div>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  Launch demo modal
</button>


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>