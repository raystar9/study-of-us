package servlet.study.each.board;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataGetter getter = new DataGetter(DatabaseAccounts.SCOTT);
		ArrayList<CommentBean> comment = new ArrayList<CommentBean>();
		comment = getter.getCommentList();
		
		OutputStream out = response.getOutputStream();
		out.
				
	}

}
