//스터디 등록
package servlet.study;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.prototype.Study;
import dateConverter.DateConverter;
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/Registration.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Study study = new Study();
		study.setName(request.getParameter("name"));
		study.setC_id(Integer.parseInt(request.getParameter("first")));
		Date date = DateConverter.convertDate(request.getParameter("day1"));
		study.setStart(date);
		study.setStart(request.getParameter("day2"));
		
	}

}
