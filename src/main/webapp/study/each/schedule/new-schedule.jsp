<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=trCkUlkJ2oAOjw3kdZSY&submodules=geocoder"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src='//cdn.rawgit.com/fgelinas/timepicker/master/jquery.ui.timepicker.js'></script>
<script src="/study-of-us/study/each/schedule/sources/new-schedule/js/dateTimePicker.js"></script>
<script src="/study-of-us/study/each/schedule/sources/new-schedule/js/ajax.js"></script>
<script src="/study-of-us/study/each/schedule/sources/new-schedule/js/naver-map.js"></script>
<link rel="stylesheet" href="/study-of-us/study/each/sources/main/css/main.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="//cdn.rawgit.com/fgelinas/timepicker/master/jquery.ui.timepicker.css">
<link rel="stylesheet" href='/study-of-us/study/each/schedule/sources/new-schedule/css/new-schedule.css'/>
</head>

<body>
<div class="page-container">
	<div class="nav-container"><%@ include file = "/general-sources/Navigation.jsp" %></div>
	<div class="main-container">
		<div class="schedule-flexbox aside"><%@ include file = "/study/each/left.jsp" %></div>
		<div class="schedule-flexbox section"><c:import url="sources/new-schedule/section.jsp"/><br></div>
	</div>
	
	<%@ include file = "/general-sources/Footer.jsp" %>
</div>
</body>
</html>