<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.button-container {text-align: center;}
#new-button {width: 400px; height: 50px;}

</style>
<link href='sources/schedule/css/fullcalendar.min.css' rel='stylesheet' />
<link href='sources/schedule/css/fullcalendar.print.min.css' rel='stylesheet' media='print' />
<link href='sources/schedule/css/schedule.css' rel='stylesheet'/>
<script src='/study-of-us/webjars/jquery/3.2.1/jquery.min.js'></script>
<script src='sources/schedule/js/moment.min.js'></script>
<script src='sources/schedule/js/fullcalendar.min.js'></script>
<script src='sources/schedule/js/schedule3.js'></script>
<script src='sources/schedule/js/locale/ko.js'></script>

<script>
var eventList = ${schedules}
console.log(eventList);
</script>

</head>
<body>
<%@ include file = "/general-sources/Navigation.jsp" %><br>
<%@ include file = "sources/schedule/section.jsp" %><br>
<%@ include file = "/general-sources/Footer.jsp" %>
</body>
</html>
