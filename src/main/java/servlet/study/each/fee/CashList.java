package servlet.study.each.fee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.study.each.fee.CashListBean;
import dao.DataGetter;
import dao.DatabaseAccounts;

@WebServlet("/study/each/cash")
public class CashList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CashList() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataGetter getter = new DataGetter(DatabaseAccounts.SCOTT);
		ArrayList<CashListBean> cashlist = new ArrayList<CashListBean>();

		int page = 1;
		int limit = 10;
		/*int studyIndex = 3;*/
		
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("넘어온 페이지 = " + page);
		
		//회비관리 리스트 가져옴
		cashlist = getter.getCashList(page, limit /*, studyIndex*/);
		//회비관리 리스트 개수 가져옴
		int cashcount = getter.getCashCount(/*studyIndex*/);
		System.out.println("총 리스트 수 = " + cashcount);
		
		int maxpage = (cashcount + limit - 1) / limit;
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
		
		request.setAttribute("endpage", endpage);

		// 현재 페이지에 표시할 끝 페이지 수
		request.setAttribute("listcount", cashcount);
		// 해당 페이지의 글 목록을 갖고 있는 리스트
		request.setAttribute("cashlist", cashlist);
		getter.close();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/cashList.jsp");
		dispatcher.forward(request, response);
	}
	
}
