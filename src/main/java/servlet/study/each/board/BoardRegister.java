package servlet.study.each.board;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.study.each.board.BoardViewRegisterBean;
import dao.DataAccessor;
import dao.DataPoster;
import dao.DatabaseAccounts;
import dao.exceptions.DatabaseConnectException;
import exceptionHanlder.ExceptionHandleable;
import exceptionHanlder.ExceptionHandler;

@WebServlet("/study/boardregister")
public class BoardRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/boardRegister.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardViewRegisterBean board = new BoardViewRegisterBean();
		board.setTitle(request.getParameter("boardSubject"));
		board.setName(request.getParameter("boardName"));
		board.setContent(request.getParameter("boardContent"));
		board.setDate(request.getParameter("boardDate"));

		ExceptionHandler.general(new ExceptionHandleable() {
			@Override
			public DataAccessor methods() throws DatabaseConnectException, SQLException {
				// TODO Auto-generated method stub

				// 계정이름은 context에서 정해줄 수 있다 현재 system/1234
				DataPoster poster = new DataPoster(DatabaseAccounts.ADMIN);
				poster.postBoard(board); // 멤버값을 받아오고
				return poster; // try 캐치문을 실행해주기위해 리턴을 보낸다.
			}
		});
		//나중엔 그 해당 글번호를 가져와서 등록한 글의 세부보기 페이지로 이동할 것임.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/board_view_form.jsp");
		dispatcher.forward(request, response);
	}

}
