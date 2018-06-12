package servlet.study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataPoster;
import dao.DatabaseAccounts;

/**
 * Servlet implementation class Message
 */
@WebServlet("/study/Message")
public class Message extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		int sm_s_index = Integer.parseInt(request.getParameter("sm_s_index"));
		int sm_m_index = Integer.parseInt(request.getParameter("sm_m_index"));
		int s_index = Integer.parseInt(request.getParameter("sm_index"));
		
			DataPoster poster = new DataPoster(DatabaseAccounts.PROJECT);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			System.out.println("거절 합니다222222222222"+request.getParameter("reject"));

			System.out.println("s_index : " + s_index);
			System.out.println("sm_m_index : " + sm_m_index);
			System.out.println("sm_s_index : " + sm_s_index);
			
			if(request.getParameter("reject")==null) {
				
			System.out.println("s_index : " + s_index);
			System.out.println("sm_m_index : " + sm_m_index);
			System.out.println("sm_s_index : " + sm_s_index);
			
			
			poster.Insertindex(s_index,sm_m_index);
			poster.delMessage(s_index,sm_m_index);
		
			out.println("<script>");
			out.println("alert('수락 했습니다.');");
			out.println("location.href = '/study-of-us/study/list' ");
			out.println("</script>");
			}else {
				poster.delMessage(s_index,sm_m_index);
				out.println("<script>");
				out.println("alert('거절 했습니다.');");
				out.println("location.href = '/study-of-us/study/list' ");
				out.println("</script>");
			}
	}
}
