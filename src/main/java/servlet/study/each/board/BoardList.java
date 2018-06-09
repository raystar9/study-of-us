package servlet.study.each.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.study.each.board.BoardListBean;
import dao.DataGetter;
import dao.DatabaseAccounts;

@WebServlet("/study/each/board")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardList() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		ArrayList<BoardListBean> boardlist = new ArrayList<BoardListBean>();
		
		String search = request.getParameter("search");
		String searchSelect = request.getParameter("searchSelect");
		String pluswhere = ")";
		
		if(search != null && search != "" && searchSelect.equals("title")) {
			pluswhere = " AND B_TITLE like ?) ";
		}else if(search != null && search != "" && searchSelect.equals("name")) {
			pluswhere = " AND M_NAME like ?) ";
		}else if(search != null && search != "" && searchSelect.equals("date")) {
			pluswhere = " AND B_DATE like ?) ";
		}
		
		int page = 1;
		int limit = 10;
		int studyIndex = 6;
		//int studyIndex = (int)request.getSession().getAttribute("index");

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("넘어온 페이지 = " + page);

		// 총 리스트 받아오기
		boardlist = getter.getBoardList(page, limit, studyIndex, pluswhere, search); 
		// 총 리스트 수 받아오기
		int boardcount = getter.getBoardCount(studyIndex, pluswhere,search); 
		
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
		request.setAttribute("endpage", endpage); 

		// 현재 페이지에 표시할 첫 페이지 수
		request.setAttribute("startpage", startpage);

		// 현재 페이지에 표시할 끝 페이지 수
		request.setAttribute("listcount", boardcount);
		// 해당 페이지의 글 목록을 갖고 있는 리스트
		request.setAttribute("boardlist", boardlist);
		
		request.setAttribute("search", search);
		request.setAttribute("searchSelect", searchSelect);
		
		getter.close();

		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/board/boardList.jsp");
		dispatcher.forward(request, response);
	}

}
