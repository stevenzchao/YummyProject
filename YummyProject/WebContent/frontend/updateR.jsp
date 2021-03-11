<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新餐廳</title>
</head>
<body style="background-color: #fdf5e6">
	<div align="center">
		<h2>更新餐廳</h2>
		<jsp:useBean id="readRBean" scope="request"
			class="com.pj.bean.RestaurantBean"></jsp:useBean>
		<form method="post" action="${pageContext.request.contextPath}/RestaurantController"  enctype="multipart/form-data">
			<img
				src="${pageContext.request.contextPath}/RestaurantController?RIDforimg=${readRBean.restaurantID }"
				height="125px">
			<table>
				<tr>
					<td>更新餐廳ID
					<td><input type="text" readonly="readonly"
						value="${readRBean.restaurantID }" name=updateRID>
				<tr>
					<td>餐廳名稱
					<td><input type="text" value="${readRBean.restaurantName }"
						name=updateRName>
				<tr>
					<td>餐廳地址
					<td><input type="text" value="${readRBean.restaurantAddress }"
						name=updateRAddress id="RAdd">
				<tr>
					<td>經度
					<td><input type="text" value="${readRBean.restaurantLong }" name="updateRLong" id="RLong">
				<tr>
					<td>緯度
					<td><input type="text" value="${readRBean.restaurantLati }" name="updateRLati" id="RLati">
				<tr>
					<td>餐廳標籤
					<td><input type="text" value="${readRBean.restaurantHashtag }"
						name=updateRHashtag>
				<tr>
					<td>餐廳聯絡方式
					<td><input type="text" value="${readRBean.restaurantContact }"
						name=updateRContact>
				<tr>
					<td>餐廳網站
					<td><input type="text" value="${readRBean.restaurantWebsite }"
						name=updateRWebsite>
				<tr>
					<td>會員ID
					<td><input type="text" readonly="readonly"
						value="${readRBean.companyID }" name=updatecompanyID>
				<tr>
					<td>餐廳照片
					<td><input type="file" name="updateRPhoto"
						accept="image/png, image/jpeg">
			</table>
			<input type="submit" value="確定更新" />
		</form>
		<h2>
			<a href="${pageContext.request.contextPath}/frontend/Rmain.jsp">返回Home</a>
		</h2>
	</div>
	<div id="map">

    </div>
    <script>
    var map;    
    
    function initMap(){
        map = new google.maps.Map(document.getElementById('map'), { center: {lat: 25.033710, lng: 121.564718}, zoom: 15});
        var marker = new google.maps.Marker({position: {lat: 25.033710, lng: 121.564718}, map: map});
    }    

    function startTrans(){
        let addr=document.getElementById("RAdd").value;
        console.log(addr);
        addressToLocation(addr);
        // console.log(document.getElementById("lat").value);      
    
    }
    
    function addressToLocation(addr){
        let longitude;
        let latitude;
        let loca;
        var geocoder = new google.maps.Geocoder(); 
        geocoder.geocode({'address': addr }, function (results, status){
            if (status == google.maps.GeocoderStatus.OK) {
                longitude=results[0].geometry.location.lng();
               
                latitude=results[0].geometry.location.lat();

                let lat=document.getElementById("RLati");
                lat.value=latitude;
                let lng=document.getElementById("RLong");
                lng.value=longitude;
        }else{}
        })

    }
    
    
    document.getElementById("RAdd").addEventListener("change",startTrans);

    </script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBTUCen4YixtEKjNBAL4CX5xkW1QQAembQ&callback=initMap" async defer></script>	
</body>
</html>