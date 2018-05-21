package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.prototype.Member;
import dao.DataAccessor;
import dao.DataGetter;
import dao.DatabaseAccounts;
import dao.exceptions.DatabaseConnectException;

@WebServlet("/test")
public class TestPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * ExceptionHandler는 Exception이 발생하는 함수를 한데 모아 같은 결과로 처리해주는 클래스다.
		 */
		ExceptionHandler.general(new ExceptionHandleable() {
			
			@Override
			public DataAccessor methods() throws DatabaseConnectException, SQLException {
				
				DataGetter getter = new DataGetter(DatabaseAccounts.ADMIN);
				ArrayList<Member> members = getter.getMembers();
				
				for(Member member  : members) {
					System.out.println((member.getId()));
				}
				
				return getter;
			}
			
		});
		
		/*
		 * 람다식을 사용한 경우(위와 같은 코드임)
		 */
		
//		ExceptionHandler.general(()->{
//			DataGetter getter = new DataGetter(DatabaseAccounts.ADMIN);
//			ArrayList<Member> members = getter.getMembers();
//			
//			for(Member member  : members) {
//				System.out.println((member.getId()));
//			}
//			return getter;
//		});
		
	}
}
