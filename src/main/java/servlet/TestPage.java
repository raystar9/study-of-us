package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.prototype.Member;
import dao.DataGetter;
import dao.DatabaseAccounts;
import dao.exceptions.DatabaseConnectException;

/**
 * Servlet implementation class TestPage
 */
@WebServlet("/test")
public class TestPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataGetter getter = null;
		try {
			getter = new DataGetter(DatabaseAccounts.ADMIN);
			ArrayList<Member> members = getter.getMembers(Member.QUERY_GET);
			
			for(Member member  : members) {
				System.out.println((member.getId()));
			}
		} catch (DatabaseConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				getter.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
