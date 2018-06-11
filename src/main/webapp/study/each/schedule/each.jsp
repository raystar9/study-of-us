<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src='/study-of-us/webjars/jquery/3.2.1/jquery.min.js'></script>
<link rel="stylesheet" href='/study-of-us/study/each/schedule/sources/each/css/notice.css'/>
<link rel="stylesheet" href="/study-of-us/study/each/sources/main/css/main.css">

</head>
<body>
<div class="page-container">
	<div class="nav-container"><%@ include file = "/general-sources/Navigation.jsp" %></div>
	<div class="main-container">
		<div class="schedule-flexbox aside"><%@ include file = "/study/each/left.jsp" %></div>
		<div class="schedule-flexbox section"><c:import url="sources/each/section.jsp"/><br></div>
	</div>
	
	<%@ include file = "/general-sources/Footer.jsp" %>
</div>
</body>
</html>
