$().ready(()=>{
	$("form").submit(e=>{
		e.preventDefault();
		$.ajax({
			url: "./new",
			method: "post",
			data: $("form").serialize(),
			success: function(){
				alert($("form").serialize());
				location.href="../schedule";
			},
			error: function(){
				alert('오류가 발생했습니다.');
			}
		})
	});
});