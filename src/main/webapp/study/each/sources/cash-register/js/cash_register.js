
$(document).ready(function() {
	
	var addNum = 2;
	$('#cashAdd-btn').click(function() {
		var strToAdd = "<tr><td>";
			strToAdd += "<input type='text' class='form-control' placeholder='내역' id='dues-exp' name='duesExp" + addNum + "'>";
			strToAdd += "</td>";
			strToAdd += "<td>";
			strToAdd += "<input type='text' class='form-control' placeholder='금액' id='dues-expfee' name='duesExpFee" + addNum + "' onkeyup='calculate();'>";
			strToAdd += "</td></tr>";
			addNum++;
		$('#expenseCount').val(addNum);
		$('#cash_tbody').append(strToAdd);	
	})// click end
	$('#submittbtn').click(function() {
		var result = confirm("회비는 수정 또는 삭제를 할 수 없습니다. 등록하시겠습니까?");
		if(result == true){
			$(".cashRegisterForm").submit();
		}else{
			return false;
		}
		
	});// click end
	
	
})// ready end

function calculate(){	// onkeyup 발생 함수 (자동계산)
	var duesFee = 0;	
	var duesExpFee = 0;	
	var duesFee_sum = 0;	
	var duesExpFee_sum = 0;	
	document.getElementById("dues-final").value = parseInt(100000);
	
	for(var i=1; i<= $('#dues-table tbody tr').length; i++){
		duesFee = document.getElementById('duesFee'+i).value;
		if(isNaN(parseInt(duesFee))){
			duesFeee = 0;
		}
		duesFee_sum += parseInt(duesFee);
	}
	
	for(var i=1; i<= $('#total-table tbody tr').length; i++){
		duesExpFee = document.getElementById('duesExpFee'+i).value;
		if(isNaN(parseInt(duesExpFee))){
			duesExpFee = 0;
		}
		duesExpFee_sum += parseInt(duesExpFee);
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

