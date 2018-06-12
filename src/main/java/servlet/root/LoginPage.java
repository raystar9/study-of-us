package servlet.root;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.root.Login;
import beans.study.StudySearch;
import beans.study.each.Message;
import dao.DataGetter;
import dao.DatabaseAccounts;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);

		
		Login logpro = getter.getLogin(id);
		ArrayList<StudySearch> m_index = getter.getMindex(id);
		
		/*
		System.out.println( "리턴받아온 아이디 : "+logpro.getId());
		System.out.println( "리턴받아온 비밀번호 : "+logpro.getPassword());
		*/
		

		if (logpro == null || !logpro.getPassword().equals(password)) {
			System.out.println("logpro"+logpro);
			response.sendRedirect(("/study-of-us/LoginFail"));
		}
		else if (logpro.getPassword().equals(password)) {
			// 로그인 성공시 세션 생성
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("index", logpro.getIndex());
			System.out.println("세션값:" + session.getAttribute("index"));
			System.out.println("비번 " + logpro.getPassword());
			
			
			/*response.sendRedirect("/study-of-us/home");*/
			getter.close();
			response.sendRedirect("/study-of-us/home");
		}
		
	}

}
