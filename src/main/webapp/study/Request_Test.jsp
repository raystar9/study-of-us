<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<% request.setCharacterEncoding("UTF-8"); %>
<body>
<h3> 테스트 페이지 </h3>
<p> 대분류 값은 : ${param.firstArray }</p>

<p> 소분류 값은 : ${param.secondArray } </p>

<p> 검색어 : ${param.searchVal } </p>

<p> 체크사항1 : ${param.check1 } </p>


</body>
</html>