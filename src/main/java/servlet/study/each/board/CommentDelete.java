package servlet.study.each.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataGetter;
import dao.DataPoster;
import dao.DatabaseAccounts;


@WebServlet("/commentdelete")
public class CommentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CommentDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Delete 서블릿으로 왔음");
		DataPoster poster = new DataPoster(DatabaseAccounts.SCOTT);
		DataGetter getter = new DataGetter(DatabaseAccounts.SCOTT);
		int cno = Integer.parseInt(request.getParameter("cno"));
		poster.postCommentDelete(cno);
		//게시글 번호
		int boardnum = Integer.parseInt(request.getParameter("bno"));
		//댓글 개수
		int commentcount = getter.getCommentCount(boardnum);
		
		poster.close();
		getter.close();
		
		PrintWriter out = response.getWriter();
		out.println(commentcount);
		
	}

}
