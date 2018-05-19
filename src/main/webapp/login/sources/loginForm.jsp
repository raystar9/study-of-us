<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>

input[type=text] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

div {
	border : 1px solid #0000004a;
	max-width : 300px;
    border-radius: 5px;
    background-color: #f2f2f259;
    padding: 20px;
    margin : 0 auto;
}
.forgot{
	float : right;
}

.icon{
	width : 100px;
	height : 100px;
}

.icon{
	   margin: 0 auto;
}
	
</style>
<body>


<p class=icon>
<a href=main.jsp><img class="icon" src="/study-of-us/resources/images/cat.png"></a>
</p>
<h3 align=center>Sign in to StudyOfUs</h3>

<div>
  <form action="#">
    <label for="lid"><strong>Your ID</strong></label>
    <input type="text" id="id" name="id" placeholder="Your ID..">

    <label for="password"><strong>Your Pass</strong></label><a href="#" class="forgot">Forgot password?</a>
    <input type="text" id="pass" name="pass" placeholder="Your PASS..">
    <input type="submit" value="Sign in">
  </form>
</div>
<br>
<div>
	<strong>New to StudyOfUs?&nbsp;&nbsp;<a href=#>Create an account</a></strong>
</div>


</body>
</html>
