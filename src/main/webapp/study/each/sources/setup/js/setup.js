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
		
	});// click() end
	
})// ready() end

function chageCategory(){
	var category1 = $('#categoryGroup').val();
	
	$('#categorySub').empty();
	$.ajax({ url : '/study-of-us/setupcategory',
		 type : 'post',
		 data : {"category1" : category1},
			success : function(data) {
				var a = '';
				$.each(JSON.parse(data), function(index, value) {
					a += '<option value=' + value + '>' + value + '</option>';
				});

				$("#categorySub").html(a);
			}
		});
	
}// changeCategory() end