<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class='new-schedule-main'>
<form action="new" method="post">
<div class='new-schedule-title-container new-schedule-container'>
<%--TODO 임시링크임. 수정 필요 --%>
<div class='new-schedule-title'>스케쥴 등록하기</div></div>
<div class='new-schedule-text-container1 new-schedule-container'>장소 : <input type="text" name="location" id="location" /></div>
<div class='new-schedule-text-container1 new-schedule-container'>시간 : <input type="text" name="date" id="date" class="datepicker" />
<input type="text" name="time" id="time" class="timepicker"/></div>
<div class='new-schedule-text-container1 new-schedule-container'>회비 : <input type="number" name="fee" id="fee" /></div>
<div class='new-schedule-map-container new-schedule-container'>지도 api가 들어갈 자리</div>
<div class='new-schedule-text-container2 new-schedule-container'>코멘트 : <textarea name="comment" id="comment" cols="30" rows="10" ></textarea></div>
<input type="submit" value="전송" />
</form>
</div>