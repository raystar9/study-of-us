package servlet.root;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.prototype.Member;
import dao.DataPoster;
import dao.DatabaseAccounts;

/**
 * Servlet implementation class InsertMember
 */
@WebServlet("/join")
public class JoinPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("/joinForm.jsp");
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		System.out.println(request.getParameter("location"));
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setName(request.getParameter("name"));
		member.setPassword(request.getParameter("password"));
		member.setEmail(request.getParameter("email"));
		member.setTel(request.getParameter("tel"));
		member.setAddress(request.getParameter("location"));
		member.setGender(request.getParameter("gender"));
		member.setIntroduce(request.getParameter("introduce"));
		
		
		
		
		//TODO 회원가입 완료 했다는 페이지 만들어줘야된다. 전화번호 디비에 저장될때 맨앞에 0이면 0 이 생략됨.
		
		
		
		DataPoster poster = new DataPoster(DatabaseAccounts.PROJECT);//계정이름은 context 에 서 정해줄 수 있다 현재 system/1234
		int result = poster.postMembers(member);
		poster.close();
		if(result == 1) {
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('회원가입이 완료되었습니다 ^^');");
			out.print("location.href='/study-of-us/home';");
			out.print("</script>");
		}
		/*response.sendRedirect("/study-of-us/home");*/
		/*RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
		dispatcher.forward(request, response);*/
	}
}
