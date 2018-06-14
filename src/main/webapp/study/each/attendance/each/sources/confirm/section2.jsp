<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="attend-main">
	<form action="confirm" method="post">
<table class="table attend-table">
	<tbody>
	<tr>
		<td colspan=2><div class="attend-title"><h1><i class="fa fa-calendar-check-o"></i> 출석체크하기</h1></div></td>
	</tr>
	<tr>
		<td class ="attend-table-border">
			<div class="attend-name"><b>구명회</b></div>
		</td>
		<td class ="attend-table-border">
			<div class="attend-button-space radio">
				<label class = "radio-inline"><input type="radio" name="member1" value="a" />출석</label>
				<label class = "radio-inline"><input type="radio" name="member1" value="na" />결석</label>
			</div>
		</td>
	</tr>
	<tr>
		<td class ="attend-table-border attend-article-each">
			<div class="attend-name">2</div>
		</td>
		<td class ="attend-table-border">
			<div class="attend-button-space radio">
				<label class = "radio-inline"><input type="radio" name="member2" value="a" />출석</label>
				<label class = "radio-inline"><input type="radio" name="member2" value="na" />결석</label>
			</div>
		</td>
	</tr>
	<tr>
		<td class ="attend-table-border attend-article-each">
			<div class="attend-name">3</div>
		</td>
		<td class ="attend-table-border">
			<div class="attend-button-space radio">
				<label class = "radio-inline"><input type="radio" name="member3" value="a" />출석</label>
				<label class = "radio-inline"><input type="radio" name="member3" value="na" />결석</label>
			</div>
		</td>
	</tr>
	<tr><td class="attend-table-border attend-submit-space" colspan=2>
	<input class ="btn btn-default" type="submit" value="전송" />
	</td></tr>
	</tbody>
	</table>
	</form>
</div>