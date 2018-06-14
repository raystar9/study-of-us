<!-- 스터디 안의 게시판 페이지에서 글을 클릭했을 때 상세보기 되는 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>스터디 안의 게시판 페이지에서 글을 클릭했을 때 상세보기 되는 페이지</title>

<!-- Bootstrap Core CSS -->
<link href="/study-of-us/vendor/bootstrap/css/bootstrap.css"
	rel="stylesheet">
</head>
<body>
	<c:set var="b" value="${boardcontent}" />
	<input type="hidden" name="commentcount" value="${commentcount}"
		id="commentcount" />
	<c:set var='id' value="${b.name}" />
	<!-- "${sessionScope.id}" 바꿀꺼임 -->

	<table id='viewtable'>
		<tr class="center" style="border-bottom: 1px solid #ccc; height: 20px;" id='tdfooter'>
			<td colspan="2" id='td_top'></td>
		</tr>

		<tr style="border-bottom: 1px solid #ccc" >
			<td style="background: #cccccc38; padding-left: 5px; height: 35px; width:70px;" >제목</td>
			<td style="padding-left: 10px;"><c:out value="${b.title }" /></td>
		</tr>

		<tr style="border-bottom: 1px solid #ccc">
			<td width='10%'
				style="background: #cccccc38; padding-left: 5px; height: 35px;">글쓴이</td>
			<td style="padding-left: 10px;"><c:out value="${b.name}" /></td>
		</tr>


		<tr style="border-bottom: 1px solid #ccc">
			<td style="background: #cccccc38; padding-left: 5px;">내용</td>
			<td style="padding-left: 10px;"><textarea cols="70" rows="15"
					readOnly><c:out value="${b.content }" /></textarea></td>
		</tr>

		<tr style="border-bottom: 1px solid #ccc">
			<td style="background: #cccccc38; padding-left: 5px; height: 35px;">날짜</td>
			<td style="padding-left: 10px;"><c:out value="${b.date}" /></td>
		</tr>
		<tr style="border-bottom: 1px solid #ccc">
			<td style="background: #cccccc38; padding-left: 5px; height: 35px;"><div>첨부파일</div></td>
			<c:if test="${!empty b.filename }">
				<td style="padding-left: 10px;"><img src="image/down.png"
					width="10px"> <a
					href="./boardfiledown?filename=${b.filename }"> ${b.filename }
				</a></td>
			</c:if>
		</tr>
		<tr style="border-bottom: 1px solid #ccc" id='trbtn'>
			<td colspan='2' id='tdfooter'><c:if
					test="${b.name == id || id == 'admin' }">
					<a href="./modify?num=${b.index}">수정</a>&nbsp;&nbsp;
							<a href="#" class='boarddelete'>삭제</a>&nbsp;&nbsp;
						</c:if> <a href="#" class='back'>뒤로</a></td>
		</tr>
	</table>

	<br>

	<input type="button" class="btn btn-default" type="button"
		id="commentListBtn" value=''>
	<div class="container" id='commentContainer'>
		<label for="content">comment</label>
		<form name="commentInsertForm">
			<div class="input-group">
				<input type="hidden" name="bno" value="${b.index}" id="bno" /> <input
					type="text" class="form-control" id="content" name="content"
					placeholder="내용을 입력하세요."> <span class="input-group-btn">
					<input type="button" class="btn btn-default" type="button"
					name="commentInsertBtn" value="등록" id='commentInsertBtn'>
				</span>
			</div>
		</form>
	</div>
	<br>

	<div class="container">
		<div class="commentList"></div>
	</div>
</body>
</html>
