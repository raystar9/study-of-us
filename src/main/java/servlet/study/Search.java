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
		String search = "", search2 = "%%";
		String category = "", category2 = "%%";
		String subcategory = "", subcategory2 = "%%";
		String time = "", time2 = "%%";
		String day = "",day2 = "%%";
		String location = "", location2 = "%%";
		
		
		
		if(request.getParameter("searchVal") != null) {
			search = request.getParameter("searchVal");	
			search2 = "%"+search+"%";
		}
		if(request.getParameter("time") != null) {
			time = request.getParameter("time");	
			time2 = "%"+time+"%";
		}
		if(request.getParameter("category") != null) {
			category = request.getParameter("category");	
			category2 = "%"+category+"%";
		}
		
		if(request.getParameter("day") != null) {
			day = request.getParameter("day");	
			day2 = "%"+day+"%";
		}
		if(request.getParameter("location") != null) {
			location = request.getParameter("location");	
			location2 = "%"+location+"%";
		}
		if(request.getParameter("subcategory") != null) {
			subcategory = request.getParameter("subcategory");	
			subcategory2 = "%"+subcategory+"%";
		}

		ArrayList<StudySearch> studiestotalcount = getter.getStudies(search2,location2,category2,subcategory2,day2,time2);
		
		
		int page = 1;
		int countlist = 4;
		int totalcount = studiestotalcount.size();
		System.out.println(totalcount + " totalcount");
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		
		int totalpage = totalcount / countlist;

		System.out.println(totalpage + " totalpage");
		if (totalcount > countlist * totalpage) {
		    totalpage++;
		}

		System.out.println(page + " page");
		if(totalpage < page) {
			page = totalpage;
		}
		
		int countpage = 5;
		
		int startpage = ((page -1) / countlist) * countlist + 1;
		int endpage = startpage + countpage - 1;
		
		if(endpage > totalpage) {
			endpage = totalpage;
		}
		System.out.println(page + " page");
		int startcount = ( page - 1 ) * countlist + 1;
		int endcount = page * countlist;

		System.out.println("strat " + startcount);
		System.out.println("endcount " + endcount);
		
		ArrayList<StudySearch> studies = getter.getStudies(search2,location2,category2,subcategory2,day2,time2,startcount, endcount);

	
		request.setAttribute("searchVal", search);
		request.setAttribute("category", category);
		request.setAttribute("subcategory", subcategory);
		request.setAttribute("time", time);
		request.setAttribute("day", day);
		request.setAttribute("location", location);
		
		request.setAttribute("studies", studies);
		request.setAttribute("startpage", startpage);
		request.setAttribute("page", page);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("endpage", endpage);
		

	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/search.jsp");
		dispatcher.forward(request, response);
		System.out.println("--------------------------완료-------------------------");
		getter.close();
		
	}
}
