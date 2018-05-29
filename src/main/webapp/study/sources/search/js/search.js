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
			location.href = "이동할 주소"
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
				alert(a);
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
				
				
		});