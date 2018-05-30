package servlet.study.each.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.study.each.board.BoardViewRegisterBean;
import dao.DataGetter;
import dao.DatabaseAccounts;


@WebServlet("/study/each/boardview")
public class BoardView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BoardView() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("넘엉ㄴ=@@@@@@@@@@@@"+request.getParameter("num"));
	
		request.setAttribute("num", request.getParameter("num"));
		
		DataGetter getter = new DataGetter(DatabaseAccounts.SCOTT);
		int studyIndex = 3; 
		BoardViewRegisterBean boardcontent = getter.getBoardView(Integer.parseInt(request.getParameter("num")), studyIndex);
		System.out.println(boardcontent.getIndex());
		request.setAttribute("boardcontent", boardcontent);
		getter.close();

		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/boardView.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
