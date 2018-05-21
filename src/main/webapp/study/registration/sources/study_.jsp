<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>




<!-- <script src = "http://code.jquery.com/jquery-3.3.1.js"></script> -->

<!--  아이콘 -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="/study-of-us/study/registration/css/sutdy_.css" rel="stylesheet">

<!-- 자바 ui -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script src="/study-of-us/study/registration/js/study_.js"></script>
</head>
<body>

<h3 align=center>Sign Up</h3>
<div>
<i class="material-icons">category</i>
<label for="category"><strong>카테고리</strong></label><br>

<input type=text name=category id="category">
<select name=sel id=sel>
	<option value="">세부 카테고리..</option>
	<option value="">option2</option>
	<option value="">option3</option>
	<option value="">option4</option>
	<option value="">option5</option>
</select>
<br>

<i class="material-icons">create</i>
<label for="category"><strong>스터디명</strong></label><br>
<input type=text name=study_name id="study_name"><br>


<i class="material-icons">date_range</i>
<label for="category"><strong>기간</strong></label><br>
<input type=text name=day1 id="day1"> ~ 
<input type=text name=day2 id="day2"><br>


<p>

<span class=one>
		
		<i class="material-icons">people</i>
		<label for="category"><strong>모집인원</strong></label><br>
		<input type=text name=people id=people name=people>
		</span>
<span class=two>

		<i class="material-icons">access_time</i>
		<label for="category"><strong>활동 시간</strong></label><br>
		<input type=text name=people id=people name=people>
</span>

<span class=three>
		<i class="material-icons">today</i>
		<label for="day"><strong>활동 요일</strong></label><br>
		<input type=text name=activity_day id=activity_day name=activity_day>
</span>
</p>


<i class="material-icons">edit</i>
<label for="explain"><strong>프로젝트 개요</strong></label><br>
<textarea rows=10 cols=60 name=explain id=explain  placeholder="너무 어려워.."></textarea><br>

<i class="material-icons">star_half</i>
<label for="prepared"><strong>주요 교재 및 준비물</strong></label><br>
<textarea rows=10 cols=60 name=prepared id=prepared></textarea><br>

<label for="prepared"><strong>기대효과 및 활동 분야</strong></label><br>
<textarea rows=10 cols=60 name=prepared id=prepared></textarea><br>
<br>


<p>
<span class="check">

	
	<label class="container">서울
        <input type="checkbox" checked="checked">
      <span class="checkmark"></span>
   </label>&nbsp;&nbsp;
      <label class="container">부산
       <input type="checkbox">
        <span class="checkmark"></span>
   </label>
   <br>
   <label class="container">대구
        <input type="checkbox" checked="checked">
      <span class="checkmark"></span>
   </label>&nbsp;&nbsp;
      <label class="container">대전
       <input type="checkbox">
        <span class="checkmark"></span>
   </label>
   <br>
   <label class="container">경기
        <input type="checkbox" checked="checked">
      <span class="checkmark"></span>
   </label>&nbsp;&nbsp;
   <label class="container">인천
       <input type="checkbox">
        <span class="checkmark"></span>
   </label>
   <br>
   <label class="container">강원
       <input type="checkbox">
        <span class="checkmark"></span>
   </label>&nbsp;&nbsp;
   <label class="container">시흥
       <input type="checkbox">
        <span class="checkmark"></span>
   </label>
</span>
<span id="map" style="width:48%;height:400px;"></span>
</p>
	<input type=submit value="올리기">
</div>
</body>
</html>