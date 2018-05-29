
  $(document).ready(function() {
	  
    $('#calendar').fullCalendar({
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month,basicWeek,basicDay'
      },
      navLinks: true, // can click day/week names to navigate views
      eventLimit: true, // allow "more" link when too many events
      events: eventList,
      timezone: 'Asia/Seoul',
      timeFormat: 'a h:mm'
    });
  });
