
  $(document).ready(function() {
    var a = $('#calendar').fullCalendar({
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month,basicWeek,basicDay'
      },
      timeFormat: 'a h:mm',
      navLinks: true, // can click day/week names to navigate views
      eventLimit: true, // allow "more" link when too many events
      events: eventList
      
    })
  });
