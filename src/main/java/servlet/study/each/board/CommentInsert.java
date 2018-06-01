package servlet.study.each.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.study.each.board.CommentBean;
import dao.DataGetter;
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
		DataGetter getter = new DataGetter(DatabaseAccounts.SCOTT);
		DataPoster poster = new DataPoster(DatabaseAccounts.SCOTT);
		
		CommentBean comment = new CommentBean();
		
		//insert할 데이터 가져와서 Bean에 저장
		comment.setContent((String) request.getAttribute("content"));
		comment.setBno(Integer.parseInt((String)request.getAttribute("bno")));		//시퀀스 처리?
		comment.setCno(10);	
		comment.setName("이다혜");	
		//DB안에 넣기
		poster.postCommentInsert(comment);
		
		//게시글 번호
		int boardnum = Integer.parseInt((String)request.getAttribute("bno"));
		//댓글 개수
		int commentcount = getter.getCommentCount(boardnum);
		
		poster.close();
		getter.close();
		
		PrintWriter out = response.getWriter();
		out.println(commentcount);
		
	}

}
