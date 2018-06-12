<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
html, body {
	width: 100%;
	height: 100%;
}

.header-title {
	/* The image used */
	background-image: url("/study-of-us/resources/images/image4.jpg");
	min-height: 380px;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

.header-text {
	height: 200px;
}

.search-bar {
	text-align: center;
	line-height: 25;
}

.category-body {
	text-align: center;
}

.category {
	display: inline-block;
	width: 100%;
	margin: 0 auto;
}

.column {
	float: left;
	width: 200px;
	height: 200px;
	margin-left: 100px;
	margin-bottom: 100px;
}

.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
}

.button {
	border: none;
	outline: 0;
	display: inline-block;
	padding: 8px;
	color: white;
	background-color: #000;
	text-align: center;
	cursor: pointer;
	width: 100%;
}

.button:hover {
	background-color: #555;
}

.pickcolumn {
	margin-left: 5%;
	float: left;
	width: 25%;
	padding: 10px;
	height: 300px; /* Should be removed. Only for demonstration */
	margin-bottom: 100px;
}

/* Clear floats after the columns */
.pickrow:after {
	content: "";
	display: table;
	clear: both;
}

.pickrowcontainer {
	border: 2px solid #dedede;
	background-color: #f1f1f1;
	border-radius: 5px;
	padding: 10px;
	margin: 10px 0;
}

.pickrowcontainer img {
	float: left;
	max-width: 60px;
	width: 100%;
	margin-right: 20px;
	border-radius: 50%;
}

.rankcard {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	transition: 0.3s;
	width: 70%;
	margin: auto;
}

.ranking {
	margin-bottom: 100px;
}
</style>
</head>
<body>
	<%@ include file="/general-sources/Navigation.jsp"%>
	<div class="container">
		<div class="header-title">
			<div class="header-text">
				<div class="search-bar">
					<button type="submit" id="button">
						<i class="fa fa-search"></i>
					</button>
					<input type="text" placeholder="Search.." id="searchVal"
						name="searchVal" value="">
				</div>
			</div>
		</div>
		<div class="category-body">
			<h3>카테고리</h3>
			<br>
			<div class="category">
				<div class="category-container">
					<div class="column">
						<div class="card">
							<img src="/study-of-us/resources/images/pc.png" alt="Jane"
								style="width: 60%;">
							<div class="container">
								<h2>프로그래밍</h2>
								<p class="title">IT & Programming</p>
								<button class="button">Contact</button>
							</div>
						</div>
					</div>

					<div class="column">
						<div class="card">
							<img src="/study-of-us/resources/images/graduate.png" alt="Jane"
								style="width: 60%;">
							<div class="container">
								<h2>외국어</h2>
								<p class="title">Language</p>
								<button class="button">Contact</button>
							</div>
						</div>
					</div>

					<div class="column">
						<div class="card">
							<img src="/study-of-us/resources/images/chat.png" alt="Jane"
								style="width: 60%;">
							<div class="container">
								<h2>면접</h2>
								<p class="title">interview</p>
								<button class="button">Contact</button>
							</div>
						</div>
					</div>



					<div class="column">
						<div class="card">
							<img src="/study-of-us/resources/images/painting-palette.png"
								alt="Jane" style="width: 60%;">
							<div class="container">
								<h2>미술</h2>
								<p class="title">interview</p>
								<button class="button">Contact</button>
							</div>
						</div>
					</div>

					<div class="column">
						<div class="card">
							<img src="/study-of-us/resources/images/id-card.png" alt="Jane"
								style="width: 60%;">
							<div class="container">
								<h2>자격증</h2>
								<p class="title">interview</p>
								<button class="button">Contact</button>
							</div>
						</div>
					</div>

					<div class="column">
						<div class="card">
							<img src="/study-of-us/resources/images/notebook.png" alt="Jane"
								style="width: 60%;">
							<div class="container">
								<h2>전체 스터디</h2>
								<p class="title">interview</p>
								<button class="button">Contact</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="soup-pick">
			<h3 style="text-align: center">SOUP 추천 스터디 목록</h3>
			<div class="pickrow">
				<div class="pickcolumn" style="background-color: #aaa;">
					<h2>프로그래밍</h2>
					<div class="pickrowcontainer">
						<img src="/study-of-us/resources/images/IMG.jpg" alt="Avatar"
							class="right">
						<p>Hey! I'm fine. Thanks for asking!</p>
						<span class="time-left">11:01</span>
					</div>
				</div>
				<div class="pickcolumn" style="background-color: #bbb;">
					<h2>외국어</h2>
					<div class="pickrowcontainer">
						<img src="/study-of-us/resources/images/IMG.jpg" alt="Avatar"
							class="right">
						<p>Hey! I'm fine. Thanks for asking!</p>
						<span class="time-left">11:01</span>
					</div>
				</div>
				<div class="pickcolumn" style="background-color: #ccc;">
					<h2>자격증</h2>
					<div class="pickrowcontainer">
						<img src="/study-of-us/resources/images/IMG.jpg" alt="Avatar"
							class="right">
						<p>Hey! I'm fine. Thanks for asking!</p>
						<span class="time-left">11:01</span>
					</div>
				</div>
			</div>
		</div>

		<div class="ranking">
			<div class="rank-container">
				<h3 style="text-align: center">스터디 최다 생성자</h3>
				<div class="rankcard">
					<img src="/study-of-us/resources/images/man.png" alt="Avatar"
						style="width: 10%">
					<div class="container">
						<h4>
							<b>John Doe</b>
						</h4>
						<p>Architect & Engineer</p>
					</div>
				</div>
			</div>
			<div class="rank-container">
				<h3 style="text-align: center">스터디 최다 참여자</h3>
				<div class="rankcard">
					<img src="/study-of-us/resources/images/girl.png" alt="Avatar"
						style="width: 10%">
					<div class="container">
						<h4>
							<b>John Doe</b>
						</h4>
						<p>Architect & Engineer</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/general-sources/Footer.jsp"%>

</body>
</html>