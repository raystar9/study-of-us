<!-- 해당 스터디 안에 들어왔을 때 처음으로 보이는 공지사항 페이지 -->
<!-- 스터디 안의 게시판 리스트 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class='notice-main'>
<%--TODO 임시링크임. 수정 필요 --%>
	<div class="notice-body">
	<div class='notice-title'><h1><i class="fa fa-bullhorn"></i>&nbsp;공지사항</h1></div><div class='notice-more'><a href="../schedule">돌아가기</a>
</div>
<div class="signup">
	<div class='well well-sm'>장소 : ${meeting.place }</div>
	<div class='well well-sm'>시간 : ${time}</div>
	<div class='well well-sm'>회비 : ${meeting.expectedFee }</div>
	<div class='notice-map-container'><span id='map'></span></div>
	<div class='well well-sm'>코멘트 : ${meeting.comment }</div>
</div>
</div>
</div>