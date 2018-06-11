package servlet.study.each.attendance;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.study.each.attendacne.MemberAttendanceBean;
import dao.DataGetter;
import dao.DatabaseAccounts;

/**
 * Servlet implementation class Attendance
 */
@WebServlet("/study/each/attendance/each/record")
public class AttendanceEach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttendanceEach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int meetingId = (int) request.getAttribute("meetingId");
		String studyName = (String) request.getAttribute("studyName");
		
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		ArrayList<MemberAttendanceBean> attendance = getter.getAttends((String)request.getAttribute("studyName"));
		request.setAttribute("attendance", attendance);
		getter.close();
		request.getRequestDispatcher("/study/"+studyName+"/attendance/"+meetingId+"/record.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("데이터를 넣어줌!");
	}
	
}
