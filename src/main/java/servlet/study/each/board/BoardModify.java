package servlet.study.each.board;

import java.io.IOException;

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

@WebServlet("/study/each/boardmodify")
public class BoardModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BoardModify() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int studyIndex = 3;
		//int studyIndex = (int)request.getSession().getAttribute("index");
		
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		BoardViewRegisterBean boardcontent = getter.getBoardView(Integer.parseInt(request.getParameter("num")));
		request.setAttribute("boardcontent", boardcontent);
		
		getter.close();

		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/board/boardModify.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int studyIndex = 3;
		//int studyIndex = (int)request.getSession().getAttribute("index");
		
		BoardViewRegisterBean boardmodify = new BoardViewRegisterBean();
		boardmodify.setTitle(request.getParameter("boardSubject"));
		boardmodify.setContent(request.getParameter("boardContent"));
		boardmodify.setDate(request.getParameter("boardDate"));
		boardmodify.setFilename(request.getParameter("fileName"));
		boardmodify.setIndex(Integer.parseInt(request.getParameter("num")));
		
		DataPoster poster = new DataPoster(DatabaseAccounts.PROJECT);
		int boardnum = Integer.parseInt(request.getParameter("num"));
		
		poster.postBoardModify(boardmodify, studyIndex);
		
		response.sendRedirect("/study-of-us/study/each/boardview" + "?num=" + boardnum);
		poster.close();
	}

}
