<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
     String pw = (String)request.getAttribute("pw");
 
%>  
<div class="pwresult">
			비밀번호는 ${pw }입니다.
</div>