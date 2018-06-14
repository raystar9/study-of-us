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
<c:forEach var="attendance" items="${attendances}">
<%@ include file="article.jsp" %>
</c:forEach>
<tr><td colspan=2>
<a href="confirm">출석체크하기</a><br>
<a href="../../schedule?type=attend">다른 날짜 확인</a>
</td></tr>
</tbody>
</table>
