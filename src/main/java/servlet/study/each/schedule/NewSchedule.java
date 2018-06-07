package servlet.study.each.schedule;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beansNew.Meeting;
import dateConverter.DateConverter;
import fakeDB.FakePoster;
import param.ParameterGetter;

/**
 * Servlet implementation class NewSchedule
 */
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
		request.getRequestDispatcher(request.getAttribute("eachStudyPath") + "/schedule/new-schedule.jsp").forward(request, response);
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
		HashMap<String, String> map = ParameterGetter.get(request);
		
		Meeting meeting = new Meeting();
		ParameterGetter.get(request).get("date");
		Date dateIn = DateConverter.convertDateTime(map.get("date") + 'T' + map.get("time") + ":00");
		meeting.setDate(dateIn);
		meeting.setPlace((String) map.get("location"));
		meeting.setComment("안녕!");
		meeting.setExpectedFee(Integer.parseInt((String)map.get("fee")));
		FakePoster poster = new FakePoster();
		poster.postMeeting(0, meeting);
		//TODO Database 연결 시 위의 두 코드가 합쳐질 예정임.
		
	}
	
}
