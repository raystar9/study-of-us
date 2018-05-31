package servlet.study.each.fee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.study.each.InformSetupMember;
import dao.DataGetter;
import dao.DatabaseAccounts;


@WebServlet("/study/each/cashregister")
public class CashRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CashRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("회비등록 서블릿 들어옴");
		DataGetter getter = new DataGetter(DatabaseAccounts.SCOTT);
		
		int membercount = getter.getInformMemberCount();	//스터디 참여인원
		
		ArrayList<InformSetupMember> memlist = new ArrayList<InformSetupMember>(); //스터디 참여인원의 정보
		memlist = getter.getInformMember();
		String[] names = new String[memlist.size()];
		
		for(int i=0; i<memlist.size(); i++) {
			names[i] = memlist.get(i).getName();
		}
		
		request.setAttribute("names", names); 	
		request.setAttribute("membercount", membercount);
		getter.close();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/cashRegister.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
