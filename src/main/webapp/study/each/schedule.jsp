<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="sources/main/css/main.css">
<style>

.button-container {text-align: center; display:table;}
.schedule-flexbox {height: 100%; vertical-align: top;}
.schedule-flexbox aside {width: 200px;}
.schedule-flexbox section {width: 100%;}
#new-button {width: 400px; height: 50px;}
#left {width: 200px; height: 100%;}
#calendar {vertical-align: top; padding: 15px; text-align: center;}
</style>
<link href='sources/schedule/css/fullcalendar.min.css' rel='stylesheet' />
<link href='sources/schedule/css/fullcalendar.print.min.css' rel='stylesheet' media='print' />
<link href='sources/schedule/css/schedule.css' rel='stylesheet'/>
<script src='/study-of-us/webjars/jquery/3.2.1/jquery.min.js'></script>
<script src='sources/schedule/js/moment.min.js'></script>
<script src='sources/schedule/js/fullcalendar.min.js'></script>
<script src='sources/schedule/js/schedule.js'></script>
<script src='sources/schedule/js/locale/ko.js'></script>

<script>
var eventList = ${schedules}
console.log(eventList);
</script>

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
