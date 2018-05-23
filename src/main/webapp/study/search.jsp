<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="sources/search/css/search.css">
<script src = "http://code.jquery.com/jquery-3.3.1.js"></script>
</head>
<script>
	$(document).ready(function(){
		var secondArray_0 = new Array ("자바","c언어","파이썬","c++","c#");
		var secondArray_1 = new Array ("영어","불어","중국어","일본어");
		var secondArray_2 = new Array ("정보처리기사","컴활","ccna","ccnp")
		
		$("#firstArray").change(function(){ // 대분류 선택시 소분류의 값을 선택할수 있도록 한다.
			var selectVal = $("#firstArray").val();
			var inner = "";
			
			
			if(selectVal == 1){
				for(var i=0; i<secondArray_0.length; i++){
				inner += "<option value="+i+">";
				inner += secondArray_0[i];
				inner += "</option>";
				}
				$("#secondArray option").remove();
				$("#secondArray").append(inner);
			}			
			if(selectVal == 2){
				for(var i=0; i<secondArray_1.length; i++){
				inner += "<option value="+i+">";
				inner += secondArray_1[i];
				inner += "</option>";
				}
				$("#secondArray option").remove();
				$("#secondArray").append(inner);
			}			
			if(selectVal == 3){
				for(var i=0; i<secondArray_2.length; i++){
				inner += "<option value="+i+">";
				inner += secondArray_2[i];
				inner += "</option>";
				}
				$("#secondArray option").remove();
				$("#secondArray").append(inner);
			}
		});
		
		$(".projectcontainer").hover(
		function(){
			$(this).css('background','#333333bd')
		},
		function(){
			$(this).css('background','#eee')
		}
		);
		
		$(".projectcontainer").click(function(){
			$(this).submit('action','/schedule/StyudySchedule.jsp');
		})
	})
</script>
<body>
<%@ include file = "/general-sources/Navigation.jsp" %>
<%@ include file = "sources/search/section.jsp" %>
<%@ include file = "/general-sources/Footer.jsp" %>
</body>
</html> 