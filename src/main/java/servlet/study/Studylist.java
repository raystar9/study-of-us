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
import beans.study.each.Message;
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
		int s_m_index = Integer.parseInt(request.getParameter("s_m_index"));
		String s_name = request.getParameter("s_name");
		
		String m_id = (String) request.getSession().getAttribute("id");
		
		
		System.out.println("스터디장 인덱스 : " + s_m_index);
		System.out.println("스터디 이름 : " + s_name);
		System.out.println("스터디 신청자 : " + m_id);
		
		
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		DataPoster poster = new DataPoster(DatabaseAccounts.PROJECT);
		
		
		response.setContentType("text/html;charset=utf-8");

		ArrayList<Message> StudyList = new ArrayList<>();
		
		// 메세지 부분 (문혁) 메세지 값 넣기
		poster.setMessage(s_m_index, m_id, s_name, m_index);


		StudyList = getter.studyMessage(s_m_index, m_index);
		int result = StudyList.size();

		
		if(result == 1) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('이미 신청을 하셨습니다.');");
			out.println("history.back()");
			out.println("</script>");
			poster.close();
			getter.close();
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('참여신청에 성공 했습니다.');");
			out.println("location.href = '/study-of-us/study/list' ");
			out.println("</script>");
			getter.close();
			poster.close();
		}
		
	}

}
