<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
       <%@ taglib prefix = "c"
				uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #ccc;
}

.topnav a {
  float: left;
  color: #333333;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.active{
	 margin-right: 60px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}
.topnav a.active {
  background-color: #252525;
  color: white;
}

.topnav-right {
  float: right;
}

</style>
</head>
<body>

<div class="topnav">

<c:if test="${empty id }">
  <a class="active" href="/study-of-us/home">Home</a>
  </c:if>
  <c:if test="${!empty id }">
  <a class="active" href="/study-of-us/study/list">Home</a>
  </c:if>
  <a href="/study-of-us/study/each/Registration">Study Create</a>
  <a href="/study-of-us/study/SearchMain">Study Search</a>
  <a href="/study-of-us/inquiryPage">Study Board</a>
  
  <a href="#information">Information</a>
  
  <div class="topnav-right">
  <c:if test="${empty id }">
  	<a href=""><i class="fa fa-bell icon"></i></a>
    <a href="/study-of-us/LoginForm">Login</a>
    <a href="/study-of-us/join">SignUp</a>
  </c:if> 
  
  <c:if test="${!empty id }">
 	 <a>${id} 님 환영합니다</a>
    <a href="/study-of-us/LogOut">로그아웃</a>
  </c:if>
   
  </div>
</div>

</body>
</html>