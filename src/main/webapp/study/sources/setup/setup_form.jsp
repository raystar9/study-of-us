<!-- 스터디 안의 스터디 정보 페이지 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
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

#three_div {
	width: 150px;
	display: inline-block;
}

.form-control {
	text-align: right;
}
</style>

</head>

<body>
	<form action="#" method="post">
		<table border='1'>
			<tr>
				<td>
					<h1 class="page-header">스터디 설정</h1>
				</td>
			</tr>
			<tr>
				<td><h4>*스터디 명</h4>
					<hr> <input type="text" class="form-control"
					value="자바 & JSP 공부"></td>
			</tr>
			<tr>
				<td><h4>*스터디 원</h4>
					<hr>
					<table class="table table-striped table-bordered table-hover"
						border='1'>
						<thead>
							<tr>
								<th>#</th>
								<th>이름</th>
								<th>전화번호</th>
								<th>이메일</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td><input type="text" class="form-control"
									value="자바 & JSP 공부"></td>
								<td><input type="text" class="form-control"
									value="010-2350-3059"></td>
								<td><input type="text" class="form-control"
									value="dahye950627@naver.com"></td>
							</tr>
							<tr>
								<td>2</td>
								<td><input type="text" class="form-control" value="소문혁"></td>
								<td><input type="text" class="form-control"
									value="010-0000-0000"></td>
								<td><input type="text" class="form-control"
									value="smh@naver.com"></td>
							</tr>
							<tr>
								<td>3</td>
								<td><input type="text" class="form-control" value="노동완"></td>
								<td><input type="text" class="form-control"
									value="010-0000-0000"></td>
								<td><input type="text" class="form-control"
									value="ndw@naver.com"></td>
							</tr>
						</tbody>
					</table></td>
			</tr>
			<tr>
				<td><h4>*기간</h4>
					<hr> <input type="text" class="form-control"
					placeholder="2018/05/18" id="date_text">&nbsp; ~ &nbsp; <input
					type="text" class="form-control" placeholder="2018/08/10"
					id="date_text"></td>
			</tr>
			<tr>
				<td><h4>*현재인원</h4>
					<hr> <input type="text" class="form-control" value="6">명
				</td>
			</tr>
			<tr>
				<td><h4>*활동시간</h4>
					<hr> <input type="text" class="form-control" value="3">시간
				</td>
			</tr>
			<tr>
				<td><h4>*요일</h4>
					<hr> <input type="text" class="form-control" value="수">요일
				</td>
			</tr>
			<tr>
				<td><h4>*프로젝트 개요</h4>
					<hr> <input type="text" class="form-control"
					value="우리 프로젝트는 자바와 JSP를 배우는 스터디로서 ~"></td>
			</tr>
			<tr>
				<td><h4>*주요 교재 및 준비물</h4>
					<hr> <input type="text" class="form-control"
					value="주요 교재 및 준비물로는~"></td>
			</tr>
			<tr>
				<td><h4>*기대효과 및 활동 분야</h4>
					<hr> <input type="text" class="form-control"
					value="우리 프로젝트는 자바와 JSP를 배우는 스터디로서 ~"></td>
			</tr>
			<tr>
				<td><h4>*스터디 지역</h4>
					<hr> <input type="text" class="form-control"
					value="우리 프로젝트는 자바와 JSP를 배우는 스터디로서 ~"></td>
			</tr>
			<tr>
				<td><input type="submit" class="btn btn-default" id="btn"
					value="수정"> <input type="reset" class="btn btn-default"
					id="btn" value="취소"></td>
			</tr>
		</table>
	</form>
</body>

</html>
