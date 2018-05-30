package servlet.study.each.schedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
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
		String queryString = new BufferedReader(new InputStreamReader(request.getInputStream())).readLine();
		System.out.println(queryString);
		//TODO querystring을 attribute로 바꾸는 파트는 controller로 내려갈 예정. 현재 미구현인 관계로 서블릿 내에 포함되어있음.
		String[] splitted = queryString.split("&");
		for(int i = 0; i < splitted.length; i++) {
			String[] keyValue = splitted[i].split("=");
			request.setAttribute(keyValue[0], URLDecoder.decode(keyValue[1], "utf-8"));
		}
		Date date = null;
		System.out.println(date);
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
		s.setUrl(m.getIndex());
		schedules.add(s);
		//TODO Database 연결 시 위의 두 코드가 합쳐질 예정임.
		
	}

}
