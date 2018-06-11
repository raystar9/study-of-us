package servlet.root;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.prototype.Inquiry;
import dao.DataGetter;
import dao.DatabaseAccounts;

/**
 * Servlet implementation class InquiryPage
 */
@WebServlet("/inquiryPage")
public class InquiryPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int index = (int)session.getAttribute("index");
		
		
		//현재 페이지 수
		int page = 1;
		
		// 한페이지에서 보여줄 게시판 테이블 개수
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("념겨온 페이지 = " + page);
		
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);

		//총게시판 숫자 뽑아옵니다.
		
		Inquiry inquirycount = getter.getInquiryCount(index);
		
		
		//게시판 글 전체 뽑아옵니다.
		ArrayList<Inquiry> board = getter.getInquiryBoard(index, page,limit);
		
		
		int maxpage = (inquirycount.getCount() + limit - 1) / limit;
		System.out.println("총페이지수 = " + maxpage);
		System.out.println("count 수 " + inquirycount.getCount());
		
		//현재 페이지수
		int startpage = ((page-1) /10) * 10 + 1;
		System.out.println("현재 페이지에서 보여줄 시작 글넘버 " + startpage);
		
		int endpage = startpage + 10 - 1;
		System.out.println("현재 페이지의 보여줄 마지막 글넘버  " + endpage);
		
		if (endpage > maxpage) 
			endpage = maxpage;
		request.setAttribute("page", page); // 현재 페이지의 수
		request.setAttribute("maxpage", maxpage); // 최대 페이지의 수
		
		//현재 페이지에서 표시할 첫 페이지의 수
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		
		
		//나의 게시판 총개수
		request.setAttribute("inquirycount", inquirycount.getCount());
		
		//게시판 리스트
		request.setAttribute("inquiryList", board);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/inquiryBoard.jsp");
		dispatcher.forward(request, response);
		
		getter.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
