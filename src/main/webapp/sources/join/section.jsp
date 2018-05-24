<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 align=center>Join StudyOfUs</h3>
	<div>
  <form action="join" method="post">
    <label for="lid"><strong>ID</strong></label><br>
    <input type="text" id="id" name="id" maxlength=10>
    <input type="button" id="idcheck" name="idcheck" value="중복검사"><br>
    
    <label for="name"><strong>Name</strong></label><br>
    <input type="text" id="name" name="name" maxlength=10><br>
    
    <label for="password"><strong>Pass</strong></label><br>
    <input type="password" id="password" name="password" maxlength=15><br>
    
    <label for="password2"><strong>비밀번호확인</strong></label><br>
    <input type="password" id=password2 name="password2" maxlength=15><br>
    
    <label for="email"><strong>E-mail</strong></label><br>
    <input type="email" id="email" name="email" maxlength=30><br>
    <!-- <input type="text" id="domain" name="domain" maxlength=10>
    <select name=sel id=sel>
    	<option value="">select domain</option>
    	<option value="naver.com">naver.com</option>
    	<option value="daum.net">daum.net</option>
    	<option value="nate.com">nate.com</option>
    	<option value="google.com">google.com</option>
    	<option value="yahoo.co.kr">yahoo.co.kr</option>
    </select><br>
 -->
	<label for="tel"><strong>전화번호</strong></label><br>
	<input type=text id=tel name="tel" maxlength="11"><br>
	
	    
    <label for="area"><strong>preference Area</strong></label><br>
    <p>
    	<input type="checkbox" name=area id=area value="서울" checked>서울
    	<input type="checkbox" name=area id=area value="경기">경기
    	<input type="checkbox" name=area id=area value="인천">인천
    	<input type="checkbox" name=area id=area value="대전">대전
    	<input type="checkbox" name=area id=area value="부산">부산
    	<input type="checkbox" name=area id=area value="대구">대구
    	<input type="checkbox" name=area id=area value="광주">광주<br>
    </p>
    
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