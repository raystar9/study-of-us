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
	height: 350px; /* Should be removed. Only for demonstration */
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
margin-left: 70px;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
    transition: 0.3s;
    width: 15%;
    display: inline-block;
}

.ranking {
	margin-bottom: 100px;
}

.openBtn {
	background: #f1f1f1;
	border: none;
	padding: 10px 15px;
	font-size: 20px;
	cursor: pointer;
}

.openBtn:hover {
	background: #bbb;
}

.pickrowcontainer:hover {
	background-color: #ddd;
	color: black;
}

.overlay {
	height: 100%;
	width: 100%;
	display: none;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: rgb(0, 0, 0);
	background-color: rgba(0, 0, 0, 0.9);
}

.overlay-content {
	position: relative;
	top: 46%;
	width: 80%;
	text-align: center;
	margin-top: 30px;
	margin: auto;
}

.overlay .closebtn {
	position: absolute;
	top: 20px;
	right: 45px;
	font-size: 60px;
	cursor: pointer;
	color: white;
}

.overlay .closebtn:hover {
	color: #ccc;
}

.overlay input[type=text] {
	padding: 15px;
	font-size: 17px;
	border: none;
	float: left;
	width: 80%;
	background: white;
}

.overlay input[type=text]:hover {
	background: #f1f1f1;
}

.overlay button {
	float: left;
	padding: 15px;
	background: #ddd;
	font-size: 17px;
	border: none;
	cursor: pointer;
}

.overlay button:hover {
	background: #bbb;
}
</style>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(document).ready(function() {
		$(".column").each(function() {
			$(this).click(function() {
				var b = $(this).find("h2").text();
				location.href = "/study-of-us/study/search?category=" + b
			})

		})

	})

	$(document).on(
			"click",
			".pickrowcontainer",
			function() {
				var index = $(this).children('#index')
				// 자식의 값을 가져오기 위해서 children('선택자')를 사용
				location.href = "/study-of-us/study/each/participate?index="
						+ index.val();
			})

	function openSearch() {
		document.getElementById("myOverlay").style.display = "block";
	}

	function closeSearch() {
		document.getElementById("myOverlay").style.display = "none";
	}
</script>
</head>
<body>
	<%@ include file="/general-sources/Navigation.jsp"%>
	<div class="container">
		<div class="header-title">
			<div class="header-text">
				<div class="search-bar">
					<button type="submit" id="button" onclick="openSearch()"
						style="height: 25px; width: 15%;">
						<i class="fa fa-search"></i>
					</button>
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
								<h2>언어</h2>
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
								<p class="title">certificate</p>
								<button class="button">Contact</button>
							</div>
						</div>
					</div>

					<div class="column">
						<div class="card">
							<img src="/study-of-us/resources/images/notebook.png" alt="Jane"
								style="width: 60%;">
							<div class="container">
								<h2>전체스터디</h2>
								<p class="title">all</p>
								<button class="button">Contact</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="soup-pick">

			<h3 style="text-align: center">SOUP 최신 스터디 목록</h3>
			<div class="pickrow">
				<div class="pickcolumn" style="background-color: #aaa;">
					<h2>프로그래밍</h2>
					<c:forEach var="study" begin="0" end="1" items="${programming }">
						<div class="pickrowcontainer" id="pickrowcontainer">
							<img src="/study-of-us/resources/images/pc.png" alt="Avatar"
								class="right">
							<h2>스터디 : ${study.name }</h2>
							<span class="time-left">스터디 내용 & 스터디 생성일</span> <input
								type="hidden" id="index" name="index" value="${study.index }" />
						</div>
					</c:forEach>
				</div>
				<div class="pickcolumn" style="background-color: #bbb;">
					<h2>언어</h2>
					<c:forEach var="study" begin="0" end="1" items="${language }">
						<div class="pickrowcontainer" id="pickrowcontainer">
							<img src="/study-of-us/resources/images/graduate.png" alt="Avatar"
								class="right">
							<h2>스터디 : ${study.name }</h2>
							<span class="time-left">스터디 내용 & 스터디 생성일</span> <input
								type="hidden" id="index" name="index" value="${study.index }" />
						</div>
					</c:forEach>
				</div>
				<div class="pickcolumn" style="background-color: #ccc;">
					<h2>자격증</h2>
					<c:forEach var="study" begin="0" end="1" items="${certificate }">
						<div class="pickrowcontainer" id="pickrowcontainer">
							<img src="/study-of-us/resources/images/id-card.png" alt="Avatar"	
								class="right">
							<h2>스터디 : ${study.name }</h2>
							<span class="time-left">스터디 내용 & 스터디 생성일</span> <input
								type="hidden" id="index" name="index" value="${study.index }" />
						</div>
					</c:forEach>
				</div>
			</div>

		</div>

		<div class="ranking">
			<div class="rank-container">
				<h2 style="text-align: center">Soup Developer</h2>
				<div class="rankcard">
					<img src="/study-of-us/resources/images/man.png" alt="Avatar"
						style="width: 100%">
					<div class="container">
						<h4>
							<b>John Doe</b>
						</h4>
						<p>Developer</p>
					</div>
				</div>
				<div class="rankcard">
					<img src="/study-of-us/resources/images/boy.png" alt="Avatar"
						style="width: 100%">
					<div class="container">
						<h4>
							<b>Mun Hyeok</b>
						</h4>
						<p>Developer</p>
					</div>
				</div>
				<div class="rankcard">
					<img src="/study-of-us/resources/images/girl.png" alt="Avatar"
						style="width: 100%">
					<div class="container">
						<h4>
							<b>Da Hye</b>
						</h4>
						<p>Developer</p>
					</div>
				</div>
				<div class="rankcard">
					<img src="/study-of-us/resources/images/man4.png" alt="Avatar"
						style="width: 100%">
					<div class="container">
						<h4>
							<b>Seung Min</b>
						</h4>
						<p>Developer</p>
					</div>
				</div>
				<div class="rankcard">
					<img src="/study-of-us/resources/images/man5.png" alt="Avatar"
						style="width: 100%">
					<div class="container">
						<h4>
							<b>Dong Wan</b>
						</h4>
						<p>Developer</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="myOverlay" class="overlay">
		<span class="closebtn" onclick="closeSearch()" title="Close Overlay">×</span>
		<div class="overlay-content">
			<form action="/study-of-us/study/search">
				<input type="text" placeholder="Search.." name="searchVal"
					id="searchVal">
				<button type="submit">
					<i class="fa fa-search"></i>
				</button>
			</form>
		</div>
	</div>

	<%@ include file="/general-sources/Footer.jsp"%>

</body>
</html>