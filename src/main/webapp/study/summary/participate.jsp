<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

table {
	 margin : 0 auto;
	width : 100%;
    border-collapse: separate;
    border-spacing: 1px;
    line-height: 70px;
    border-top: 1px solid #ccc;
  	/* margin : 20px 10px; */
}
table th {
    width: 40%;
	height : 70px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
}
table td {
    width: 100%;
	height : 70px;
	float : left;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
}

input[type=text] {
    width: 20%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}
</style>
</head>
<body>
<hr>
	<h1 align=center>스터디 명</h1>
<hr>
<div>
<table>
<tr>
<th>스터디 기간</th>
<td>스터디 기간</td>
</tr>
<tr>
<th>스터디 종류</th>
<td>스터디 종류</td>
</tr>
<tr>
<th>스터디 목표</th>
<td>스터디 목표</td>
</tr>
<tr>
<th>교재 및 준비물</th>
<td>교재 및 준비물</td>
</tr>
<tr>
<th>스터디 기대효과</th>
<td>스터디 기대효과</td>
</tr>

<tr>
<th>스터디 목표</th>
<td>스터디 목표</td>
</tr>

<tr>
<th colspan=2>모집인원<input type=text> 활동시간<input type=text> 요일<input type=text></th>
</tr>

<tr>
<th>스터디 개요</th>
<td>스터디 개요</td>
</tr>

<tr>
<th>교재 및 준비물</th>
<td>교재 및 준비물</td>
</tr>

<tr>
<th>스터디 기대효과</th>
<td>스터디 기대효과</td>
</tr>

<tr>
<th>스터디 목표</th>
<td>스터디 목표</td>
</tr>

<tr>
<th>스터디 지역</th>
<td>스터디 지역</td>
</tr>
</table>
	<input type=submit value=스터디 참여하기>
</div>
</body>
</html>