$().ready(()=>{
	
	$('form').submit(e=>{
		e.preventDefault();
		$.ajax({
			success: ()=>{
				location.href='/study-of-us/study/each/schedule';
			}
		});
	});
});