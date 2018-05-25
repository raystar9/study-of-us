package servlet.study;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.study.StudySearch;
import dao.DataGetter;
import dao.DatabaseAccounts;

/**
 * Servlet implementation class SearchList
 */
@WebServlet("/study/SearchList")
public class SearchList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchList() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		int page = 1; // 현재페이지
		int totalList = 0; // 총 스터디의 수
		int countList = 5; // 화면에 보여줄 스터디의 수
		int countpage = 5; // 
		DataGetter getter = new DataGetter(DatabaseAccounts.SCOTT);
		String place = request.getParameter("place");
		String searchVal ="";
		HttpSession session = request.getSession();

		if(request.getParameter("place")!=null) {
			session.setAttribute("place", place);
		}
		
		if(request.getParameter("page")==null) {
			page = 1;
		}else {
		page = Integer.parseInt(request.getParameter("page"));
		}
	
		
		
		System.out.println("값이 넘어온건가 ?" + request.getParameter("place"));
	
		System.out.println("세션값"+session.getAttribute("place").toString());
		
		
		
		if(request.getParameter("place")==null) {
				searchVal = session.getAttribute("place").toString();
		}else {
			searchVal = request.getParameter("place");
		}
		
		ArrayList<StudySearch> studies = getter.getSearchStudies(searchVal); // 지역별 스터디의 갯수 구하기
		
		
	
		
	
		
		System.out.println("page 값 "+request.getParameter("page"));
		
		totalList = studies.size(); // 총 스터디의 개수를 구하기 위해서 사용
		
		
		int startcount = (page - 1)* countpage + 1; // 한페이지에 표시할 5개의 스터디중 시작 번호(rownum)
		int endcount = page * countpage;			// 한페이지에 표시할 5개의 스터디중 끝나는 번호 (rownum)
		
		System.out.println("startcount" + startcount);
		System.out.println("endcount" + endcount);
		

		ArrayList<StudySearch> studies2 = getter.getSearchList(searchVal,startcount,endcount);
		
		int totalpage = totalList / countList;
		if(totalList % countList > 0) {
			totalpage++;
		}			
		System.out.println("총페이지의 수는 :" + totalpage);
		
		if(totalpage < page) {
			page = totalpage;
		}
		
		int startpage =((page - 1)/countpage) * countpage + 1; // 시작 페이지를 구하는 방법
		int endpage = startpage + countpage -1; // 
		
		
		if(endpage > totalpage) { // startpage 와 endpage 만으로는 계산을하게 되면 26개의 페이지수가 나오더라도 30페이지가 나타나기 떄문에 조건문을 사용해 토탈페이지의 값을 바꿔준다
			endpage = totalpage;
		}
		
		request.setAttribute("startpage",startpage);
		request.setAttribute("page",page);
		request.setAttribute("totalpage",totalpage);
		request.setAttribute("endpage",endpage);
		request.setAttribute("studies", studies2);
		
		System.out.println("검색어는 "+ searchVal);
		
		try {
			getter.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(request.getParameter("state")!=null) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/study/sources/search/section2.jsp");
			dispatcher.forward(request, response);
			System.out.println("아작스 실행");
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/study/search.jsp");
			dispatcher.forward(request, response);
		}

	}


}
