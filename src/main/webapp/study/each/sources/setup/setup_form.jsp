<!-- 스터디 안의 스터디 정보 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    		
<!DOCTYPE html>
<html lang="en">

<head>
<link rel="stylesheet" type="text/css" href="css/setup.css">
<style>
	#categorySub , categoryGroup{width:100px;}
</style>
</head>
<body>
<form action="./setup" method="post" class='setupForm'>
	<c:set var="set" value="${setup}" />
	<input type='hidden' id='studyIndex' value='${set.index}'>
	<input type='hidden' id='category1' value='${set.category1}'>
	<input type='hidden' id='category2' value='${set.category2}'>
		<table border='1'>
		<tr>
			<td>
				<h1 class="page-header">설정</h1>
			</td>
		</tr>
		<tr>
			<td><h4>*스터디 명</h4>
				<hr>
				<div class="panel-body"><input type="text" class="form-control" name='studyName' value="${set.name }"></div>
			</td>
		</tr>
		<tr>
			<td><h4>*카테고리 (대분류/소분류)</h4>
				<hr>
				<div class="panel-body">
				<select name='categoryGroup' id='categoryGroup' onchange="chageCategory()" >
				<c:forEach var="item" items="${mainCategory }">
					<option value="${item }">${item }</option>
				</c:forEach>
				</select>
				<select name='categorySub' id='categorySub'>
				<c:forEach var="item" items="${subCategory }">
					<option value="${item }">${item }</option>
				</c:forEach>
				</select>
					
				</div>
			</td>
		</tr>
		<tr>
			<td><h4>*스터디 원</h4>
				<hr>
				<table class="table table-striped table-bordered table-hover"
					border='1'>
					<thead>
						<tr>
							<th>이름</th>
							<th>전화번호</th>
							<th>이메일</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="memlist" items="${memlist }">
					 <tr>
					 	<td>${memlist.name }</td>
					 	<td>${memlist.phone }</td>
					 	<td>${memlist.email }</td>
					 </tr>
					</c:forEach>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td><h4>*기간</h4>
				<hr> <input type="text" name='startDate' class="form-control"
				 id="date_text" value='${set.startDate }'>&nbsp; ~
				&nbsp; <input type="text" name='endDate' class="form-control"
				 id="date_text" value='${set.endDate }'>
			</td>
		</tr>
		<tr>
			<td><h4>*현재인원 / 최대인원</h4>
				<hr> 
				<input type="text" name='memberCount' class="form-control" value='${membercount }' readOnly>명/
				<input type="text" name='peopleNum' class="form-control" value='${set.peopleNum }'>명
			</td>
		</tr>
		<tr>
			<td><h4>*활동시간</h4>
				<hr> <input type="text" name='time' class="form-control" value='${set.activityTime }'>시간
			</td>
		</tr>
		<tr>
			<td><h4>*요일</h4>
				<hr> <input type="text" name='day' class="form-control" value='${set.day }'>요일
			</td>
		</tr>
		<tr>
			<td><h4>*스터디 지역</h4>
				<hr> <input type="text" name='place' class="form-control" value='${set.place }'></td>
		</tr>
		<tr>
			<td><h4>*프로젝트 개요</h4>
				<hr>
				<textarea rows="7" cols="100" name='explain'>${set.explain}</textarea></td>
		</tr>
		<tr>
			<td><h4>*주요 교재 및 준비물</h4>
				<hr> <textarea rows="7" cols="100" name='prepared'>${set.prepared }</textarea></td>
		</tr>
		<tr>
			<td><h4>*기대효과 및 활동 분야</h4>
				<hr><textarea rows="7" cols="100" name='effective'>${set.effective}</textarea></td>
		</tr>
		<tr>
			<td>
				<input type="button" class="btn btn-default" id="submittbtn" value="수정">
				<input type="reset" class="btn btn-default" id="btn" value="초기화">
				<input type="button" class="btn btn-default" id="btn" value="취소" onClick="history.go(-1);">
			</td>
		</tr>
	</table>
</form>
</body>

</html>
