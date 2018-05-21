  $( function() {
    $( "#day1,#day2" ).datepicker({
   	monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
    dayNamesMin: ['일','월','화','수','목','금','토'],
     dateFormat: "yy년mm월dd일",
      changeYear: true,
      changeMonth: true
    });
  });