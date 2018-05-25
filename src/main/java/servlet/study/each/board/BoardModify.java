package servlet.study.each.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.study.each.board.BoardViewRegisterBean;
import dao.DataAccessor;
import dao.DataGetter;
import dao.DataPoster;
import dao.DatabaseAccounts;
import dao.exceptions.DatabaseConnectException;
import exceptionHanlder.ExceptionHandleable;
import exceptionHanlder.ExceptionHandler;


@WebServlet("/study/boardmodify")
public class BoardModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BoardModify() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ExceptionHandler.general(new ExceptionHandleable() {

			@Override
			public DataAccessor methods() throws DatabaseConnectException, SQLException {

				DataGetter getter = new DataGetter(DatabaseAccounts.ADMIN);
				ArrayList<BoardViewRegisterBean> boardcontent = getter.getBoardView();
				request.setAttribute("boardcontent", boardcontent);
				return getter;
			}
		});
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/boardModify.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ExceptionHandler.general(new ExceptionHandleable() {

			@Override
			public DataAccessor methods() throws DatabaseConnectException, SQLException {
				BoardViewRegisterBean boardmodify = new BoardViewRegisterBean();
				boardmodify.setTitle(request.getParameter("boardSubject"));
				boardmodify.setContent(request.getParameter("boardContent"));
				boardmodify.setDate(request.getParameter("boardDate"));
				
				DataPoster poster = new DataPoster(DatabaseAccounts.ADMIN);
				poster.postBoardModify(boardmodify);
				return poster;
			}
		});
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/boardView.jsp");
		dispatcher.forward(request, response);
	}

}
