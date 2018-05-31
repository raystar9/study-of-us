<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>스터디 메인 페이지입니다.</title>
<script src='sources/schedule/js/jquery.min.js'></script>
<link rel="stylesheet" href="sources/main/css/main.css">
<style>
* {
	margin: 0px;
	padding: 0px;
}
html, body{
	width: 100%; 
	height: 100%;
}
body {
	display: table;
}
.page-container {
	display:flex;
	width: 100%;
	height: 100%;
	flex-direction: column;
}
.nav-container {
	width: 100%;
}
.main-container {
	display:flex;
	width: 100%;
	height: 100%;
	
}
#left {width: 200px; height: 100%;}
</style>
</head>
<body>
<div class="page-container">
	<div class="nav-container"><%@ include file = "/general-sources/Navigation.jsp" %></div>
	<div class="main-container">
		<div class="schedule-flexbox aside"><%@ include file = "left.jsp" %></div>
		<div class="schedule-flexbox section"><%@ include file = "sources/schedule/section.jsp" %><br></div>
	</div>
	<%@ include file = "/general-sources/Footer.jsp" %>
</div>
</body>
</html>