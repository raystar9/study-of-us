<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>스터디 메인 페이지입니다.</title>
<script src='/study-of-us/study/each/sources/schedule/js/jquery.min.js'></script>
<link rel="stylesheet" href="/study-of-us/study/each/sources/main/css/main.css">
<script src="/study-of-us/study/each/board/sources/board-register/js/board_register.js" type="text/javascript"></script>
<link rel="stylesheet" href="/study-of-us/study/each/board/sources/board-register/css/board_register.css">
</head>
<body>
<div class="page-container">
	<div class="nav-container"><%@ include file = "/general-sources/Navigation.jsp" %></div>
	<div class="main-container">
		<div class="schedule-flexbox aside"><%@ include file = "/study/each/left.jsp" %></div>
		<div class="schedule-flexbox section"><%@ include file = "sources/board-register/board_register_form.jsp" %><br></div>
	</div>
	
	<%@ include file = "/general-sources/Footer.jsp" %>
</div>
</body>
</html>