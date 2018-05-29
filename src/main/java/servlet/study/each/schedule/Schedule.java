package servlet.study.each.schedule;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.prototype.Meeting;
import beans.study.each.schedule.ScheduleBean;
import fakeDB.FakeDB;

/**
 * Servlet implementation class Schedule
 */
@WebServlet("/study/each/schedule")
public class Schedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Schedule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<Meeting> meetings = FakeDB.getInstance().getMeetings();
		ArrayList<ScheduleBean> schedules = new ArrayList<>();
		for(Meeting meeting : meetings) {
			ScheduleBean s = new ScheduleBean();
			s.setStart(meeting.getDate());
			s.setTitle(meeting.getLocation());
			s.setUrl("1");
			schedules.add(s);
		}
		System.out.println(mapper.writeValueAsString(schedules));
		request.setAttribute("schedules", mapper.writeValueAsString(schedules));
		
		request.getRequestDispatcher("schedule.jsp").forward(request, response);
	}

}
