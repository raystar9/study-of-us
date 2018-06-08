
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>

</style>
<div class="project">

	<c:forEach var="study" items="${studies }">
		<div class="projectcontainer">

			<img src="/study-of-us/resources/images/pc.png" alt="Avatar"
				style="width: 90px">
			<H3>스터디 : ${study.name }</H3>
			<p>목표 :</p>
			<span>${study.explain}</span> 
			<p>스터디 위치 : ${study.place}</p>
			<p>스터디 시간 : ${study.time}</p>
			<p>진행 요일 : ${study.day}	</p>
			<p>스터디 시작일 - 종료일  : ${study.start} -  ${study.end} </p>
			
			
			
			<input type="hidden" id="index" name="index" value="${study.index }" />
		</div>
	</c:forEach>

	<H3 style="text-align: center; clear: left">현재 페이지 ${page }</H3>
	<div class="paging" style="text-align: center; margin-bottom: 100px">
		<c:if test="${startpage > 1}">
			<a class="round2"
				href="/study-of-us/study/search?page=1&searchVal=${searchVal}&time=${time}&day=${day}&location=${location}&category=${category}">&laquo;</a>
		</c:if>

		<c:if test="${page > 1}">
			<a class="round"
				href="/study-of-us/study/search?page=${page-1 }&searchVal=${searchVal}&time=${time}&day=${day}&location=${location}&category=${category}">&#8249;</a>
		</c:if>

		<c:forEach var="i" begin="${startpage }" end="${endpage }">
			<a id=atag
				href="/study-of-us/study/search?page=${i }&searchVal=${searchVal}&time=${time}&day=${day}&location=${location}&category=${category}">${i }</a>
		</c:forEach>

		<c:if test="${page < totalpage}">
			<a class="round"
				href="/study-of-us/study/search?page=${page+1 }&searchVal=${searchVal}&time=${time}&day=${day}&location=${location}&category=${category}">&#8250;</a>
		</c:if>

		<c:if test="${endpage < totalpage}">
			<a class="round2"
				href="/study-of-us/study/search?page=${totalpage }&searchVal=${searchVal}&time=${time}&day=${day}&location=${location}&category=${category}">&raquo;</a>
		</c:if>

	</div>
</div>


