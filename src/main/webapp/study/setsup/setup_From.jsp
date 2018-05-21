<!-- 스터디 안의 설정 페이지 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html lang="en">

<head>
<style>
.col-lg-6 {
	width: 600px;
}

.col-lg-4 {
	width: 600px;
}

#date_text {
	width: 150px;
	display: inline;
}
#three_div{
	width: 150px;
	display:inline-block;
}
.form-control{
	text-align:right;
}

</style>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>스터디 설정 페이지</title>

<!-- Bootstrap Core CSS -->
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="../vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="../vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="../dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="../vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

</head>

<body>
	<form action="#" method="get">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">설정</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<div class="col-lg-4">
			<div class="panel panel-default">
				<div class="panel-heading"><p class="fa fa-mortar-board">&nbsp;</p>카테고리</div>
				<div class="panel-body">
					<br>
					<blockquote>자바 & JSP 공부</blockquote>
				</div>
				<!-- /.panel-heading -->
			</div>
		</div>
		<div class="col-lg-4">
			<div class="panel panel-default">
				<div class="panel-heading"><p class="fa fa-mortar-board">&nbsp;</p>스터디 명</div>
				<div class="panel-body">
					<br>
					<blockquote>자바 & JSP 공부</blockquote>
				</div>
				<!-- /.panel-heading -->
			</div>
		</div>
		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading"><p class="fa fa-bar-chart-o">&nbsp;</p>기간</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
				<input type="text" class="form-control"
					placeholder="2018/05/18" id="date_text" >&nbsp; ~
				&nbsp; <input type="text" class="form-control"
					placeholder="2018/08/10" id="date_text" readOnly>
				</div>
			</div>
		</div>
		<div class="col-lg-6" id="three_div">
			<div class="panel panel-default">
				<div class="panel-heading"><p class="glyphicon glyphicon-ok">&nbsp;</p>모집인원</div>
				<div class="panel-body">
				<input type="text" class="form-control" value="6"  readOnly>명
				</div>
			</div>
		</div>
		<div class="col-lg-6" id="three_div">
			<div class="panel panel-default">
				<div class="panel-heading"><p class="fa fa-bell">&nbsp;</p>활동시간</div>
				<div class="panel-body">
				<input type="text" class="form-control" value="3"  readOnly>시간
				</div>
			</div>
		</div>
		<div class="col-lg-6" id="three_div">
			<div class="panel panel-default">
				<div class="panel-heading"><p class="fa fa-calendar">&nbsp;</p>요일</div>
				<div class="panel-body">
				<input type="text" class="form-control" value="수"  readOnly>요일
				</div>
			</div>
		</div>
		<div class="col-lg-4">
			<div class="panel panel-default">
				<div class="panel-heading"><p class="glyphicon glyphicon-bookmark">&nbsp;</p>프로젝트 개요</div>
				<div class="panel-body">
					<h4>[ 자바 & JSP ]</h4>
					<blockquote>우리 프로젝트는 자바와 JSP를 배우는 스터디로서 ~</blockquote>
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<div class="col-lg-4">
			<div class="panel panel-default">
				<div class="panel-heading"><p class="glyphicon glyphicon-bookmark">&nbsp;</p>주요 교재 및 준비물</div>
				<div class="panel-body">
					<blockquote>주요 교재 및 준비물로는 ~ </blockquote>
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<div class="col-lg-4">
			<div class="panel panel-default">
				<div class="panel-heading"><p class="glyphicon glyphicon-bookmark">&nbsp;</p>기대효과 및 활동 분야</div>
				<div class="panel-body">
					<blockquote>기대효과와 활동 분야로는 ~</blockquote>
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<div class="col-lg-4">
			<div class="panel panel-default">
				<div class="panel-heading"><p class="glyphicon glyphicon-bookmark">&nbsp;</p>스터디 지역</div>
				<div class="panel-body">
					<blockquote>KH정보교육원 (여기에 지도넣기)</blockquote>
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>

	</form>
	<!-- jQuery -->
	<script src="../vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="../vendor/metisMenu/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script src="../vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script src="../vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script src="../vendor/datatables-responsive/dataTables.responsive.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="../dist/js/sb-admin-2.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>

</body>

</html>