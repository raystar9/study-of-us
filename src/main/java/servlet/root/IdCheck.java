package servlet.root;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.root.Login;
import dao.DataGetter;
import dao.DatabaseAccounts;

/**
 * Servlet implementation class IdCheck
 */
@WebServlet("/IdCheck")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
		System.out.println(id);
		PrintWriter out = response.getWriter();
		int result = 0;
		System.out.println("id : " + id);
		
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		Login idcheck = getter.getIdCheck(id);
		
		
		if(idcheck == null) {
			System.out.println("아이디 사용가능");
			result = -1;
			out.print(result);
		}else{
			System.out.println("아이디 존재함");
			System.out.println(idcheck.getId());
			result = 1;
			out.print(result);
		}
		getter.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
