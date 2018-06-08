<!-- 스터디 안의 회비관리 페이지에서 추가버튼 클릭했을 때 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html lang="en">

<head>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" type="text/css" href="/study-of-us/study/each/fee/sources/cash-view/css/cash_view.css">
<title>회비 등록 페이지</title>

</head>
<c:set var='c' value="${cash}" />
<c:set var='ex' value="${expense}" />
<c:set var='m' value="${mem}" />
<body>
	<div>
		<!-- /.row -->
		<table border='1'>
			<tr>
				<td>
					<div class="row">
						<div class="col-lg-12">
							<h1 class="page-header">회비 상세보기</h1>
						</div>
						<!-- /.col-lg-12 -->
					</div>
				</td>
			</tr>
			
			<tr>
				<td>
					<div class="calendar">
						<div>
							<label>*날짜</label><input type="date" id="dues-date"
								name="duesDate" value="${c.date }" readOnly>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-group">
						<label>*회비</label>
						<div class="panel panel-default" id="cash">
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dues-table" border='1'>
										<thead>
											<tr>
												<th>#</th>
												<th>이름</th>
												<th>금액</th>
												<th>비고</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="mem" items="${mem }" varStatus="status">
											<tr>
												<td>${status.count}</td>
												<td><div>${mem.name}</div></td>
												<td><div>${mem.memfee}</div></td>
												<td><div>${mem.note}</div></td>
											</tr>
										</c:forEach>
										</tbody>
									</table>
								</div>
								<!-- /.table-responsive -->
							</div>
							<!-- /.panel-body -->
						</div>
						<!-- /.panel -->
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-group">
						<label>*지출 내역</label>
						<div class="panel panel-default" id="cash">
							<div class="panel-body">
								<table class="table table-striped table-bordered table-hover"
									id="total-table" border='1'>
									<thead>
										<tr>
											<th>내역</th>
											<th>금액</th>
										</tr>
									</thead>
									<tbody id='cash_tbody'>
									<c:forEach var="expense" items="${expense }" varStatus="status">
											<tr>
												<td>${status.count}</td>
												<td><div>${expense.content}</div></td>
												<td><div>${expense.expense}</div></td>
											</tr>
									</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-group">
						<label>*총계</label>
						<div class="panel panel-default" id="cash">
							<div class="panel-body">
								<input type="text" class="total" id="dues-totalFee"
									name="duesTotalFee" readOnly value='${c.memfeetotal }'>&nbsp;원 &nbsp;-&nbsp; <input
									type="text" class="total" id="dues-totalExpen"
									name="duesTotalExpen" readOnly value='${c.expensetotal }'>&nbsp;원 &nbsp;=&nbsp; 
									<c:set var='total' value="${c.memfeetotal }-${c.expensetotal }" />
									<input
									type="text" class="total" id="dues-total" name="duesTotal"
									readOnly value='${total }'>&nbsp;원
								
							</div>
						</div>
					</div> <br>
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-group">
						<label>*총 남은 금액</label>
						<div class="panel panel-default" id="cash">
							<div class="panel-body">
								<div>
									<c:set var='allTotal' value="${c.alltotal }+${total }" />
									<input type="text" class="total" id="dues-final"
										name="duesfinal" placeholder="0" readOnly value='${allTotal}'>&nbsp;원
								</div>
							</div>
						</div>
					</div> <br>
				</td>
			</tr>
			<tr>
				<td>
					<a href="/study-of-us/study/each/cash">뒤로</a>
				</td>
					
			</tr>
		</table>
	</div>
</body>

</html>
