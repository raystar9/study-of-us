<!-- 스터디 안의 회비관리 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" type="text/css" href="/study-of-us/study/each/fee/sources/cash-list/css/cash_list.css">
</head>

<body>
	<!-- "${sessionScope.id}" 바꿀꺼임 -->
	<c:set var='id' value="${b.name}" />
	<div>
		<table border='1' class='big-table'>
			<tr>
				<th>
					<div class="row">
						<div class="col-lg-12">
							&nbsp;&nbsp;
							<h1 class="page-header">회비 관리</h1>
						</div>
						<!-- /.col-lg-12 -->
					</div>
				</th>
				<th><font size=2>글개수 : ${listcount }</font></th>
			</tr>
			<tr height="10%">
				<td colspan='2'>
					<div class="panel-heading" id="top_head">
						*회비: <input type="text" class="form-control" id="top-total"
							value="" readOnly>&nbsp;원
					</div>
				</td>
			</tr>
			<tr>
				<td colspan='2'>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-striped" border='1' width="100%">
								<thead>
									<tr>
										<th width="8%"><div>번호</div></th>
										<th width="17%"><div>날짜</div></th>
									</tr>
								</thead>
								<tbody>
									<c:set var="num" value="${listcount-(page-1)*10 }" />
									<c:forEach var="c" items="${cashlist}">
										<tr>
											<td align="center"><c:out value="${num }"></c:out> <c:set var="num"
													value="${num-1}" /></td>
											<td><a href="./fee/${c.meetingIndex}">${c.date}</a></td>
										</tr>
									</c:forEach>
									<tr class="h30 lime center btn">
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
											<td style="test-align: right"><font size=2>등록된 회비가 없습니다.
													</font></td>
										</tr>
									</c:if>

									<tr>
										<c:if test="${b.name == id || id == 'admin' }">
											<td colspan="5" style="text-align: right"><a href="./schedule?type=attend">[회비등록]</a></td>
										</c:if>
									</tr>
								</tbody>

							</table>
						</div>
						<!-- /.table-responsive -->
					</div>
				</td>
			</tr>

		</table>
	</div>
</body>
</html>
