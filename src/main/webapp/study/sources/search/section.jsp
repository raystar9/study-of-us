 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"
 				uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<form class="example" action="/study-of-us/study/search" method="get">
<div class="search">
  		<button type="submit" id="button"><i class="fa fa-search"></i></button>
 		 <input type="text" placeholder="Search.." id="searchVal" name="searchVal" value="">
	
	
	<div class="custom-select">
  		<select id="firstArray" name="firstArray">
  			  <option value="-1">대분류</option>
  			  <option value="1">프로그래밍</option>
 			  <option value="2">언어</option>
   			  <option value="3">자격증</option>
  		</select>
	</div>
	
	<div class="custom-select2">
  		<select id="secondArray" name="secondArray">
  			  <option>소분류</option>
  			  
  		</select>
	</div>
</div>
	
	<div class="check" >
	<p>
	 
	<label class="container">서울
  		<input type="checkbox" name="checkbox" value="서울">
		<span class="checkmark"></span>
	</label>
		<label class="container">부천
 		<input type="checkbox" value="부천" name="checkbox">
  		<span class="checkmark"></span>
	</label>
	<label class="container">인천
  		<input type="checkbox" value="인천" name="checkbox">
 		<span class="checkmark"></span>
	</label>
	<label class="container">춘천
  		<input type="checkbox" value="춘천" name="checkbox">
  		<span class="checkmark"></span>
	</label>	
	</p>
	
	<p>
		<span style="font-size: 1.17em;
    font-weight: bold">선호지역 </span>
	<label class="container">대전
  		<input type="checkbox" value="대전" name="checkbox">
		<span class="checkmark"></span>
	</label>
		<label class="container">세종
 		<input type="checkbox" value="세종" name="checkbox">
  		<span class="checkmark"></span>
	</label>
	<label class="container">천안
  		<input type="checkbox" value="천안" name="checkbox">
 		<span class="checkmark"></span>
	</label>
	<label class="container">부산
  		<input type="checkbox"  value="부산" name="checkbox">
  		<span class="checkmark"></span>
	</label>	
	</p>
	
		<p>
	
	<label class="container">부산
  		<input type="checkbox"  value="부산" name="checkbox"> 
		<span class="checkmark"></span>
	</label>
		<label class="container">경남
 		<input type="checkbox"  value="창원" name="checkbox">
  		<span class="checkmark"></span>
	</label>
	<label class="container">경북
  		<input type="checkbox"  value="광주" name="checkbox">
 		<span class="checkmark"></span>
	</label>
	<label class="container">전북
  		<input type="checkbox"  value="수원" name="checkbox">
  		<span class="checkmark"></span>
	</label>	
	</p>
	</div>
		<input type="hidden" id="place2" name="place2" value=""/>
	</form>
	<div class="project">
		<c:forEach var="study" items="${studies }">
		<div class="projectcontainer">
		
  			<img src="/study-of-us/resources/images/open-book.png" alt="Avatar" style="width:90px">
 			 <H3>스터디 : ${study.name }</H3>
  			<p>목표 :  </p>
  			 <span>스터디 기간 :  스터디 위치 ${study.place}</span>
  			<input type="hidden" id="index" name="index" value="${study.index }"/>
		</div>
		</c:forEach>
	<div class="paging"  style="text-align:center; margin-bottom:100px">
		<c:if test="${startpage > 1}">
			<a href="/study-of-us/study/search?page=1&searchVal=${searchVal}${check}&secondArray=${secondArray}">처음</a>
		</c:if>
		
		<c:if test="${page > 1}">
			<a href="/study-of-us/study/search?page=${page-1 }&searchVal=${searchVal}${check}&secondArray=${secondArray}">이전</a>
		</c:if>
		
		<c:forEach var="i" begin= "${startpage }" end="${endpage }">
			<a href="/study-of-us/study/search?page=${i }&searchVal=${searchVal}${check}&secondArray=${secondArray}">${i }</a>
		</c:forEach>
		
		<c:if test="${page < totalpage}">
			<a href="/study-of-us/study/search?page=${page+1 }&searchVal=${searchVal}&checkbox=${check}&secondArray=${secondArray}">다음</a>
		</c:if>
		
		<c:if test="${endpage < totalpage}">
			<a href="/study-of-us/study/search?page=${totalpage }&searchVal=${searchVal}${check}&secondArray=${secondArray}">끝</a>
		</c:if>

		</div>
		</div>
		
