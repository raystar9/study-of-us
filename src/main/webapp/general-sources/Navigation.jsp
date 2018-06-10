<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.topnav {
	overflow: hidden;
	background-color: #ccc;
}

.topnav a {
	float: left;
	color: #333333;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.active {
	margin-right: 60px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #252525;
	color: white;
}

.topnav-right {
	float: right;
}
table.type10 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;
    border-top: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
    margin: 20px 10px;
}
table.type10 thead th {
    width: 70px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #fff;
    background: #e7708d;
    margin: 20px 10px;
}
table.type10 tbody th {
    width: 70px;
    padding: 10px;
}
table.type10 td {
    width: 200px;
    padding: 10px;
    vertical-align: top;
        background-color: #f1f1f1;
}
table.type10 .even {
    background: #fdf3f5;
}

</style>

<script>
function closeLayer( obj ) {
	$(obj).parent().parent().hide();
}

$(function(){
	$('.popupLayer').hide()
	/* 클릭 클릭시 클릭을 클릭한 위치 근처에 레이어가 나타난다. */
	$('#icon2').click(function(e)
	{
		var sWidth = window.innerWidth;
		var sHeight = window.innerHeight;

		var oWidth = $('.popupLayer').width();
		var oHeight = $('.popupLayer').height();

		// 레이어가 나타날 위치를 셋팅한다.
		var divLeft = e.clientX + 250;
		var divTop = e.clientY + 5;

		// 레이어가 화면 크기를 벗어나면 위치를 바꾸어 배치한다.
		if( divLeft + oWidth > sWidth ) divLeft -= oWidth;
		if( divTop + oHeight > sHeight ) divTop -= oHeight;

		// 레이어 위치를 바꾸었더니 상단기준점(0,0) 밖으로 벗어난다면 상단기준점(0,0)에 배치하자.
		if( divLeft < 0 ) divLeft = 0;
		if( divTop < 0 ) divTop = 0;

		$('.popupLayer').css({
			"top": divTop,
			"left": divLeft,
			"position": "absolute"
		}).show();
	});
	})
$(document).ready(function(){
	
 $("#reject").click(function(){
	var sm_s_index = $("#sm_s_index").val()
	var sm_m_index = $("#sm_m_index").val()

	location.href = "/study-of-us/study/Message?sm_s_index="+sm_s_index+"&sm_m_index="+sm_m_index+"&reject=reject";
}) 

})
</script>
</head>
<body>

	<div class="topnav">

		<c:if test="${empty id }">
			<a class="active" href="/study-of-us/home">Home</a>
		</c:if>
		<c:if test="${!empty id }">
			<a class="active" href="/study-of-us/study/list">Home</a>
		</c:if>
		<a href="/study-of-us/study/each/Registration">Study Create</a> <a
			href="/study-of-us/study/SearchMain">Study Search</a> <a
			href="#information">Information</a>

		<div class="topnav-right">
			<c:if test="${empty id }">
				<a href="/study-of-us/LoginForm">Login</a>
				<a href="/study-of-us/join">SignUp</a>
			</c:if>

			<c:if test="${!empty id }">
				<a id="icon2"><i class="fa fa-bell icon2" ></i></a>
				<a>${id} 님 환영합니다</a>
				<a href="/study-of-us/LogOut">로그아웃</a>
			</c:if>

		</div>
	</div>


	<div class="popupLayer">
		<div>
			<span onClick="closeLayer(this)"
				style="cursor: pointer; font-size: 1.5em" title="닫기">X</span>
		</div>
<Form action="/study-of-us/study/Message" method="get">
		<table class=type10 border="1" width="100%" style="float: right">

			<thead>
				<tr>
					<th>신청자</th>
					<th>스터디 명</th>
					<th>말풍선 </th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="message2" items="${message }">
				<tr>
					<td>${message2.m_m_id }</td>
					<td>${message2.m_s_name }</td>
					<td><button id="accept" type="submit">수락</button><button id="reject" type="button">거절</button></td>
				</tr>
				
		
				<input type="hidden" id="sm_s_index" name="sm_s_index" value="${message2.m_s_index }">
				<input type="hidden" id="sm_m_index" name="sm_m_index" value="${message2.m_m_index }">
	
				</c:forEach>
			</tbody>
		</table>
			</Form>
	</div>
</body>
</html>