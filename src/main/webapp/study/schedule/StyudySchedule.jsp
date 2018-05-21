<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href='css/fullcalendar.min.css' rel='stylesheet' />
<link href='css/fullcalendar.print.min.css' rel='stylesheet' media='print' />
<link href='css/schedule.css' rel='stylesheet'/>
<script src='js/moment.min.js'></script>
<script src='js/jquery.min.js'></script>
<script src='js/fullcalendar.min.js'></script>
<script src='js/schedule.js'></script>

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
