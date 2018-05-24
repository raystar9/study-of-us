<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix="c"
 				uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<form class="example" action="/study-of-us/study/SearchList" method="get">
<div class="search">
  		<button type="submit"><i class="fa fa-search"></i></button>
 		 <input type="text" placeholder="Search.." id="searchVal" name="searchVal" value=${study.name }>
	
	
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
		<c:forEach var="study" items="${studies }">
		<div class="projectcontainer">
		
  			<img src="/study-of-us/resources/images/open-book.png" alt="Avatar" style="width:90px">
 			 <H3>스터디 : ${study.name }</H3>
  			<p>목표 : ${study.goal } </p>
  			 <span>스터디 기간 : ${study.term }</span>
		</div>
		</c:forEach>
		
		<div class="paging">
		<c:if test="${startpage > 1}">
			<a href="#">처음</a>
		</c:if>
		
		<c:if test="${page > 1}">
			<a href="#">이전</a>
		</c:if>
		
		<c:forEach var="i" begin= "${startpage }" end="${endpage }">
			<a href="#">${i }</a>
		</c:forEach>
		
		<c:if test="${page < totalpage}">
			<a href="#">다음</a>
		</c:if>
		
		<c:if test="${endpage < totalpage}">
			<a href="#">끝</a>
		</c:if>
		</div>
		
	</div>