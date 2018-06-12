
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	function myFunction() {
		var x = document.getElementById("hidedetail");
		if (x.style.display == "none") {
			x.style.display = "block";
		} else {
			x.style.display = "none";
		}
	}
</script>
<!DOCTYPE html>
<form class="example" action="/study-of-us/study/search" method="get">
	<div class="search">
		<div class="detail">
			<button class="detail-search" type="button" onclick="myFunction()">세부
				검색</button>
			<button class="detail-search" type="submit" id="button">
				<i class="fa fa-search"></i>
			</button>
			<input type="text" placeholder="Search.." id="searchVal"
				name="searchVal" value="">
		</div>
	</div>
	<input type="hidden" id="place2" name="place2" value="" />
</form>
<div id="loader"></div>

<div class="hidedetail" id="hidedetail" style="display: none">
	<form action="/study-of-us/study/search" method="get"
		style="max-width: 500px; margin: auto">
		<h2>세부 검색</h2>
		<div class="input-container">
			<i class="fa fa-search icon"></i> <input class="searchval"
				type="text" placeholder="검색어를 입력하세요" name="searchVal"
				style="width: 100%;">
		</div>

		<div class="input-container">
			<i class="fa fa-sitemap icon"></i> <input class="category"
				type="text" placeholder="카테고리를 선택하세요" name="subcategory"
				style="width: 60%;"> <select id="firstArray"
				name="firstArray" style="width: 20%;">
				<option value="-1">대분류</option>
				<option value="1">프로그래밍</option>
				<option value="2">언어</option>
				<option value="3">자격증</option>
			</select> <select id="secondArray" name="secondArray" style="width: 20%;">
				<option>소분류</option>
			</select>
		</div>

		<div class="input-container">
			<i class="fa fa-clock-o icon"></i> <input class="time" type="text"
				placeholder="시간대를 선택 하세요" name="time" style="width: 70%;"> <select
				id="stime" name="stime" style="width: 30%;">
				<option value="">시간</option>
				<option value="01:00">01:00~</option>
				<option value="02:00">02:00~</option>
				<option value="03:00">03:00~</option>
				<option value="04:00">04:00~</option>
				<option value="05:00">05:00~</option>
				<option value="06:00">06:00~</option>
				<option value="07:00">07:00~</option>
				<option value="08:00">08:00~</option>
				<option value="09:00">09:00~</option>
				<option value="10:00">10:00~</option>
				<option value="11:00">11:00~</option>
				<option value="12:00">12:00~</option>
				<option value="13:00">13:00~</option>
				<option value="14:00">14:00~</option>
				<option value="15:00">15:00~</option>
				<option value="16:00">16:00~</option>
				<option value="17:00">17:00~</option>
				<option value="18:00">18:00~</option>
				<option value="19:00">19:00~</option>
				<option value="20:00">20:00~</option>
				<option value="21:00">21:00~</option>
				<option value="22:00">22:00~</option>
				<option value="23:00">23:00~</option>
				<option value="24:00">24:00~</option>
			</select>
		</div>

		<div class="input-container">
			<i class="fa fa-calendar-check-o icon"></i> <input class="day"
				type="text" placeholder="요일을 선택 하세요" name="day" style="width: 70%;">
			<select name="day" id="day-select" style="width: 30%;">
				<option value="">요일</option>
				<option value="월">월</option>
				<option value="화">화</option>
				<option value="수">수</option>
				<option value="목">목</option>
				<option value="금">금</option>
				<option value="토">토</option>
				<option value="일">일</option>
			</select>
		</div>
		<div class="input-container">
			<i class="fa fa-globe icon"></i> <input class="location" type="text"
				placeholder="지역을 선택 하세요" name="location" style="width: 70%;">
				 <select id="location" name="location" style="width: 30%;">
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
		</div>

		<button type="submit" class="btn">검색</button>
	</form>
</div>

	<div class="project">
		<div>
			<c:forEach var="study" items="${studies }">
				<div class="projectcontainer">
					<div>
						<img src="/study-of-us/resources/images/pc.png" alt="Avatar"
							style="width: 90px">
					</div>
					<h3>${study.name }</h3>
					<span>${study.explain}</span>
					<p>스터디 위치 : ${study.place}</p>
					<p>스터디 시간 : ${study.time}</p>
					<p>진행 요일 : ${study.day}</p>
					<p>스터디 시작일 - 종료일 : ${study.start} - ${study.end}</p>



					<input type="hidden" id="index" name="index"
						value="${study.index }" />
				</div>
			</c:forEach>
		</div>

		<H3 style="text-align: center; clear: left">현재 페이지 ${page }</H3>
	<div class="paging" style="text-align: center; margin-bottom: 100px">
		<c:if test="${startpage > 1}">
			<a class="round2"
				href="/study-of-us/study/search?page=1&searchVal=${searchVal}&time=${time}&day=${day}&location=${location}&category=${category}&subcategory=${subcategory}">&laquo;</a>
		</c:if>

		<c:if test="${page > 1}">
			<a class="round"
				href="/study-of-us/study/search?page=${page-1 }&searchVal=${searchVal}&time=${time}&day=${day}&location=${location}&category=${category}&subcategory=${subcategory}">&#8249;</a>
		</c:if>

		<c:forEach var="i" begin="${startpage }" end="${endpage }">
			<a id=atag
				href="/study-of-us/study/search?page=${i }&searchVal=${searchVal}&time=${time}&day=${day}&location=${location}&category=${category}&subcategory=${subcategory}">${i }</a>
		</c:forEach>

		<c:if test="${page < totalpage}">
			<a class="round"
				href="/study-of-us/study/search?page=${page+1 }&searchVal=${searchVal}&time=${time}&day=${day}&location=${location}&category=${category}&subcategory=${subcategory}">&#8250;</a>
		</c:if>

		<c:if test="${endpage < totalpage}">
			<a class="round2"
				href="/study-of-us/study/search?page=${totalpage }&searchVal=${searchVal}&time=${time}&day=${day}&location=${location}&category=${category}&subcategory=${subcategory}">&raquo;</a>
		</c:if>

	</div>

</div>


