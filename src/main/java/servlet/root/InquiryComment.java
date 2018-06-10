package servlet.root;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DataGetter;
import dao.DatabaseAccounts;

/**
 * Servlet implementation class Comment
 */
@WebServlet("/comment")
public class InquiryComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		HttpSession session = request.getSession();
		int num = (int) session.getAttribute("num");
		
		
		InquiryComment comment = getter.getInquiryComment(num);
		
		response.setHeader("cache-control", "no-cache,no-store");
		System.out.println(sb.toString());
		out.print(sb.toString());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
	}
}
