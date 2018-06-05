<!-- 스터디 안의 스터디 정보 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    	
<!DOCTYPE html>
<html lang="en">

<head>
</head>

<body>
	
	<table border='1'>
	<c:set var="m" value="${memlist}" />
	<c:set var="s" value="${setup}" />
		<tr>
			<td>
				<h1 class="page-header">설정</h1>
			</td>
		</tr>
		<tr>
			<td><h4>*스터디 명</h4>
				<hr>
				<div class="panel-body">${s.name}</div>
			</td>
		</tr>
		<tr>
			<td><h4>*카테고리 (대분류/소분류)</h4>
				<hr>
				<div class="panel-body">
				<select>
					<option value="프로그래밍" selected>프로그래밍</option>
					<option value="영어">영어</option>
					<option value="국어">국어</option>
				</select>
				<select>
					<option value="JAVA" selected>JAVA</option>
					<option value="토익">토익</option>
					<option value="독후감">독후감</option>
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
				<hr> <input type="text" class="form-control"
				 id="date_text" readOnly value='${s.startDate }'>&nbsp; ~
				&nbsp; <input type="text" class="form-control"
				 id="date_text" readOnly value='${s.endDate }'>
			</td>
		</tr>
		<tr>
			<td><h4>*현재인원 / 최대인원</h4>
				<hr> 
				<input type="text" class="form-control" value='${membercount }' readOnly>명/
				<input type="text" class="form-control" value='${s.peopleNum }' readOnly>명
			</td>
		</tr>
		<tr>
			<td><h4>*활동시간</h4>
				<hr> <input type="text" class="form-control" value='${s.activityTime }' readOnly>시간
			</td>
		</tr>
		<tr>
			<td><h4>*요일</h4>
				<hr> <input type="text" class="form-control" value='${s.day }' readOnly>요일
			</td>
		</tr>
		<tr>
			<td><h4>*프로젝트 개요</h4>
				<hr>
				${s.explain }</td>
		</tr>
		<tr>
			<td><h4>*주요 교재 및 준비물</h4>
				<hr> ${s.prepared }</td>
		</tr>
		<tr>
			<td><h4>*기대효과 및 활동 분야</h4>
				<hr> ${s.effective }</td>
		</tr>
		<tr>
			<td><h4>*스터디 지역</h4>
				<hr> ${s.place } </td>
		</tr>
		<tr>
			<td><input type="button" id='withdraw-btn' value='탈퇴하기'></td>
		</tr>
	</table>
</body>

</html>
