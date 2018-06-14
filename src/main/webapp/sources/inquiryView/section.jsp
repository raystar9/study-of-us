<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>우리를 위한 스터디 SOUP!</title>
</head>
<body>

<div class="all">
<table>
	<tr>
		<th colspan = 2 style="text-align : center;" ><h3>게시판 view 페이지</h3></th>
	</tr>
	
	<tr>
		<td width="30%">글쓴이</td>
		<td width="70%">${boardView.m_id }</td>
	</tr>
	
	<tr>
		<td width="30%">제목</td>
		<td width="70%">${boardView.subject }</td>
	</tr>	
	
	
	<tr>
		<td width="30%">내용</td>
		<td width="70%">${boardView.content }</td>
	</tr>	
	
	<tr>
		<td>파일</td>
		
		<c:choose>
		<c:when test="${!empty boardView.file }">
		<td>
		<a href="/study-of-us/fileDown?filename=${boardView.file}">
						${boardView.file }</a>
		</td>
		</c:when>
		<c:otherwise>
		<td> </td>
		</c:otherwise>
		
		</c:choose>
		
		<%-- <c:if test="${!empty boardView.file }">
		<td>
		<a href="/study-of-us/fileDown?filename=${boardView.file}">
						${boardView.file }</a>
		</td>
		</c:if> --%>
	
	</tr>
	
	
	
</table>
	<br><br><br>
	<table class="comment">
	
	</table>	
	
	<br>
	
	<form id = insert_form action = /study-of-us/comment action="post">
	<table class="two">
		 <tr>
			<td colspan="2"><textarea id="comment" name="comment" style="margin: 0px; width:90%; height: 80%;"></textarea>&nbsp;&nbsp;<input type="submit" value="입력"></td>
		</tr>
	</table>
	</form>
	
	
	</div>
	
	
	
	
	
	<!-- <table>
		<tbody class="container"></tbody>
		
	</table> -->
	<!-- <div class="container">
		<div class="commentList"> 
		</div>
	</div> -->
		
		
</body>
</html>