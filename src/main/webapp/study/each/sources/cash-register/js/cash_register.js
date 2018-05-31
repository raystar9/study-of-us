
$(document).ready(function() {
	
	var addNum = 1;
	$('#cashAdd-btn').click(function() {
		var strToAdd = "<tr><td>";
			strToAdd += "<input type='text' class='form-control' placeholder='내역' id='dues-exp' name='duesExp'>";
			strToAdd += "</td>";
			strToAdd += "<td>";
			strToAdd += "<input type='text' class='form-control' placeholder='금액' id='dues-expfee' name='duesExpFee' onkeyup='calculate();'>";
			strToAdd += "</td></tr>";
			
		$('#cash_tbody').append(strToAdd);	
	})// click end
	
})// ready end

function calculate(){	// onkeyup 발생 함수 (자동계산)
	var duesFee = 0;	
	var duesExpFee = 0;	
	var duesFee_sum = 0;	
	var duesExpFee_sum = 0;	
	document.getElementById("dues-final").value = parseInt(100000);
	
	for(var i=0; i< $('#dues-table tbody tr').length; i++){
		duesFee = document.getElementsByName('duesFee')[i];
		if(isNaN(parseInt(duesFee.value))){
			duesFee.value = 0;
		}
		duesFee_sum += parseInt(duesFee.value);
	}
	
	for(var i=0; i<$('#total-table tbody tr').length; i++){
		duesExpFee = document.getElementsByName('duesExpFee')[i];
		if(isNaN(parseInt(duesExpFee.value))){
			duesExpFee.value = 0;
		}
		duesExpFee_sum += parseInt(duesExpFee.value);
	}
	
	document.getElementById("dues-totalFee").value = parseInt(duesFee_sum);
	if(isNaN(document.getElementById("dues-totalFee").value)){
		document.getElementById("dues-totalFee").value = 0;
	}
	document.getElementById("dues-totalExpen").value = parseInt(duesExpFee_sum);
	if(isNaN(document.getElementById("dues-totalExpen").value)){
		document.getElementById("dues-totalExpen").value = 0;
	}
	
	var totalFee = parseInt(document.getElementById('dues-totalFee').value);
	var totalExpen = parseInt(document.getElementById('dues-totalExpen').value);
	document.getElementById("dues-total").value = totalFee - totalExpen;
	document.getElementById("dues-final").value = parseInt(document.getElementById("dues-total").value) 
												+ parseInt(document.getElementById("dues-final").value);
													
}// calculation end

