
$(document).ready(function() {
	
	$sql = "select M_NAME, M_TEL, M_EMAIL from member";
	
	
	
	
	
	
	
	
	
	
	var personNum = parseInt(3);	//스터디 안의 
	
	for(var i=1; i<=personNum; i++){
		var strToAdd = "<tr><td>";
		strToAdd += i + "</td>";
		strToAdd += "<td>";
		strToAdd += "<input type='text' class='form-control' placeholder='내역' id='dues-exp' name='duesExp'>";
		strToAdd += "</td>";
		strToAdd += "<td>";
		strToAdd += "<input type='text' class='form-control' placeholder='금액' id='dues-expfee' name='duesExpFee' onkeyup='calculate();'>";
		strToAdd += "</td></tr>";
	}
$('#cash_tbody').append(strToAdd);	
})// ready end