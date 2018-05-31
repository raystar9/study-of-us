package servlet.root;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.root.Login;
import dao.DataGetter;
import dao.DatabaseAccounts;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String id = request.getParameter("id");	
		 String password = request.getParameter("password");
		 
		

		DataGetter getter = new DataGetter(DatabaseAccounts.ADMIN);
		
		
		Login Index = getter.getIndex(id);
		
		
		Login logpro = getter.getLogin(id);
		//
		/*request.setAttribute("login", logpro);*/
		
		if(logpro == null || !logpro.getPassword().equals(password)) {
			System.out.println(logpro);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginFail");
			dispatcher.forward(request, response);
		}
		if(logpro.getPassword().equals(password) || Index != null){
			//로그인 성공시 세션 생성 
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("index", Index.getIndex());
			
			System.out.println("세션값:"+session.getAttribute("index"));
			
			
			System.out.println(logpro.getPassword());
			response.sendRedirect("/study-of-us/study/list");
			/*RequestDispatcher dispatcher = request.getRequestDispatcher("/list");
			dispatcher.forward(request, response);*/
		}
	/*	}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginFail");
			dispatcher.forward(request, response);
		}*/

		getter.close();
	}
}
