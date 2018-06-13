<!-- 스터디 안의 게시판 페이지에서 글을 클릭하고 수정하기 버튼을 누른 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>스터디 안의 게시판 페이지에서 글을 클릭하고 수정하기 버튼을 누른 페이지</title>

<!-- Bootstrap Core CSS -->
<link href="/study-of-us/vendor/bootstrap/css/bootstrap.css"
	rel="stylesheet">
</head>
<body>
	<c:set var='id' value="${sessionScope.id}" />
	<form action='./modify' method='post' class='boardModify'>
		<c:set var="b" value="${boardcontent}" />
		<input type="hidden" name="num" value="${b.index}" id='bno'>

	<table id='viewtable'>
		<tr class="center" style="border-bottom: 1px solid #ccc; height: 20px;" id='tdfooter'>
			<td colspan="2" id='td_top'></td>
		</tr>

		<tr style="border-bottom: 1px solid #ccc" >
			<td style="background: #cccccc38; padding-left: 5px; height: 30px;" width='12%'>제목</td>
			<td style="padding-left: 10px;"><input name="boardSubject" id="board-subject" type="text"
					size="50" maxlength="100" value="${b.title }"></td>
		</tr>

		<tr style="border-bottom: 1px solid #ccc">
			<td width='10%'
				style="background: #cccccc38; padding-left: 5px; height: 30px;">글쓴이</td>
			<td style="padding-left: 10px;"><div id="board-name">${b.name}</div></td>
		</tr>


		<tr style="border-bottom: 1px solid #ccc">
			<td style="background: #cccccc38; padding-left: 5px;">내용</td>
			<td style="padding-left: 10px;"><textarea name="boardContent" id="board-content" cols="67"
						rows="15"><c:out value="${b.content }" /></textarea></td>
		</tr>

		<tr style="border-bottom: 1px solid #ccc">
			<td style="background: #cccccc38; padding-left: 5px; height: 30px;">날짜</td>
			<td style="padding-left: 10px;"><input name="boardDate" id="board-date" type="hidden"
					size="10" maxlength="30" value="${b.date}"><div>${b.date}</div></td>
		</tr>
		<tr style="border-bottom: 1px solid #ccc">
			<td style="background: #cccccc38; padding-left: 5px; height: 35px;"><div>첨부파일</div></td>
			<c:if test="${!empty b.filename }">
				<td style="padding-left: 10px;">&nbsp;${b.filename }</td>
			</c:if>
		</tr>
		<tr style="border-bottom: 1px solid #ccc" id='trbtn'>
				<td colspan="2" class="center" id='tdfooter'>&nbsp; 
				<input type="button" class="btn btn-default" type="button" name="modifyBtn" value="등록" id='modifyBtn'>
				<input type="button" class="btn btn-default" type="button" name="cancelBtn" value="취소" id='cancelBtn' onClick="history.go(-1);">
				</td>
			</tr>
	</table>
	</form>
</body>
</html>
