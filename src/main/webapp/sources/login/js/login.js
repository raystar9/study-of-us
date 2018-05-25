$(function(){
	('#submit').click(function(){
		if($(requestScope.login))
		$('#message').load("loginFail.jsp")
	})
})