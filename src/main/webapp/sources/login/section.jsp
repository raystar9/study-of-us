<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->



</head>
<body>
<p class=icon>
<a href=home><img class="icon" src="/study-of-us/resources/images/cat.png"></a>
</p>
<h3 align=center>Sign in to StudyOfUs</h3>

<div>
  <form action="LoginPage" method="get">
    <label for="lid"><strong>Your ID</strong></label><a href="IDFind.jsp" class="forgot">Forgot ID?</a>
    <input type="text" id="id" name="id" placeholder="Your ID.." maxlength="10">

    <label for="password"><strong>Your Pass</strong></label><a href="PWFind.jsp" class="forgot">Forgot password?</a>
    <input type="password" id="password" name="password" placeholder="Your PASS.." maxlength="13">
    <input type="submit" value="Sign in" id="submit">
  </form>
</div>
<br>
<div>
	<strong>New to StudyOfUs?&nbsp;&nbsp;<a href=#>Create an account</a></strong>
</div>
		<p></p>
</body>
</html>
