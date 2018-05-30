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

import beans.prototype.Study;
import beans.study.StudyListCount;
import dao.DataGetter;
import dao.DatabaseAccounts;

/**
 * Servlet implementation class Home
 */
@WebServlet("/study/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("스터디 검색 페이지");
		
		DataGetter getter = new DataGetter(DatabaseAccounts.SCOTT);
		HttpSession session = request.getSession();
		
		int[] count;
		int page = 1; // 현재 페이지 번호 (이하 page)
		int totalList = 0; // 총 스터디의 수
		int totalSearchList = 0; // 검색조건 사용한 스터디의 수
		int countpage = 5; // 한 화면에 출력될 페이지 수 (countPage)
		int countList = 5; // 한 페이지에 출력될 게시물 수 (countList)
		String searchVal = ""; // 검색바를 통해서 검색한 내용
		String place = ""; // 체크박스를 통해 선택한 지역명
		String secondArray = "";
		
		
		if(request.getParameter("secondArray")!=null) {
		secondArray = request.getParameter("secondArray");
		System.out.println(secondArray);
		}
		if(request.getParameterValues("checkbox")!=null)
			place=request.getParameterValues("checkbox")[0];
		{
			
		}
		System.out.println("분류 종목  :"+request.getParameter("secondArray"));
		/*System.out.println("체크항목은  :"+request.getParameterValues("checkbox")[0]);*/
		System.out.println("검색어는 :"+request.getParameter("searchVal"));
		System.out.println("페이지값은 : " + request.getParameter("page"));
		
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
	
		if (request.getParameter("place")!=null || request.getParameter("searchVal")!=null || request.getParameter("check") != null){
			
			
			if(request.getParameter("place")==null) {
			place = request.getParameter("check");
			System.out.println("check 값을 사용합니다." + place);
			}else{
			place = request.getParameter("place");
			System.out.println("place 값을 사용합니다."+ place);
			}
			
				// 검색어로 검색한 경우
			searchVal = request.getParameter("searchVal");
			request.setAttribute("searchVal", searchVal);

			

				
			ArrayList<Study> studies = getter.getStudies(searchVal, place);
			totalSearchList = studies.size(); // 총 스터디의 개수를 구하기 위해서 사용

			count = gettotalpage(totalSearchList, countList, page, countpage, request); 
			// 검색 후 페이징 처리 메서드
			ArrayList<StudyListCount> studiespaging = getter.getStudyPaging(count[0], count[1], searchVal, place, secondArray); 
			
			// 페이징 기법을 통해서 게시물 보여주는 부분
																											
			request.setAttribute("studies", studiespaging);
			request.setAttribute("place", place);
		} else {
			ArrayList<Study> studies = getter.getStudies();
			totalList = studies.size(); 
			// 총 스터디의 개수를 구하기 위해서 사용

			count = gettotalpage(totalList, countList, page, countpage, request); 
			// 검색 전 페이징 처리 메서드

			ArrayList<StudyListCount> studiespaging = getter.getStudyPaging(count[0], count[1]); 
			// 페이징 기법을 통해서 보여주기 위한  부분
			
			request.setAttribute("studies", studiespaging);
		}

		getter.close();

		System.out.println("상태는 : " + request.getParameter("state"));
		if (request.getParameter("state") != null) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/study/sources/search/section2.jsp");
			dispatcher.forward(request, response);
			System.out.println("아작스 실행--------------------------완료-------------------------");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/study/search.jsp");
			dispatcher.forward(request, response);
			System.out.println("--------------------------완료-------------------------");
		}
	}


	
	// 중복되는 부분 메서드 처리
	public int[] gettotalpage(int totalList, int countList, int page, int countpage, HttpServletRequest request) {
		int count[] = new int[2];

		int totalpage = totalList / countList;
		if (totalList % countList > 0) {
			totalpage++;
		}
		System.out.println("총페이지의 수는 :" + totalpage);

		if (totalpage < page) {
			page = totalpage;
		}

		int startpage = ((page - 1) / countpage) * countpage + 1; // 시작 페이지를 구하는 방법
		int endpage = startpage + countpage - 1; //

		if (endpage > totalpage) { // startpage 와 endpage 만으로는 계산을하게 되면 26개의 페이지수가 나오더라도 30페이지가 나타나기 떄문에 조건문을 사용해
									// 토탈페이지의 값을 바꿔준다
			endpage = totalpage;
		}

	
		int startcount = (page - 1) * countpage + 1; // 한페이지에 표시할 5개의 스터디중 시작 번호(rownum)
		int endcount = page * countpage; // 한페이지에 표시할 5개의 스터디중 끝나는 번호 (rownum)

		count[0] = startcount;
		count[1] = endcount;

		request.setAttribute("startpage", startpage);
		request.setAttribute("page", page);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("endpage", endpage);
		return count;
	}
}