<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	

</script>

</head>
<body>
<form action="/study-of-us/study/Studylist" method="get">
<hr>
	<h1 align=center>${study[0].name }</h1>
<hr>
<div>
<table>
<tr>
<th>스터디 기간</th>
<td>${study[0].start } - ${study[0].end }</td>
</tr>
<tr>
<th>스터디 종류</th>
<td>${study[0].s_c_id }</td>
</tr>

<tr>
<th>스터디 개요</th>
<td>${study[0].explain }</td>
</tr>

<tr>
<th>스터디 기대 및 효과</th>
<td>${study[0].effect }</td>
</tr>
<tr>
<th>교재 및 준비물</th>
<td>${study[0].material }</td>
</tr>
<tr>

<tr>
<th colspan=2>모집인원<input type=text value="${study[0].maxmember }"> 활동시간<input type=text value="${study[0].time}"> 요일<input type=text value="${study[0].day }"></th>
</tr>
<tr>
<th>스터디 지역 </th>
<td>${study[0].place }</td>
</tr>
</table>
<input type="hidden" name="s_index" value=${study[0].index }>
<input type="hidden" name="m_index" value=${index }>
	<input type=submit value='스터디 참여하기'>
</div>
</form>
</body>
</html>