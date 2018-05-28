
  $(document).ready(function() {
	  
    $('#calendar').fullCalendar({
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month,basicWeek,basicDay'
      },
      navLinks: true, // can click day/week names to navigate views
      eventLimit: true, // allow "more" link when too many events
      views: {
    	  month: {
    		  timeFormat:"h:mma" // top level of text
    	  },
    	  basicWeek: {
    		  timeFormat:"h:mma"
    	  },
    	  basicDay: {
    		  timeFormat:"h:mma"
    	  }
      }
    });

  });
