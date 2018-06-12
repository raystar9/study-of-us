package servlet.study.each;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.prototype.Member;
import beans.prototype.Study;
import beans.study.each.Message;
import dao.DataGetter;
import dao.DataPoster;
import dao.DatabaseAccounts;

@WebServlet("/study/each/participate")
public class Participate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Participate() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
	
		System.out.println(request.getSession().getAttribute("id"));
		if(request.getSession().getAttribute("id") == null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('참여는 로그인 후에 이용 가능합니다.');");
			out.println("history.back()");
			out.println("</script>");
		}else {
			int index = Integer.parseInt(request.getParameter("index"));
			ArrayList<Study> study = getter.getStudies(index); // 인덱스번호를 통해 선택된 스터디를 찾음
			request.setAttribute("study", study);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/participate.jsp");
			dispatcher.forward(request, response);
		}
	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		int s_index = Integer.parseInt(request.getParameter("s_index"));
		int m_index = Integer.parseInt(request.getParameter("m_index"));
		int s_m_index = Integer.parseInt(request.getParameter("s_m_index"));
		String s_name = request.getParameter("s_name");

		String m_id = (String) request.getSession().getAttribute("id");


		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		DataPoster poster = new DataPoster(DatabaseAccounts.PROJECT);

		response.setContentType("text/html;charset=utf-8");

		ArrayList<Message> StudyList = new ArrayList<>();
		ArrayList<Member> StudyID = new ArrayList<>();

		StudyID = getter.getStudy_m_id(s_m_index);
		StudyList = getter.studyMessage(s_m_index, m_index);
		int result = StudyList.size();
		// 메세지 부분 (문혁) 메세지 값 넣기
		System.out.println("아이디값은? " + StudyID.get(0).getId());
		System.out.println(result + "result 값");
		

		System.out.println("스터디 인덱스 : " + s_index);
		System.out.println("스터디장 인덱스 : " + s_m_index);
		System.out.println("스터디 신청자 : " + m_id);
		System.out.println("스터디 이름 : " + s_name);
		System.out.println("멤버 인덱스" + request.getParameter("m_index"));

		if (result == 1) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('이미 신청을 하셨습니다.');");
			out.println("history.back()");
			out.println("</script>");
			poster.close();
			getter.close();
		} else if (StudyID.get(0).getId().equals(m_id)) {

			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('자신이 만든 스터디입니다.');");
			out.println("history.back()");
			out.println("</script>");
			poster.close();
			getter.close();
		} else {
			poster.setMessage(s_index, s_m_index, m_id, s_name, m_index);
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
