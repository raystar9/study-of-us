package servlet.study;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.study.StudyListSelect;
import dao.DataGetter;
import dao.DatabaseAccounts;

/**
 * Servlet implementation class List
 */
@WebServlet("/study/list")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 멤버의 인덱스번호 세션받아주고
		HttpSession session = request.getSession();
		int index = (int) session.getAttribute("index");
		System.out.println(index);

		// 현재 페이지수
		int page = 1;

		//// 한페이지에 보여줄 스터디테이블 갯수
		int limit = 3;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("넘어온 페이지 = " + page);

		// 총스터디 수를 받아옵니다. (나의스터디만)
		DataGetter getter2 = new DataGetter(DatabaseAccounts.ADMIN);
		StudyListSelect studycount = getter2.getStudyListCount(index);

		// 내가뽑아올 목록을 받아옵니다.
		DataGetter getter = new DataGetter(DatabaseAccounts.ADMIN);
		ArrayList<StudyListSelect> studyList = getter.getStudyList(index,page ,limit);

		// (17 + (3 - 1)) / 3 = 6페이지가 마지막 페이지가된다. 19 / 3 = 6
		int maxpage = (studycount.getCount() + limit - 1) / limit;
		System.out.println("총페이지수 = " + maxpage);

		// 현재 페이지 의수
		int startpage = ((page - 1) / 5) * 10 + 1;

		System.out.println("현재 페이지에서 보여줄 시작 페이지수 " + startpage);

		// end 페이지 현재 페이지 그룹에서 보여줄 마지막 페이지수
		int endpage = startpage + 5 - 1;
		System.out.println("현재 페이지의 보여줄 마지막 페이지 수 " + endpage);

		// 마지막 페이지 까지만 보여주게 하는 if 문

		if (endpage > maxpage)
			endpage = maxpage;
		request.setAttribute("page", page); // 현재 페이지의수
		request.setAttribute("maxpage", maxpage); // 최대 페이지의 수

		// 현재 페이지에 표시할 첫 페이지의 수
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);

		// 해당 페이지의 글 목록을 갖고 있는 리스트
		request.setAttribute("studyList", studyList);

		// 카운트받아온 나의 스터디 개수
		request.setAttribute("studycount", studycount);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/list.jsp");
		dispatcher.forward(request, response);

		getter.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
}
