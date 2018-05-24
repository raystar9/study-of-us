package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.prototype.Member;
import dao.DataAccessor;
import dao.DataPoster;
import dao.DatabaseAccounts;
import dao.exceptions.DatabaseConnectException;

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
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setName(request.getParameter("name"));
		member.setPassword(request.getParameter("password"));
		member.setEmail(request.getParameter("email"));
		member.setTel(Integer.parseInt(request.getParameter("tel")));
		member.setAddress(request.getParameter("area"));
		member.setGender(request.getParameter("gender"));
		member.setIntroduce(request.getParameter("introduce"));
		//TODO 회원가입 완료 했다는 페이지 만들어줘야된다. 전화번호 디비에 저장될때 맨앞에 0이면 0 이 생략됨.
		
		
		ExceptionHandler.general(new ExceptionHandleable() 
		{
			@Override
			public DataAccessor methods() throws DatabaseConnectException, SQLException {
				// TODO Auto-generated method stub
				DataPoster poster = new DataPoster(DatabaseAccounts.ADMIN);//계정이름은 context 에 서 정해줄 수 있다 현재 system/1234
				poster.postMembers(member);			//멤버값을 받아오고
				return poster;						// try 캐치문을 실행해주기위해 리턴을 보낸다.!
			}
		});
		RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
		dispatcher.forward(request, response);
		
		
	}
}
