package servlet.root;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.root.Find;
import dao.DataGetter;
import dao.DatabaseAccounts;

@WebServlet("/PWFindPage")
public class PWFindPage extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String id = request.getParameter("id");
		 String name = request.getParameter("name");

		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		
		Find findid = getter.getPass(id);
		Find findname = getter.getFind(name);
		//
		/*request.setAttribute("login", logpro);*/
		
		if(findid == null || !findid.getId().equals(id) || findname == null || !findname.getName().equals(name)) {
			System.out.println(findid);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/IDFindFail");
			dispatcher.forward(request, response);
		}
		if(findid.getId().equals(id) && findname.getName().equals(name)){
			String pw = findid.getPassword();
		
			System.out.println(pw);
			request.setAttribute("pw", pw);
			request.getRequestDispatcher("/PWFindResult.jsp").forward(request, response);
		}

		getter.close();
	}

}
