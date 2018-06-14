<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<table class="table attend-table">
<tbody>
	<tr>
		<th colspan=2>
			<div class="attend-title"><h1><i class="fa fa-list"></i> 출석 확인</h1></div>
		</th>
	</tr>
	<tr><td colspan=2>
		<div class="attend-time-container"><input type="date" id="dues-date" readonly></div>
	</td></tr>
	<c:if test='${attendances == null}'>
		<tr><td colspan=2>
			검색 결과가 없습니다.
		</td></tr>
	</c:if>
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
	<tr>
		<td><div><b>노동완</b></div></td>
		<td><div>na</div></td>
	</tr>
<tr><td colspan=2>
<a href="confirm">출석체크하기</a><br>
<a href="../../schedule?type=attend">다른 날짜 확인</a>
</td></tr>
</tbody>
</table>