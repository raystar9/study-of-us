package servlet.root;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.prototype.Inquiry;
import dao.DataGetter;
import dao.DatabaseAccounts;

/**
 * Servlet implementation class InquiryView
 */
@WebServlet("/inquiryView")
public class InquiryView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		HttpSession session = request.getSession();
		session.setAttribute("num", num);
		
		
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		Inquiry boardview = getter.getInquiryBoardView(num); 
		
		
		
		
		
		request.setAttribute("boardView", boardview);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/inquiryView.jsp");
		dispatcher.forward(request, response);
		
		getter.close();	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
