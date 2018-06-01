$().ready(()=>{
	
	$("form").submit(e=>{
		e.preventDefault();
		$.ajax({
			url: "./confirm",
			method: "post",
			data: $("form").serialize(),
			success: (result)=>{
				location.href='/study-of-us/study/each/schedule';
				
			}
		});
	});
});