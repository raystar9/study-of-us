package servlet.study;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.prototype.Study;
import dao.DataGetter;
import dao.DatabaseAccounts;

/**
 * Servlet implementation class Home
 */
@WebServlet("/study/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("resource")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("스터디 검색 페이지");
		DataGetter getter = new DataGetter(DatabaseAccounts.SCOTT);
		String url = "";

		String[] check = request.getParameterValues("checkbox");
		String secondArray = request.getParameter("secondArray");
		String search = request.getParameter("searchVal");

		int startcount = 0;
		int endcount = 0;

		int page = 1; // 기본페이지 값은 항상 1
		int countlist = 5; // 한 화면에 출력될 페이지의 수

		ArrayList<Study> studiestotalcount = getter.getStudies(search, check, secondArray);
		int totalcount = studiestotalcount.size();
		System.out.println("총 스터디의 수 :" + totalcount);
		// 총 스터디의 개수를 구하기 위해서 getStudies 메서드 사용
		int totalpage = totalcount / countlist;

		if (totalcount > countlist * totalpage) {
			totalpage++;
		}

		if (request.getParameter("page") != null) {
			// 페이지 값이 넘어 왔다면 넘어온 값을 사용한다
			page = Integer.parseInt(request.getParameter("page"));
		}
		System.out.println(page + "page");
		if (totalpage < page) {
			// 현재 페이지 번호가 총페이지 번호 보다 커지는 것을 막기 위해서
			page = totalpage;
		}
		// 시작페이지와 끝페이지를 구하기
		int countpage = 5; // 아래에 표시될 페이지 단위 1~5개 즉, 1,2,3,4,5 까지 하단의 표시

		int startpage = ((page - 1) / countpage) * countpage + 1;
		int endpage = startpage + countpage - 1;

		startcount = (page - 1) * countpage + 1;
		endcount = page * countpage;

		System.out.println(startcount + "start");
		System.out.println(endcount + "endcount");
		// rownum의 값을 구하기위해서 사용함

		if (endpage > totalpage) {
			// 마지막 페이지가 총페이지보다 많으면 안되므로 처리해준다
			endpage = totalpage;
		}

		ArrayList<Study> studies = getter.getStudies(search, check, secondArray, startcount, endcount);

		if (check != null) {
			for (int i = 0; i < check.length; i++) {
				url += "&checkbox=" + check[i];
				request.setAttribute("check", url);
			}
		}
		
		request.setAttribute("checkbox", check);
		request.setAttribute("searchVal", search);
		request.setAttribute("secondArray", secondArray);
		request.setAttribute("studies", studies);
		request.setAttribute("startpage", startpage);
		request.setAttribute("page", page);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("endpage", endpage);
		System.out.println("check: "+check);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/search.jsp");
		dispatcher.forward(request, response);
		System.out.println("--------------------------완료-------------------------");
	}
}
