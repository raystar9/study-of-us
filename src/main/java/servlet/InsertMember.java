package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataAccessor;
import dao.DataGetter;
import dao.DataPoster;
import dao.DatabaseAccounts;
import dao.exceptions.DatabaseConnectException;

/**
 * Servlet implementation class InsertMember
 */
@WebServlet("/insertprocess")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ExceptionHandler.general(new ExceptionHandleable() {
			
			@Override
			public DataAccessor methods() throws DatabaseConnectException, SQLException {
				// TODO Auto-generated method stub
				DataPoster Poster = new DataPoster(DatabaseAccounts.ADMIN);//계정이름은 context 에 서 정해줄 수 있다 현재 system/1234
					
				
				return null;
			}
		});
		
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
