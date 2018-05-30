package servlet.study.each.board;

import java.io.IOException;
import java.io.OutputStream;
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
		DataGetter getter = new DataGetter(DatabaseAccounts.SCOTT);
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<CommentBean> comment = new ArrayList<CommentBean>();
		int studyIndex = 3; 
		BoardViewRegisterBean boardcontent = getter.getBoardView(Integer.parseInt(request.getParameter("num")), studyIndex);
		int num = boardcontent.getIndex();
		System.out.println(num);
		comment = getter.getCommentList(num);
		
		getter.close();
		
		ServletOutputStream out = response.getOutputStream();
		System.out.println(mapper.writeValueAsString(comment));
		out.println(mapper.writeValueAsString(comment));
	}

}
