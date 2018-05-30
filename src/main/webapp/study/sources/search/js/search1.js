	$(document).ready(function(){
		var secondArray_0 = new Array ("자바","c언어","파이썬","c++","c#");
		var secondArray_1 = new Array ("영어","불어","중국어","일본어","한국어");
		var secondArray_2 = new Array ("정보처리기사","컴퓨터활용","ccna","ccnp","네트워크관리사");
	

	
		
		$("#firstArray").change(function(){ // 대분류 선택시 소분류의 값을 선택할수 있도록 한다.
			var selectVal = $("#firstArray").val();
			var inner = "";
			
			
			if(selectVal == 1){
				for(var i=0; i<secondArray_0.length; i++){
				inner += "<option value="+secondArray_0[i]+">";
				inner += secondArray_0[i];
				inner += "</option>";
				}
				$("#secondArray option").remove();
				$("#secondArray").append(inner);
			}			
			if(selectVal == 2){
				for(var i=0; i<secondArray_1.length; i++){
				inner += "<option value="+secondArray_1[i]+">";
				inner += secondArray_1[i];
				inner += "</option>";
				}
				$("#secondArray option").remove();
				$("#secondArray").append(inner);
			}			
			if(selectVal == 3){
				for(var i=0; i<secondArray_2.length; i++){
				inner += "<option value="+secondArray_1[i]+">";
				inner += secondArray_2[i];
				inner += "</option>";
				}
				$("#secondArray option").remove();
				$("#secondArray").append(inner);
			}
		});
		

		$(".projectcontainer").click(function(){
			var index = $(this).children('#index') 
			//자식의 값을 가져오기 위해서 children('선택자')를 사용
			location.href = "/study-of-us/study/each/participate?index="+index.val();
		})
		
		$(".atag1").click(function(e){
     		e.preventDefault();
			var page = $(this).text()
				alert(page); 
			
			$.ajax({
 				type : "get",
 				data : {"page" : page, "check" : '${place}' , "state" : "ajax"},
 				url  : "/study-of-us/study/search",
 				success : function(rdata){
 					
 					$(".project").empty().append(rdata);
 				}
 			
 			})

        })
		
		$("input[type=checkbox]").each(function(){
			$(this).change(function(){
				var a = $(this).val()
				$("#place2").val(a)
				$("input[type=checkbox]").prop("checked",false)
				$(this).prop("checked",true)
				
				$.ajax({
					type : "get",
					data : {"place" : a, "state":"ajax"},
					url : "/study-of-us/study/search",
					success : function(rdata){
							$(".project").empty().append(rdata);
						}
					})					
				})
			})
			
			$(".projectcontainer").click(function(){
			var index = $(this).children('#index') 
			//자식의 값을 가져오기 위해서 children('선택자')를 사용
			location.href = "/study-of-us/study/each/participate?index="+index.val();
		})
		
			
	
			$("input[value=${place2}]").prop('checked', true)
			//이 부분에  나는 오류는 나중에 수정하겠음 (실행에는 문제가 없음)
			
		
				
		});