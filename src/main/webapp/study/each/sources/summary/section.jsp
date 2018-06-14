<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>우리를 위한 스터디 SOUP!</title>
<style>

.type11{
    margin-left: 20%;  
}
table.type10 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;
    border-top: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
    margin: 20px 10px;
}
table.type10 thead th {
    width: 70px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #fff;
    background: #e7708d;
    margin: 20px 10px;
}
table.type10 tbody th {
    width: 30%	;
    padding: 10px;
    
        background-color: #f1f1f1;
}
table.type10 td {
    width: 70%;
    padding: 10px;
    vertical-align: top;
     background-color: #f1f1f18a
}
table.type10 .even {
    background: #fdf3f5;
}

input[type=submit] {
    width: 80%;
    }
</style>
</head>
<body>
<form action="/study-of-us/study/each/participate" method="post">
<hr>
	<h1 align=center>${study[0].name }</h1>
<hr>
<div class="type11">
<table class=type10>
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
<th>모집인원</th>
<td>${study[0].maxmember } 명</td>
</tr>

<tr>
<th>활동시간</th>
<td>${study[0].time} </td>
</tr>

<tr>
<th>요일</th>
<td>${study[0].day }</td>
</tr>



<tr>
<th>스터디 지역 </th>
<td>${study[0].place }</td>
</tr>
</table>
<input type="hidden" name="s_index" value=${study[0].index }>
<input type="hidden" name="m_index" value=${index }>
<input type="hidden" name="s_m_index" value=${study[0].s_m_index }>
<input type="hidden" name="s_name" value="${study[0].name }">

</div>
</form>
</body>
</html>