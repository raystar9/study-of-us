<!-- 스터디 안의 스터디 정보 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    	
<!DOCTYPE html>
<html lang="en">

<head>
<link rel="stylesheet" type="text/css" href="css/inform.css">
</head>

<body>
	<table border='1'>
	<c:set var="m" value="${memlist}" />
		<tr>
			<td>
				<h1 class="page-header"></h1>
			</td>
		</tr>
		<tr>
			<td><h4>*스터디 명</h4>
				<hr>
				<div class="panel-body"><c:out value="${}" /></div>
			</td>
		</tr>
		<tr>
			<td><h4>*스터디 원</h4>
				<hr>
				<table class="table table-striped table-bordered table-hover"
					border='1'>
					<thead>
						<tr>
							<th>#</th>
							<th>이름</th>
							<th>전화번호</th>
							<th>이메일</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>이다혜</td>
							<td>010-2350-3059</td>
							<td>dahye950627@naver.com</td>
						</tr>
						<tr>
							<td>2</td>
							<td>소문혁</td>
							<td>010-0000-0000</td>
							<td>smh@naver.com</td>
						</tr>
						<tr>
							<td>3</td>
							<td>노동완</td>
							<td>010-0000-0000</td>
							<td>ndw@naver.com</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td><h4>*기간</h4>
				<hr> <input type="text" class="form-control"
				placeholder="2018/05/18" id="date_text" readOnly>&nbsp; ~
				&nbsp; <input type="text" class="form-control"
				placeholder="2018/08/10" id="date_text" readOnly>
			</td>
		</tr>
		<tr>
			<td><h4>*현재인원 / 최대인원</h4>
				<hr> 
				<input type="text" class="form-control" value="6" readOnly>명/
				<input type="text" class="form-control" value="10" readOnly>명
			</td>
		</tr>
		<tr>
			<td><h4>*활동시간</h4>
				<hr> <input type="text" class="form-control" value="3" readOnly>시간
			</td>
		</tr>
		<tr>
			<td><h4>*요일</h4>
				<hr> <input type="text" class="form-control" value="수" readOnly>요일
			</td>
		</tr>
		<tr>
			<td><h4>*프로젝트 개요</h4>
				<hr>
				우리 프로젝트는 자바와 JSP를 배우는 스터디로서 ~</td>
		</tr>
		<tr>
			<td><h4>*주요 교재 및 준비물</h4>
				<hr> 주요 교재 및 준비물로는~</td>
		</tr>
		<tr>
			<td><h4>*기대효과 및 활동 분야</h4>
				<hr> 우리 프로젝트는 자바와 JSP를 배우는 스터디로서 ~</td>
		</tr>
		<tr>
			<td><h4>*스터디 지역</h4>
				<hr> 우리 프로젝트는 자바와 JSP를 배우는 스터디로서 ~</td>
		</tr>
		<tr>
			<td><input type="button" id='withdraw-btn' value='탈퇴하기'></td>
		</tr>
	</table>
</body>

</html>
