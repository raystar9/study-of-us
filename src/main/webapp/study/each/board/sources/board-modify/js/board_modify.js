$(function() {
	var bno = $('#bno').val();
	$('#modifyBtn').click(function() {
		var result = confirm("게시글을 수정하시겠습니까?");
		if(result == true){
			$(".boardModify").submit();
		}else{
			return false;
		}
	});//click()
	
});