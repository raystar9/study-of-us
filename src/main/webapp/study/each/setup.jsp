<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" href="/study-of-us/study/each/sources/main/css/main.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="sources/setup/js/setup.js" type="text/javascript"></script>
</head>
<body>
<div class="page-container">
	<div class="nav-container"><%@ include file = "/general-sources/Navigation.jsp" %></div>
	<div class="main-container">
		<div class="schedule-flexbox aside"><%@ include file = "/study/each/left.jsp" %></div>
		<div class="schedule-flexbox section"><c:import url="sources/setup/setup_form.jsp"/><br></div>
	</div>
	
	<%@ include file = "/general-sources/Footer.jsp" %>
</div>
</body>
</html>