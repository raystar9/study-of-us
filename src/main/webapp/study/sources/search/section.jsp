<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<form class="example" action="Request_Test.jsp" method="post">
<div class="search">
  		<button type="submit"><i class="fa fa-search"></i></button>
 		 <input type="text" placeholder="Search.." id="searchVal" name="searchVal">
	
	
	<div class="custom-select">
  		<select id="firstArray" name="firstArray">
  			  <option value="-1">대분류</option>
  			  <option value="1">프로그래밍</option>
 			  <option value="2">외국어</option>
   			  <option value="3">자격증</option>
  		</select>
	</div>
	
	<div class="custom-select2">
  		<select id="secondArray" name="secondArray">
  			  <option value="-1">소분류</option>
  			  
  		</select>
	</div>
</div>
	
	<div class="check">
	<p>
	<span>체크사항1</span>
	<label class="container">One
  		<input type="checkbox" checked="checked" value="One" name="check1">
		<span class="checkmark"></span>
	</label>
		<label class="container">Two
 		<input type="checkbox">
  		<span class="checkmark"></span>
	</label>
	<label class="container">Three
  		<input type="checkbox">
 		<span class="checkmark"></span>
	</label>
	<label class="container">Four
  		<input type="checkbox">
  		<span class="checkmark"></span>
	</label>	
	</p>
	
	<p>
	<span>체크사항2</span>
	<label class="container">One
  		<input type="checkbox" checked="checked">
		<span class="checkmark"></span>
	</label>
		<label class="container">Two
 		<input type="checkbox">
  		<span class="checkmark"></span>
	</label>
	<label class="container">Three
  		<input type="checkbox">
 		<span class="checkmark"></span>
	</label>
	<label class="container">Four
  		<input type="checkbox">
  		<span class="checkmark"></span>
	</label>	
	</p>
	
		<p>
		<span>체크사항3</span>
	<label class="container">One
  		<input type="checkbox" checked="checked">
		<span class="checkmark"></span>
	</label>
		<label class="container">Two
 		<input type="checkbox">
  		<span class="checkmark"></span>
	</label>
	<label class="container">Three
  		<input type="checkbox">
 		<span class="checkmark"></span>
	</label>
	<label class="container">Four
  		<input type="checkbox">
  		<span class="checkmark"></span>
	</label>	
	</p>
	</div>
	</form>
	<div class="project">
		<div class="projectcontainer">
  			<img src="/study-of-us/resources/images/IMG2.jpg" alt="Avatar" style="width:90px">
 			 <p><span>스터디장 아이디</span> 스터디 제목</p>
  			<p>스터디 관련 내용.</p>
		</div>
		
		<div class="projectcontainer">
  			<img src="/study-of-us/resources/images/IMG.jpg"  alt="Avatar" style="width:90px">
 			 <p><span>Chris Fox.</span> CEO at Mighty Schools.</p>
  			<p>John Doe saved us from a web disaster.</p>
		</div>
		
		<div class="projectcontainer">
  			<img src="/study-of-us/resources/images/IMG2.jpg"  alt="Avatar" style="width:90px">
 			 <p><span>Chris Fox.</span> CEO at Mighty Schools.</p>
  			<p>John Doe saved us from a web disaster.</p>
		</div>
		
		<div class="projectcontainer">
  			<img src="/study-of-us/resources/images/IMG.jpg"  alt="Avatar" style="width:90px">
 			 <p><span>Chris Fox.</span> CEO at Mighty Schools.</p>
  			<p>John Doe saved us from a web disaster.</p>
		</div>
		
		<div class="projectcontainer">
  			<img src="/study-of-us/resources/images/IMG2.jpg"  alt="Avatar" style="width:90px">
 			 <p><span>Chris Fox.</span> CEO at Mighty Schools.</p>
  			<p>John Doe saved us from a web disaster.</p>
		</div>
	</div>