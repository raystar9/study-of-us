<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="attend-article-each">
<div class="attend-name attend-container">${member.name }</div> 
<div class="attend-button-space"><input type="radio" name="${member.index}" value="a" />출석<input type="radio" name="${member.index}" value="na" />결석</div>
</div>