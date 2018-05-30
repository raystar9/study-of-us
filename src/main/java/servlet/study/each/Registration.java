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
		Study study = new Study();
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
		poster.postStudy(study);
		
		//try catch 문 실행
		poster.close();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/list.jsp");
		dispatcher.forward(request, response);
	}
}

