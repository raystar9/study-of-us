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
import beans.study.StudySearch;
import dao.DataGetter;
import dao.DatabaseAccounts;

@WebServlet("/study/SearchMain")
public class SearchMain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("resource")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		String category = "";
		if (request.getParameter("category") != null) {
			category = request.getParameter("category");
			if (category.equals("전체스터디")) {
				category = "%%";
			}
		}
		ArrayList<StudySearch> studiestotalcount = getter.getCategryStudies(category);

		ArrayList<StudySearch> programming = getter.getprogramming();
		ArrayList<StudySearch> language = getter.getlanguage();
		ArrayList<StudySearch> certificate = getter.getcertificate();

		int page = 1;
		int countlist = 4;
		int totalcount = studiestotalcount.size();
		
		int totalpage = totalcount / countlist;
		
		if(totalcount % countlist > 0) {
			totalpage++;
		}
		
		if(totalpage < page) {
			page = totalpage;
		}
		
		int countpage = 5;
		
		int startpage = ((page -1) / countlist) * countlist + 1;
		int endpage = startpage + countpage - 1;
		
		if(endpage > totalpage) {
			endpage = totalpage;
		}
		
		int startcount = (page -1 ) * countpage + 1;
		int endcount = page * countpage;
		
		studiestotalcount = getter.getCategryStudies(category, startcount, endcount);

		

		if (request.getParameter("category") == null) {
			request.setAttribute("programming", programming);
			request.setAttribute("language", language);
			request.setAttribute("certificate", certificate);
			request.setAttribute("studies", studiestotalcount);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/study/searchmain.jsp");
			dispatcher.forward(request, response);
			System.out.println("--------------------------완료-------------------------");
		} else {
			request.setAttribute("page", page); // 현재 페이지 수
			request.setAttribute("totalpage", totalpage); // 최대 페이지 수
			request.setAttribute("endpage", endpage);

			request.setAttribute("studies", studiestotalcount);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/study/search.jsp");
			dispatcher.forward(request, response);
			System.out.println("--------------------------여기까지------------------------");

		}

		getter.close();
	}
}
