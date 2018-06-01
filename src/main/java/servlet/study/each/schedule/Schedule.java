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

		String type = null;
		if(request.getParameter("type") == null) {
			type = "notice";
		} else {
			type = request.getParameter("type");
		}
		if(type.equals("attend")) {
			System.out.println("attend입니다.");
			//TODO 데이터베이스에서 attendance 링크를 받아와서 attribute로 넘겨줘야함
			request.getRequestDispatcher("schedule.jsp").forward(request, response);
		}else if(type.equals("notice")) {
			ObjectMapper mapper = new ObjectMapper();
			ArrayList<ScheduleBean> schedules = FakeDB.getInstance().getSchedules();
			
			System.out.println(mapper.writeValueAsString(schedules));
			request.setAttribute("schedules", mapper.writeValueAsString(schedules));
			
			request.getRequestDispatcher("schedule.jsp").forward(request, response);
		}
		
	}

}
