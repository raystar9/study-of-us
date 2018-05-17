<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body, html {
    height: 100%;
    font-family: Arial, Helvetica, sans-serif;
}

* {
    box-sizing: border-box;
}

.bg-img {
    /* The image used */
    background-image: url("images/image6.jpg");

    min-height: 600px;

    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}


.main-writing{
    color: white;
    position: absolute;
    right: 50%;
    max-width: 400px;
    margin-top: 150px;

}

/* Add styles to the form container */



.container {
    position: absolute;
    left: 50%;
    margin: 20px;
    max-width: 400px;
    padding: 16px;
    background-color: white;
    margin-top: 150px;
}

/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    border: none;
    background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
}

/* Set a style for the submit button */
.btn {
    background-color: #4CAF50;
    color: white;
    padding: 16px 20px;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
}

.btn:hover {
    opacity: 1;
}
</style>
</head>
<body>

<%@ include file = "/Navigation.jsp" %>
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
    </div>
    <%@ include file = "/Footer.jsp" %>
  </form>
</div>


</body>
</html>