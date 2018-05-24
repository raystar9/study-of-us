<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>해당 스터디 안에 들어왔을 때 </title>
<%
	String pagefile = request.getParameter("page");
	if (pagefile == null) {
		pagefile = "";
	}
%>
</head>
<body>
<%@ include file = "/general-sources/Navigation.jsp" %>
<%@ include file = "left.jsp" %>
<jsp:include page='<%=pagefile + ".jsp"%>' />
<%@ include file = "/general-sources/Footer.jsp" %>
</body>
</html>