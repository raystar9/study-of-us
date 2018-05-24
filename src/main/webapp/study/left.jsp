<!-- 스터디 안의 왼쪽 메뉴 바 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<style>
	#left{
		width: 200px;
	}
</style>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>왼쪽 사이드 메뉴</title>

<!-- Bootstrap Core CSS -->
<link href="/study-of-us/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="/study-of-us/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="/study-of-us/vendor/morrisjs/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="/study-of-us/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

</head>

<body>

		<div class="navbar-default sidebar" role="navigation" id='left'>
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">

					<li><a href="#"><i class="fa fa-edit fa-fw"></i>
							게시판 </a></li>
					<li><a href="#"><i class="fa fa-table fa-fw"></i>
							출석체크</a></li>
					<li><a href="#"><i
							class="fa fa-bar-chart-o fa-fw"></i> 진행현황</a></li>
					<li><a href="#"><i class="fa fa-dollar fa-fw"></i>
							회비관리</a></li>
					<li><a href="#"><i class="fa fa-bookmark fa-fw"></i> 스터디
							정보</a></li>
					<li><a href="#"><i class="fa fa-cog fa-fw"></i> 설정<span
							class="fa"></span></a></li>
				</ul>
			</div>
			<!-- /.sidebar-nav navbar-collapse -->
		</div>
		<!-- /.navbar-default sidebar -->
		

	<!-- jQuery -->
	<script src="/study-of-us/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="/study-of-us/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="/study-of-us/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<script src="/study-of-us/vendor/raphael/raphael.min.js"></script>
	<script src="/study-of-us/vendor/morrisjs/morris.min.js"></script>
	<script src="../data/morris-data.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="../dist/js/sb-admin-2.js"></script>

</body>
</html>
