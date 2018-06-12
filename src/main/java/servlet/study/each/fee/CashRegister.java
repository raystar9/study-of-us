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
import beansNew.FeeCollect;
import beansNew.FeeSpend;
import dao.DataGetter;
import dao.DataPoster;
import dao.DatabaseAccounts;


@WebServlet("/study/each/fee/each/register")
public class CashRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CashRegister() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("CashRegister 서블릿 들어옴");
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		if(getter.isFeeRegistered((String)request.getAttribute("meetingId"))) {
			request.getRequestDispatcher("/study/each/fee/already-registered.jsp").forward(request, response);
			
		} else {
			String studyName = (String)request.getAttribute("studyName");
			
			ArrayList<InformSetupMember> memlist = new ArrayList<InformSetupMember>(); //스터디 참여인원의 정보
			memlist = getter.getInformMember(studyName);
			String[] names = new String[memlist.size()];
			
			for(int i=0; i<memlist.size(); i++) {
				names[i] = memlist.get(i).getName();
			}
			
			ArrayList<Integer> memIndex = getter.getMemberIndexes(studyName);
			
			request.setAttribute("memIndex", memIndex);
			request.setAttribute("names", names); 	
			getter.close();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/fee/cashRegister.jsp");
			dispatcher.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		ArrayList<Integer> memberIndexes = getter.getMemberIndexes((String)request.getAttribute("studyName"));
		getter.close();
		DataPoster poster = new DataPoster(DatabaseAccounts.PROJECT);
		
		int meetingId = Integer.parseInt((String)request.getAttribute("meetingId"));
		//스터디원 별 낸 회비, 비고
		ArrayList<FeeCollect> mem = new ArrayList<>();
		for(int i=0; i<memberIndexes.size(); i++) {
			FeeCollect collect = new FeeCollect();
			collect.setMeetingId(meetingId);
			collect.setMemberId(memberIndexes.get(i));
			collect.setFee(Integer.parseInt(request.getParameter("duesFee" + (i+1))));
			collect.setNote(request.getParameter("duesNote" + (i+1)));
			mem.add(collect);
		}
		poster.postFeeMemberInsert(mem);
		
		int expenseCount = Integer.parseInt(request.getParameter("expenseCount"));
		//사용 내역, 금액
		ArrayList<FeeSpend> spends = new ArrayList<>();
		for(int i=0; i<expenseCount; i++) {
			FeeSpend spend = new FeeSpend();
			spend.setMeetingId(meetingId);
			spend.setExpense(Integer.parseInt(request.getParameter("duesExpFee" + (i+1))));
			spend.setComment(request.getParameter("duesExp" + (i+1)));
			spends.add(spend);
		}
		poster.postFeeSpend(spends);
		
		poster.close();
		
		response.sendRedirect("../");
	}

}
