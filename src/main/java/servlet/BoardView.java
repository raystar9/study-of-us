package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataAccessor;
import dao.exceptions.DatabaseConnectException;

@WebServlet("/study/board_view_form")
public class BoardView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardView() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			ExceptionHandler.general(new ExceptionHandleable() {
			
			@Override
			public DataAccessor methods() throws DatabaseConnectException, SQLException {

				DataGetter
				return null;
			}
		});
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/board_view_form.jsp");
		dispatcher.forward(request, response);
	}

}
