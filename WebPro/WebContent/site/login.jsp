<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<style type="text/css">
.container-fluid {
	width: 40%;
	margin: 30%
}
.row {
	border: 4px solid lightgray;
	padding: 10%;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12">
				<input id="userId" class="form-control">
			</div>
			<div class="col-xs-12">
				<input id="userPw" type="password" class="form-control">
			</div>
			<div class="col-xs-12">
				<input id="loginBtn" type="button" value="로그인"
					class="btn btn-success col-xs-12">
			</div>
			<div class="col-xs-12">
				<a href="/WebPro/join">회원가입하기</a>
			</div>
		</div>
	</div>


	<script>
		// ajax 통신으로 /20221027/loadTest.jsp의 결과를 콘솔에 출력
		$('#loginBtn').click(function() {
// 			var id = document.querySelector('#userId').value;
			// jsp 파일에서는 달러 백틱 사용금지 주석에서도
			var pw = document.querySelector('#userPw').value;
			var data = "usrId="+$("#userId").val()+"&usrPw="+pw;
			console.log(data);
			var req = new XMLHttpRequest();
			req.open('post', '/webPro/20221027/loadTest.jsp', true);
			req.onreadystatechange = function() {
				if (req.readyState == 4 && req.status == 200) {
// 					console.log(req.responseText);
					var jsObj = JSON.parse(req.responseText);
					if(jsObj.rst == "ok"){
						location.replace("/webPro/Index.do");	// location.href = ""
					} else {
						// 현재 페이지 새로고침
						location.reload();
					}
				}
			}
			req.setRequestHeader('content-type','application/x-www-form-urlencoded');
			req.send(data);
		});
	</script>
</body>
</html>