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
import beans.study.each.board.CommentBean;
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
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		int studyIndex = 3;
		//int studyIndex = (int)request.getSession().getAttribute("index");
		
		BoardViewRegisterBean boardcontent = getter.getBoardView(Integer.parseInt(request.getParameter("num")));
		request.setAttribute("boardcontent", boardcontent);
		
		ArrayList<CommentBean> comment = new ArrayList<CommentBean>();
		//게시글 번호
		int boardnum = boardcontent.getIndex();
		
		//댓글 개수
		int commentcount = getter.getCommentCount(boardnum);
		comment = getter.getCommentList(studyIndex, boardnum);
		
		request.setAttribute("comment", comment);
		request.setAttribute("commentcount", commentcount);
		getter.close();
		
		/* 사용자 아이디 session에서 가져오는 것 필요 */
        /* 사용자 아이디 session에서 저장해서 form으로 보내는 것 필요 */
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/board/boardView.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
