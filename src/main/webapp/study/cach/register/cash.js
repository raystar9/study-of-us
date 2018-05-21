
$(document).ready(function() {
	let addNum = 1;
	$('#cashAdd_btn').click(function() {
		++addNum;
		var strToAdd = "<tr><td>";
			strToAdd += "<input type='text' class='form-control' placeholder='내역' id='dues-exp" + addNum + "' name='duesExp" + addNum + "'>";
			strToAdd += "</td>";
			strToAdd += "<td>";
			strToAdd += "<input type='text' class='form-control' placeholder='금액' id='dues-expfee" + addNum + "' name='duesExpFee" + addNum + "'>";
			strToAdd += "</td></tr>";
			
		$('#cash_tbody').append(strToAdd);	
	})// click end
})// ready end

