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
	width: 1910px;
	height: 1100px;
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
	left: 88%;
	top: 5%;
	position: absolute;
}

.HeadIcons img {
	width: 60px;
	height: 60px;
}

.logo {
	position: absolute;
	width: 153px;
	height: 193px;
}

.SearchIcon, .LoginIcon, .MenuIcon {
	font-size: 15px;
	width: 63px;
	height: 58px;
	position: absolute;
	width: 43.96px;
}

.MenuIcon {
	left: 80%;
}

.LoginIcon {
	left: 40%;
}

.Group6 {
	width: 1440px;
	height: 99px;
	left: 0;
	top: 801px;
	position: absolute;
}

.SlaRecipeStartHeadBar {
	width: 100%;
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
/*하단 바*/
.startPage_bottom_Container {
	width: 100%;
	height: 99px;
	position: absolute;
	bottom: 0;
	left: 0;
	display: flex;
	justify-content: space-between;
	align-items: center;
	background: rgba(255, 255, 255, 0.3); /* 배경색을 흰색으로 투명도 조절 */
	backdrop-filter: blur(10px); /* 블러 효과 추가 */
	padding: 0 20px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.startPage_bottom_box1, .startPage_bottom_box2, .startPage_bottom_box3,
	.startPage_bottom_box4 {
	position: relative;
	display: flex;
	justify-content: space-between;
	align-items: center;
	box-sizing: border-box;
}

.startPage_bottom_item1, .startPage_bottom_item2,
	.startPage_bottom_item3, .startPage_bottom_item4 {
	width: 477px;
	height: 99px;
	left: -19.5px;
	position: relative;
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 0 20px;
	box-sizing: border-box;
}

.startPage_bottom_box1:hover .startPage_bottom_item1 {
	background: rgba(0, 0, 0, 0.3);
}

.startPage_bottom_box1:hover .introduce_box {
	display: block;
}

.startPage_bottom_box2:hover .startPage_bottom_item2 {
	background: rgba(0, 0, 0, 0.3);
}

.startPage_bottom_box2:hover .ingredients_box {
	display: block;
}

.startPage_bottom_box3:hover .startPage_bottom_item3 {
	background: rgba(0, 0, 0, 0.3);
}

.startPage_bottom_box3:hover .recommendRecipe_box {
	display: block;
}

.startPage_bottom_box4:hover .startPage_bottom_item4 {
	background: rgba(0, 0, 0, 0.3);
}

.startPage_bottom_box4:hover .recipeList_box {
	display: block;
}

.separator1 {
	width: 1px;
	left: 477px;
	position: absolute;
	height: 99px;
	background-color: #ccc;
}

.separator2 {
	width: 1px;
	left: 954px;
	position: absolute;
	height: 99px;
	background-color: #ccc;
}

.separator3 {
	width: 1px;
	left: 1431px;
	position: absolute;
	height: 99px;
	background-color: #ccc;
}

.icon {
	border-radius: 5px;
	margin-right: 10px;
}

.icon img {
	color: rgba(0, 0, 0, 0.5);
	width: 35px;
	height: 35px;
	border-radius: 5px;
	margin-right: 10px;
}

.startPage_bottom_content {
	color: rgba(0, 0, 0, 0.8);
	font-size: 25px;
	width: 400px;
	font-family: Inter;
	font-weight: 500;
	display: flex;
	justify-content: space-between;
	align-items: center;
	display: flex;
	font-family: Inter;
}

.introduce_box, .ingredients_box, .recommendRecipe_box, .recipeList_box
	{
	background: rgba(0, 0, 0, 0.3);
	width: 1910px;
	height: 800px;
	position: absolute;
	bottom: 99px;
	backdrop-filter: blur(10px);
	display: none;
}

.introduce_box {
	left: -2px;
}

.ingredients_box {
	left: -477px;
}

.recommendRecipe_box {
	left: -954px;
}

.recipeList_box {
	left: -1431px;
}

/* 타이틀 */
.header-container {
	width: 602px;
	height: 157px;
	position: relative;
}

.title, .subtitle {
	position: absolute;
	color: white;
	font-family: Inter;
	font-weight: 600;
	word-wrap: break-word;
	left: 35%;
}

.title {
	font-size: 90px;
	width: 450px;
	top: 0px;
}

.subtitle {
	width: 800px;
	font-size: 40px;
	top: 109px;
}

.material-symbols-outlined {
	font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 24
}
/* 재료공구 */
.ingredients_img1 {
	width: 605px;
	height: 345px;
	top: 150px;
	left: 350px;
	border-radius: 10px;
	position: absolute;
	background: linear-gradient(0deg, #D9D9D9 0%, #D9D9D9 100%);
}

.ingredients_img2 {
	width: 605px;
	height: 345px;
	top: 300px;
	left: 900px;
	position: absolute;
	background: linear-gradient(0deg, #D9D9D9 0%, #D9D9D9 100%);
	border-radius: 10px;
}

.ingredients_item1, .ingredients_item2 {
	width: 605px;
	position: relative;
}

.ingredients_content {
	width: 566px;
	height: 66px;
	position: absolute;
	left: 350px;
	top: 50px;
}

.ingredients_content2 {
	width: 566px;
	height: 66px;
	position: absolute;
	font-size: 20px;
	font-weight: 600;
	line-height: 24px;
	word-wrap: break-word;
	left: 900px;
	top: 666px;
	font-family: Inter;
	color: white;
}

.ingredients_content>.title {
	left: 0;
	top: 0;
	position: absolute;
	color: white;
	font-size: 35px;
	font-family: Inter;
	font-weight: 600;
	line-height: 42px;
	word-wrap: break-word;
}

.ingredients_content>.subtitle {
	left: 151px;
	top: 9px;
	position: absolute;
	color: white;
	font-size: 20px;
	font-family: Inter;
	font-weight: 600;
	line-height: 24px;
	word-wrap: break-word;
}

.ingredients_content>.description {
	left: 0;
	top: 42px;
	position: absolute;
	color: white;
	font-size: 20px;
	font-family: Inter;
	font-weight: 600;
	line-height: 24px;
	word-wrap: break-word;
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
		<div class="header-container">
			<div class="title">Sla Recipe</div>
			<div class="subtitle">A Taste to Build Your Dream On</div>
		</div>
		<div class="HeadIcons">
			<div class="SearchIcon">
				<a href="">
					<img src="https://velog.velcdn.com/images/fake150907/post/c3ce7de3-1a43-42f7-88bf-e8d45e5fdd04/image.svg">
					Search
				</a>
			</div>
			<div class="LoginIcon">
				<a href="">
					<img src="https://velog.velcdn.com/images/fake150907/post/cb9fe070-b691-4cf6-b7cf-a4ddd545b586/image.svg" />
					Login
				</a>
			</div>
			<div class="MenuIcon">
				<a href="">
					<img src="https://velog.velcdn.com/images/fake150907/post/34249e90-532a-4676-b0ca-321777ab36f5/image.svg" />
					Menu
				</a>
			</div>
		</div>
		<div class="startPage_bottom_Container">
			<div class="startPage_bottom_box1">
				<div class="startPage_bottom_item1">
					<div class="introduce_box"></div>
					<a href="">
						<div class="startPage_bottom_content">
							아무개소개
							<div class="icon">
								<img src="https://velog.velcdn.com/images/fake150907/post/7379f23c-b9d0-4da9-bf1d-3eba0567ea40/image.svg" alt="" />
							</div>
						</div>
					</a>
				</div>
			</div>
			<div class="separator1"></div>
			<div class="startPage_bottom_box2">
				<div class="startPage_bottom_item2">
					<div class="ingredients_box">
						<div class="ingredients_item1">
							<div class="ingredients_content">
								<div class="title">재료공구</div>
								<div class="subtitle">신선한 재료로 요리하고싶은 당신의 마음!</div>
								<div class="description">마트에 가서 재료를 사도 혼자 사는 당신들이 먹기에는 양이 너무 많다!</div>
							</div>
							<img class="ingredients_img1"
								src="https://velog.velcdn.com/images/fake150907/post/f78257ce-3777-4a59-9bf6-7b8323cd1810/image.jpg" />
						</div>
						<div class="ingredients_item2">
							<div class="ingredients_content2">이제 다른 사람들과 재료를 공동구매해서 항상 신선하고 질 좋은 재료로 식사해보세요!</div>
							<img class="ingredients_img2"
								src="https://velog.velcdn.com/images/fake150907/post/8ce2087f-9ea9-433b-94e6-d3f38de359a3/image.jpg" />
						</div>
					</div>
					<a href="">
						<div class="startPage_bottom_content">
							재료공구
							<div class="icon">
								<img src="https://velog.velcdn.com/images/fake150907/post/7379f23c-b9d0-4da9-bf1d-3eba0567ea40/image.svg" alt="" />
							</div>
						</div>
					</a>
				</div>
			</div>
			<div class="separator2"></div>
			<div class="startPage_bottom_box3">
				<div class="startPage_bottom_item3">
					<div class="recommendRecipe_box"></div>
					<a href="">
						<div class="startPage_bottom_content">
							맟춤레시피
							<div class="icon">
								<img src="https://velog.velcdn.com/images/fake150907/post/7379f23c-b9d0-4da9-bf1d-3eba0567ea40/image.svg" alt="" />
							</div>
						</div>
					</a>
				</div>
			</div>
			<div class="separator3"></div>
			<div class="startPage_bottom_box4">
				<div class="startPage_bottom_item4">
					<div class="recipeList_box"></div>
					<a href="">
						<div class="startPage_bottom_content">
							레시피 목록
							<div class="icon">
								<img src="https://velog.velcdn.com/images/fake150907/post/7379f23c-b9d0-4da9-bf1d-3eba0567ea40/image.svg" alt="" />
							</div>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

<%@ include file="../common/foot.jspf"%>