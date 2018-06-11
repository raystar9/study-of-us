<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = 1>
	<tr>
		<th colspan = 2>게시판 view 페이지</th>
	</tr>
	
	<tr>
		<td>글쓴이</td>
		<td>${boardView.m_id }</td>
	</tr>
	
	<tr>
		<td>제목</td>
		<td>${boardView.subject }</td>
	</tr>	
	
	
	<tr>
		<td>내용</td>
		<td>${boardView.content }</td>
	</tr>	
	
	<tr>
		<td>파일</td>
		<c:if test="${!empty boardView.file }">
		<td>
		<a href="/study-of-us/fileDown?filename=${boardView.file}">
						${boardView.file }</a>
		</td>
		</c:if>
	
	</tr>
</table>
	
	
	<form id = insert_form action = /study-of-us/comment action="post">
	<table>
		 <tr>
			<td colspan="2"><textarea id="comment" name="comment"></textarea>&nbsp;&nbsp;<input type="submit" value="입력"></td>
		</tr>
	</table>
	</form>
	
	
	
	<c:forEach var="comment" items="${commentGet}">
	<span id="output">
		${comment.m_id}
		${comment.content}
		${comment.date}<br>
	</span>
	</c:forEach>  
	
		
		
</body>
</html>