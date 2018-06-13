<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<tr>
	<td><div><b>${attendance.memberName }</b></div></td>
	<td>
	<c:if test='${attendance.attend.equals("a") }'>
		<div>출석</div>
	</c:if>
	<c:if test='${attendance.attend.equals("na") }'>
		<div>결석</div>
	</c:if>
	</td>
</tr>