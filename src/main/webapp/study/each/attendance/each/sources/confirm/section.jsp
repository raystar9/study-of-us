<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="attend-main">
	<form action="confirm" method="post">
	<c:forEach var="name" items="${names}" varStatus="loop">
		<div class="attend-container attend-article">
			<%@ include file = "article.jsp"%>
		</div>
	</c:forEach>
	<input type="submit" value="전송" />
	</form>
</div>