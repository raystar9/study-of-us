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

import beans.prototype.Study;
import beans.study.StudyListCount;
import dao.DataAccessor;
import dao.DataGetter;
import dao.DataPoster;
import dao.DatabaseAccounts;
import dao.exceptions.DatabaseConnectException;
import exceptionHanlder.ExceptionHandleable;
import exceptionHanlder.ExceptionHandler;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("스터디 검색 페이지");
		
		ExceptionHandler.general(new ExceptionHandleable() {
			
			@Override
			public DataAccessor methods() throws DatabaseConnectException, SQLException {

				DataGetter getter = new DataGetter(DatabaseAccounts.ADMIN);
				ArrayList<Study> studies = getter.getStudys();
				
				int page = 1; // 현재페이지
				int totalList = 0; // 총 스터디의 수
				int countList = 5; // 화면에 보여줄 스터디의 수
				int countpage = 5; // 
				
				System.out.println("page 값 "+request.getParameter("page"));
				
				totalList = studies.size();
				
				if(request.getParameter("page")==null) {
					page = 1;
				}else {
				page = Integer.parseInt(request.getParameter("page"));
				}
				
				int startcount = (page - 1)* countpage + 1; // 한페이지에 표시할 5개의 스터디중 시작 번호(rownum)
				int endcount = page * countpage;			// 한페이지에 표시할 5개의 스터디중 끝나는 번호 (rownum)
				
				System.out.println("startcount" + startcount);
				System.out.println("endcount" + endcount);
				
				ArrayList<StudyListCount> studiespaging = getter.getStudyPaging(startcount,endcount);
				
				
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
				request.setAttribute("studies", studiespaging);
				return getter;
				
			}
		});
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/search.jsp");
		dispatcher.forward(request, response);
		System.out.println("완료");
	}
}