<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>우리를 위한 스터디 SOUP!</title>
<link rel="stylesheet" href="/study-of-us/study/each/sources/main/css/main.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%--<link rel="stylesheet" href="/study-of-us/study/each/attendance/each/sources/record/css/attendance.css"> --%>
<link rel="stylesheet" href="/study-of-us/study/each/attendance/each/sources/record/css/article.css">
<script src = "http://code.jquery.com/jquery-3.3.1.js"></script>
<%--<script src = "sources/record/js/ajax.js"/> --%>
</head>
<body>
<div class="page-container">
	<div class="nav-container"><%@ include file = "/general-sources/Navigation.jsp" %></div>
	<div class="main-container">
		<div class="schedule-flexbox aside"><%@ include file = "/study/each/left.jsp" %></div>
		<div class="schedule-flexbox section"><%@ include file = "sources/record/section.jsp" %><br></div>
	</div>
	<%@ include file = "/general-sources/Footer.jsp" %>
</div>
</body>
</html>