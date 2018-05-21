<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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
    width : 100%;
}

div {
	border : 1px solid #0000004a;
	max-width : 500px;
    border-radius: 5px;
    background-color: #f2f2f259;
    padding: 20px;
    margin : 0 auto;
   
}
#email{
	width : 30%
}

#domain{
	width : 30%
}	
#post1{
	width : 48%;
}
#post2{
	width : 48%;
}

p{
	text-align : center;
}

textarea{
	width : 100%;
}
select{
	width : 30%;
	padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
	
}
</style>
</head>
<body>
<h3 align=center>Join StudyOfUs</h3>
	<div>
  <form action="#">
    <label for="lid"><strong>ID</strong></label>
    <input type="text" id="id" name="id" maxlength=7>
    
    <label for="password"><strong>Pass</strong></label><br>
    <input type="text" id="pass" name="pass" maxlength=10><br>
    
    <label for="password"><strong>Name</strong></label><br>
    <input type="text" id="name" name="name" maxlength=10><br>
    
    <label for="password"><strong>E-mail</strong></label><br>
    <input type="text" id="email" name="email" maxlength=10> @
    <input type="text" id="domain" name="domain" maxlength=10>
    <select name=sel id=sel>
    	<option value="">select domain</option>
    	<option value="naver.com">naver.com</option>
    	<option value="daum.net">daum.net</option>
    	<option value="nate.com">nate.com</option>
    	<option value="google.com">google.com</option>
    	<option value="yahoo.co.kr">yahoo.co.kr</option>
    </select><br>
    
    <label for="address"><strong>Address</strong></label><br>
    <input type="text" id=post1 name=post1 maxlength=3> -
    <input type="text" id=post2 name=post2 maxlength=3><br>
    
    
    <label for="gender"><strong>Gender</strong></label><br>
    
    <p>
	<input type="radio" name=gender id=gender1 class="radio" value="m">Male
	<input type="radio" name=gender id=gender2 class="radio" value="f">FeMale<br>
	</p>
	<label for="introduce"><strong>Introduce</strong></label><br>
    <textarea rows=10 cols=60 name=introduce id=introduce></textarea><br>
    <input type="submit" value="Join">
  </form>
</div>



</body>
</html>