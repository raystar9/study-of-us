package servlet.study.each.fee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.study.each.fee.CashExpenseBean;
import beans.study.each.fee.CashMemberBean;
import beans.study.each.fee.CashViewRegisterBean;
import dao.DataGetter;
import dao.DatabaseAccounts;


@WebServlet("/study/each/fee/each")
public class CashView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CashView() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataGetter getter = new DataGetter(DatabaseAccounts.SCOTT);
		int studyIndex = 3; 
		
		/*
		//날짜,지출총액,회비총액,누적총액 Bean
		CashViewRegisterBean cash = new CashViewRegisterBean();
		cash = getter.getXXX(Integer.parseInt(request.getParameter("num")), studyIndex);
		
		//각각의 지출금액,지출내역 arrayList Bean
		ArrayList<CashExpenseBean> expense = new ArrayList<CashExpenseBean>();
		expense = getter.getXXX(Integer.parseInt(request.getParameter("num")), studyIndex);
		
		//회원명,회원마다 낸 회비,비고 arrayList Bean
		ArrayList<CashMemberBean> mem = new ArrayList<CashMemberBean>();
		mem = getter.getXXX(Integer.parseInt(request.getParameter("num")), studyIndex);
		
		request.setAttribute("cash", cash);				
		request.setAttribute("expense", expense);		
		request.setAttribute("mem", mem);				
		*/
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/fee/cashView.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
