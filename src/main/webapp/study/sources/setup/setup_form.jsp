<!-- ���͵� ���� ���͵� ���� ������ -->
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
					<h1 class="page-header">���͵� ����</h1>
				</td>
			</tr>
			<tr>
				<td><h4>*���͵� ��</h4>
					<hr> <input type="text" class="form-control"
					value="�ڹ� & JSP ����"></td>
			</tr>
			<tr>
				<td><h4>*���͵� ��</h4>
					<hr>
					<table class="table table-striped table-bordered table-hover"
						border='1'>
						<thead>
							<tr>
								<th>#</th>
								<th>�̸�</th>
								<th>��ȭ��ȣ</th>
								<th>�̸���</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td><input type="text" class="form-control"
									value="�ڹ� & JSP ����"></td>
								<td><input type="text" class="form-control"
									value="010-2350-3059"></td>
								<td><input type="text" class="form-control"
									value="dahye950627@naver.com"></td>
							</tr>
							<tr>
								<td>2</td>
								<td><input type="text" class="form-control" value="�ҹ���"></td>
								<td><input type="text" class="form-control"
									value="010-0000-0000"></td>
								<td><input type="text" class="form-control"
									value="smh@naver.com"></td>
							</tr>
							<tr>
								<td>3</td>
								<td><input type="text" class="form-control" value="�뵿��"></td>
								<td><input type="text" class="form-control"
									value="010-0000-0000"></td>
								<td><input type="text" class="form-control"
									value="ndw@naver.com"></td>
							</tr>
						</tbody>
					</table></td>
			</tr>
			<tr>
				<td><h4>*�Ⱓ</h4>
					<hr> <input type="text" class="form-control"
					placeholder="2018/05/18" id="date_text">&nbsp; ~ &nbsp; <input
					type="text" class="form-control" placeholder="2018/08/10"
					id="date_text"></td>
			</tr>
			<tr>
				<td><h4>*�����ο�</h4>
					<hr> <input type="text" class="form-control" value="6">��
				</td>
			</tr>
			<tr>
				<td><h4>*Ȱ���ð�</h4>
					<hr> <input type="text" class="form-control" value="3">�ð�
				</td>
			</tr>
			<tr>
				<td><h4>*����</h4>
					<hr> <input type="text" class="form-control" value="��">����
				</td>
			</tr>
			<tr>
				<td><h4>*������Ʈ ����</h4>
					<hr> <input type="text" class="form-control"
					value="�츮 ������Ʈ�� �ڹٿ� JSP�� ���� ���͵�μ� ~"></td>
			</tr>
			<tr>
				<td><h4>*�ֿ� ���� �� �غ�</h4>
					<hr> <input type="text" class="form-control"
					value="�ֿ� ���� �� �غ񹰷δ�~"></td>
			</tr>
			<tr>
				<td><h4>*���ȿ�� �� Ȱ�� �о�</h4>
					<hr> <input type="text" class="form-control"
					value="�츮 ������Ʈ�� �ڹٿ� JSP�� ���� ���͵�μ� ~"></td>
			</tr>
			<tr>
				<td><h4>*���͵� ����</h4>
					<hr> <input type="text" class="form-control"
					value="�츮 ������Ʈ�� �ڹٿ� JSP�� ���� ���͵�μ� ~"></td>
			</tr>
			<tr>
				<td><input type="submit" class="btn btn-default" id="btn"
					value="����"> <input type="reset" class="btn btn-default"
					id="btn" value="���"></td>
			</tr>
		</table>
	</form>
</body>

</html>
