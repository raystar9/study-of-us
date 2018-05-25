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

import beans.study.each.board.BoardListBean;
import dao.DataAccessor;
import dao.DataGetter;
import dao.DatabaseAccounts;
import dao.exceptions.DatabaseConnectException;
import exceptionHanlder.ExceptionHandleable;
import exceptionHanlder.ExceptionHandler;

@WebServlet("/study/board")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardList() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ExceptionHandler.general(new ExceptionHandleable() {

			@Override
			public DataAccessor methods() throws DatabaseConnectException, SQLException {

				DataGetter getter = new DataGetter(DatabaseAccounts.ADMIN);
				ArrayList<BoardListBean> boardlist = getter.getBoardList();
				int boardcount = getter.getBoardCount();
				request.setAttribute("boardlist", boardlist);
				request.setAttribute("listcount", boardcount);
				return getter;
			}
		});

		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/boardList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
