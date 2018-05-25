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
import dao.DataGetter;
import dao.DataPoster;
import dao.DatabaseAccounts;

@WebServlet("/study/boardmodify")
public class BoardModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BoardModify() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DataGetter getter = new DataGetter(DatabaseAccounts.SCOTT);
		ArrayList<BoardViewRegisterBean> boardcontent = getter.getBoardView();
		request.setAttribute("boardcontent", boardcontent);
		
		try {
			getter.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/boardModify.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BoardViewRegisterBean boardmodify = new BoardViewRegisterBean();
		boardmodify.setTitle(request.getParameter("boardSubject"));
		boardmodify.setContent(request.getParameter("boardContent"));
		boardmodify.setDate(request.getParameter("boardDate"));
		
		DataPoster poster = new DataPoster(DatabaseAccounts.ADMIN);
		poster.postBoardModify(boardmodify);

		try {
			poster.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/boardView.jsp");
		dispatcher.forward(request, response);
	}

}
