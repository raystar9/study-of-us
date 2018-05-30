package servlet.study.each.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataPoster;
import dao.DatabaseAccounts;


@WebServlet("/study/each/boarddelete")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BoardDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num"));
		int studyIndex = 3;
		
		DataPoster poster = new DataPoster(DatabaseAccounts.SCOTT);
		poster.postBoardDelete(num, studyIndex);
		poster.close();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/boardList.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
