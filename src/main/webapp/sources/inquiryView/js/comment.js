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
					output += "<tr>"
					output += "<td>" + item.m_id + "</td>" 
					output += "<td>" + item.content + "</td>"
					output += + "<td>" +  item.date + "</td>" 
					output += "</tr>";
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
				output += "<div class='comment'>"
				output += "<p>" + item.m_id + "</p>" 
				output += "<p>" + item.content + "</p>"
				output += "<p>" +  item.date + "</p>"
				output += "</div> " 
				$(".container").append(output);
			})
		}
	});
	};
})