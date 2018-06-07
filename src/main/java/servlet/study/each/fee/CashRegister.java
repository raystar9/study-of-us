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
import beans.study.each.fee.CashExpenseBean;
import beans.study.each.fee.CashMemberBean;
import beans.study.each.fee.CashViewRegisterBean;
import dao.DataGetter;
import dao.DataPoster;
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
		System.out.println("CashRegister 서블릿 들어옴");
		DataGetter getter = new DataGetter(DatabaseAccounts.SCOTT);
		
		ArrayList<InformSetupMember> memlist = new ArrayList<InformSetupMember>(); //스터디 참여인원의 정보
		memlist = getter.getInformMember();
		String[] names = new String[memlist.size()];
		
		for(int i=0; i<memlist.size(); i++) {
			names[i] = memlist.get(i).getName();
		}
		
		request.setAttribute("names", names); 	
		getter.close();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/cashRegister.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataGetter getter = new DataGetter(DatabaseAccounts.SCOTT);
		DataPoster poster = new DataPoster(DatabaseAccounts.SCOTT);
		int memcount = getter.getInformMemberCount();
		
		//스터디원 별 낸 회비, 비고
		ArrayList<CashMemberBean> mem = new ArrayList<CashMemberBean>();
		int memFeeTotal = 0;
		for(int i=1; i<=memcount; i++) {
			CashMemberBean m = new CashMemberBean();
			m.setName(request.getParameter("name" + i));
			m.setMemfee(Integer.parseInt(request.getParameter("duesFee" + i)));
			m.setNote(request.getParameter("duesNote" + i));
			memFeeTotal += Integer.parseInt(request.getParameter("duesFee" + i));
			mem.add(m);
		}
		
		//사용 내역, 금액
		int expenseCount = Integer.parseInt(request.getParameter("expenseCount"));
		int expenseTotal = 0;
		ArrayList<CashExpenseBean> expense = new ArrayList<CashExpenseBean>();
		for(int j=1; j<=expenseCount; j++) {
			CashExpenseBean ex = new CashExpenseBean();
			ex.setContent(request.getParameter("duesExp" + j));
			ex.setExpense(Integer.parseInt(request.getParameter("duesExpFee" + j)));
			expenseTotal += Integer.parseInt(request.getParameter("duesExpFee" + j));
			expense.add(ex);
		}
		
		//날짜, 총액 등
		CashViewRegisterBean cash = new CashViewRegisterBean();
		cash.setDate(request.getParameter("duesDate"));
		cash.setMemfeetotal(memFeeTotal);
		cash.setExpensetotal(expenseTotal);
		cash.setAlltotal(memFeeTotal-expenseTotal);
		
		
		getter.close();
		poster.close();
		
		response.sendRedirect("/study-of-us/study/each/cash");
	}

}
