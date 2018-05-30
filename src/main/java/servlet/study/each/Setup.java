package servlet.study.each;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.study.each.InformSetup;
import beans.study.each.InformSetupMember;
import dao.DataGetter;
import dao.DataPoster;
import dao.DatabaseAccounts;


@WebServlet("/study/each/setup")
public class Setup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Setup() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataGetter getter = new DataGetter(DatabaseAccounts.SCOTT);
		
		int membercount = getter.getInformMemberCount();	//스터디 참여인원
		
		ArrayList<InformSetupMember> memlist = new ArrayList<InformSetupMember>(); //스터디 참여인원의 정보
		memlist = getter.getInformMember();
		
		InformSetup setup = new InformSetup();
		setup = getter.getInformation();	
		
		request.setAttribute("membercount", membercount); 	//스터디 참여인원
		request.setAttribute("memlist", memlist);			//스터디 참여인원의 정보
		request.setAttribute("setup", setup);
		getter.close();
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/setup.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataPoster poster = new DataPoster(DatabaseAccounts.SCOTT);
		InformSetup setup = new InformSetup();
		/*int index = Integer.parseInt(request.getParameter("studyIndex"));*/
		
		setup.setCategory("새로운카테");
		setup.setPeopleNum(request.getParameter("peopleNum"));
		setup.setName(request.getParameter("studyName"));
		setup.setPlace(request.getParameter("place"));
		setup.setActivityTime(request.getParameter("time"));
		setup.setStartDate(request.getParameter("startDate"));
		setup.setEndDate(request.getParameter("endDate"));
		setup.setDay(request.getParameter("day"));
		setup.setExplain(request.getParameter("explain"));
		setup.setPrepared(request.getParameter("prepared"));
		setup.setEffective(request.getParameter("effective"));
		
		System.out.println(setup.getName());
		poster.postSetup(setup);
		
		poster.close();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/setup.jsp");
		dispatcher.forward(request, response);
	}

}
