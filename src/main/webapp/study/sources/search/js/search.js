
$(document).ready(function(){
		var secondArray_0 = new Array ("자바","c언어","파이썬","c++","c#");
		var secondArray_1 = new Array ("영어","불어","중국어","일본어","한국어");
		var secondArray_2 = new Array ("정보처리기사","컴퓨터활용","ccna","ccnp","네트워크관리사");
	
		$("form").submit(function(){	
			if($("#searchVal").val()==null || $("#searchVal").val()==""){
			alert("검색어를 입력해주세요!")
			$(this).focus();
			}
			
			var params = $("form").serialize()
			// form의 모든 Element을 문자열의 데이터에 serialize 한다
			
			$("#loader").addClass("loader")
			$(".project").empty()
			
			setTimeout(function(){
				// ajax를 사용해서 검색을 하면 바로 화면이 전환되어 검색이 적용됬는지 확인하기 어려워
				// 1초정도의 시간을 두고 로더화면을 띄우고 검색내용을 화면에 나타낸다.
				$.ajax({
					type : "get",		
					data : {"state": "ajax"},
					url : "/study-of-us/study/search?"+params,
					success : function(rdata){
					$("#loader").removeClass("loader")
					$(".project").append(rdata);	
				}	
			})
		},700)
			return false;
		})
		

		$(document).on("click","#atag",function(){
			var page = $(this).text()
			var params = $("form").serialize()
			$.ajax({
 				type : "get",
 				data : {"page" : page , "state" : "ajax"},
 				url  : "/study-of-us/study/search?"+params,
 				success : function(rdata){
 					$(".project").empty().append(rdata);
 				}
 			})
 			return false;
        })
        
		
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
		// 스터디를 클릭하면 참여할수 있도록 함
		
		$(document).on("click",".projectcontainer",function(){
			var index = $(this).children('#index') 
			//자식의 값을 가져오기 위해서 children('선택자')를 사용
			location.href = "/study-of-us/study/each/participate?index="+index.val();
		})
	
		
		
	   	 $("input[type=checkbox]").each(function(){
	   		
	   	 	 $("input[value=checkbox]").prop("checked",true)
	   	  a = $(this).val()
  	  }); 
		
		
	});
