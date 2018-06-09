$(document).ready(function() {
	$('#submittbtn').click(function() {
		var result = confirm("게시글을 작성하시겠습니까?");
		if(result == true){
			$(".boardform").submit();
		}else{
			return false;
		}
		
	});// click end
	
})// ready end
