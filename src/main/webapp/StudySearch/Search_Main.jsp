<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<style>


body {
    font-family: Arial;
}

 
form.example{
	margin-top:30px;
	display: inline-block;
	width: 80%;
	float:right;
}


form.example input[type=text] {
    padding: 10px;
    font-size: 17px;
    border: 1px solid grey;
    float: right;
    width: 80%;
    background: #f1f1f1;
    
}

form.example button {
    float: right;
    width: 10%;
    padding: 10px;
    background: #2196F3;
    color: white;
    font-size: 17px;
    border: 1px solid grey;
    border-left: none;
    cursor: pointer;
    margin-right:20px;
}

form.example button:hover {
    background: #0b7dda;
}

form.example::after {
    content: "";
    clear: both;
    display: table;
}

div.custom-select {
	display: inline-block;
	margin-left: 90px;
    margin-top: 40px;
}
div.custom-select2 {
	display: inline-block;
	margin-left: 15px;
}

option{
	height:20px;
}


.check{
	border-bottom:1px solid black;
	border-left:1px solid black;
	border-right:1px solid black;
    display: block;
    height: 50%;
    width: 100%;
}
.check p{
	text-align: right;
	margin-right:350px
}

.check p span{
	float: left;
	margin-left: 80px;
}
.search{
	border:1px solid black;
	height:100px;
	width: 100%;
}

.container{
	margin-top:30px;
	margin-right:100px;
}

.project{
 	height: -webkit-fill-available;
}



.projectcontainer {
  border: 2px solid #ccc;
  background-color: #eee;
  border-radius: 5px;
  padding: 16px;
  margin: 16px 0
}

.projectcontainer::after {
  content: "";
  clear: both;
  display: table;
}

.projectcontainer img {
  float: left;
  margin-right: 20px;
  border-radius: 50%;
}

.projectcontainer span {
  font-size: 20px;
  margin-right: 15px;
}

</style>
<body>
<%@ include file = "/Navigation.jsp" %>
<div class="search">
	<form class="example" action="/action_page.php">
  		<button type="submit"><i class="fa fa-search"></i></button>
 		 <input type="text" placeholder="Search.." name="search2">
	</form>
	
	<div class="custom-select">
  		<select>
  			  <option value="0">대분류</option>
  			  <option value="1">프로그래밍</option>
 			  <option value="2">영어</option>
   			  <option value="3">면접</option>
  		</select>
	</div>
	
	<div class="custom-select2">
  		<select>
  			  <option value="0">대분류</option>
  			  <option value="1">프로그래밍</option>
 			  <option value="2">영어</option>
   			  <option value="3">면접</option>
  		</select>
	</div>
</div>
	
	<div class="check">
	<p>
	<span>체크사항1</span>
	<label class="container">One
  		<input type="checkbox" checked="checked">
		<span class="checkmark"></span>
	</label>
		<label class="container">Two
 		<input type="checkbox">
  		<span class="checkmark"></span>
	</label>
	<label class="container">Three
  		<input type="checkbox">
 		<span class="checkmark"></span>
	</label>
	<label class="container">Four
  		<input type="checkbox">
  		<span class="checkmark"></span>
	</label>	
	</p>
	
	<p>
	<span>체크사항2</span>
	<label class="container">One
  		<input type="checkbox" checked="checked">
		<span class="checkmark"></span>
	</label>
		<label class="container">Two
 		<input type="checkbox">
  		<span class="checkmark"></span>
	</label>
	<label class="container">Three
  		<input type="checkbox">
 		<span class="checkmark"></span>
	</label>
	<label class="container">Four
  		<input type="checkbox">
  		<span class="checkmark"></span>
	</label>	
	</p>
	
		<p>
		<span>체크사항3</span>
	<label class="container">One
  		<input type="checkbox" checked="checked">
		<span class="checkmark"></span>
	</label>
		<label class="container">Two
 		<input type="checkbox">
  		<span class="checkmark"></span>
	</label>
	<label class="container">Three
  		<input type="checkbox">
 		<span class="checkmark"></span>
	</label>
	<label class="container">Four
  		<input type="checkbox">
  		<span class="checkmark"></span>
	</label>	
	</p>
	</div>
	
	<div class="project">
		<div class="projectcontainer">
  			<img src="IMG2.jpg" alt="Avatar" style="width:90px">
 			 <p><span>스터디장 아이디</span> 스터디 제목</p>
  			<p>스터디 관련 내용.</p>
		</div>
		
		<div class="projectcontainer">
  			<img src="IMG.jpg"  alt="Avatar" style="width:90px">
 			 <p><span>Chris Fox.</span> CEO at Mighty Schools.</p>
  			<p>John Doe saved us from a web disaster.</p>
		</div>
		
		<div class="projectcontainer">
  			<img src="IMG2.jpg"  alt="Avatar" style="width:90px">
 			 <p><span>Chris Fox.</span> CEO at Mighty Schools.</p>
  			<p>John Doe saved us from a web disaster.</p>
		</div>
		
		<div class="projectcontainer">
  			<img src="IMG.jpg"  alt="Avatar" style="width:90px">
 			 <p><span>Chris Fox.</span> CEO at Mighty Schools.</p>
  			<p>John Doe saved us from a web disaster.</p>
		</div>
		
		<div class="projectcontainer">
  			<img src="IMG2.jpg"  alt="Avatar" style="width:90px">
 			 <p><span>Chris Fox.</span> CEO at Mighty Schools.</p>
  			<p>John Doe saved us from a web disaster.</p>
		</div>
	</div>
</div>
<%@ include file = "/Footer.jsp" %>
</body>
</html> 