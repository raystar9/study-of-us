package servlet.study;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.prototype.Study;
import dao.DataGetter;
import dao.DatabaseAccounts;

@WebServlet("/study/SearchMain")
public class SearchMain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("resource")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataGetter getter = new DataGetter(DatabaseAccounts.SCOTT);

		ArrayList<Study> studiestotalcount = getter.getStudies();

		if (request.getParameter("category") != null) {
			String category = request.getParameter("category");
			System.out.println(category);

			studiestotalcount = getter.getCategryStudies(category);
			request.setAttribute("studies", studiestotalcount);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/study/search.jsp");
			dispatcher.forward(request, response);
			System.out.println("--------------------------여기까지------------------------");
		} else {
			request.setAttribute("studies", studiestotalcount);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/study/searchmain.jsp");
			dispatcher.forward(request, response);
			System.out.println("--------------------------완료-------------------------");
		}
	}
}
