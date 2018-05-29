$(document).ready(function() {
	$('form').submit(function() {
		
		if ($('#id').val() == "") {
			alert("아이디를 입력하세요");
			return false;
		}
		if ($('#password').val() == "") {
			alert("비밀번호를 입력하세요");
			return false;
		}

		if ($('#password2').val().length < 7 || $('#pass').val().length > 13) {
			alert("비밀번호는 7자리이상 12자리 이하로 입력되어야합니다.");
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
	
	$("input[type=checkbox]").each(function(){
		$(this).change(function(){
			/*var a = $(this).val()
			alert(a);*/
			$("input[type=checkbox]").prop("checked",false)
			$(this).prop("checked",true)
		})
	})
	
	//sel 직접입력일때는 도메인의 값을 쓸수있게
	//sel 값의 값이 있을때는 못쓰게.
	$('#sel').change(function() {
		if ($('#sel').val() == "") {
			$('#domain').val("").focus()
			$('#domain').attr("disabled", false)
		} else {
			$('#domain').val($("#sel").val())
			$('#domain').attr("disabled", true)
		}
	})

	$('#tel').keyup(function() {
		if (isNaN($('#tel').val())) {
			alert("전화번호는 숫자만 입력 가능합니다.")
			$('#tel').val("")
		}
	})
})

