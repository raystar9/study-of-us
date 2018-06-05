package servlet.root;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//멤버에 인덱스 변수
		
		
		String id = (String)session.getAttribute("id");
		
		System.out.println("홈에서 받는 맴버 인덱스 번호 " + id);
		
		
		if(id == null) {
			System.out.println("로그인 전 메인페이지");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Main.jsp");
			dispatcher.forward(request, response);
		}else {
			System.out.println("로그인 후 메인페이지");
			response.sendRedirect("/study-of-us/study/list");
		}
		/*if(index == 0 ) {
			System.out.println("로그인 전 메인페이지");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Main.jsp");
			dispatcher.forward(request, response);
		}else {
			System.out.println("로그인 후 메인페이지");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/study/list");
			dispatcher.forward(request, response);	
		}*/
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}