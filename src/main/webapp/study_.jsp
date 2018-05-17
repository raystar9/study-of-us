<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<!-- <script src = "http://code.jquery.com/jquery-3.3.1.js"></script> -->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
   <script>
  $( function() {
    $( "#day1,#day2" ).datepicker({
   	monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
    dayNamesMin: ['일','월','화','수','목','금','토'],
     dateFormat: "yy년mm월dd일",
      changeYear: true,
      changeMonth: true
    });
  } );
  </script>

<style>
input[type=text] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

div {
	border : 1px solid #0000004a;
	max-width : 700px;
    border-radius: 5px;
    background-color: #f2f2f259;
    padding: 20px;
    margin : 0 auto;
}

#day1{
	width : 48%;
}

#day2{
	width : 48%;
}
span{
	width : 30px;
}
</style>
</head>
<body>
<div>
<label for="category"><strong>카테고리</strong></label><br>
<input type=text name=category id="category"><br>
<label for="category"><strong>스터디명</strong></label><br>
<input type=text name=study_name id="study_name"><br>

<label for="category"><strong>기간</strong></label><br>
<input type=text name=day1 id="day1"> ~ 
<input type=text name=day2 id="day2"><br>

<span><label for="category"><strong>모집인원</strong></label><br>
	<input type=text name=Personnel id=Personnel></span>
<span><label for="category"><strong>활동시간</strong></label><br>
	<input type=text name=Personnel id=Personnel></span>
<span><label for="category"><strong>요일</strong></label><br>
	<input type=text name=Personnel id=Personnel></span>


</div>





</body>
</html>