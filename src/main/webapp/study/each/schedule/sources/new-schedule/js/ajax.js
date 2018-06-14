$().ready(()=>{
	$("form").submit(e=>{
		e.preventDefault();
		$.ajax({
			url: "./new",
			method: "post",
			data: $("form").serialize(),
			success: function(){
				alert("성공적으로 등록되었습니다.");
				location.href="../schedule";
			},
			error: function(){
				alert('오류가 발생했습니다.');
			}
		})
	});
});