$(document).ready(function() {
	
	var categoryGroup = $('#category1').val();
	var categorySub = $('#category2').val();
	
	$('#categoryGroup').val(categoryGroup).prop("selected", true);
	$('#categorySub').val(categorySub).prop("selected", true);
	
})// ready end