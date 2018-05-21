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
<%@ include file = "/general-sources/Navigation.jsp" %>
<%@ include file = "sources/section.jsp" %>
<%@ include file = "/general-sources/Footer.jsp" %>
</body>
</html> 