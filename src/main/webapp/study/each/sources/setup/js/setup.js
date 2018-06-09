$(document).ready(function() {
	
	var categoryGroup = $('#category1').val();
	var categorySub = $('#category2').val();
	
	$('#categoryGroup').val(categoryGroup).prop("selected", true);
	$('#categorySub').val(categorySub).prop("selected", true);
	
	$('#submittbtn').click(function() {
		var result = confirm("스터디 설정을 수정하시겠습니까?");
		if(result == true){
			$(".setupForm").submit();
		}else{
			return false;
		}
		
	});// click end
	
})// ready end