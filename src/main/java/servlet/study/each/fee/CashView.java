package servlet.study.each.fee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.study.each.fee.FeeCollectListBean;
import beansNew.FeeCollect;
import beansNew.FeeSpend;
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
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		String studyName = (String) request.getAttribute("studyName");
		int meetingId = Integer.parseInt((String) request.getAttribute("meetingId"));
		ArrayList<FeeSpend> expenses = getter.getFeeExpense(meetingId);
		ArrayList<FeeCollectListBean> members = getter.getFeeMember(meetingId);
		int spentTotal = getter.getFeeSpentTotal(meetingId);
		int collectTotal = getter.getFeeCollectTotal(meetingId);
		request.setAttribute("expenses", expenses);
		request.setAttribute("members", members);
		int spentToday = 0;
		int collectToday = 0;
		for(FeeSpend fs : expenses) {
			spentToday += fs.getExpense();
		}
		for(FeeCollectListBean cb : members) {
			collectToday += cb.getFee();
		}
		
		request.setAttribute("collectToday", Integer.toString(collectToday));
		request.setAttribute("spentToday", Integer.toString(spentToday));
		
		request.setAttribute("remainedFee", Integer.toString(collectTotal - spentTotal));
		
		
		getter.close();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/fee/cashView.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
