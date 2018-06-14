<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>우리를 위한 스터디 SOUP!</title>
</head>
<body>

<div class="all">
<h2 align=center>Join StudyOfUs</h2>
	<div class="join_form">
  <form action="join" method="post">
    <label for="lid"><strong>ID</strong></label><br>
    <span id="place"></span><input type="text" id="id" name="id" maxlength=13>
    <input type="button" id="idcheck" name="idcheck" value="중복검사"><br>
    

    
    <label for="password"><strong>Pass</strong></label><br>
    <input type="password" id="password" name="password" maxlength=13><br>
    
    <label for="password2"><strong>비밀번호확인</strong></label><br>
    <input type="password" id=password2 name="password2" maxlength=13>
    <font name = check size="2"></font>
    <br>
    
        <label for="name"><strong>Name</strong></label><br>
    <input type="text" id="name" name="name" maxlength=10><br>
    
    
    
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
    	<select id="location" name="location">
			<option value="">지역</option>
			<option value="서울">서울</option>
			<option value="부천">부천</option>
			<option value="인천">인천</option>
			<option value="춘천">춘천</option>
			<option value="대전">대전</option>
			<option value="세종시">세종</option>
			<option value="천안">천안</option>
			<option value="부산">부산</option>
			<option value="창원">창원</option>
			<option value="광주">광주</option>
		</select>
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


</div>
</body>
</html>