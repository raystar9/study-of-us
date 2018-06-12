<!-- 해당 스터디 안에 들어왔을 때 처음으로 보이는 공지사항 페이지 -->
<!-- 스터디 안의 게시판 리스트 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class='notice-main'>
<div class='notice-title-container notice-container'>
<%--TODO 임시링크임. 수정 필요 --%>
	<div class='notice-title'>공지사항</div><div class='notice-more'><a href="../schedule">돌아가기</a>
	</div></div>
<div class='notice-text-container1 notice-container'>장소 : ${meeting.place }</div>
<div class='notice-text-container1 notice-container'>시간 : ${time}</div>
<div class='notice-text-container1 notice-container'>회비 : ${meeting.expectedFee }</div>
<div class='notice-map-container notice-container'>지도 api가 들어갈 자리</div>
<div class='notice-text-container2 notice-container'>코멘트 : ${meeting.comment }</div>
</div>