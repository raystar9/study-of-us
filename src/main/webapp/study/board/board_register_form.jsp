<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Insert title here</title>
<link href="css/form.css" rel="stylesheet">
</head>
<body>
<form action = "#" method="post" name="boardform">
<table border="1">
	<tr class="center">
		<th colspan="2">글쓰기 - write</th>
	</tr>
	<tr>
		<td><div>글쓴이</div></td>
		<td>
			<input name="BOARD_NAME" id="board_name" readOnly type="text" size="10" maxlength="30" value="${id}">
		</td>
	</tr>
	<tr>                          
		<td><div>비밀번호</div></td>
		<td>
			<input name="BOARD_PASS" id="board_pass" type="password" 
				   size="10" maxlength="30" value="">
		</td>
	</tr>
	<tr>
		<td><div>제 목</div></td>
		<td>
			<input name="BOARD_SUBJECT" id="board_subject" type="text" size="50" maxlength="100" value="">
		</td>
	</tr>
	<tr>
		<td><div>내 용</div></td>
		<td>
			<textarea name="BOARD_CONTENT" id="board_content" cols="67" rows="15"></textarea>
		</td>
	</tr>
	<tr class="center">
		<td colspan="2" class="h30 lime">
			<input type=submit value="등록">
			<input type=reset value="취소">
		</td>
	</tr>
</table>
</form>

</body>
</html>