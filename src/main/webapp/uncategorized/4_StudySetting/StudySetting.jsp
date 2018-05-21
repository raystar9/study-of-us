<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=trCkUlkJ2oAOjw3kdZSY&submodules=geocoder"></script>
<body>
<%@ include file = "/0_Navigation/Navigation.jsp" %>
<!-- <script src = "http://code.jquery.com/jquery-3.3.1.js"></script> -->

<!--  아이콘 -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">


<!-- 자바 ui -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
  
   <script>
  $( function() {
    $( "#day1,#day2" ).datepicker({
      monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
    dayNamesMin: ['일','월','화','수','목','금','토'],
     dateFormat: "yy년mm월dd일",
      changeYear: true,
      changeMonth: true
    });
    
    var map = new naver.maps.Map('map');
    var myaddress = '종로5가';// 도로명 주소나 지번 주소만 가능 (건물명 불가!!!!)
    naver.maps.Service.geocode({address: myaddress}, function(status, response) {
        if (status !== naver.maps.Service.Status.OK) {
            return alert(myaddress + '의 검색 결과가 없거나 기타 네트워크 에러');
        }
        var result = response.result;
        // 검색 결과 갯수: result.total
        // 첫번째 결과 결과 주소: result.items[0].address
        // 첫번째 검색 결과 좌표: result.items[0].point.y, result.items[0].point.x
        var myaddr = new naver.maps.Point(result.items[0].point.x, result.items[0].point.y);
        map.setCenter(myaddr); // 검색된 좌표로 지도 이동
        // 마커 표시
        var marker = new naver.maps.Marker({
          position: myaddr,
          map: map
        });
        // 마커 클릭 이벤트 처리
        naver.maps.Event.addListener(marker, "click", function(e) {
          if (infowindow.getMap()) {
              infowindow.close();
          } else {
              infowindow.open(map, marker);
          }
        });
        // 마크 클릭시 인포윈도우 오픈
        var infowindow = new naver.maps.InfoWindow({
            content: '<h4> [네이버 개발자센터]</h4><a href="https://blog.naver.com/rumor1993" target="_blank"><img src="https://developers.naver.com/inc/devcenter/images/nd_img.png"></a>'
        });
    });
  });
  </script>

<style>
input[type=text] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

div.signup {
   border : 1px solid #0000004a;
   max-width : 700px;
    border-radius: 5px;
    background-color: #f2f2f259;
    padding: 20px;
    margin : 0 auto;
}

#day1{
   width : 48%;
}

#day2{
   width : 48%;
}

#category{
   width : 50%;
}

#sel{
   float : right;
   width : 40%;
   padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
   
}

#people{
   width : 100%;
}

span{
   display : inline-block;
}

.one{
   width : 32%
}

.two{
   width : 32%
}

.three{
   width : 32%
}

textarea{
   width : 100%;
}
.check{
   border : 1px solid #ccc;
   width :48%;
   float : left;
   height:400px;
   text-align : center
}

#map{
   border : 1px solid #ccc;
   float : right;
}

textarea{
   border : 1px solid #ccc;
}
.checkcontainer{
   	margin-top: 30px;
}



</style>
</head>
<body>

<h3 align=center>Modify</h3>
<div class="signup">
<i class="material-icons">category</i>
<label for="category"><strong>카테고리</strong></label><br>

<input type=text name=category id="category">
<select name=sel id=sel>
   <option value="">세부 카테고리..</option>
   <option value="">option2</option>
   <option value="">option3</option>
   <option value="">option4</option>
   <option value="">option5</option>
</select>
<br>

<i class="material-icons">create</i>
<label for="category"><strong>스터디명</strong></label><br>
<input type=text name=study_name id="study_name"><br>


<i class="material-icons">date_range</i>
<label for="category"><strong>기간</strong></label><br>
<input type=text name=day1 id="day1"> ~ 
<input type=text name=day2 id="day2"><br>


<p>

<span class=one>
      
      <i class="material-icons">people</i>
      <label for="category"><strong>모집인원</strong></label><br>
      <input type=text name=people id=people name=people>
      </span>
<span class=two>

      <i class="material-icons">access_time</i>
      <label for="category"><strong>활동 시간</strong></label><br>
      <input type=text name=people id=people name=people>
</span>

<span class=three>
      <i class="material-icons">today</i>
      <label for="day"><strong>활동 요일</strong></label><br>
      <input type=text name=activity_day id=activity_day name=activity_day>
</span>
</p>


<i class="material-icons">edit</i>
<label for="explain"><strong>프로젝트 개요</strong></label><br>
<textarea rows=10 cols=60 name=explain id=explain  placeholder="너무 어려워.."></textarea><br>

<i class="material-icons">star_half</i>
<label for="prepared"><strong>주요 교재 및 준비물</strong></label><br>
<textarea rows=10 cols=60 name=prepared id=prepared></textarea><br>

<label for="prepared"><strong>기대효과 및 활동 분야</strong></label><br>
<textarea rows=10 cols=60 name=prepared id=prepared></textarea><br>
<br>


<p>
<span class="check">

   
   <label class="checkcontainer">서울
        <input type="checkbox" checked="checked">
      <span class="checkmark"></span>
   </label>&nbsp;&nbsp;
      <label class="checkcontainer">부산
       <input type="checkbox">
        <span class="checkmark"></span>
   </label>
   <br>
   <label class="checkcontainer">대구
        <input type="checkbox" checked="checked">
      <span class="checkmark"></span>
   </label>&nbsp;&nbsp;
      <label class="checkcontainer">대전
       <input type="checkbox">
        <span class="checkmark"></span>
   </label>
   <br>
   <label class="checkcontainer">경기
        <input type="checkbox" checked="checked">
      <span class="checkmark"></span>
   </label>&nbsp;&nbsp;
   <label class="checkcontainer">인천
       <input type="checkbox">
        <span class="checkmark"></span>
   </label>
   <br>
   <label class="checkcontainer">강원
       <input type="checkbox">
        <span class="checkmark"></span>
   </label>&nbsp;&nbsp;
   <label class="checkcontainer">시흥
       <input type="checkbox">
        <span class="checkmark"></span>
   </label>
</span>
<span id="map" style="width:48%;height:400px;">

</span>
</p>
   <input type=submit value="수정하기">
</div>
<br>
</body>
</html>
<%@ include file = "/0_Navigation/Footer.jsp" %>
</body>
</html>