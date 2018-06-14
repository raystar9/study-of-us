<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
     String pw = (String)request.getAttribute("pw");
 
%>  
<form action="loginForm.jsp" method="get">
<div class="pwresult">
			비밀번호는 ${pw }입니다.
</div>
<div class="submit">
	<input type="submit" value="로그인" id="submit">
</div>
</form>