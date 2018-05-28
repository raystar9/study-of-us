<!-- 스터디 안의 회비관리 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" type="text/css" href="css/cash_list.css">
</head>

<body>
	<div>
		<table border='1' class='big-table'>
			<tr>
				<td>
					<div class="row">
						<div class="col-lg-12">
							&nbsp;&nbsp;
							<h1 class="page-header">회비 관리</h1>
						</div>
						<!-- /.col-lg-12 -->
					</div>
				</td>
			</tr>
			<tr height="10%">
				<td>

					<div class="panel-heading" id="top_head">
						*회비: <input type="text" class="form-control" id="top-total"
							placeholder="120,000" readOnly>&nbsp;원
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-striped" border='1' width="100%">
								<thead>
									<tr>
										<th>#</th>
										<th>제목</th>
										<th>글쓴이</th>
										<th>날짜</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td>회비관리</td>
										<td>구명회</td>
										<td>2018/05/17</td>
									</tr>
									<tr>
										<td>2</td>
										<td>회비관리</td>
										<td>구명회</td>
										<td>2018/05/15</td>
									</tr>
									<tr>
										<td>3</td>
										<td>회비관리</td>
										<td>구명회</td>
										<td>2018/05/10</td>
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
