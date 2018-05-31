package servlet.study.each.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.study.each.board.CommentBean;
import dao.DataPoster;
import dao.DatabaseAccounts;


@WebServlet("/commentinsert")
public class CommentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CommentInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("insert 서블릿으로 옴");
		DataPoster poster = new DataPoster(DatabaseAccounts.SCOTT);
		
		CommentBean comment = new CommentBean();
		comment.setContent(request.getParameter("content"));
		comment.setBno(Integer.parseInt(request.getParameter("bno")));		//시퀀스 처리?
		comment.setCno(10);	//시퀀스 처리?
		comment.setName("이다혜");	//로그인한 사람 이름 가져올꺼임
		poster.postCommentInsert(comment);
		poster.close();
		
		PrintWriter out = response.getWriter();
		out.println(1);
		
	}

}
