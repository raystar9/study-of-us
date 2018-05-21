<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<link href="/study-of-us/main/css/main.css" rel="stylesheet">
</head>
<body>

<h2>Form on Hero Image</h2>
<div class="bg-img">
<div class=main-writing>
	<h1>Don't be too timid and <br>
	squeamish about your actions.<br>
	 All life is an experiment.<br>
	  The more experiments you make the better.</h1>
</div>
	
  <form action="/action_page.php">
    <div class="container">
      <h1>Login</h1>

      <label for="email"><b>Email</b></label>
      <input type="text" placeholder="Enter Email" name="email" required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw" required>

      <button type="submit" class="btn">Login</button>
      <button type="submit" class="btn">Join</button>
    </div>
  </form>
</div>

<p>This example creates a form on a responsive image. Try to resize the browser window to see how it always will cover the whole width of the screen, and that it scales nicely on all screen sizes.</p>

</body>
</html>