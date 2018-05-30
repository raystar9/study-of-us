package servlet.root;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.prototype.Study;
import dao.DataGetter;
import dao.DatabaseAccounts;

/**
 * Servlet implementation class SnameCheck
 */
@WebServlet("/SnameCheck")
public class SnameCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String sname = request.getParameter("id");
		System.out.println("아이디는" + sname);
		PrintWriter out = response.getWriter();
		int result = 0;
		
		DataGetter getter = new DataGetter(DatabaseAccounts.ADMIN);
		Study sname_ck = getter.getSname_ck(sname);
		
		
		if(sname_ck != null) {
			result = -1;
			out.print(result);
		}
		getter.close();
	}
}






















