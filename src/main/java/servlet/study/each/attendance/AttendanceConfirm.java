package servlet.study.each.attendance;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beansNew.Member;
import fakeDB.FakeDB;

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
		FakeDB db = FakeDB.getInstance();
		ArrayList<Member> members = db.getStudies().get(0).getMembers();
		request.setAttribute("members", members);
		request.getRequestDispatcher("/study/each/attendance/each/confirm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FakeDB db = FakeDB.getInstance();
		/*Enumeration<String> names = request.getAttributeNames();
		while(names.hasMoreElements()) {
			//TODO 보여줄 수준만 구현해둠. 추가 구현해야함.
			Attend attend = new Attend();
			String name = names.nextElement();
			attend.setAttend(names.);
			db.addAttendances(attendance);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		response.getOutputStream().print(mapper.writeValueAsString(db.getAttendances()));*/
		System.out.println("데이터를 넣어줌!");
	}

}
