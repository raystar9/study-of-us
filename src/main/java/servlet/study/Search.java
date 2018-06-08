package servlet.study;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.study.StudySearch;
import dao.DataGetter;
import dao.DatabaseAccounts;

@WebServlet("/study/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("resource")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("스터디 검색 페이지");
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		String search = "%%";
		String category = "%%";
		String time = "%%";
		String day = "%%";
		String location = "%%";
		
		if(request.getParameter("searchVal") != null) {
			search = request.getParameter("searchVal");	
			search = "%"+search+"%";
		}
		if(request.getParameter("time") != null) {
			time = request.getParameter("time");	
			time = "%"+time+"%";
		}
		if(request.getParameter("category") != null) {
			category = request.getParameter("category");	
			category = "%"+category+"%";
		}
		
		if(request.getParameter("day") != null) {
			day = request.getParameter("day");	
			day = "%"+day+"%";
		}
		if(request.getParameter("location") != null) {
			location = request.getParameter("location");	
			location = "%"+location+"%";
		}

		int startcount = 0;
		int endcount = 0;
		int page = 1; // 기본페이지 값은 항상 1
		int countpage = 5; // 아래에 표시될 페이지 단위 1~5개 즉, 1,2,3,4,5 까지 하단의 표시
		ArrayList<StudySearch> studiestotalcount = getter.getStudies(search,location,category,day,time);
		int totalcount = studiestotalcount.size();
		System.out.println("총 스터디의 수 :" + totalcount);
		// 총 스터디의 개수를 구하기 위해서 getStudies 메서드 사용
		int totalpage = totalcount / countpage;

		if (totalcount > countpage * totalpage) {
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
		int countlist = 4; // 
		
		int startpage = ((page - 1) / countlist) * countlist + 1;
		int endpage = startpage + countlist - 1;

		startcount = (page - 1) * countlist + 1;
		endcount = page * countlist;

		System.out.println(startcount + "start");
		System.out.println(endcount + "endcount");
		// rownum의 값을 구하기위해서 사용함

		if (endpage > totalpage) {
			// 마지막 페이지가 총페이지보다 많으면 안되므로 처리해준다
			endpage = totalpage;
		}

		ArrayList<StudySearch> studies = getter.getStudies(search,location,category,day,time,startcount, endcount);

	
		request.setAttribute("searchVal", search);
		request.setAttribute("category", category);
		request.setAttribute("time", time);
		request.setAttribute("day", day);
		request.setAttribute("location", location);
		
		request.setAttribute("studies", studies);
		request.setAttribute("startpage", startpage);
		request.setAttribute("page", page);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("endpage", endpage);
		

		if(request.getParameter("state")!=null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/study/sources/search/section3.jsp");
			dispatcher.forward(request, response);
			System.out.println("--------------------------ajax------------------------");
			getter.close();
		}else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/search.jsp");
		dispatcher.forward(request, response);
		System.out.println("--------------------------완료-------------------------");
		getter.close();
		}
	}
}
