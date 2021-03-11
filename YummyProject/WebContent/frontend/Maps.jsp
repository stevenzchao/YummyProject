<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.* "%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        html,body{
                width: 100%;
                height: 100%;
                }
                #map { width: 70%;height: 70%; } 
	</style>


 	<link rel="stylesheet" href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css" />
    <script src="https://unpkg.com/leaflet@1.6.0/dist/leaflet.js"></script>
    <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"
    integrity="sha512-XQoYMqMTK8LvdxXYG3nZ448hOEQiglfqkJs1NOQV44cWnUrBc8PkAOcXy20w0vlaXaVUearIOBhiXZ5V3ynxwA=="
    crossorigin=""></script>
    
    <title>Map</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/HomePage.html/HomePage.html">首頁</a>
	<div id="nav" style="padding-top:20px;padding-left:20px;margin:0px;height:50px; width: 100%; background-color: #46A3FF;">
            <!--目前是地圖搜尋-->
            <button onclick="getcenter()" value="cc">cc</button>
            <form name="centerSearch" action="CenterSearch" method="post">
            <input type="hidden" name="ctPositon"></form>
            
             <form name="keyNameSearch" action="KeyNameSearch" method="post">
            <input type="text" name="kName">
            <input type="submit" name="kName">
            </form>
        
      </div>


	<div id="memoBoard" style="float: left;height: 100%;width:400px;overflow: scroll;"></div>
    <div id="map" style="float:left">
    
    </div>

    
    
    
    <br>
	<%String json = (String)request.getAttribute("json"); %>

<script>
//地圖端
   let jsonData=<%=json%>; //javascript 接 java 變數
   console.log(jsonData);
//memo   
	let memo=document.getElementById("memoBoard");
    let memosheet = document.createElement("table");
    let HTMLtable="";
    for(let i=0;i<jsonData.length;i++){

        let tr1 = document.createElement("tr");
        // td1.className="tdtop";
        let td1=document.createElement("td");
        td1.rowSpan="4";

        let img = document.createElement("img"); 
        //img 的來源
        //img.src="https://m-miya.net/blog/wp-content/uploads/2014/09/956-4.min_-546x546.jpg";
        img.src="${pageContext.request.contextPath}/ImageRetriveServer?filename="+jsonData[i].RestaurantID;
        img.style.width="80px";
        img.id=i;
        img.addEventListener("click",showMemo);
        td1.appendChild(img);  
        tr1.appendChild(td1);      

        let tr2 = document.createElement("tr");
        let td2=document.createElement("td");        
        let anchr=document.createElement("a")
        anchr.href="${pageContext.request.contextPath}/SingleStore?filename="+jsonData[i].RestaurantID;
        anchr.innerHTML=jsonData[i].RestaurantName;
        
        td2.appendChild(anchr);
        
        tr2.appendChild(td2);
        let tr3 = document.createElement("tr");
        let td3=document.createElement("td");
        td3.innerHTML=jsonData[i].RestaurantAddress;
            tr3.appendChild(td3);
        let tr4 = document.createElement("tr");
        let td4=document.createElement("td");
        td4.className="tdbot";
        td4.innerHTML=jsonData[i].RestaurantHashtag
        tr4.appendChild(td4);

        memosheet.appendChild(tr1);
        memosheet.appendChild(tr2);
        memosheet.appendChild(tr3);
        memosheet.appendChild(tr4);  
       
        }
   
  
    memo.appendChild(memosheet);
   
   
   
   //window.alert(jsonData[2].names);
   //console.log(jsonData);
	console.log(jsonData);
   let namesCollect=document.getElementsByName("names");
   
    //定map和center
   var map = L.map('map', {center: [25.0333, 121.5358], zoom: 16});

   var greenIcon= new L.Icon({
       iconUrl:"https://cdn.rawgit.com/pointhi/leaflet-color-markers/master/img/marker-icon-2x-green.png",
       iconSize:[25,41],
       iconAnchor:[12,41],
       popupAncher:[1,-34],
       shadowSize:[41,41]
   });
 
    //定義圖磚加到 varrmap
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);

    
    let count = 0;
    let alat=0;
    let along=0;
	
    var markerArray = []; //create new markers array auto Zoom
    
    for(let i=0; i <jsonData.length;i++){
        let lat=parseFloat(jsonData[i].Latitude);
 
        let long=parseFloat(jsonData[i].Longitude);

        let name=jsonData[i].RestaurantName;
        var marker = L.marker([lat,long]);
        marker.addTo(map).bindPopup(name).openPopup();
        markerArray.push(marker);//把marker丟進arr裡
        
        if(i==jsonData.length-1){//this is the case when all the markers would be added to array
            var group = L.featureGroup(markerArray); //add markers array to featureGroup
            map.fitBounds(group.getBounds());   
            }
        alat+=lat;
        along+=long;
        count++;        
    }
    
    let center=[alat/count,along/count];
    
    map.panTo(center);
    console.log(center);
    //map.setZoom(16);

    //L.marker([25.0333, 121.5358]).addTo(map).bindPopup("aa").openPopup();
    //L.marker([25.033674, 121.540411],{icon:greenIcon}).addTo(map).openPopup();
    
    
    
   ////////////////////////////////////////function area
    function getcenter(){
        center=map.getCenter();
        console.log(center);
        let hdform=document.getElementsByName("ctPositon")[0]
        hdform.value=center;
        document.getElementsByName("centerSearch")[0].submit();
    }
  //試試看的function
  	var popup = L.popup();
    function onMapClick(e) {
        popup.setLatLng(e.latlng)
            .setContent("You clicked the map at " + e.latlng.toString())
            .openOn(map);
    }

    map.on('click', onMapClick);

//  按左邊彈出視窗
    function showMemo(){

    let lng=parseFloat(jsonData[this.id].Longitude);

    let lat=parseFloat(jsonData[this.id].Latitude);
    popup.setLatLng([lat,lng]);
    popup.setContent(jsonData[this.id].RestaurantName)
    .openOn(map)
        //var marker = L.marker();
        //marker.bindPopup(jsonData[this.id].RestaurantName).openPopup();
    }
        
    
    
</script>


</body>

</html>