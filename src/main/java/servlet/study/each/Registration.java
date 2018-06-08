//스터디 등록
package servlet.study.each;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.prototype.Study;
import dao.DataGetter;
import dao.DataPoster;
import dao.DatabaseAccounts;
import dateConverter.DateConverter;
@WebServlet("/study/each/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		 
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		if(id == null) {
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('로그인을 해주세요');");
			out.print("history.back();");
			out.print("</script>");
		}else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
		dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		HttpSession session = request.getSession();
		int m_index = (int)session.getAttribute("index");
		
		Date date = DateConverter.convertDate(request.getParameter("day1"));
		Date date2 = DateConverter.convertDate(request.getParameter("day2"));
		 
		Study study = new Study();
		System.out.println("데이1" + request.getParameter("day1"));
		System.out.println("데이2" + request.getParameter("day1"));
		
		
		study.setName(request.getParameter("study_name"));
		study.setS_c_id(Integer.parseInt(request.getParameter("second")));
		System.out.println("소분류 값 잘받아오는지.. : " + Integer.parseInt(request.getParameter("second")));
		study.setS_m_index(m_index);
		study.setStart(date);
		study.setEnd(date2);
		study.setMaxmember(Integer.parseInt(request.getParameter("people")));
		study.setDay(request.getParameter("day"));
		study.setTime(request.getParameter("stime"));
		study.setExplain(request.getParameter("explain"));
		study.setMaterial(request.getParameter("prepared"));
		study.setEffect(request.getParameter("activity"));
		study.setPlace(request.getParameter("location"));
		DataPoster poster = new DataPoster(DatabaseAccounts.PROJECT);
		
		
		
		int result = poster.postStudy(study);
		
		
		System.out.println("리절트 값 ㅡㅡ " + result);
	
		
		Study index = getter.getSindex();
		int s_index = index.getIndex();
		
		
		//스터디 인덱스 뽑아오고 
		
		System.out.println("세션으로 받은 m_index : " + m_index);
		System.out.println("스터디의 인덱스 값 : " +  s_index);
		
		
		DataPoster poster2 = new DataPoster(DatabaseAccounts.PROJECT);
		
		//studyList 에 담아준다 
		poster2.postStudyList(m_index , s_index);
		
		
		//try catch 문 실행
		poster.close();
		poster2.close();
		getter.close();
		
		if(result == 1) {
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('스터디 생성이 완료되었습니다 ^^');");
			out.print("location.href='/study-of-us/study/list';");
			out.print("</script>");
		/*response.sendRedirect("/study-of-us/study/list");*/
		}
		/*RequestDispatcher dispatcher = request.getRequestDispatcher("/study-of-us/study/list");
		dispatcher.forward(request, response);*/
		
	}
}

