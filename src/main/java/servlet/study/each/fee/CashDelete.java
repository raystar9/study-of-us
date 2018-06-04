package servlet.study.each.fee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataPoster;
import dao.DatabaseAccounts;


@WebServlet("/study/each/cashdelete")
public class CashDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CashDelete() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num"));
		int studyIndex = 3;
		
		DataPoster poster = new DataPoster(DatabaseAccounts.SCOTT);
		
		/* 지우는 DB 메소드 만들어야 함 */
		
		/*poster.postBoardDelete(num, studyIndex);*/
		poster.close();
		
		response.sendRedirect("/study-of-us/study/each/cash");
	}

}
