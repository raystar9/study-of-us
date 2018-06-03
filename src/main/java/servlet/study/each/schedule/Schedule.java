package servlet.study.each.schedule;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.study.each.schedule.ScheduleBean;
import beansNew.Meeting;
import dao.DataGetter;
import fakeDB.FakeDB;
import fakeDB.FakeGetter;

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
		String type = "notice";
		if(request.getParameter("type") != null) {
			type = request.getParameter("type");
		}
		FakeGetter getter = new FakeGetter();
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<ScheduleBean> schedules = getter.getSchedules();
		if(type.equals("attend")) {
			System.out.println("attend입니다.");
			schedules.get(0).setUrl("/study-of-us/study/each/attendance/each");
			System.out.println(mapper.writeValueAsString(schedules));
			request.setAttribute("schedules", mapper.writeValueAsString(schedules));
		}else if(type.equals("notice")) {
			
			System.out.println(mapper.writeValueAsString(schedules));
			schedules.get(0).setUrl("/study-of-us/study/each/schedule/each");
			request.setAttribute("schedules", mapper.writeValueAsString(schedules));
		}
		request.getRequestDispatcher("schedule.jsp").forward(request, response);
	}

}
