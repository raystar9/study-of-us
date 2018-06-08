<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
     String id = (String)request.getAttribute("id");
 
%>  
<form action="LoginPage" method="get">
<div class="idresult">
			아이디는 ${id }입니다.
</div>
<div class="submit">
	<input type="submit" value="로그인" id="submit">
</div>
</form>