<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<style>
.btn btn-default{
	float:right;
}

</style>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>회비관리 페이지</title>

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

	<div id="wrapper">

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
					<div class="panel panel-default">
						<div class="panel-heading"></div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-6">
									<form role="form">
										<div class="form-group">
											<label>제목</label> <input class="form-control">
										</div>
										<div class="form-group">
											<label>회비</label>
											<div class="col-lg-6">
												<div class="panel panel-default">
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
																		<td><input type="text" class="form-control" placeholder="이름"></td>
																		<td><input type="text" class="form-control" placeholder="금액"></td>
																		<td><input type="text" class="form-control" placeholder="비고"></td>
																	</tr>
																	<tr>
																		<td><input type="text" class="form-control" placeholder="이름"></td>
																		<td><input type="text" class="form-control" placeholder="금액"></td>
																		<td><input type="text" class="form-control" placeholder="비고"></td>
																	</tr>
																	<tr>
																		<td><input type="text" class="form-control" placeholder="이름"></td>
																		<td><input type="text" class="form-control" placeholder="금액"></td>
																		<td><input type="text" class="form-control" placeholder="비고"></td>
																	</tr>
																</tbody>
															</table>
														</div>
														<!-- /.table-responsive -->
														 <button type="button" class="btn btn-default">추가</button>
													</div>
													<!-- /.panel-body -->
												</div>
												<!-- /.panel -->
											</div>
										</div>
									
										<button type="submit" class="btn btn-default">Submit
											Button</button>
										<button type="reset" class="btn btn-default">Reset
											Button</button>
									</form>
								</div>
								<!-- /.col-lg-6 (nested) -->
								<div class="col-lg-6">
									<form role="form">
										
									</form>
									
								</div>
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

	</div>
	<!-- /#wrapper -->

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
