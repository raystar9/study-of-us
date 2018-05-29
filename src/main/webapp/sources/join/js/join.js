$(document).ready(function() {
	var check = 0;
	var overlap = false;
	
	$('form').submit(function() {
		sid2 = $("input[name=id]").val();
		
		if(check == 0 || sid != sid2){
			alert('중복체크를 해주세요');
			return false;
		}
		
		
		if(overlap == false ){
			alert("아이디중복입니다");
			return false;
		}
		
		
		
	//유효성검사	
		
		if ($('#id').val() == "") {
			alert("아이디를 입력하세요");
			return false;
		}
		if ($('#password').val() == "") {
			alert("비밀번호를 입력하세요");
			return false;
		}

		if ($('#password2').val().length < 7 || $('#password').val().length > 13) {
			alert("비밀번호는 7자리이상 12자리 이하로 입력되어야합니다.");
			return false;
		}
		
		
		
		if ($('#password').val() !=  $("#password2").val()) {
			alert("비밀번호를 확인해주세요");
			return false;
		}
		
		if ($('#name').val() == '') {
			alert("이름을 입력하세요");
			return false;
		}

		if ($('#email').val() == '') {
			alert("이메일을 입력하세요");
			return false;
			// 이메일 change 이용해서 도메인 값 넣어주기			//확인해야함 
		}
		
		
		if ($('#tel').val() == '') {
			alert("전화번호를 입력하세요");
			return false;
			// 이메일 change 이용해서 도메인 값 넣어주기			//확인해야함 
		}

		
		//라디오 버튼
		if ($('input:radio:checked').length < 1) {
			alert("성별을 선택해주세요");
			return false;
		}

		if ($('#introduce').val() == '') {
			alert("자기소개를 입력해주세요");
			return false;
		}
	
	})
	
	
	//ajax
	$("#idcheck").click(function(){
		check++;
		sid = $('input[name=id]').val();
		alert(sid);
		$.ajax({
			type : "GET",
			url : "/study-of-us/IdCheck",
			data : {
				"id" : $("input[name=id]").val()
			},
			success : function(result){
				check = result;
				//비워주고 
				$("#place").empty();
				if(result == -1){
					$("#place").append("아이디 사용 가능합니다.")
					$("#place").css("color","blue")
					overlap = true;
				}else{
					$("#place").append("중복된 아이디입니다.")
					$("#place").css("color","red");
					overlap = false;
				}
				alert(result);
					
			}
		})
	})
	
	$("input[type=checkbox]").each(function(){
		$(this).change(function(){
			/*var a = $(this).val()
			alert(a);*/
			$("input[type=checkbox]").prop("checked",false)
			$(this).prop("checked",true)
		})
	})

	
	$("#password").keyup(function(){
		$("font[name=check]").text("");
		if($("#password").val() != $("#password2").val()){
			if($("#password2").val() == ""){
				$("font[name=check]").text("");	
			}else{
			$("font[name=check]").text("");
			$("font[name=check]").html("비밀번호가 일치하지 않습니다");
			$("font[name=check]").css("color","red");
			}
		}
	});
	$("#password2").keyup(function(){
		if($("#password").val() != $("#password2").val()){
			$("font[name=check]").text("");
			$("font[name=check]").html("비밀번호가 일치하지 않습니다");
			$("font[name=check]").css("color","red");
		}else{
			$("font[name=check]").text("");
			$("font[name=check]").html("비밀번호 일치");
			$("font[name=check]").css("color","blue");
		}
	})
	

	$('#tel').keyup(function() {
		if (isNaN($('#tel').val())) {
			alert("전화번호는 숫자만 입력 가능합니다.")
			$('#tel').val("")
		}
	})
})

