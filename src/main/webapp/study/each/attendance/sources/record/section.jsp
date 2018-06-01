<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<div class="attend-record-content">날짜가 들어갈 공간</div>
<c:forEach var="member" items="${members}">
<%@ include file="article.jsp" %>
</c:forEach>
<a href="confirm">출석체크하기</a><br>
<a href="/study-of-us/study/each/schedule?type=attend">다른 날짜 확인</a>