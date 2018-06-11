package servlet.study.each;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.prototype.Study;
import dao.DataGetter;
import dao.DatabaseAccounts;

@WebServlet("/study/each/participate")
public class Participate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Participate() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
	
		System.out.println(request.getSession().getAttribute("id"));
		if(request.getSession().getAttribute("id") == null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('참여는 로그인 후에 이용 가능합니다.');");
			out.println("history.back()");
			out.println("</script>");
		}else {
			int index = Integer.parseInt(request.getParameter("index"));
			ArrayList<Study> study = getter.getStudies(index); // 인덱스번호를 통해 선택된 스터디를 찾음
			request.setAttribute("study", study);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/participate.jsp");
			dispatcher.forward(request, response);
		}
	
	}

	
	

}
