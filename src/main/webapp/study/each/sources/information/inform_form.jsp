<!-- 스터디 안의 스터디 정보 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="/study-of-us/study/each/sources/information/css/inform.css">
<link href="/study-of-us/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/study-of-us/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
<link href="/study-of-us/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>

<body>
	<table id='inform_table'>
		<c:set var="set" value="${setup}" />
		<tr>
			<td id='title_h1'>
				<h1 ><i class="fa fa-bookmark  ">&nbsp;</i>정보 <input type="button" class="btn btn-default" type="button"
				name="modifyBtn" value="탈퇴하기" id='withdraw-btn'></h1><br>
			</td>
		</tr>
		<tr>
			<td id='td_title' style="padding-left:10px;"><i class="fa fa-mortar-board"></i>&nbsp;<strong>스터디 명</strong></td>
		</tr>
		<tr>
			<td id='shortText'>${set.name}</td>
		</tr>
		<tr>
			<td id='td_title' style="padding-left:10px;"><i class="fa fa-check-circle"></i>&nbsp;<strong>카테고리 (대분류/소분류)</strong></td>
		</tr>
		<tr>
			<td id='shortText'>${set.category1 }&nbsp;/&nbsp;${set.category2 }</td>
		</tr>
		<tr>
			<td id='td_title' style="padding-left:10px;"><i class="fa fa-user"></i>&nbsp;<strong>스터디 원</strong></td>
		</tr>
		<tr>
			<td>
			<table class="table table-striped table-bordered table-hover"
					border='1'>
					<thead>
						<tr>
							<td id='member'><strong>이름</strong></td>
							<td id='member'><strong>전화번호</strong></td>
							<td id='member'><strong>이메일</strong></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="memlist" items="${memlist }">
							<tr>
								<td id='tr_mem'>${memlist.name }</td>
								<td id='tr_mem'>${memlist.phone }</td>
								<td id='tr_mem'>${memlist.email }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</td>
		</tr>
		<tr>
			<td id='td_title' style="padding-left:10px;"><i class="fa fa-calendar"></i>&nbsp;<strong>기간</strong></td>
		</tr>
		<tr>
			<td id='shortText'><span>${set.startDate }</span>&nbsp; ~ &nbsp;<span>${set.endDate }</span></td>
		</tr>
		<tr>
			<td id='td_title' style="padding-left:10px;"><i class="fa fa-group"></i>&nbsp;<strong>현재인원 / 최대인원</strong></td>
		</tr>
		<tr>
			<td id='shortText'><span>${membercount }</span>&nbsp;명&nbsp;&nbsp;/ <span>${set.peopleNum }</span>&nbsp;명</td>
		</tr>
		<tr> 
			<td id='td_title' style="padding-left:10px;"><i class="fa fa-lightbulb-o"></i>&nbsp;<strong>활동시간</strong></td>
		</tr>
		<tr>
			<td id='shortText'><span>${set.activityTime }</span></td>
		</tr>
		<tr>
			<td id='td_title' style="padding-left:10px;"><i class="fa fa-bell"></i>&nbsp;<strong>요일</strong></td>
		</tr>
		<tr>
			<td id='shortText'><span>${set.day }</span></td>
		</tr>
		<tr>
			<td id='td_title' style="padding-left:10px;"><i class="fa fa-pencil"></i>&nbsp;<strong>프로젝트 개요</strong></td>
		</tr>
		<tr>
			<td id='longText'>${set.explain }</td>
		</tr>
		<tr>
			<td id='td_title' style="padding-left:10px;"><i class="fa fa-pencil"></i>&nbsp;<strong>주요 교재 및 준비물</strong></td>
		</tr>
		<tr>
			<td id='longText'>${set.prepared }</td>
		</tr>
		<tr>
			<td id='td_title' style="padding-left:10px;"><i class="fa fa-pencil"></i>&nbsp;<strong>기대효과 및 활동 분야</strong></td>
		</tr>
		<tr>
			<td id='longText'>${set.effective }</td>
		</tr>
		<tr>
			<td id='td_title' style="padding-left:10px;"><i class="fa fa-crosshairs"></i>&nbsp;<strong>스터디 지역</strong></td>
		</tr>
		<tr>
			<td id='longText'>${set.place }</td>
		</tr>
	</table>
</body>

</html>
