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


	function selectData(){
			$.ajax({
			type : "GET",
			url : "/study-of-us/comment",
			success : function(comment){
				alert(comment)
				var a = "";
				$.each(JSON.parse(data), function(value){
					a += '<div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
					a += '작성자 : ' + this.m_id + '  날짜: ' + this.date;
					a += '<p> 내용 : '+ this.content + '</p>';
					a += '</div><br>';
				})
				$("#output").html(a);
			}
		});
		};
})