package servlet.study.each.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.study.each.board.BoardListBean;
import dao.DataGetter;
import dao.DatabaseAccounts;


@WebServlet("/boardsearch")
public class BoardSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public BoardSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("BoardSearch 서블릿으로 들어옴");
		response.setContentType("text/plain; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		DataGetter getter = new DataGetter(DatabaseAccounts.SCOTT);
		
		int studyIndex = Integer.parseInt(request.getParameter("studyIndex"));
		String search = request.getParameter("search");
		String searchSelect = request.getParameter("searchSelect");
		
		int page = 1;
		int limit = 10;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("넘어온 페이지 = " + page);

		
		ArrayList<BoardListBean> boardlist = new ArrayList<BoardListBean>();
		boardlist = getter.getBoardSearch(page, limit, studyIndex, search, searchSelect);
		
		int boardcount = getter.getBoardSearchCount(studyIndex, search, searchSelect); // 총 리스트 수 받아오기
		System.out.println("총 리스트 수 = " + boardcount);

		int maxpage = (boardcount + limit - 1) / limit;
		System.out.println("총 페이지수 = " + maxpage);

		int startpage = ((page - 1) / 10) * 10 + 1;
		System.out.println("현재 페이지에 보여줄 시작 페이지수 = " + startpage);

		int endpage = startpage + 10 - 1;
		System.out.println("현재 페이지에 보여줄 마지막 페이지 수 = " + endpage);

		if (endpage > maxpage)
			endpage = maxpage;
		
		request.setAttribute("page", page); // 현재 페이지 수
		request.setAttribute("maxpage", maxpage); // 최대 페이지 수

		// 현재 페이지에 표시할 첫 페이지 수
		request.setAttribute("startpage", startpage);

		// 현재 페이지에 표시할 끝 페이지 수
		request.setAttribute("listcount", boardcount);
		// 해당 페이지의 글 목록을 갖고 있는 리스트
		request.setAttribute("boardlist", boardlist);
		getter.close();
		
		ObjectMapper mapper = new ObjectMapper();
		
		PrintWriter out = response.getWriter();
		out.println(mapper.writeValueAsString(boardlist));
		
	}

}
