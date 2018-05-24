package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BoardViewRegister;


@WebServlet("/study/boardregister")
public class BoardRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BoardRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/boardRegister.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardViewRegister board = new BoardViewRegister();
		board.setTitle(request.getParameter("boardSubject"));
		board.setName(request.getParameter("boardName"));
		board.setContent(request.getParameter("boardContent"));
		board.setDate(request.getParameter("boardDate"));
	}

}
