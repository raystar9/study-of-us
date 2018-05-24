<!-- 스터디 안의 게시판 페이지에서 글을 클릭했을 때 상세보기 되는 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>스터디 안의 게시판 페이지에서 글을 클릭했을 때 상세보기 되는 페이지</title>
</head>
<body>
	<c:set var='id' value="${sessionScope.id}" />
	<table border="1">
		<tr class="center">
			<th colspan="2">스터디 안의 게시판 페이지에서 글을 클릭했을 때 상세보기 되는 페이지</th>
		</tr>

		<c:set var="b" value="${boarddata}" />
		<tr>
			<td>글쓴이</td>
			<td><c:out value="${b.BOARD_NAME}" /></td>
		</tr>

		<tr>
			<td>제목</td>
			<td><c:out value="${b.BOARD_SUBJECT }" /></td>
		</tr>

		<tr>
			<td>내용</td>
			<td><c:out value="${b.BOARD_CONTENT }" /></td>
		</tr>

		<tr>
			<td>날짜</td>
			<td><c:out value="${b.BOARD_DATE}" /></td>
		</tr>

		<tr>
			<td colspan="2" class="center"><a
				href="./BoardReplyView.bo?num=${b.BOARD_NUM}">답변</a> &nbsp;&nbsp; <c:if
					test="${b.BOARD_NAME == id || id == 'admin' }">
					<a href="./BoardModifyView.bo?num=${b.BOARD_NUM}">수정</a>
				&nbsp;&nbsp;
			
			<a href="./BoardDelete.bo?num=${b.BOARD_NUM}">삭제</a>
				&nbsp;&nbsp;
			</c:if> <a href="BoardList.bo">뒤로</a></td>
		</tr>
	</table>

</body>
</html>
