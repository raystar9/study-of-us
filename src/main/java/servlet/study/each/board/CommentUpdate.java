package servlet.study.each.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataPoster;
import dao.DatabaseAccounts;


@WebServlet("/commentupdate")
public class CommentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CommentUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataPoster poster = new DataPoster(DatabaseAccounts.SCOTT);
		System.out.println("update 서블릿으로 넘어옴");
		String content = request.getParameter("content");
		int cno = Integer.parseInt(request.getParameter("cno"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		poster.postCommentUpdate(content, cno, bno);
		
		PrintWriter out = response.getWriter();
		out.println(1);
		poster.close();
	}

}
