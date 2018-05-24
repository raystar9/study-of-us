<!-- 스터디 안의 회비관리 페이지 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<style>
.input-group.custom-search-form {
	width: 200px;
}

.panel-heading {
	height: 50px;
}

.input-group.custom-search-form {
	float: right;
	height: 20px;
}

#top_total {
	text-align: right;
	width: 200px;
	display: inline-block;
}

.big-table{
	width:600px;
	height:300px;
}
</style>

</head>

<body>
	<form action="#" method="get">
		<div class="row">
			<div class="col-lg-12">
				&nbsp;&nbsp;
				<h1 class="page-header">회비 관리</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<table border='1' class='big-table'>
			<tr height="10%">
				<td>

					<div class="panel-heading" id="top_head">
						*회비: <input type="text" class="form-control" id="top_total"
							placeholder="120,000" readOnly>&nbsp;원
						<button type="button" class="btn btn-default" id="fee-add-btn">추가</button>
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
	</form>

</body>

</html>
