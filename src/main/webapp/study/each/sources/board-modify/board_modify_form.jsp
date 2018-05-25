<!-- 스터디 안의 게시판 페이지에서 글을 클릭하고 수정하기 버튼을 누른 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>스터디 안의 게시판 페이지에서 글을 클릭하고 수정하기 버튼을 누른 페이지</title>
</head>
<body>
	<c:set var='id' value="${sessionScope.id}" />
	<form method='#' action='post'>
		<table border="1">
			<tr class="center">
				<th colspan="2">스터디 안의 게시판 페이지에서 글을 클릭했을 때 상세보기 되는 페이지</th>
			</tr>

			<c:set var="b" value="${boardcontent}" />
			<tr>
				<td>글쓴이</td>
				<td><input type="text" name="boardName" id="board-name"
					size="10" maxlength="30" value="${b.name}" readOnly></td>
			</tr>

			<tr>
				<td>제목</td>
				<td><input name="boardSubject" id="board-subject" type="text"
					size="50" maxlength="100" value="${b.title }"></td>
			</tr>

			<tr>
				<td>내용</td>
				<td><textarea name="boardContent" id="board-content" cols="67"
						rows="15"><c:out value="${b.content }" /></textarea></td>
			</tr>

			<tr>
				<td>날짜</td>
				<td><input name="boardDate" id="board-date" type="text"
					size="10" maxlength="30" value="${b.date}"></td>
			</tr>

			<tr>
				<td colspan="2" class="center">&nbsp; <a
					href="./study/boardview?num=${b.index}">수정</a>&nbsp;&nbsp; <a
					href="./study/boardview?num=${b.index}">취소</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>