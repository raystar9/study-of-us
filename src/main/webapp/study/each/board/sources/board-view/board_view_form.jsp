<!-- 스터디 안의 게시판 페이지에서 글을 클릭했을 때 상세보기 되는 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>스터디 안의 게시판 페이지에서 글을 클릭했을 때 상세보기 되는 페이지</title>
<style>
</style>
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
	<div class="col-lg-4">
		<div class="panel panel-primary">
			<div class="panel-heading"></div>
			<div class="panel-body">
				<table border="1">
					<tr class="center">
						<th colspan="2"></th>
					</tr>

					<tr>
						<td width='10%'>글쓴이</td>
						<td><c:out value="${b.name}" /></td>
					</tr>

					<tr>
						<td>제목</td>
						<td><c:out value="${b.title }" /></td>
					</tr>

					<tr>
						<td>내용</td>
						<td><textarea cols="67" rows="15" readOnly><c:out
									value="${b.content }" /></textarea></td>
					</tr>

					<tr>
						<td>날짜</td>
						<td><c:out value="${b.date}" /></td>
					</tr>
					<tr>
						<td><div>첨부파일</div></td>
						<c:if test="${!empty b.filename }">
							<td><img src="image/down.png" width="10px"> <a
								href="./boardfiledown?filename=${b.filename }"> ${b.filename }
							</a></td>
						</c:if>
					</tr>
				</table>
			</div>
			<div class="panel-footer">
				<c:if test="${b.name == id || id == 'admin' }">
					<a href="./boardmodify?num=${b.index}">수정</a>&nbsp;&nbsp;
				<a href="#" class='boarddelete'>삭제</a>&nbsp;&nbsp;
			</c:if>
				<a href="#" class='back'>뒤로</a>
			</div>
		</div>
	</div>


	<br>

	<input type="button" class="btn btn-default" type="button"
		id="commentListBtn" value=''>
	<div class="container">
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
