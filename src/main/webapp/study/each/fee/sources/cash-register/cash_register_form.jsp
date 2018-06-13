<!-- 스터디 안의 회비관리 페이지에서 추가버튼 클릭했을 때 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<link rel="stylesheet" type="text/css" href="/study-of-us/study/each/fee/sources/cash-register/css/cash_register.css">
<title>회비 등록 페이지</title>
</head>

<body>
	<form action="./register" method="post" class="cashRegisterForm">

		<table border='1'>
			<tr>
				<td>
					<div class="row">
						<div class="col-lg-12">
							<h1 class="page-header">회비관리</h1>
						</div>
						<!-- /.col-lg-12 -->
					</div> <!-- /.row -->
				</td>
			</tr>
			<tr>
				<td>
					<div class="calendar">
						<div>
							<label>*날짜</label><input type="date" id="dues-date"
								name="duesDate" value="" readOnly><!-- 선택한 날짜로 자동으로 채워지게 해야 함 -->
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
											<c:forEach var="name" items="${names }" varStatus="status">
												<tr>
													
													<td>${status.count}</td>
													<td>
														${name }
														<input type='hidden' value='${memIndex }' name='memIndex${status.count}'>
													</td>
													<td><input type='text' class='form-control' placeholder='금액' id='duesFee${status.count}' name='duesFee${status.count}' onkeyup='calculate();'></td>
													<td><input type='text' class='form-control' placeholder='비고' id='duesNote${status.count}' name='duesNote${status.count}'></td>
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
											<th>금액<input type="hidden" id='expenseCount' name='expenseCount' value='1'></th>
										</tr>
									</thead>
									<tbody id='cash_tbody'>
										<tr>
											<td>
											<input type="text" class="form-control"
												placeholder="내역" id='duesExp1' name='duesExp1'></td>
											<td><input type="text" class="form-control"
												placeholder="금액" id='duesExpFee1' name='duesExpFee1'
												onkeyup="calculate();"></td>
										</tr>
									</tbody>
								</table>
								<input type="button" class="btn btn-default" value="추가"
									id="cashAdd-btn">
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
									name="duesTotalFee">&nbsp;원 &nbsp;-&nbsp; <input
									type="text" class="total" id="dues-totalExpen"
									name="duesTotalExpen">&nbsp;원 &nbsp;=&nbsp; <input
									type="text" class="total" id="dues-total" name="duesTotal">&nbsp;원
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
									<input type="text" class="total" id="dues-final"
										name="duesfinal" placeholder="0">&nbsp;원
								</div>
							</div>
						</div>
					</div> <br>
				</td>
			</tr>
			<tr>
				<td><input type="button" class="btn btn-default" id="btn"
					value="취소" onclick="location.href='/study-of-us/study/each/cash';"> <input
					type="button" class="btn btn-default" id="submittbtn" value="등록"></td>
			</tr>
		</table>
	</form>

</body>

</html>
