
$(document).ready(function() {
	var addNum = 1;
	$('#cashAdd-btn').click(function() {
		var strToAdd = "<tr><td>";
			strToAdd += "<input type='text' class='form-control' placeholder='내역' id='dues-exp' name='duesExp'>";
			strToAdd += "</td>";
			strToAdd += "<td>";
			strToAdd += "<input type='text' class='form-control' placeholder='금액' id='dues-expfee' name='duesExpfee' onkeyup='calculate();'>";
			strToAdd += "</td></tr>";
			
		$('#cash_tbody').append(strToAdd);	
	})// click end
	
	
})// ready end

function calculate(){	// onkeyup 발생 함수
	var duesFee_sum;	
	var duesFee;	
	var duesExpFee_sum;	
	var duesExpFee;	
	
	for(var i=0; i< $('#dues-table tbody tr').length; i++){
		duesFee = document.getElementsByName('duesFee')[i].value;
		if(!isNumeric(duesFee)){
			duesFee = 0;
		}
		duesFee_sum += parseInt(duesFee.value);
	}
	for(var i=0; i<$('#total-table tbody tr').length; i++){
		duesExpFee_sum += parseInt(document.getElementsByName('duesExpfee')[i].value);
		alert(parseInt(document.getElementsByName('duesExpfee')[i].value));
	}
	
	document.getElementById("dues-totalFee").value = parseInt(duesFee_sum);
	document.getElementById("dues-totalExpen").value = parseInt(duesExp_sum);
	
	var totalFee = parseInt(document.getElementById('dues-totalFee').value);
	var totalExpen = parseInt(document.getElementById('dues-totalExpen').value);
	
	document.getElementById("dues-total").value = totalFee + totalExpen;
													
	
}// calculation end

