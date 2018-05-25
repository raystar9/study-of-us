<!-- 스터디 안의 게시판 글 등록 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form action="#" method="post" name="boardform">
		<table border="1">
			<tr class="center">
				<th colspan="4">글쓰기 - write</th>
			</tr>
			<tr>
				<td>
					<div>글쓴이</div>
				</td>
				<td>
					<input type="text" name="boardName" id="board-name" readOnly size="10" maxlength="30" value="${id}">
				</td>
				<td>
					<div>작성일</div> 
				</td>
				<td>
					<input name="boardDate" id="board-date" readOnly type="text" size="10" maxlength="30" value="2018-05-24"> 
					<!-- value="${date}"해서 작성일 가져올 것 --> 
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
			<tr class="center">
				<td colspan="3" class="h30 lime"><input type=submit value="등록" onClick="location.href='./boardview'">
					<input type=button value="취소" onClick="location.href='./board'"></td>
			</tr>
		</table>
	</form>

</body>
</html>