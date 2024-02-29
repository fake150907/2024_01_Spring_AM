<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="API TEST4"></c:set>

<%@ include file="../common/head.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>지도 이동시키기</title>

<style>
#map {
	width: 1400px;
	left:520px;
	top:200px;
	height: 750px;
	position:absolute;
}
body > p{
position:absolute;
left:600px;
z-index: 2;
}
body > .p1{
	top:20%;
}
body > .p2{
	top:40%;
}
body > .p3{
	top:60%;
}
body >.p4{
	top:80%;
}
body >.p5{
	top:95%;
}
</style>
</head>
<body>
	
	<p class="p1">
		<button class="btn btn-outline" onclick="setCenter()">지도 중심좌표 이동시키기</button>
		<button class="btn btn-outline" onclick="panTo()">지도 중심좌표 부드럽게 이동시키기</button>
	</p>
	<p class="p2">
		<button class="btn btn-outline" onclick="zoomIn()">지도레벨 - 1</button>
		<button class="btn btn-outline" onclick="zoomOut()">지도레벨 + 1</button>
		<span id="maplevel"></span>
	</p>
	<p class="p3">
		<button class="btn btn-outline" onclick="setDraggable(false)">지도 드래그 이동 끄기</button>
		<button class="btn btn-outline" onclick="setDraggable(true)">지도 드래그 이동 켜기</button>
	</p>
	<p class="p4">
		<button class="btn btn-outline" onclick="setZoomable(false)">지도 확대/축소 끄기</button>
		<button class="btn btn-outline" onclick="setZoomable(true)">지도 확대/축소 켜기</button>
	</p>
	<p class="p5"><em>지도를 클릭해주세요!</em></p> 
	<div id="clickLatlng"></div>
	<div id="map"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9cbb9e3d7d768b8c1c16039718e05b00"></script>
	<script>
		var lat;
		var lon;
		//		주차장
		async function getData2() {
			const API_KEY = '발급받은 API 키';
			const url = 'https://www.yuseong.go.kr/ys_parking/ysparkingList/ORP/getJSONData.do?_wadl&type=json';
			const response = await fetch(url);
			const data = await
			response.json();

			console.log("data", data);
			console.log(data.response);
			console.log(data.response.body);
			console.log(data.response.header);
			console.log(data.response.body.items);
			console.log(data.response.body.items[0]);
			console.log(data.response.body.items[0].item.addr);
			console.log(data.response.body.items[0].item.latitude);
			console.log(data.response.body.items[0].item.longitude);

			lat = data.response.body.items[0].item.latitude;
			lon = data.response.body.items[0].item.longitude;
		}
		getData2();
		
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(36.35053893518407, 127.38482370655444), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

		function setCenter() {
			// 이동할 위도 경도 위치를 생성합니다 
			var moveLatLon = new kakao.maps.LatLng(36.35053893518407 , 127.38482370655444 );

			// 지도 중심을 이동 시킵니다
			map.setCenter(moveLatLon);
		}

		function panTo() {
			// 이동할 위도 경도 위치를 생성합니다 
			var moveLatLon = new kakao.maps.LatLng(lat, lon);

			// 지도 중심을 부드럽게 이동시킵니다
			// 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
			map.panTo(moveLatLon);
		}
		displayLevel();

		// 지도 레벨은 지도의 확대 수준을 의미합니다
		// 지도 레벨은 1부터 14레벨이 있으며 숫자가 작을수록 지도 확대 수준이 높습니다
		function zoomIn() {
			// 현재 지도의 레벨을 얻어옵니다
			var level = map.getLevel();

			// 지도를 1레벨 내립니다 (지도가 확대됩니다)
			map.setLevel(level - 1);

			// 지도 레벨을 표시합니다
			displayLevel();
		}

		function zoomOut() {
			// 현재 지도의 레벨을 얻어옵니다
			var level = map.getLevel();

			// 지도를 1레벨 올립니다 (지도가 축소됩니다)
			map.setLevel(level + 1);

			// 지도 레벨을 표시합니다
			displayLevel();
		}

		function displayLevel() {
			var levelEl = document.getElementById('maplevel');
			levelEl.innerHTML = '현재 지도 레벨은 ' + map.getLevel() + ' 레벨 입니다.';
		}
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
		var mapTypeControl = new kakao.maps.MapTypeControl();

		// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
		// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
		map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

		// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
		var zoomControl = new kakao.maps.ZoomControl();
		map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

		function setDraggable(draggable) {
			// 마우스 드래그로 지도 이동 가능여부를 설정합니다
			map.setDraggable(draggable);
		}

		function setZoomable(zoomable) {
			// 마우스 휠로 지도 확대,축소 가능여부를 설정합니다
			map.setZoomable(zoomable);
		}
		
		// 지도를 클릭한 위치에 표출할 마커입니다
		var marker = new kakao.maps.Marker({ 
		    // 지도 중심좌표에 마커를 생성합니다 
		    position: map.getCenter() 
		}); 
		// 지도에 마커를 표시합니다
		marker.setMap(map);

		// 지도에 클릭 이벤트를 등록합니다
		// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
		kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
		    
		    // 클릭한 위도, 경도 정보를 가져옵니다 
		    var latlng = mouseEvent.latLng; 
		    
		    // 마커 위치를 클릭한 위치로 옮깁니다
		    marker.setPosition(latlng);
		    
		    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
		    message += '경도는 ' + latlng.getLng() + ' 입니다';
		    
		    var resultDiv = document.getElementById('clickLatlng'); 
		    resultDiv.innerHTML = message;
		    
		});
	</script>
</body>
</html>

<%@ include file="../common/foot.jspf"%>