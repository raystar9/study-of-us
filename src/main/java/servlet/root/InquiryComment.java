package servlet.root;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.prototype.Comment;
import dao.DataGetter;
import dao.DataPoster;
import dao.DatabaseAccounts;

/**
 * Servlet implementation class Comment
 */

//		comment insert
@WebServlet("/comment")
public class InquiryComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int ib_index = (int)session.getAttribute("num");
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		ArrayList<Comment> commentGet = getter.getinquiryComment(ib_index);
		
		PrintWriter out = response.getWriter();
		out.println(mapper.writeValueAsString(commentGet));
		
		getter.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		DataPoster poster = new DataPoster(DatabaseAccounts.PROJECT);
		//테이블 인덱스 받아주고
		int ib_index = (int) session.getAttribute("num");
		
		//넘어온 댓글 받아주고
		String comment = request.getParameter("comment");
		
		//멤버의 로그인 인덱스 번호 받아준다.
		int m_index =  (int)session.getAttribute("index");
		
		int result = poster.postInquiryComment(ib_index,comment,m_index);
		
		
		System.out.println("인설트 성공이면 1: " + result);
		
		poster.close();
		
			
	}
}
