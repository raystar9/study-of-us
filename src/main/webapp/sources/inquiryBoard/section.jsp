<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>문의사항 게시판</title>
</head>
<body>
	
	
	<table>
		
		<c:if test="${inquirycount > 0}">
			<tr>
				<th colspan = "3"> 문의사항 게시판 list</th>
				<th colspan = "2">
					<font size=2>글 개수 : ${inquirycount }</font>
				</th>
			</tr>
			<tr>
		<th width="8%"><div>번호</div></th>
		<th  width="50%"><div >제목</div></th>
		<th width="14%"><div >작성자</div></th>
		<th  width="17%"><div >날짜</div></th>
			</tr>
	
			<c:set var="num" value="${inquirycount-(page-1)*10 }"/>
			<c:forEach var="list" items="${inquiryList }">
		<tr>
		<td>
			  <c:out value="${num}"/>
			 <c:set var="num" value="${num-1 }"/> 
			 
			 <%-- ${list.rnum } --%>
		</td>
		<td>
			 <a href="/study-of-us/inquiryView?num=${list.i_index}">
			 			${ list.subject}</a>
		</td>
		<td>
			 ${list.m_id} 
		</td>
		<td>
			 ${list.date }
		</td>
		
		</tr>
		
			</c:forEach>
		
		<!--  페이징 처리 -->
		<tr class="h30 lime center btn">
		<td colspan=5>			
			<c:if test="${page <= 1 }">
				이전&nbsp;
			</c:if>
			<c:if test="${page > 1 }">			
				 <a href="/study-of-us/inquiryPage?page=${page-1}">이전</a>&nbsp;
			</c:if>
					
			<c:forEach var="a" begin="${startpage}" end="${endpage}">
				<c:if test="${a == page }">
					${a}
				</c:if>
				<c:if test="${a != page }">
					<a href="/study-of-us/inquiryPage?page=${a}">${a}</a>
				</c:if>
			</c:forEach>
			
			<c:if test="${page >= maxpage }">
				&nbsp;다음 
			</c:if>
			<c:if test="${page < maxpage }">
				<a href="/study-of-us/inquiryPage?page=${page+1}">&nbsp;다음</a>
			</c:if>
		</td>
	</tr>
		</c:if>
		
		
		<tr>
			<td colspan = "5" style="text-align : right"><a 
			href ="/study-of-us/boardWriteView">[글쓰기]</a></td>
		</tr>
	</table>
	
	

	
</body>
</html>