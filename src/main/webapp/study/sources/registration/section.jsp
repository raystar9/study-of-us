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
<form action="/study-of-us/study/registration" method="post">
<h2 align=center>StudyOfUs</h2>
<div class="signup">
<i class="material-icons">category</i>
<label for="category"><strong>카테고리</strong></label><br>

<span id=category>
<select name=first id="first">
	<option value="-1">대분류</option>
	<option value="1">프로그래밍</option>
	<option value="2">언어</option>
	<option value="3">자격증</option>
	<option value="4">수능</option>
</select>

<select name="second" id="second">
	<option value="-1">소분류</option>
</select>
</span>
<br>

<i class="material-icons">create</i>
<span id="place"></span>
<label for="category"><strong>스터디명</strong></label><br>
<input type=text name=study_name id="study_name"><br>


<i class="material-icons">date_range</i>
<label for="category"><strong>기간</strong></label><br>
<input type=text name=day1 id="day1" readOnly> ~ 
<input type=text name=day2 id="day2" readOnly><br>


<span>
<span class=one>
      
      <i class="material-icons">people</i>
      <label for="people"><strong>모집인원</strong></label><br>
      <input type=text name=people id=people>
      </span>


<span class=two>
      <i class="material-icons">today</i>
      <label for="day"><strong>활동 요일</strong></label><br>
      <select name="day" id="day">
      <option value="">요일</option>
      <option value="월">월</option>
      <option value="화">화</option>
      <option value="수">수</option>
      <option value="목">목</option>
      <option value="금">금</option>
      <option value="토">토</option>
      <option value="일">일</option>
      </select>
</span>&nbsp;

<span class="three">
      <i class="material-icons">access_time</i>
      <label for="category"><strong>활동 시간</strong></label><br>
      <select id="stime" name="stime">
      <option value = "">시간</option>
      <option value = "01:00~">01:00~</option>
      <option value = "02:00~">02:00~</option>
      <option value = "03:00~">03:00~</option>
      <option value = "04:00~">04:00~</option>
      <option value = "05:00~">05:00~</option>
      <option value = "06:00~">06:00~</option>
      <option value = "07:00~">07:00~</option>
      <option value = "08:00~">08:00~</option>
      <option value = "09:00~">09:00~</option>
      <option value = "10:00~">10:00~</option>
      <option value = "11:00~">11:00~</option>
      <option value = "12:00~">12:00~</option>
      <option value = "13:00~">13:00~</option>
      <option value = "14:00~">14:00~</option>
      <option value = "15:00~">15:00~</option>
      <option value = "16:00~">16:00~</option>
      <option value = "17:00~">17:00~</option>
      <option value = "18:00~">18:00~</option>
      <option value = "19:00~">19:00~</option>
      <option value = "20:00~">20:00~</option>
      <option value = "21:00~">21:00~</option>
      <option value = "22:00~">22:00~</option>
      <option value = "23:00~">23:00~</option>
      <option value = "24:00~">24:00~</option>
      </select>
</span>&nbsp;

<span class="four">
<i class="material-icons">location_on</i>
<label for="location"><strong>선호 지역</strong></label><br>
<select id="locationSel" name=location>
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
</span>
</span>



<i class="material-icons">edit</i>
<label for="explain"><strong>프로젝트 개요</strong></label><br>
<textarea rows=10 cols=60 name=explain id=explain ></textarea><br>

<i class="material-icons">star_half</i>
<label for="prepared"><strong>주요 교재 및 준비물</strong></label><br>
<textarea rows=10 cols=60 name=prepared id=prepared></textarea><br>

<i class="material-icons">public</i>
<label for="prepared"><strong>기대효과 및 활동 분야</strong></label><br>
<textarea rows=10 cols=60 name=activity id=activity></textarea><br>


   <input type=submit value="저장하기">
</div>
</form>
</div>
</body>
</html>
