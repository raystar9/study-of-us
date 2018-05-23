<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href='sources/schedule/css/fullcalendar.min.css' rel='stylesheet' />
<link href='sources/schedule/css/fullcalendar.print.min.css' rel='stylesheet' media='print' />
<link href='sources/schedule/css/schedule.css' rel='stylesheet'/>
<script src='sources/schedule/js/moment.min.js'></script>
<script src='sources/schedule/js/jquery.min.js'></script>
<script src='sources/schedule/js/fullcalendar.min.js'></script>
<script src='sources/schedule/js/schedule.js'></script>

</head>
<body>
<%@ include file = "/general-sources/Navigation.jsp" %><br>
	<div id='calendar'></div>
	
	<div class="varcontainer">
  		<div class="skills js">진행률(65%)</div>
	</div>
<%@ include file = "/general-sources/Footer.jsp" %>
</body>
</html>
