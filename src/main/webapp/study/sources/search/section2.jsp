 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"
 				uri="http://java.sun.com/jsp/jstl/core" %>
 				
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
			<a id=atag href="/study-of-us/study/search?page=${i }&searchVal=${searchVal}${check}&secondArray=${secondArray}">${i }</a>
		</c:forEach>
		
		<c:if test="${page < totalpage}">
			<a href="/study-of-us/study/search?page=${page+1 }&searchVal=${searchVal}&checkbox=${check}&secondArray=${secondArray}">다음</a>
		</c:if>
		
		<c:if test="${endpage < totalpage}">
			<a href="/study-of-us/study/search?page=${totalpage }&searchVal=${searchVal}${check}&secondArray=${secondArray}">끝</a>
		</c:if>
		</div>
		</div>
		
