<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>已新增餐廳資料</title>
</head>
<body style="background-color: #fdf5e6">
<div align="center">
<h2>新增餐廳</h2>
<form method="post" action="${pageContext.request.contextPath}/RestaurantController" enctype="multipart/form-data">
<table><tr><td>餐廳名稱
<td><input type="text" name="newRName">
<!-- 使用EL寫法  ${Bean名稱.property名稱} 注意property是getter setter 去掉首字改小寫-->
<tr><td>餐廳地址
<td><input type="text" name="newRAddress" id="RAdd">
<tr><td>經度
<td><input type="text" name="newRLong" id="RLong">
<tr><td>緯度
<td><input type="text" name="newRLati" id="RLati">
<tr><td>餐廳標籤
<td><input type="text" name="newRHashtag">
<tr><td>聯絡方式
<td><input type="text" name="newRContact">
<tr><td>官網
<td><input type="text" name="newRWebsite">
<tr><td>餐廳照片
<td><input type="file" name="newRPhoto" accept="image/png, image/jpeg">
<tr><td>會員編號
<td><input type="text" name="newcompanyID">
</table>
		<input type="submit" value="確定" />

	</form>
		<h2>
			<a href="${pageContext.request.contextPath}/frontend/Rmain.jsp">Home</a>
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