//스터디 등록
package servlet.study.each;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
import dao.interfaces.DataGettable;
import dao.interfaces.DataSettable;
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
		 
		Study study = new Study();
		System.out.println("데이1" + request.getParameter("day1"));
		System.out.println("데이2" + request.getParameter("day1"));
		
		Date date = DateConverter.convertDate(request.getParameter("day1"));
		Date date2 = DateConverter.convertDate(request.getParameter("day2"));
		study.setC_id(Integer.parseInt(request.getParameter("first")));
		study.setName(request.getParameter("study_name"));
		study.setStart(date);
		study.setEnd(date2);
		study.setPeoplenum(Integer.parseInt(request.getParameter("people")));
		study.setDay(request.getParameter("day"));
		study.setTime(request.getParameter("stime"));
		study.setExplain(request.getParameter("explain"));
		study.setPrepared(request.getParameter("prepared"));
		study.setEffective(request.getParameter("activity"));
		study.setPlace(request.getParameter("location"));
		DataPoster poster = new DataPoster(DatabaseAccounts.ADMIN);
		
		
		
		int result = poster.postStudy(study);
		
		
		System.out.println("리절트 값 ㅡㅡ " + result);
		
		
	
		
		
		
		
		//스터디 인덱스 뽑아오고 
		DataGetter getter = new DataGetter(DatabaseAccounts.ADMIN);
		Study index = getter.getSindex();
		
		
		int s_index = index.getIndex();
		
		
		
		
		HttpSession session = request.getSession();
		int m_index = (int)session.getAttribute("index");
		System.out.println("세션으로 받은 m_index : " + m_index);		
		DataPoster poster2 = new DataPoster(DatabaseAccounts.ADMIN);
		
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

