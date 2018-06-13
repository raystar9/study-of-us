<!-- 스터디 안의 게시판 리스트 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="/study-of-us/study/each/board/sources/board-list/css/board_list.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>스터디 안의 게시판 리스트 페이지</title>
</head>
<body>

	<!-- 게시판 리스트 -->
	<form action='./board' method='get' class='boardlistform'>
		<table class="table table-striped" id="boardtable">
			<!-- 레코드가 있으면 -->
			<tr id='table_title'>
				<th width="5%" id="numTitle"><div>
						<strong>번호</strong>
					</div></th>
				<th width="50%"><div>제목</div></th>
				<th width="14%"><div>작성자</div></th>
				<th width="17%" colspan='3'><div>날짜</div></th>
			</tr>
			<c:set var="num" value="${listcount-(page-1)*10 }" />
			<c:forEach var="b" items="${boardlist}">
				<tr>
					<td align="center"><c:out value="${num }"></c:out> <c:set
							var="num" value="${num-1}" /></td>
					<td>
						<div>
							&nbsp; ▶ <a href="./board/view?num=${b.index}"> ${b.title} </a>
							<c:if test='${!empty b.filename }'>
								<img src='/study-of-us/study/each/board/sources/board-list/file.png' width='11px'
									height='11px'>
							</c:if>
						</div>
					</td>
					<td>
						<div>${b.name}</div>
					</td>
					<td colspan='4'>
						<div>${b.date}</div>
					</td>
				</tr>
			</c:forEach>
			<!-- 레코드가 없으면 -->
			<c:if test="${listcount == 0 }">
				<tr><td></td></tr>
				<tr>
					<td style="text-align: center" colspan='7'><font size=2><h5>등록된
								글이 없습니다.</h5></font></td>
				</tr>
				<tr>
					<td></td>
			</c:if>

			<tr id="number">
				<td colspan="7"><c:if test="${page <= 1 }">
      		이전&nbsp;&nbsp;
      		</c:if> <c:if test="${page > 1 }">
						<a
							href="./board?searchSelect=${searchSelect }&search=${search }&page=${page-1}">이전</a>&nbsp;
      		</c:if> <c:forEach var="a" begin="${startpage }" end="${endpage }">
						<c:if test="${a == page}">
      				${a}
      			</c:if>
						<c:if test="${a != page }">
							<a
								href="./board?searchSelect=${searchSelect }&search=${search }&page=${a}">${a}</a>
						</c:if>
					</c:forEach> <c:if test="${page >= maxpage}">
      			&nbsp;&nbsp;다음
      		</c:if> <c:if test="${page < maxpage }">
						<a href="./board?page=${page+1}">&nbsp;다음</a>
					</c:if></td>
			<tr>
				<td colspan="7"><select name="searchSelect" id='searchSelect'>
						<option value="title" selected="selected">제목</option>
						<option value="name">작성자</option>
						<option value="date">날짜</option>
				</select> <input type="text" class="" id="search" name="search"> <input
					type="submit" value="검색" class="btn btn-default"
					id='boardSearchBtn'> <input type="button"
					class="btn btn-default" onClick='location.href="./board/register"'
					id='write' value="글쓰기"></td>
			</tr>
		</table>
	</form>
</body>
</html>
