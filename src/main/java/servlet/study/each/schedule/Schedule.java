package servlet.study.each.schedule;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.study.each.schedule.ScheduleBean;
import dao.DataGetter;
import dao.DatabaseAccounts;
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
		String studyName = (String)request.getAttribute("studyName");
		if(request.getParameter("type") != null) {
			type = request.getParameter("type");
		}
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<ScheduleBean> schedules = getter.getSchedules(studyName);
		getter.close();
		if(type.equals("attend")) {
			System.out.println("attend입니다.");
			for(ScheduleBean schedule : schedules) {
				schedule.setUrl("/study-of-us/study/"+studyName+"/attendance/"+schedule.getId()+"/record");
			}
			System.out.println(mapper.writeValueAsString(schedules));
			request.setAttribute("schedules", mapper.writeValueAsString(schedules));
		}else if(type.equals("notice")) {
			
			System.out.println(mapper.writeValueAsString(schedules));
			for(ScheduleBean schedule : schedules) {
				schedule.setUrl("/study-of-us/study/"+studyName+"/schedule/" + schedule.getId());
			}
			request.setAttribute("schedules", mapper.writeValueAsString(schedules));
		}else if(type.equals("fee")) {
			
			System.out.println(mapper.writeValueAsString(schedules));
			for(ScheduleBean schedule : schedules) {
				schedule.setUrl("/study-of-us/study/"+request.getAttribute("studyName")+"/fee/" + schedule.getId() + "/register");
			}
			request.setAttribute("schedules", mapper.writeValueAsString(schedules));
		}
		request.getRequestDispatcher("/study/each/schedule.jsp").forward(request, response);
	}

}
