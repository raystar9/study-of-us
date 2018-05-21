
$(document).ready(function() {
	let idNum = 1;
	$('#cashAdd_btn').click(function() {
		++idNum;
		var strToAdd = "<tr><td>";
			strToAdd += "<input type='text' class='form-control' placeholder='내역' id='cash_content" + idNum + "'>";
			strToAdd += "</td>";
			strToAdd += "<td>";
			strToAdd += "<input type='text' class='form-control' placeholder='금액' id='cash_money" + idNum + "'>";
			strToAdd += "</td></tr>";
			
		$('#cash_tbody').append(strToAdd);	
	})// click end
})// ready end

