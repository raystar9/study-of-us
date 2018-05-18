<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

.topnav .search-container button {
  float: right;
  padding: 6px 10px;
  margin-top: 8px;
  margin-right: 16px;
  background: #ddd;
  font-size: 17px;
  border: none;
  cursor: pointer;
}
.topnav .search-container {
  float: right;
}
.topnav .search-container button:hover {
  background: #ccc;
}

input {
      height: 28px;
    width: 200px;
    margin-top: 7px;
}
</style>
</head>
<body>

<div class="topnav">
  <a class="active" href="#home">Home</a>
  <a href="#studycreate">Study Create</a>
  <a href="#studysearch">Study Search</a>
  <a href="#information">Information</a>
  <div class="topnav-right">
    <a href="#login">Login</a>
    <a href="#signup">SignUp</a>
   <!-- if 문을 통해서 로그인 상태시 로그아웃을 표시하고 로그인을 하지 않으면 회원가입을 표시한다  -->
  </div>
  <div class="search-container">
    <form action="/action_page.php">
      <input type="text" placeholder="Search.." name="search">
      <button type="button"><i class="fa fa-search"></i></button>
    </form>
  </div>
</div>

</body>
</html>