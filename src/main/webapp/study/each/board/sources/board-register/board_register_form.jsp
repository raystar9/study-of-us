<!-- 스터디 안의 게시판 글 등록 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<!-- Bootstrap Core CSS -->
<link href="/study-of-us/vendor/bootstrap/css/bootstrap.css"
	rel="stylesheet">
</head>
<body>
	<c:set var='id' value="${sessionScope.id}" />
	<form action="./boardregister" method="post" name="boardform" enctype="multipart/form-data" class="boardform">
	<table id='viewtable'>
		<tr class="center" style="border-bottom: 1px solid #ccc; height: 20px;" id='tdfooter'>
			<td colspan="2" id='td_top'></td>
		</tr>

		<tr style="border-bottom: 1px solid #ccc" >
			<td style="background: #cccccc38; padding-left: 5px; height: 30px;" width='12%'>제목</td>
			<td style="padding-left: 10px;"><input name="boardSubject" id="board-subject" type="text"
					size="50" maxlength="100" value=""></td>
		</tr>

		<tr style="border-bottom: 1px solid #ccc">
			<td width='10%'
				style="background: #cccccc38; padding-left: 5px; height: 30px;">글쓴이</td>
			<td style="padding-left: 10px;"><input type="text" name="boardName" id="board-name" size="10" maxlength="30">
					<%-- value="${id}"하고 readOnly로 바꿀것임 --%></td>
		</tr>


		<tr style="border-bottom: 1px solid #ccc">
			<td style="background: #cccccc38; padding-left: 5px;">내용</td>
			<td style="padding-left: 10px;"><textarea name="boardContent" id="board-content" cols="67"
						rows="15"></textarea></td>
		</tr>

		<tr style="border-bottom: 1px solid #ccc">
			<td style="background: #cccccc38; padding-left: 5px; height: 35px;"><div>첨부파일</div></td>
			<td style="padding-left: 10px;"><input type="file" id="upfile" name="filename" value="파일추가"></td>
		</tr>
		
		<tr style="border-bottom: 1px solid #ccc" id='trbtn'>
			<td colspan='2' id='tdfooter'>
			<input type="button" class="btn btn-default" id="submittbtn" value="등록">
			<input type=button class="btn btn-default" id="cancelbtn" value="취소" onClick="history.go(-1);"> </td>
		</tr>
	</table>
	</form>
</body>
</html>
