<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class='new-schedule-main'>
<form action="new" method="post" class="form-horizontal" autocomplete="off">
<%--TODO 임시링크임. 수정 필요 --%>
<div class='schedule-body'>
<div class='new-schedule-title'><h1><i class='fa fa-calendar-plus-o'></i>&nbsp;스케줄 등록하기</h1></div></div>
<div class="signup">
	<div class='form-group'>
		<label class='control-label col-sm-2' for='location'>장소 : </label>
		<div class='col-sm-10'>
			<input type="text" class="form-control" name="location" id="location"/>
		</div>
	</div>
	<div class='form-group'>
		<label class='control-label col-sm-2' for='date'>시간 : </label>
		<div class='col-sm-5'>
			<input type="text" name="date" id="date" class="form-control datepicker" />
		</div>
		<div class='col-sm-5'>
			<input type="text" name="time" id="time" class="form-control timepicker"/>
		</div>	
	</div>
	<div class='form-group'>
		<label class='control-label col-sm-2' for='fee'>회비 : </label>
		<div class='col-sm-10'>
			<input type="number" class="form-control" name="fee" id="fee" step="100"/>
		</div>
	</div>
	<div class='new-schedule-map-container'><span id='map'></span></div>
	<div class='form-group'>
		<label class='control-label col-sm-2' for='comment'>코멘트 : </label>
		<div class='col-sm-12'>
			<textarea class='form-control' name="comment" id="comment" rows="10" ></textarea>
		</div>
	</div>
	<input type="submit" class='btn btn-default' value="등록" />
</div>
</form>
</div>