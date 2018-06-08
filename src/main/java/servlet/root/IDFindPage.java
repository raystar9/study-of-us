package servlet.root;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.root.Find;
import dao.DataGetter;
import dao.DatabaseAccounts;

@WebServlet("/IDFindPage")
public class IDFindPage extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name = request.getParameter("name");
		 String email = request.getParameter("email");

		DataGetter getter = new DataGetter(DatabaseAccounts.SCOTT);
		
		Find findname = getter.getFind(name);
		Find findemail = getter.getEmail(email);
		//
		/*request.setAttribute("login", logpro);*/
		
		if(findname == null || !findname.getName().equals(name) || findemail == null || !findemail.getEmail().equals(email)) {
			System.out.println(findname);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/IDFindFail");
			dispatcher.forward(request, response);
		}
		if(findname.getName().equals(name) && findemail.getEmail().equals(email)){
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("email", email);
			session.setAttribute("id", findemail.getId());

			System.out.println(findname.getName());
			System.out.println(findemail.getEmail());
			response.sendRedirect("/study-of-us/IDFindResult");
		}

		getter.close();
	}

}
