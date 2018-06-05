package servlet.study.each.fee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.study.each.fee.CashExpenseBean;
import dao.DataGetter;
import dao.DatabaseAccounts;


@WebServlet("/study/each/cashview")
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
		 //그 날의 총 걷은 금액 합계 쿼리로 짜서 DB에서 가져오기
		 int totalFee = getter.get   View(Integer.parseInt(request.getParameter("num")), studyIndex)
		 //그 날의 총 지출 금액 합계 쿼리로 짜서 DB에서 가져오기
		 int totalExpense = getter.get   View(Integer.parseInt(request.getParameter("num")), studyIndex)
		 int total = totalFee - totalExpense;
		 //원래 있었던 총계 + total;
		 int allTotal = getter.get   View(Integer.parseInt(request.getParameter("num")), studyIndex)
		 
		//지출금액 , 지출내역 가져오는 Bean
		CashExpenseBean expense = getter.get   View(Integer.parseInt(request.getParameter("num")), studyIndex);
		//회원명단, 회비, 비고 가져오는 Bean
		CashMemberBean mem = getter.get   View(Integer.parseInt(request.getParameter("num")), studyIndex);
		
		request.setAttribute("expense", expense);
		request.setAttribute("mem", mem);
		request.setAttribute("totalFee", totalFee)			//총 걷은 회비
		request.setAttribute("totalExpense", totalExpense)	//총 지출한 금액
		request.setAttribute("total", total)				//그날 총 회비 - 지출금액
		request.setAttribute("allTotal", allTotal)			//쌓여있던 회비 + total
		request.setAttribute("cash", cashInform);			//그 회비등록 날짜와 index번호 가져오는 테이터
		
		*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/cashView.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
