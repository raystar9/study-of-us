	$(function (){
		$('form').submit(function() {
			$.ajax({
			url: '/study-of-us/sources/pwfind/section.jsp',
			type: 'post',
			dataType : 'text',
			success : function(data) {
				$('#result').html(data);
			}
			});
		});
	});
	