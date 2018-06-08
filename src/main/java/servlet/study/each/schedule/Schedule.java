package servlet.study.each.schedule;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.study.each.schedule.ScheduleBean;
import fakeDB.FakeGetter;

/**
 * Servlet implementation class Schedule
 */
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
		String type = "notice";
		if(request.getParameter("type") != null) {
			type = request.getParameter("type");
		}
		FakeGetter getter = new FakeGetter();
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<ScheduleBean> schedules = getter.getSchedule(0);
		if(type.equals("attend")) {
			System.out.println("attend입니다.");
			for(ScheduleBean schedule : schedules) {
				schedule.setUrl("/study-of-us/study/each/attendance/each/record");
			}
			System.out.println(mapper.writeValueAsString(schedules));
			request.setAttribute("schedules", mapper.writeValueAsString(schedules));
		}else if(type.equals("notice")) {
			
			System.out.println(mapper.writeValueAsString(schedules));
			for(ScheduleBean schedule : schedules) {
				schedule.setUrl("/study-of-us/study/each/schedule/each");
			}
			request.setAttribute("schedules", mapper.writeValueAsString(schedules));
		}
		request.getRequestDispatcher("/study/each/schedule.jsp").forward(request, response);
	}

}
