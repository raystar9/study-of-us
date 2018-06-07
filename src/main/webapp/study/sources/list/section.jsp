<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix = "c"
				uri="http://java.sun.com/jsp/jstl/core" %>


<c:choose>
<c:when test="${studycount == 0}">
<div class="StudyList">
	<span class="heading">아직 생성된 스터디가 없습니다</span>
	<hr style="border:3px olid #f1f1f1">
	<a href="/study-of-us/study/each/Registration">스터디 생성하러가기</a>/<a href=#>스터디 참가하러가기</a>
</div>	
</c:when>

<c:otherwise>

<c:forEach var="list" items="${studyList}" varStatus="status">


<div class="StudyList">
<span class="heading">${list.s_name} </span> <span class="dayday">기간 ${list.start} ~  ${list.end} </span>
<hr style="border:3px solid #f1f1f1">
<div class="people">${list.s_peoplenum}명</div><br>
<div class="row">
  <div class="side">
    <div>스터디 진행현황</div>
  </div>
  <div class="middle">
    <div class="bar-container">
    
  
    <div class="bar-5" style="width: ${list.progress}%" title="스터디 종료일까지  ${day[status.index].dday+1} 일 남았습니다"></div>
    </div>
  </div>
  <div class="side right">
  
  
  <c:choose>
     <c:when test="${list.progress > 100}">
    <div>100% </div>
    </c:when>
    <c:otherwise>
       <div>${list.progress}%</div>
       </c:otherwise>
       </c:choose>
    <br>
    
    <a href="#">내스터디</a>
  </div>
</div>
</div>
</c:forEach>

<!-- 페이지가 1보다 같거나 작으면 "이전"에 a태그 없이 표시함 -->
<div class= "page">
<c:if test="${page <= 1}">
	이전&nbsp;
</c:if>
<!-- 페이지가 1보다 크면 "이전"에 a태그 값을주어표시함 -->
<c:if test="${page > 1 }">
	<a href="/study-of-us/study/list?page=${page-1 }">이전</a>&nbsp;
</c:if>

<!--  a 에다 start값  end값  을 집어넣는다 -->
<c:forEach var="a" begin="${startpage }" end="${endpage}">
	<c:if test="${a==page }">
	${a}
	</c:if>
	<c:if test="${a != page }">
		<a href="/study-of-us/study/list?page=${a}">${a}</a>&nbsp;
	</c:if>
</c:forEach>
<!--  숫자 누르면 가는곳 -->
<c:if test="${page >= maxpage}">
	&nbsp;다음 <a href="/study-of-us/study/complete">완료목록</a>
</c:if>
<c:if test="${page < maxpage }">
	<a href="/study-of-us/study/list?page=${page+1 }">다음</a>&nbsp;<a href="/study-of-us/study/complete">완료목록</a>
</c:if>
</div>




</c:otherwise>
</c:choose>



