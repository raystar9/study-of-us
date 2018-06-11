$(document).ready(function() {

	$("#insert_form").submit(function(event) {
		var data1 = $(this).serialize();
		alert(data1)
		$.ajax({
			type : "POST",
			data : data1,
			url : "/study-of-us/comment",
			success : function(comment) {
				$("#comment").val("")
			}
		});
		/*$('#output').empty();*/
		selectData();
		event.preventDefault();
	})
})

	function selectData(){
			$.ajax({
			type : "GET",
			url : "/study-of-us/comment",
			success : function(comment){
				$("#output").append(comment);
				$(comment).empty();
			}
		});
		};