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
		 
		

		DataGetter getter = new DataGetter(DatabaseAccounts.ADMIN);
		
		
		Find Index = getter.getIndex2(name);
		
		
		Find findpro = getter.getFind(name);
		//
		/*request.setAttribute("login", logpro);*/
		
		if(findpro == null || !findpro.getEmail().equals(email)) {
			System.out.println(findpro);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/IDFindFail");
			dispatcher.forward(request, response);
		}
		if(findpro.getEmail().equals(email) || Index != null){
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("email", findpro.getEmail());
			session.setAttribute("index", Index.getIndex());
			
			System.out.println("세션값:"+session.getAttribute("index"));
			
			
			System.out.println(findpro.getEmail());
			response.sendRedirect("/study-of-us/IDFindResult");
			/*RequestDispatcher dispatcher = request.getRequestDispatcher("/list");
			dispatcher.forward(request, response);*/
		}

		getter.close();
	}

}
