<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="MAIN"></c:set>
<%@ include file="../common/head.jspf"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sla Recipe</title>
<style>
.SlaRecipeStartPageVer01 {
	width: 1440px;
	height: 900px;
	position: relative;
	background: white;
}

.Rectangle61 {
	width: 100%;
	height: 100%;
	left: 0;
	top: 0;
	position: absolute;
	background: linear-gradient(0deg, #D9D9D9 0%, #D9D9D9 100%);
}

.HeadIcons {
	width: 160px;
	height: 55px;
	left: 1214px;
	top: 59px;
	position: absolute;
}

.logo {
	position: absolute;
	width: 153px;
	height: 193px;
}

.LoginIcon, .MenuIcon {
	width: 43.96px;
	height: 38.19px;
	position: absolute;
}

.MenuIcon {
	left: 116.04px;
}

.LoginIcon {
	left: 52.75px;
}

.Group6 {
	width: 1440px;
	height: 99px;
	left: 0;
	top: 801px;
	position: absolute;
}

.SlaRecipeStartHeadBar {
	width: 1440px;
	height: 99px;
	left: 0;
	top: 0;
	position: absolute;
}

.Group22 {
	width: 304.07px;
	height: 30.62px;
	position: absolute;
	display: flex;
	align-items: center;
}

.Group23 {
	width: 304.07px;
	height: 30.62px;
	left: 25%;
	position: absolute;
	display: flex;
	align-items: center;
}

.Group24 {
	width: 304.07px;
	height: 30.62px;
	left: 50%;
	position: absolute;
	display: flex;
	align-items: center;
}

.Group25 {
	width: 304.07px;
	height: 30.62px;
	left: 75%;
	position: absolute;
	display: flex;
	align-items: center;
}

.DoubleArrowFill0Wght400Grad0Opsz241 {
	width: 30px;
	height: 30px;
	padding: 6.25px;
	left: 274.07px;
	display: inline-flex;
	justify-content: center;
	align-items: center;
	border: 1px rgba(0, 0, 0, 0) solid;
}

.material-symbols-outlined {
	font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 24
}
</style>
</head>
<body>
	<div class="SlaRecipeStartPageVer01">
		<img class="Rectangle61"
			src="https://images.unsplash.com/photo-1516824467205-afa656d31a79?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
			alt="Background Image">
		<div class="logo">
			<a href="/">
				<img src="https://velog.velcdn.com/images/fake150907/post/265346d4-9a4e-4661-8925-816dcc4ffa21/image.png"
					alt="Background Image" />
			</a>
		</div>
		<div class="HeadIcons">
			<div class="SearchIcon">
				<a href="">
					<img src="https://velog.velcdn.com/images/fake150907/post/c3ce7de3-1a43-42f7-88bf-e8d45e5fdd04/image.svg">
					Search
				</a>
			</div>
			<div class="LoginIcon">
				<div class="Vector"></div>
				<div class="Vector"></div>
				<div class="Login">Login</div>
			</div>
			<div class="MenuIcon">
				<div class="Vector"></div>
				<div class="Vector"></div>
				<div class="Menu">Menu</div>
			</div>
		</div>
		<div class="Group6">
			<div class="SlaRecipeStartHeadBar">
				<div class="Rectangle43"></div>
				<div class="Rectangle42"></div>
				<div class="Rectangle41"></div>
				<div class="Rectangle40"></div>
				<div class="Group22">
					<div class="DoubleArrowFill0Wght400Grad0Opsz241">
						<div class="Vector"></div>
					</div>
					<div>아무개소개</div>
				</div>
				<div class="Group23">
					<div class="DoubleArrowFill0Wght400Grad0Opsz241">
						<div class="Vector"></div>
					</div>
					<div>재료공구</div>
				</div>
				<div class="Group24">
					<div class="DoubleArrowFill0Wght400Grad0Opsz241">
						<div class="Vector"></div>
					</div>
					<div>맟춤레시피</div>
				</div>
				<div class="Group25">
					<div class="DoubleArrowFill0Wght400Grad0Opsz241">
						<div class="Vector"></div>
					</div>
					<div>레시피 목록</div>
				</div>
			</div>
			<div class="Group5">
				<div class="Line20"></div>
				<div class="Line19"></div>
				<div class="Line21"></div>
			</div>
		</div>
	</div>
</body>
</html>

<%@ include file="../common/foot.jspf"%>