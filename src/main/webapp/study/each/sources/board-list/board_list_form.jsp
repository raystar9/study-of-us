<!-- 스터디 안의 게시판 리스트 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>스터디 안의 게시판 리스트 페이지</title>
</head>
<body>
	<!-- 게시판 리스트 -->
	<form action='./board' method='get'>
	<table border='1'>
		<!-- 레코드가 있으면 -->
		<tr>
			<th colspan="3">스터디 안의 게시판 리스트 페이지</th>
			<th colspan="2"><font size=2>글개수 : ${listcount }</font></th>
		</tr>
		<tr>
			<th width="5%"><div>번호</div></th>
			<th width="50%"><div>제목</div></th>
			<th width="14%"><div>작성자</div></th>
			<th width="17%"><div>날짜</div></th>
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
					<td>
						<div>${b.date}</div>
					</td>
				</tr>
			</c:forEach>

			<tr > 
				<td colspan="5"><c:if test="${page <= 1 }">
      		이전&nbsp;
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
      			&nbsp;다음
      		</c:if> <c:if test="${page < maxpage }">
						<a href="./board?page=${page+1}">&nbsp;다음</a>
					</c:if></td>
		<tr>
			<td colspan="5">
					<select name="searchSelect">
						<option value="title" selected="selected">제목</option>
						<option value="name">작성자</option>
						<option value="date">날짜</option>
					</select> <input type="text" class="" id="search" name="search"> <input
						type="submit" value="검색"
						id='boardSearchBtn'>
			</td>
		</tr>

		<!-- 레코드가 없으면 -->
		<c:if test="${listcount == 0 }">
			<tr>
				<td colspan="4">MVC 게시판</td>
				<td style="test-align: right"><font size=2>등록된 글이 없습니다.</font>
				</td>
			</tr>
		</c:if>

		<tr>
			<td colspan="5" style="text-align: right"><a
				href="./boardregister">[글쓰기]</a></td>
		</tr>
	</table>
	</form>
</body>
</html>
