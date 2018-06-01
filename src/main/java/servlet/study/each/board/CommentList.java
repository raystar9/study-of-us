package servlet.study.each.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.study.each.board.BoardViewRegisterBean;
import beans.study.each.board.CommentBean;
import dao.DataGetter;
import dao.DatabaseAccounts;


@WebServlet("/commentlist")
public class CommentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CommentList() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		DataGetter getter = new DataGetter(DatabaseAccounts.SCOTT);
		System.out.println("bnobno = " + request.getAttribute("bno"));
		
		ObjectMapper mapper = new ObjectMapper();
		int studyIndex = 3; 
		ArrayList<CommentBean> comment = new ArrayList<CommentBean>();
		int boardnum = Integer.parseInt((String) request.getAttribute("bno"));
		BoardViewRegisterBean boardcontent = getter.getBoardView(boardnum, studyIndex);
		
		int num = boardcontent.getIndex();
		comment = getter.getCommentList(num);
		getter.close();
		
		PrintWriter out = response.getWriter();
		out.println(mapper.writeValueAsString(comment));
		
		/*ServletOutputStream out = response.getOutputStream();*/
	}

}
