<!-- 스터디 안의 게시판 리스트 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>스터디 안의 게시판 리스트 페이지</title>
<style>
	#boardtable{width:1080px; border:1px solid #ddd; font-size: 11px}
	#number{text-align: center; font-size:13px}
	#write{float:right; padding:3px 10px; font-size:12px}
	#boardSearchBtn{padding:3px 10px; font-size:11px}
</style>
</head>
<body>
	<!-- 게시판 리스트 -->
	<form action='./board' method='get'>
	<table class="table table-striped" id="boardtable">
		<!-- 레코드가 있으면 -->
		<tr>
			<td colspan="5"></th>
			<td colspan="2"><strong>글개수 : ${listcount }</strong></th>
		</tr>
		<tr>
			<th width="5%" id="numTitle"><div><strong>번호</strong></div></th>
			<th width="50%"><div>제목</div></th>
			<th width="14%"><div>작성자</div></th>
			<th width="17%" colspan='3'><div>날짜</div></th>
		</tr>
		<c:set var="num" value="${listcount-(page-1)*10 }" />
			<c:forEach var="b" items="${boardlist}">
				<tr>
					<td align="center"><c:out value="${num }"></c:out> <c:set var="num"
							value="${num-1}" /></td>
					<td>
						<div>
							&nbsp; ▶ <a href="./boardview?num=${b.index}"> ${b.title} </a>
							<c:if test='${!empty b.filename }'>
								<img src='../sources/board-list/file.png' width='13px'
									height='13px'>
							</c:if>
						</div>
					</td>
					<td>
						<div>${b.name}</div>
					</td>
					<td colspan='3'>
						<div>${b.date}</div>
					</td>
				</tr>
			</c:forEach>

			<tr id="number"> 
				<td colspan="7"><c:if test="${page <= 1 }">
      		이전&nbsp;&nbsp;
      		</c:if> <c:if test="${page > 1 }">
					<a href="./board?searchSelect=${searchSelect }&search=${search }&page=${page-1}">이전</a>&nbsp;
      		</c:if> <c:forEach var="a" begin="${startpage }" end="${endpage }">
						<c:if test="${a == page}">
      				${a}
      			</c:if>
						<c:if test="${a != page }">
							<a href="./board?searchSelect=${searchSelect }&search=${search }&page=${a}">${a}</a>
						</c:if>
					</c:forEach> <c:if test="${page >= maxpage}">
      			&nbsp;&nbsp;다음
      		</c:if> <c:if test="${page < maxpage }">
						<a href="./board?page=${page+1}">&nbsp;다음</a>
					</c:if></td>
		<tr>
			<td colspan="7">
					<select name="searchSelect">
						<option value="title" selected="selected">제목</option>
						<option value="name">작성자</option>
						<option value="date">날짜</option>
					</select> <input type="text" class="" id="search" name="search"> <input
						type="submit" value="검색" class="btn btn-default"
						id='boardSearchBtn'>
						<input type="button" class="btn btn-default" onClick='location.href="./boardregister"' id='write' value="글쓰기">
			</td>

		</tr>

		<!-- 레코드가 없으면 -->
		<c:if test="${listcount == 0 }">
			<tr>
				<td style="text-align: center" colspan='4'>
					<font size=2><h4>등록된 글이 없습니다.</h4></font>
				</td>
			</tr>
			<tr>
			<td colspan="5" style="text-align: right"><a
				href="./boardregister">[글쓰기]</a></td>
			</tr>
		</c:if>

		
	</table>
	</form>
</body>
</html>
