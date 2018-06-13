<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<td class ="attend-table-border">
	<div class="attend-name"><b>${name }</b></div>
</td>
<td class ="attend-table-border">
	<div class="attend-button-space radio">
		<label class = "radio-inline"><input type="radio" name="member${loop.index}" value="a" />출석</label>
		<label class = "radio-inline"><input type="radio" name="member${loop.index}" value="na" />결석</label>
	</div>
</td>