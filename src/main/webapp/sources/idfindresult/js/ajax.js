	$(function (){
		$('form').submit(function() {
			$.ajax({
			url: '/study-of-us/sources/idfind/section.jsp',
			type: 'post',
			dataType : 'text',
			success : function(data) {
				$('#result').html(data);
			}
			});
		});
	});
	