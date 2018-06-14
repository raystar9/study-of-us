<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="attend-main">
	<form action="confirm" method="post">
	<table class="table attend-table">
	<tbody>
	<tr>
		<td colspan=2><div class="attend-title"><h1><i class="fa fa-calendar-check-o"></i> 출석체크하기</h1></div></td>
	</tr>
	<c:if test="${names == null}">
	<tr>
		<td colspan=2> 결과가 없습니다.</td>
	</tr>
	</c:if>
	<c:forEach var="name" items="${names}" varStatus="loop">
		<%@ include file = "article.jsp"%>
	</c:forEach>
	<tr><td class="attend-table-border attend-submit-space" colspan=2>
	<input class ="btn btn-default" type="submit" value="전송" />
	</td></tr>
	</tbody>
	</table>
	</form>
</div>