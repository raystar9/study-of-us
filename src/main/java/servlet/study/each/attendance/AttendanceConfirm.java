package servlet.study.each.attendance;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beansNew.Attend;
import dao.DataGetter;
import dao.DataPoster;
import dao.DatabaseAccounts;

/**
 * Servlet implementation class AttendanceConfirm
 */
@WebServlet("/study/each/attendance/each/confirm")
public class AttendanceConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttendanceConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int meetingId = Integer.parseInt((String) request.getAttribute("meetingId"));
		
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		if(getter.isAttendChecked(meetingId)) {
			request.getRequestDispatcher("/study/each/attendance/each/already-confirm.jsp").forward(request, response);
		} else {
			ArrayList<String> names = getter.getMemberNames((String)request.getAttribute("studyName"));
			request.setAttribute("names", names);
			request.getRequestDispatcher("/study/each/attendance/each/confirm.jsp").forward(request, response);
		}
		getter.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		ArrayList<Integer> memberIndexes = getter.getMemberIndexes((String)request.getAttribute("studyName"));
		getter.close();
		
		
		System.out.println();
		DataPoster poster = new DataPoster(DatabaseAccounts.PROJECT);
		ArrayList<Attend> attends = new ArrayList<>();
		int i = 0;
		for(int memberIndex : memberIndexes) {
			attends.add(new Attend(Integer.parseInt((String)request.getAttribute("meetingId")), memberIndex, (String)request.getParameter("member"+i)));
			System.out.println(memberIndex);
			i++;
		}
		
		poster.postAttend(attends);
		
		poster.close();
		System.out.println("데이터를 넣어줌!");
	}

}
