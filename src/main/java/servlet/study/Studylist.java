package servlet.study;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.prototype.StudyList;
import dao.DataGetter;
import dao.DataPoster;
import dao.DatabaseAccounts;

/**
 * Servlet implementation class Studylist
 */
@WebServlet("/study/Studylist")
public class Studylist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Studylist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Get 방식");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("스터디 인덱스" + request.getParameter("s_index"));
		System.out.println("멤버 인덱스" +request.getParameter("m_index"));
		int s_index = Integer.parseInt(request.getParameter("s_index"));
		int m_index = Integer.parseInt(request.getParameter("m_index"));
		
		DataGetter getter = new DataGetter(DatabaseAccounts.SCOTT);
		DataPoster poster = new DataPoster(DatabaseAccounts.SCOTT);
		
		ArrayList<StudyList> study = poster.Insertindex(s_index,m_index);
		
		
	}

}
