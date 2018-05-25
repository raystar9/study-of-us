<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="attend-main">
	<c:forEach var="member" items="${members}">
		<div class="attend-container attend-article">
			<%@ include file = "article.jsp"%>
		</div>
	</c:forEach>
</div>