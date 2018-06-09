<!-- 스터디 안의 게시판 글 등록 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<c:set var='id' value="${sessionScope.id}" />
	<form action="./boardregister" method="post" name="boardform" enctype="multipart/form-data" class="boardform">
		<table border="1">
			<tr class="center">
				<th colspan="4">글쓰기 - write</th>
			</tr>
			<tr>
				<td>
					<div>글쓴이</div>
				</td>
				<td>
					<input type="text" name="boardName" id="board-name" size="10" maxlength="30">
					<%-- value="${id}"하고 readOnly로 바꿀것임 --%>
				</td>
				
			</tr>
			<tr>
				<td><div>제 목</div></td>
	
						<td colspan='3'><input name="boardSubject" id="board-subject" type="text"
					size="50" maxlength="100" value=""></td>
			</tr>
			<tr>
				<td><div>내 용</div></td>
				<td colspan='3'><textarea name="boardContent" id="board-content" cols="67"
						rows="15"></textarea></td>
			</tr>
			<tr>
				<td><div>파일 첨부</div></td>
				<td>
				 <input type="file" id="upfile" name="filename" value="파일추가">
				</td>
			</tr>
			<tr class="center">
				<td colspan="3" class="h30 lime">
				<input type="button" class="btn btn-default" id="submittbtn" value="등록">
				<input type=button value="취소" onClick="history.go(-1);"></td>
			</tr>
		</table>
	</form>

</body>
</html>