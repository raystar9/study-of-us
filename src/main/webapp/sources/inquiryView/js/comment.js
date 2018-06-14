$(document).ready(function() {

		selectData();
	
	$("#insert_form").submit(function(event) {
		var data1 = $(this).serialize();
		$.ajax({
			type : "POST",
			data : data1,
			url : "/study-of-us/comment",
			success : function(comment) {
				$("#comment").val("")
			}
		});
		$('.comment').empty();
		selectData();
		event.preventDefault();
	})
	function selectData(){
		$.ajax({
		type : "GET",
		url : "/study-of-us/comment",
		success : function(comment){
			$.each(JSON.parse(comment), function(index, item){
				var output = '';
				if(item.m_id == 'admin'){
					output +=  "<tr class='whiteTr'>"
					output +=  "<td>" + "<font color='blue' style='width:20%'>" + item.m_id+"</font>"    
					output +=   "<td style='width: 50%;'>"+item.content +"</td>"   
					output +=   "<td style='width: 50%;'>" + item.date + "</td>" 
					output +=  "</tr>"
						$(".comment").append(output);
				}else{
				output +=  "<tr class='whiteTr'>"
				output +=  "<td style='width: 20%; background-color : white;'>" + item.m_id+"</td>"
				output +=  "<td style='width: 50%; background-color : white;'>" + item.content   +"</td>"
				output +=  "<td style='width: 30%; background-color : white;'>" + item.date +"</td>"
				output +=  "</tr>"
				$(".comment").append(output);
				}
			})
		}
	});
	};
})