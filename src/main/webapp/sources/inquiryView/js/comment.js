

$(document).ready(function(){
	
	function selectData(){
		$('#output').empty();
	var data = $("#insert_form").serialize();
		$.getJSON('/study-of-us/comment',data,function(rdata){
		$(rdata).each(function(index,item){
		var output = '';
		output += "<tr>";
		output += "<td>" + item.m_id + "</td>"
		output += "<td>" + item.comment_content + "</td>"
		output += "<td>" + item.comment_date + "</td>"
		output += "</tr>";
		$("#output").append(output)
		});
	});
	};
	
	selectData();
	$('#insert_form').submit(function(event){
		if($("#comment").val() == ""){
			alert('댓글을 입력해주세요');
		return false;
		}
	selectData();
	
	event.preventDefault();
	
	})
})