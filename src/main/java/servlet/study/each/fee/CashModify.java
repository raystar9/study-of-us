package servlet.study.each.fee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/study/each/cashmodify")
public class CashModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CashModify() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/* 가져오는 메소드로 가져오고 */

		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/cashModify.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/* 수정하는 메소드 만들기 */
		
	}

}
