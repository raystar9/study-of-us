package servlet.study.each.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataGetter;
import dao.DatabaseAccounts;


@WebServlet("/commentcount")
public class CommentCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CommentCount() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataGetter getter = new DataGetter(DatabaseAccounts.SCOTT);

		//게시글 번호
		int boardnum = Integer.parseInt(request.getParameter("bno"));
		//댓글 개수
		int commentcount = 0;
		commentcount = getter.getCommentCount(boardnum);
		
		getter.close();
		
		PrintWriter out = response.getWriter();
		out.println(commentcount);
	}

}
