<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"
 				uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<form class="example" action="/study-of-us/study/search" method="get">
<div class="search">
  		<button type="submit"><i class="fa fa-search"></i></button>
 		 <input type="text" placeholder="Search.." id="searchVal" name="searchVal" value="">
	
	
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
	
	<div class="check" >
	<p>

	<label class="container">서울
  		<input type="checkbox"  value="서울">
		<span class="checkmark"></span>
	</label>
		<label class="container">경기
 		<input type="checkbox" value="경기">
  		<span class="checkmark"></span>
	</label>
	<label class="container">인천
  		<input type="checkbox" value="인천">
 		<span class="checkmark"></span>
	</label>
	<label class="container">강원
  		<input type="checkbox" value="강원">
  		<span class="checkmark"></span>
	</label>	
	</p>
	
	<p>
		<span style="font-size: 1.17em;
    font-weight: bold">선호지역</span>
	<label class="container">대전
  		<input type="checkbox" value="대전">
		<span class="checkmark"></span>
	</label>
		<label class="container">세종
 		<input type="checkbox" value="세종">
  		<span class="checkmark"></span>
	</label>
	<label class="container">충남
  		<input type="checkbox" value="충남">
 		<span class="checkmark"></span>
	</label>
	<label class="container">충북
  		<input type="checkbox"  value="충북">
  		<span class="checkmark"></span>
	</label>	
	</p>
	
		<p>
	<label class="container">부산
  		<input type="checkbox"  value="부산">
		<span class="checkmark"></span>
	</label>
		<label class="container">경남
 		<input type="checkbox"  value="경남">
  		<span class="checkmark"></span>
	</label>
	<label class="container">경북
  		<input type="checkbox"  value="경북">
 		<span class="checkmark"></span>
	</label>
	<label class="container">전북
  		<input type="checkbox"  value="전북">
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
  			 <span>스터디 기간 : ${study.term } 스터디 위치 ${study.place}</span>
		</div>
		</c:forEach>
		
		<div class="paging"  style="text-align:center; margin-bottom:100px">
		<c:if test="${startpage > 1}">
			<a href="/study-of-us/study/search?page=1&searchVal=${searchVal}"">처음</a>
		</c:if>
		
		<c:if test="${page > 1}">
			<a href="/study-of-us/study/search?page=${page-1 }&searchVal=${searchVal}">이전</a>
		</c:if>
		
		<c:forEach var="i" begin= "${startpage }" end="${endpage }">
			<a href="/study-of-us/study/search?page=${i }&searchVal=${searchVal}">${i }</a>
		</c:forEach>
		
		<c:if test="${page < totalpage}">
			<a href="/study-of-us/study/search?page=${page+1 }&searchVal=${searchVal}">다음</a>
		</c:if>
		
		<c:if test="${endpage < totalpage}">
			<a href="/study-of-us/study/search?page=${totalpage }&searchVal=${searchVal}">끝</a>
		</c:if>
		</div>
		
	</div>