<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src = "http://code.jquery.com/jquery-3.3.1.js"></script> 
<title>우리를 위한 스터디 SOUP!</title>
</head>
<body>
	<%
	int index = Integer.parseInt(request.getParameter("m_index"));
	int sindex = Integer.parseInt(request.getParameter("s_index"));
	%>
	<h3><%=index %></h3>
		<h3><%=sindex %></h3>
	

</body>
</html>