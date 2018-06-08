<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="attend-article-each">
<div class="attend-name attend-container">${name }</div> 
<div class="attend-button-space"><input type="radio" name="${loop.index}" value="a" />출석<input type="radio" name="member${loop.index}" value="na" />결석</div>
</div>