<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style>
html, body { width: 100%; height: 100%; }

.header-title {
    /* The image used */
    background-image: url("/study-of-us/resources/images/image4.jpg");

    min-height: 380px;

    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
   
}


.search-bar{;
    border: 6px solid #ffd400;
    width: 700px !important;
    position: relative;
    
     width: 70%;
 	 height: 70%;
 	 margin: 40px auto;
}
	</style>
</head>
<body>
<%@ include file = "/general-sources/Navigation.jsp" %>
	<div class="container">
		<div class="header-title">
			<div class="search-bar">
			  	<button type="submit" id="button"><i class="fa fa-search"></i></button>
				<input type="text" placeholder="Search.." id="searchVal" name="searchVal" value="">
			</div>
		</div>
		<div class="category-body">
			<div class="category">
				<div>프로그래밍</div>
				
				<div>외국어</div>
				
				<div>면접</div>
				
				<div>문서작성</div>
				
				<div>자격증</div>
				
				<div>음악</div>
				
				<div>컨텐츠 제작</div>
			</div>
		</div>
		
		<div class="soup-pick">
			<div class="english-container">
				영어 스터디
			</div>
			
			<div class="programming-container">
				프로그래밍 스터디
			</div>
			
			<div class="interview-container">
				면접 스터디
			</div>
		</div>
	</div>
	<%@ include file = "/general-sources/Footer.jsp" %>
</body>
</html>