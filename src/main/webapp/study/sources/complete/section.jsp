<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix = "c"
				uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	$(document).ready(function(){
	
	var timer = setTimeout(function(){
		$('.bar-5').css('background-color','#0276ff3b')
	},100)
	
	var timer = setTimeout(function(){
		$('.bar-5').css('background-color','#0276ff8a')
	},200)
	
	var timer = setTimeout(function(){
		$('.bar-5').css('background-color','#0276ffbf')
	},300)
	
	var timer = setTimeout(function(){
		$('.bar-5').css('background-color','#0276ff')
	},400)
})		

</script>



<c:choose>
<c:when test="${studycount == 0}">
<div class="StudyList">
	<span class="heading">아직 생성된 스터디가 없습니다</span>
	<hr style="border:1px solid #d6d5d536;">
	<a href="/study-of-us/study/registration">스터디 생성하러가기</a>/<a href=/study-of-us/study/serach>스터디 참가하러가기</a>
</div>	
</c:when>

<c:otherwise>

<c:forEach var="list" items="${studyList}" varStatus="status">


<div class="StudyList">
<span class="heading">${list.s_name} </span> <span class="dayday">기간 ${list.start} ~  ${list.end}</span>
	<hr style="border:1px solid #d6d5d536;">
<div class="people">${list.s_maxmember}명</div><br>
<div class="row">
  <div class="side">
    <div>스터디 진행현황</div>
  </div>
  <div class="middle">
    <div class="bar-container">
    
  <c:choose>
    <c:when test="${list.progress > 100 }">
    <div class="bar-5" style="width:100%" ></div>
    </c:when>
    <c:otherwise>
    <div class="bar-5" style="width: ${list.progress}%"></div>
    </c:otherwise>
    </c:choose>



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
	<a href="/study-of-us/study/complete?page=${page-1 }">이전</a>&nbsp;
</c:if>

<!--  a 에다 start값  end값  을 집어넣는다 -->
<c:forEach var="a" begin="${startpage }" end="${endpage}">
	<c:if test="${a==page }">
	${a}
	</c:if>
	<c:if test="${a != page }">
		<a href="/study-of-us/study/complete?page=${a}">${a}</a>&nbsp;
	</c:if>
</c:forEach>
<!--  숫자 누르면 가는곳 -->
<c:if test="${page >= maxpage}">
	&nbsp;다음 <a href="/study-of-us/study/list">현재목록</a>
</c:if>
<c:if test="${page < maxpage }">
	<a href="/study-of-us/study/list?page=${page+1 }">다음</a>&nbsp;<a href="/study-of-us/study/list">현재목록</a>
</c:if>
</div>




</c:otherwise>
</c:choose>



