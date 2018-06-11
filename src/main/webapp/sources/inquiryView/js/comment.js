$(document).ready(function() {

		selectData();
	
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
		$('.container').empty();
		selectData();
		event.preventDefault();
	})


/*	function selectData(){
			$.ajax({
			type : "GET",
			url : "/study-of-us/comment",
			success : function(comment){
				$.each(JSON.parse(comment), function(index, item){
					var output = ''; 
					output += "<span>"
					output +=  item.m_id
					output +=  item.content
					output +=  item.date 
					output += '</span><br>';
					$(".container").append(output);
				})
			}
		});
		};*/
	
	
	
	function selectData(){
		$.ajax({
		type : "GET",
		url : "/study-of-us/comment",
		success : function(comment){
			$.each(JSON.parse(comment), function(index, item){
				var output = ''; 
				output +=  "<p>" + item.content +"</p>"
				output +=  "<span class='time-right'>" + item.date + "</span><br>"
				$(".container").append(output);
			})
		}
	});
	};
})