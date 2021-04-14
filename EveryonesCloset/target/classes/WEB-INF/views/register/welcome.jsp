<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<script>
$(function(){
	$("#mainBtn").click(function(){
		main_go();
	});
	
});

function main_go(){
	location.href="${pageContext.servletContext.contextPath}";
}

</script>
    
<div class=	"card-body text-center">
		<div class="form-group">	
				<img src="${pageContext.servletContext.contextPath}/resources/images/welcome3.jpg" class="img-responsive center-block" style="width:40%;height:40%;" object-fit:cover;">
					<div style="font-weight: 700; font-size: 20pt; color: DimGray;"><a href="#" style="color: tomato;">회원가입</a>이 완료되었습니다</div>
					<div style="font-weight: 700; font-size: 20pt; margin-top: 10px; color: DimGray;">EveryoneS Closet에서 <a href="#" style="color: tomato;">${sessionScope.login}님</a>만의 옷을 찾아보세요!</div>
					<button type="button" id="mainBtn" class="btn waves-effect waves-light btn-danger"  style="border-radius : 15px; margin-top: 40px; width: 30%; font-size: 15px;">Main</button>
				</div>
</div>	