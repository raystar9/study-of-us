<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <script src = "http://code.jquery.com/jquery-3.3.1.js"></script>
     
     <script>
     	$(document).ready(function(){
     		$("a").each(function(){
     			$(this).click(function(){
     				$ajax()
     				
     			})
     		})
     	})
     </script>
     <%@ taglib prefix="c"
 				uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="project">
		<c:forEach var="study" items="${studies }">
		<div class="projectcontainer">
		
  			<img src="/study-of-us/resources/images/open-book.png" alt="Avatar" style="width:90px">
 			 <H3>스터디 : ${study.name }</H3>
  			<p>목표 : ${study.goal } </p>
  			 <span>스터디 기간 : ${study.term }</span>
		</div>
		</c:forEach>
		<div class="paging"  style="text-align:center; margin-bottom:100px">
		<c:if test="${startpage > 1}">
			<a href="/study-of-us/study/SearchList?page=1">처음</a>
		</c:if>
		
		<c:if test="${page > 1}">
			<a href="/study-of-us/study/SearchList?page=${page-1 }">이전</a>
		</c:if>
		
		<c:forEach var="i" begin= "${startpage }" end="${endpage }">
			<a href="/study-of-us/study/SearchList?page=${i }">${i }</a>
		</c:forEach>
		
		<c:if test="${page < totalpage}">
			<a href="/study-of-us/study/SearchList?page=${page+1 }">다음</a>
		</c:if>
		
		<c:if test="${endpage < totalpage}">
			<a href="/study-of-us/study/SearchList?page=${totalpage }">끝</a>
		</c:if>
		</div>
	</div>