<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>우리를 위한 스터디 SOUP!</title>
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->



</head>
<body>
<h2 align=center>Sign in to StudyOfUs</h2>

<div class=login_form>
  <form action="LoginPage" method="post">
    <label for="lid"><strong>Your ID</strong></label><a href="IDFindForm" class="forgot">Forgot ID?</a>
    <input type="text" id="id" name="id" placeholder="Your ID.." maxlength="10">

    <label for="password"><strong>Your Pass</strong></label><a href="PWFindForm" class="forgot">Forgot password?</a>
    <input type="password" id="password" name="password" placeholder="Your PASS.." maxlength="13">
    <input type="submit" value="Sign in" id="submit">
  </form>
</div>
<br>
<div class=login_form>
	<strong>New to StudyOfUs?&nbsp;&nbsp;<a href=join>Create an account</a></strong>
</div>
		<p></p>
</body>
</html>
