package servlet.root;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.root.Login;
import dao.DataAccessor;
import dao.DataGetter;
import dao.DatabaseAccounts;
import dao.exceptions.DatabaseConnectException;
import exceptionHanlder.ExceptionHandleable;
import exceptionHanlder.ExceptionHandler;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login loginbean= new Login(); 
		loginbean.setId(request.getParameter("id"));
		loginbean.setPassword(request.getParameter("password"));
		
		
		ExceptionHandler.general(new ExceptionHandleable() {
			
			@Override
			public DataAccessor methods() throws DatabaseConnectException, SQLException {
				DataGetter getter = new DataGetter(DatabaseAccounts.ADMIN);
				Login logpro = getter.getLogin(loginbean);
				request.setAttribute("login", logpro);
				return getter;				//트라이 캐치문 실행
			}
		});
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/list.jsp");
		response.sendRedirect("loginFail");
		dispatcher.forward(request, response);
	}
}
