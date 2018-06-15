<!-- 스터디 안의 회비관리 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/study-of-us/study/each/fee/sources/cash-list/css/cash_list.css">
<link rel="stylesheet" type="text/css"
	href="/study-of-us/vendor/bootstrap/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
					<div id="top_head">
						*회비: <input type="text" class="form-control" id="top-total"
							value="" readOnly style='height:28px'>&nbsp;원
					</div>
	<div>
		<table class="table table-striped" id="cashtable">
			<tr id='table_title'>
				<th width="8%"><div>번호</div></th>
				<th width="17%"><div>날짜</div></th>
			</tr>
			<tbody>
				<c:set var="num" value="${listcount-(page-1)*10 }" />
				<c:forEach var="c" items="${cashlist}">
					<tr>
						<td align="center"><c:out value="${num }"></c:out> <c:set
								var="num" value="${num-1}" /></td>
						<td><a href="./fee/${c.meetingIndex}">${c.date}</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan='5'><c:if test="${page <= 1 }">
      									이전&nbsp;
      									</c:if> <c:if test="${page > 1 }">
							<a href="./cash?page=${page-1}">이전</a>&nbsp;
      									</c:if> <c:forEach var="a" begin="${startpage }"
							end="${endpage }">
							<c:if test="${a == page}">
      									${a}
      								</c:if>
							<c:if test="${a != page }">
								<a href="./cash?page=${a}">${a}</a>
							</c:if>
						</c:forEach> <c:if test="${page >= maxpage}">
      								&nbsp;다음
      							</c:if> <c:if test="${page < maxpage }">
							<a href="./cash?page=${page+1}">&nbsp;다음</a>
						</c:if></td>
				</tr>

				<!-- 레코드가 없으면 -->
				<c:if test="${listcount == 0 }">
					<tr>
						<td style="test-align: right"><font size=2>등록된 회비가
								없습니다. </font></td>
					</tr>
				</c:if>

				<tr>
					<td colspan="5" style="text-align: right"><a
						href="./schedule?type=fee">[회비등록]</a></td>
				</tr>
			</tbody>

		</table>
	</div>
	<!-- /.table-responsive -->
	</td>
	</tr>

	</table>
	</div>
</body>
</html>
