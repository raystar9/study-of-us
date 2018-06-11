<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
	<c:forEach var="comment" items="${commentGet}">
	<span>
		${comment.m_id}
		${comment.content}
		${comment.date}<br>
	</span>
	</c:forEach>  
</body>