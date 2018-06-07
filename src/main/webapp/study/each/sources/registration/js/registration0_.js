  $( function() {
	  
	  var ck = 0;
	  
	  //유효성 검사 시작 
	  $("form").submit(function(){
		
		  
		  if($("#first").val() == "-1"){
			  alert("카테고리를 선택해주세요.");
			  return false;
		  }
		  
		  if($("#second").val() == "-1"){
			  alert("카테고리를 선택해주세요.");
			  return false;
		  }
		  
		 if($("#study_name").val() == ""){
			 alert("스터디 명을 입력해주세요");
			 return false;
		 }
		 
		 
		 if($("#day1").val() == ""){
			 alert("시작날짜를 입력해주세요");
			 return false;
		 }
		 
		 if($("#day2").val() == ""){
			 alert("끝날짜 입력해주세요");
			 return false;
		 }

		 if($("#day1").val() == $("#day2").val()){
			 alert("날짜를 다시 선택해주세요")
			 return false;
		 }
		 
		 
		 if($("#people").val() == ""){
			 alert("모집인원을 입력해주세요");
			 return false;
		 }
		 
		 if($("#day").val() == ""){
			 alert("요일을 입력해주세요");
			 return false;
		 }
		 
		 if($("#stime").val() == ""){
			 alert("시간을입력해주세요");
			 return false;
		 }
		 
		 
		 if($("#explain").val() == ""){
			 alert("프로젝트 개요를 입력해주세요.");
			 return false;
		 }
		 
		 if($("#prepared").val() == ""){
			 alert("주요 교재및 준비물을 입력해주세요.");
			 return false;
		 }
		 
		 if($("#activity").val() == ""){
			 alert("기대효과 및 활동 분야를 입력해 주세요.");
			 return false;
		 }
		 
		 if($("#locationSel").val() == ""){
			 alert("지역을 선택해주세요!");
			 return false;
		 }
		 
		 
		 

		 /*
		 
		 $.ajax({
			type : "GET",
			url : "/study-of-us/SnameCheck",
			data : {
				"name" : $("input[name=study_name]").val()
			},
			success : function(result){
				alert(result);
				$("#place").empty();
				if(result == -1){
					ck = -1;
					$("#place").append("스터디명이 중복입니다.");
					$("#place").css("color","red");
				}
			}
		 })
		 if(ck == -1){
			 alert("스터디명을 다시적어주세요");
			 return false;
		 }*/
		 
		 
	  })
	  
	  $('#people').keyup(function(){
		  if(isNaN($("#people").val())){
			  alert("숫자만 입력가능합니다.")
			  $("#people").val("")
		  }
	  })
	  

	  
	  
	  
	  //달력
	  
	  
	   //datepicker 한국어로 사용하기 위한 언어설정
      $.datepicker.setDefaults($.datepicker.regional['ko']); 
      
      // 시작일(fromDate)은 종료일(toDate) 이후 날짜 선택 불가
      // 종료일(toDate)은 시작일(fromDate) 이전 날짜 선택 불가

      //시작일.
      $('#day1').datepicker({
           //dateFormat: "yy-mm-dd",
           monthNamesShort: ["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
           dayNamesMin:["일","월","화","수","목","금","토"],
          //buttonImage: "/jdAdmin/images/calendar.png", // 버튼 이미지
          //buttonImageOnly : true,             // 버튼 이미지만 표시할지 여부
          //buttonText: "날짜선택",             // 버튼의 대체 텍스트
           minDate : 7,
          dateFormat: "yy-mm-dd",             // 날짜의 형식
          changeMonth: true,                  // 월을 이동하기 위한 선택상자 표시여부
              /*maxDate: 0,                       // 선택할수있는 최소날짜, ( 0 : 오늘 이후 날짜 선택 불가)
*/          onSelect: function( selectedDate ) {    
              // 시작일(fromDate) datepicker가 닫힐때
              // 종료일(toDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
              $("#day2").datepicker( "option", "minDate", selectedDate );
          }                
      });

      //종료일
      $('#day2').datepicker({
           /*dateFormat: "yy-mm-dd",*/
           monthNamesShort: ["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
           dayNamesMin:["일","월","화","수","목","금","토"], 
          dateFormat: "yy-mm-dd",
          changeMonth: true,
          onSelect: function( selectedDate ) {
              // 종료일(toDate) datepicker가 닫힐때
              // 시작일(fromDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 종료일로 지정 
              $("#day1").datepicker( "option", "maxDate"+7, selectedDate );
          },
          minDate : 7
      });
    
    
    /*// 지도
	  
	
	  sel = $("#locationSel");
	  
	 $("#locationSel").change(function(){
		 var sel = $("#locationSel").val();
	
    var map = new naver.maps.Map('map');
     myaddress = '서울';// 도로명 주소나 지번 주소만 가능 (건물명 불가!!!!)    
	 myaddress = sel;
	 naver.maps.Service.geocode({address: myaddress}, function(status, response) {
        if (status !== naver.maps.Service.Status.OK) {
            return alert(myaddress + '의 검색 결과가 없거나 기타 네트워크 에러');
        }
        var result = response.result;
        // 검색 결과 갯수: result.total
        // 첫번째 결과 결과 주소: result.items[0].address
        // 첫번째 검색 결과 좌표: result.items[0].point.y, result.items[0].point.x
        var myaddr = new naver.maps.Point(result.items[0].point.x, result.items[0].point.y);
        map.setCenter(myaddr); // 검색된 좌표로 지도 이동
        // 마커 표시
        var marker = new naver.maps.Marker({
          position: myaddr,
          map: map
        });
        // 마커 클릭 이벤트 처리
        naver.maps.Event.addListener(marker, "click", function(e) {
          if (infowindow.getMap()) {
              infowindow.close();
          } else {
              infowindow.open(map, marker);
          }
        });
        // 마크 클릭시 인포윈도우 오픈
        var infowindow = new naver.maps.InfoWindow({
            content: '<h4> [네이버 개발자센터]</h4><a href="https://blog.naver.com/rumor1993" target="_blank"><img src="https://developers.naver.com/inc/devcenter/images/nd_img.png"></a>'
        });
    });
	 })*/
    
    //카테고리
    var second0=new Array ("자바","c언어","파이썬","c++","c#");
    var second1=new Array ("영어","불어","중국어","일본어");
    var second2=new Array ("정보처리기사","컴활","ccna","ccnp");
    
    $("#first").change(function(){				//대분류 소분류의 값을 선택할 수 있도록한다.
    	var selectVal = $("#first").val();
    	var inner = "";
    	
    	if(selectVal == 1){
		for(var i = 0; i < second0.length; i++){
			inner += "<option value="+i+">";
			inner += second0[i];
			inner += "</option>";
		}
		$("#second option").remove();
		$("#second").append(inner);
	}
	
	if(selectVal == 2){
		for(var i = 0; i < second1.length; i++){
			inner += "<option value="+i+">";
			inner += second1[i];
			inner += "</option>";
		}
		$("#second option").remove();
		$("#second").append(inner);
	}
	
	if(selectVal == 3){
		for(var i = 0; i < second2.length; i++){
			inner += "<option value="+i+">";
			inner += second2[i];
			inner += "</option>";
		}
		$("#second option").remove();
		$("#second").append(inner);
	}
	
})		
	


    
  });
