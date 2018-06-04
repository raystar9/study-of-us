<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<body>

<h3 align=center>ID Search</h3>
<h5 align=center>등록한 정보로 아이디를 찾을 수 있습니다.</h5>
<div>
  <form action="IDFindPage" method="post">
    <label for="lid"><strong>Your Name</strong></label>
    <input type="text" id="name" name="name" placeholder="Your Name.." maxlength="20">
    
    <label for="lid"><strong>Your Email</strong></label>
    <input type="text" id="email" name="email" placeholder="Your Email.." maxlength="50">
    <input type="submit" value="Find" id="submit">
  </form>
</div>
</body>
</html>