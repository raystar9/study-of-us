package servlet.study;

import java.io.IOException;
import java.io.PrintWriter;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("스터디 인덱스" + request.getParameter("s_index"));
		System.out.println("멤버 인덱스" +request.getParameter("m_index"));
		int s_index = Integer.parseInt(request.getParameter("s_index"));
		int m_index = Integer.parseInt(request.getParameter("m_index"));
		
		DataGetter getter = new DataGetter(DatabaseAccounts.SCOTT);
		DataPoster poster = new DataPoster(DatabaseAccounts.SCOTT);
		
		
		response.setContentType("text/html;charset=utf-8");

		ArrayList<StudyList> StudyList = new ArrayList<>();
		StudyList = getter.studylist(s_index,m_index);
		int result = StudyList.size();
		
		
		if(result == 1) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('이미 신청을 하셨습니다.');");
			out.println("history.back()");
			out.println("</script>");
		}else {
			
			poster.Insertindex(s_index,m_index);
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('참여신청에 성공 했습니다.');");
			out.println("location.href = '/study-of-us/study/list' ");
			out.println("</script>");
		}
		
	}

}
