package servlet.study.each.attendance;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.prototype.Member;
import fakeDB.FakeDB;

/**
 * Servlet implementation class Attendance
 */
@WebServlet("/study/each/attendance/each")
public class Attendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Attendance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FakeDB db = FakeDB.getInstance();
		ArrayList<Member> members = db.getMembers();
		request.setAttribute("members", members);
		request.getRequestDispatcher("/study/each/attendance/record.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("데이터를 넣어줌!");
	}
	
}
