<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body {margin : 0; padding : 0;}
	nav {background-color: red; height : 100px}
	aside {display : inline-block; background-color: green; width: 30%; height: 300px;}
	section {display: inline-block; background-color: blue; width: 70%; height: 300px;}
</style>
</head>
<body>
<nav><c:import url="/contents/exampleNav.jsp"/></nav><aside>
<c:import url="/contents/exampleAside.jsp"/></aside><section>
<c:import url="/contents/exampleSection.jsp"/></section>
<!-- https://css-tricks.com/fighting-the-space-between-inline-block-elements/ 인라인 블록 공백 없애는 꼼수-->
</body>
</html>