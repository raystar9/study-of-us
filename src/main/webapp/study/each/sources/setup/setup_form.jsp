<!-- 스터디 안의 스터디 정보 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    		
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<style>
	#categorySub , #categoryGroup{width:100px; height:25px;}
</style>
<body>
	<form action="./setup" method="post" class='setupForm'>
	<c:set var="set" value="${setup}" />
	<input type='hidden' id='studyIndex' value='${set.index}'>
	<input type='hidden' id='category1' value='${set.category1}'>
	<input type='hidden' id='category2' value='${set.category2}'>
	<table id='inform_table'>
		<tr>
			<td id='title_h1'>
				<h1 ><i class="fa fa-gear"></i>&nbsp;설정 <input type="button" class="btn btn-default" type="button"
				name="modifyBtn" value="탈퇴하기" id='withdraw-btn'></h1><br>
			</td>
		</tr>
		<tr>
			<td id='td_title'><i class="fa fa-mortar-board"></i>&nbsp;<strong>스터디 명</strong></td>
		</tr>
		<tr>
			<td id='shortText' style=" padding-left:0;"><div class="panel-body"><input type="text" class="form-control" name='studyName' value="${set.name }" style="width:600px;"></div></td>
		</tr>
		<tr>
			<td id='td_title'><i class="fa fa-check-circle"></i>&nbsp;<strong>카테고리 (대분류/소분류)</strong></td>
		</tr>
		<tr>
			<td id='shortText'>
				<select name='categoryGroup' id='categoryGroup' onchange="chageCategory()" >
				<c:forEach var="item" items="${mainCategory }">
					<option value="${item }">${item }</option>
				</c:forEach>
				</select>&nbsp;&nbsp;/&nbsp;
				<select name='categorySub' id='categorySub'>
				<c:forEach var="item" items="${subCategory }">
					<option value="${item }">${item }</option>
				</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td id='td_title'><i class="fa fa-user"></i>&nbsp;<strong>스터디 원</strong></td>
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
			<td id='td_title'><i class="fa fa-calendar"></i>&nbsp;<strong>기간</strong></td>
		</tr>
		<tr>
			<td id='shortText'><input type="text" name='startDate' class="form-control"
				 id="date_text" value='${set.startDate }'>&nbsp; ~
				&nbsp; <input type="text" name='endDate' class="form-control"
				 id="date_text" value='${set.endDate }'></td>
		</tr>
		<tr>
			<td id='td_title'><i class="fa fa-group"></i>&nbsp;<strong>현재인원 / 최대인원</strong></td>
		</tr>
		<tr>
			<td id='shortText'><input type="text" name='memberCount' class="form-control" value='${membercount }' readOnly id='person_num'>명&nbsp;&nbsp;/&nbsp;&nbsp;
				<input type="text" name='peopleNum' class="form-control" value='${set.peopleNum }' id='person_num'>명</td>
		</tr>
		<tr> 
			<td id='td_title'><i class="fa fa-lightbulb-o"></i>&nbsp;<strong>활동시간</strong></td>
		</tr>
		<tr>
			<td id='shortText' class='td_time' ><input type="text" name='time' class="form-control" value='${set.activityTime }' style="text-align: right;"></td>
		</tr>
		<tr>
			<td id='td_title'><i class="fa fa-bell"></i>&nbsp;<strong>요일</strong></td>
		</tr>
		<tr>
			<td id='shortText' class='td_day'><input type="text" name='day' class="form-control" value='${set.day }' style="text-align: right;"></td>
		</tr>
		<tr>
			<td id='td_title'><i class="fa fa-pencil"></i>&nbsp;<strong>프로젝트 개요</strong></td>
		</tr>
		<tr>
			<td id='longText'><textarea rows="7" cols="100" name='explain' style="width:100%; border: 0; resize: none; margin-top:10px;">${set.explain}</textarea></td>
		</tr>
		<tr>
			<td id='td_title'><i class="fa fa-pencil"></i>&nbsp;<strong>주요 교재 및 준비물</strong></td>
		</tr>
		<tr>
			<td id='longText'><textarea rows="7" cols="100" name='prepared' style="width:100%; border: 0; resize: none; margin-top:10px;">${set.prepared }</textarea></td>
		</tr>
		<tr>
			<td id='td_title'><i class="fa fa-pencil"></i>&nbsp;<strong>기대효과 및 활동 분야</strong></td>
		</tr>
		<tr>
			<td id='longText'><textarea rows="7" cols="100" name='effective' style="width:100%; border: 0; resize: none; margin-top:10px;">${set.effective}</textarea></td>
		</tr>
		<tr>
			<td id='td_title'><i class="fa fa-crosshairs"></i>&nbsp;<strong>스터디 지역</strong></td>
		</tr>
		<tr>
			<td id='shortText' style="padding-top:20px;"><input type="text" name='place' class="form-control" value='${set.place }' style="width:600px;margin-left:10px;"><hr><br></td>
		</tr>
		<tr>
			<td id='bottombtn'>
				<input type="button" class="btn btn-default" id="submittbtn" value="수정">&nbsp;
				<input type="reset" class="btn btn-default" id="btn" value="초기화">&nbsp;
				<input type="button" class="btn btn-default" id="btn" value="취소" onClick="history.go(-1);">
			</td>
		</tr>
	</table>
	</form>
</body>

</html>
