<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>우리를 위한 스터디 SOUP!</title>

</head>
<body>
		
		<form action="/study-of-us/boardWrite" method="post"
	enctype="multipart/form-data" name="boardform">
		<table>
			<tr class="center">
				<th colspan=2>게시판 write 페이지</th>
			</tr>

			<tr>
				<td><div>글쓴이</div></td>
				<td><input type="text" name="id" id="board_name" readOnly
					value="${id}"></td>
			<tr>
				<td><div>제목</div></td>
				<td><input type="text" name="subject" id="board_subject"
					value=""></td>
			</tr>


			<tr>
				<td><div>내 용</div></td>
				<td><input type="text" id="board_content" name="content"
					value=""></td>
			</tr>

			<tr>
				<td><div>파일 첨부</div></td>
				<td><input type="file" id="upfile" name="file"
					value="attach.png"></td>
			</tr>


			<tr class="center">
				<td colspan="2" class="h30 lime"><input type=submit value="등록">
					<input type=reset value="최소">
			</tr>
		</table>
	</form>
</body>
</html>