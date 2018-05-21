<!-- 스터디 안의 회비관리 페이지에서 회비 목록을 클릭해서 자세히 볼때 페이지 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<style>
.btn btn-default {
	float: right;
}

#cash {
	width: 600px;
}

#cash2 {
	width: 700px;
}

#cash3 {
	float: right;
}

#total {
	width: 150px;
	display: inline;
	height: 34px;
	padding: 6px 12px;
	font-size: 14px;
	line-height: 1.42857143;
	color: #555;
	background-color: #fff;
	background-image: none;
	border: 1px solid #ccc;
	border-radius: 4px;
	text-align: right;
}

#btn {
	float: right;
}
</style>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>회비 등록 페이지에서 상세보기 페이지</title>

<!-- Bootstrap Core CSS -->
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="../vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
</head>

<body>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">회비관리</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default" id="cash2">
						<div class="panel-heading"></div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-6">
									<div class="form-group">
										<label>*제목</label> <input class="form-control" value="05/19 회비목록" readOnly>
									</div>
									<div class="calendar">
										<div>
											<label>*날짜</label><br> <input type="date" id="userdate"
												name="userdate" value="2015-10-10" readOnly>
										</div>
										<br>
									</div>
									<div class="form-group">
										<label>*회비</label>
										<div class="panel panel-default" id="cash">
											<!-- /.panel-heading -->
											<div class="panel-body">
												<div class="table-responsive">
													<table
														class="table table-striped table-bordered table-hover">
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
																	placeholder="이름" readOnly></td>
																<td><input type="text" class="form-control"
																	placeholder="금액" readOnly></td>
																<td><input type="text" class="form-control"
																	placeholder="비고" readOnly></td>
															</tr>
															<tr>
																<td><input type="text" class="form-control"
																	placeholder="이름" readOnly></td>
																<td><input type="text" class="form-control"
																	placeholder="금액" readOnly></td>
																<td><input type="text" class="form-control"s
																	placeholder="비고" readOnly></td>
															</tr>
															<tr>
																<td><input type="text" class="form-control"
																	placeholder="이름" readOnly></td>
																<td><input type="text" class="form-control"
																	placeholder="금액" readOnly></td>
																<td><input type="text" class="form-control"
																	placeholder="비고" readOnly></td>
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
									<div class="form-group">
										<label>*지출 내역</label>
										<div class="panel panel-default" id="cash">
											<div class="panel-body">
												<table
													class="table table-striped table-bordered table-hover">
													<thead>
														<tr>
															<th>내역</th>
															<th>금액</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td><input type="text" class="form-control"
																placeholder="내역" readOnly></td>
															<td><input type="text" class="form-control"
																placeholder="금액" readOnly></td>
														</tr>
														<tr>
															<td><input type="text" class="form-control"
																placeholder="내역" readOnly></td>
															<td><input type="text" class="form-control"
																placeholder="금액" readOnly></td>
														</tr>
														<tr>
															<td><input type="text" class="form-control"
																placeholder="내역" readOnly></td>
															<td><input type="text" class="form-control"
																placeholder="금액" readOnly></td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label>*총계</label>
										<div class="panel panel-default" id="cash">
											<div class="panel-body">
												<input type="text" id="total" placeholder="0" readOnly>&nbsp;원
												&nbsp;-&nbsp; <input type="text" id="total" placeholder="0" readOnly>&nbsp;원
												&nbsp;=&nbsp; <input type="text" id="total" placeholder="0" readOnly>&nbsp;원
											</div>
										</div>
									</div>
									<div class="form-group">
										<label>*총 남은 금액</label>
										<div class="panel panel-default" id="cash">
											<div class="panel-body">
												<div>
													<input type="text" id="total" placeholder="0" readOnly>&nbsp;원
												</div>
											</div>
										</div>
									</div>

									<input type="button" class="btn btn-default" id="btn" value="삭제">
									<input type="button" class="btn btn-default" id="btn" value="목록">
								</div>
								<!-- /.col-lg-6 (nested) -->
								<div class="col-lg-6"></div>
								<!-- /.col-lg-6 (nested) -->
							</div>
							<!-- /.row (nested) -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->
	<!-- jQuery -->
	<script src="../vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="../vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="../dist/js/sb-admin-2.js"></script>

</body>

</html>
