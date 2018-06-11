package servlet.study.each.schedule;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beansNew.Meeting;
import dao.DataGetter;
import dao.DataPoster;
import dao.DatabaseAccounts;
import dateConverter.DateConverter;
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
		request.getRequestDispatcher("/study/each/schedule/new-schedule.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studyName = (String)request.getAttribute("studyName");
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		int studyIndex = getter.getStudyIndex(studyName);
		getter.close();
		HashMap<String, String> map = ParameterGetter.get(request);
		
		Meeting meeting = new Meeting();
		ParameterGetter.get(request).get("date");
		System.out.println(map.get("date") + ' ' + map.get("time"));
		
		Timestamp dateIn = DateConverter.convertDateTime(map.get("date") + 'T' + map.get("time"));
		
		meeting.setTimestampate(dateIn);
		meeting.setStudyId(studyIndex);
		meeting.setPlace((String) map.get("location"));
		meeting.setComment((String) map.get("comment"));
		meeting.setExpectedFee(Integer.parseInt((String)map.get("fee")));
		DataPoster poster = new DataPoster(DatabaseAccounts.PROJECT);
		poster.postMeeting(meeting);
		poster.close();
		
	}
	
}
