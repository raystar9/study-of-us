package servlet.study.each.schedule;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beansNew.Meeting;
import dao.DataGetter;
import dao.DatabaseAccounts;

/**
 * Servlet implementation class EachStudy
 */
@WebServlet("/study/each/schedule/each")
public class EachSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EachSchedule() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studyName = (String) request.getAttribute("studyName");
		int meetingId = Integer.parseInt((String) request.getAttribute("meetingId"));
		
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		Meeting m = getter.getEachSchedules(studyName, meetingId);
		getter.close();
		
		request.setAttribute("meeting", m);
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd a h:mm");
		request.setAttribute("time", format.format(m.getTimestamp().getTime()));
		request.getRequestDispatcher("/study/each/schedule/each.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
