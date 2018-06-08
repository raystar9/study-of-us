package servlet.study.each.schedule;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.prototype.Meeting;
import beans.study.each.schedule.ScheduleBean;
import dateConverter.DateConverter;
import fakeDB.FakeDB;

/**
 * Servlet implementation class NewSchedule
 */
@WebServlet("/study/each/schedule/new")
public class NewSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewSchedule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("new-schedule.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*TODO 데이터베이스 연결부분.
		DataPoster poster = new DataPoster(DatabaseAccounts.SCOTT);
		Meeting meeting = new Meeting();
		
		poster.postMeeting(meeting);
		
		poster.close();
		*/
		ArrayList<ScheduleBean> schedules = FakeDB.getInstance().getSchedules();
		
		Meeting m = new Meeting();
		Date dateIn = DateConverter.convertDateTime((String)request.getAttribute("date") + 'T' + (String)request.getAttribute("time") + ":00");
		m.setDate(dateIn);
		m.setLocation((String) request.getAttribute("location"));
		FakeDB.getInstance().setMeeting(m);
		
		ScheduleBean s = new ScheduleBean();
		s.setStart(DateConverter.getDateString(m.getDate()));
		s.setTitle(m.getLocation());
		//TODO 추후에 schedule번호로 수정해야함.
		s.setUrl("/study-of-us/study/each/schedule/each");
		schedules.add(s);
		//TODO Database 연결 시 위의 두 코드가 합쳐질 예정임.
		
	}

}
