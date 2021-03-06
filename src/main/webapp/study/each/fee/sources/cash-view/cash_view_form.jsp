<!-- 스터디 안의 회비관리 페이지에서 추가버튼 클릭했을 때 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<c:set var='c' value="${cash}" />
<c:set var='ex' value="${expense}" />
<c:set var='m' value="${mem}" />
<body>
	<form action="./register" method="post" class="cashRegisterForm">
		<table class='registerTable'>
			<tr>
				<td id="title_h1">
					<div class="row">
						<div class="col-lg-12">
							<h1 class="page-header">
								<i class="fa fa-dollar">&nbsp;</i>회비 내역
							</h1>
						</div>
						<!-- /.col-lg-12 -->
					</div> <!-- /.row -->
				</td>
			</tr>
			<tr>
				<td id='td_title' style="padding-left: 10px;"><i
					class="fa fa-thumb-tack">&nbsp;</i><strong>날짜</strong></td>
			</tr>
			<tr>
				<td id='td_date'><input type="date" id="dues-date"
					name="duesDate" value="${c.date }" readOnly></td>
			</tr>
			<tr>
				<td id='td_title' style="padding-left: 10px;"><i
					class="fa fa-thumb-tack">&nbsp;</i><strong>회비</strong></td>
			</tr>
			<tr>
				<td>
					<div class="panel-body">
						<div class="table-responsive" style="margin-left: 10px;">
							<table class="table table-striped table-bordered table-hover"
								id="dues-table" border='1' style="width: 600px;">
								<thead>
									<tr>
										<th id='th_title' width='10%'>#</th>
										<th id='th_title'>이름</th>
										<th id='th_title'>금액</th>
										<th id='th_title'>비고</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="member" items="${members }" varStatus="status">
										<tr>
											<td>${status.count}</td>
											<td><div>${member.memberName}</div></td>
											<td><div>${member.fee}</div></td>
											<td><div>${member.note}</div></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- /.table-responsive -->
					</div> <!-- /.panel-body -->
				</td>
			</tr>
			<tr>
				<td id='td_title' style="padding-left: 10px;"><i
					class="fa fa-thumb-tack">&nbsp;</i><strong>지출 내역</strong></td>
			</tr>
			<tr>
				<td>
					<div class="panel-body" style="margin-left: 10px;">
						<table class="table table-striped table-bordered table-hover"
							id="total-table" border='1' style="width: 600px;">
							<thead>
								<tr>
									<th id='th_title'>내역</th>
									<th id='th_title'>금액<input type="hidden" id='expenseCount'
										name='expenseCount' value='1'></th>
								</tr>
							</thead>
							<tbody id='cash_tbody'>
								<c:forEach var="expense" items="${expenses }" varStatus="status">
									<tr>
										<td>${status.count}</td>
										<td><div>${expense.comment}</div></td>
										<td><div>${expense.expense}</div></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<td id='td_title' style="padding-left: 10px;"><i
					class="fa fa-thumb-tack">&nbsp;</i><strong>총계</strong></td>
			</tr>
			<tr>
				<td><div id='td_total'>
						<input type="text" class="total" id="dues-totalFee"
							name="duesTotalFee" readOnly value='${collectToday }'>&nbsp;원
						&nbsp;-&nbsp; <input type="text" class="total"
							id="dues-totalExpen" name="duesTotalExpen" readOnly
							value='${spentToday }'>&nbsp;원 &nbsp;=&nbsp;
						<c:set var='total' value="${collectToday - spentToday}" />
						<input type="text" class="total" id="dues-total" name="duesTotal"
							readOnly value='${total }'>&nbsp;원
					</div></td>
			</tr>
			<tr>
				<td id='td_title' style="padding-left: 10px;"><i
					class="fa fa-thumb-tack">&nbsp;</i><strong>총 남은 금액</strong></td>
			</tr>
			<tr>
				<td>
					<div id='td_allTotal'>
						<input type="text" class="total" id="dues-final" name="duesfinal"
							placeholder="0" readOnly value='${remainedFee}'>&nbsp;원
					</div>
					<hr>
				</td>
			</tr>
			<tr>
				<td>
					<div id='td_back'><a href="../fee">뒤로</a></div>
				</td>
			</tr>
		</table>
	</form>

</body>

</html>
