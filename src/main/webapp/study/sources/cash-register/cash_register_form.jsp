<!-- 스터디 안의 회비관리 페이지에서 추가버튼 클릭했을 때 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="js/cash_register.js"></script>
<link rel="stylesheet" type="text/css" href="css/cash_register.css">

<title>회비 등록 페이지</title>

</head>

<body>
	<form action="#" method="post">

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
					<div class="form-group">
						<label>*제목</label> <input type="text" id="dues-title"
							name="duesTitle" class="form-control">
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="calendar">
						<div>
							<label>*날짜</label><input type="date" id="dues-date"
								name="duesDate" value="2015-10-10">
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
												<th>이름</th>
												<th>금액</th>
												<th>비고</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><input type="text" class="form-control"
													placeholder="이름" id='dues-mem' name='duesMem'></td>
												<td><input type="text" class="form-control"
													placeholder="금액" id='dues-fee' name='duesFee'
													onkeyup="calculate();"></td>
												<td><input type="text" class="form-control"
													placeholder="비고" id='dues-note' name='duesNote'></td>
											</tr>
											<tr>
												<td><input type="text" class="form-control"
													placeholder="이름" id='dues-mem' name='duesMem'></td>
												<td><input type="text" class="form-control"
													placeholder="금액" id='dues-fee' name='duesFee'
													onkeyup="calculate();"></td>
												<td><input type="text" class="form-control"
													placeholder="비고" id='dues-note' name='duesNote'></td>
											</tr>
											<tr>
												<td><input type="text" class="form-control"
													placeholder="이름" id='dues-mem' name='duesMem'></td>
												<td><input type="text" class="form-control"
													placeholder="금액" id='dues-fee' name='duesFee'
													onkeyup="calculate();"></td>
												<td><input type="text" class="form-control"
													placeholder="비고" id='dues-note' name='duesNote'></td>
											</tr>
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
										<tr>
											<td><input type="text" class="form-control"
												placeholder="내역" id='dues-exp' name='duesExp'></td>
											<td><input type="text" class="form-control"
												placeholder="금액" id='dues-expfee' name='duesExpFee'
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
				<td><input type="reset" class="btn btn-default" id="btn"
					value="취소"> <input type="submit" class="btn btn-default"
					id="btn" value="등록"></td>
			</tr>
		</table>
	</form>

</body>

</html>
