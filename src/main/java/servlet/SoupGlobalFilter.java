package servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataGetter;
import dao.DatabaseAccounts;
import servlet.study.List;
import servlet.study.Registration;
import servlet.study.SearchMain;
import servlet.study.Studylist;
import servlet.study.each.Information;
import servlet.study.each.Setup;
import servlet.study.each.attendance.Attendance;
import servlet.study.each.attendance.AttendanceConfirm;
import servlet.study.each.attendance.AttendanceEach;
import servlet.study.each.board.BoardDelete;
import servlet.study.each.board.BoardFileDown;
import servlet.study.each.board.BoardList;
import servlet.study.each.board.BoardModify;
import servlet.study.each.board.BoardRegister;
import servlet.study.each.board.BoardView;
import servlet.study.each.board.CommentCount;
import servlet.study.each.board.CommentDelete;
import servlet.study.each.board.CommentInsert;
import servlet.study.each.board.CommentList;
import servlet.study.each.board.CommentUpdate;
import servlet.study.each.fee.CashList;
import servlet.study.each.fee.CashRegister;
import servlet.study.each.fee.CashView;
import servlet.study.each.schedule.EachSchedule;
import servlet.study.each.schedule.NewSchedule;
import servlet.study.each.schedule.Schedule;

/**
 * Servlet Filter implementation class SoupGlobalFilter
 */
@WebFilter("/*")
public class SoupGlobalFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SoupGlobalFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String[] uri = httpRequest.getRequestURI().split("/");
		String lastUri = uri[uri.length - 1];
		if(lastUri.endsWith(".jsp") || lastUri.endsWith(".js") || lastUri.endsWith(".css") || lastUri.endsWith(".woff") || lastUri.endsWith(".ttf")) {
			chain.doFilter(request, response);
		} else if(uri.length == 2) {
			httpResponse.sendRedirect("/study-of-us/home");
		} else {
			request.setAttribute("root", httpRequest.getContextPath());
			if(uri[2].equals("study")) {
				studyPaging(httpRequest, httpResponse, chain, uri);
			} else {
				chain.doFilter(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	private void studyPaging(HttpServletRequest request, HttpServletResponse response, FilterChain chain, String[] uri) throws IOException, ServletException {
		if(uri.length == 3) {
			new Studylist().service(request, response);
		} else if(uri.length == 4) {
			switch(uri[3]) {
			case "search":
				new SearchMain().service(request, response);
				break;
			case "list":
				new List().service(request, response);
				break;
			case "registration":
				new Registration().service(request, response);
				break;
			case "join":
				new Studylist().service(request, response);
				break;
			default : 
				String studyName = URLDecoder.decode(uri[3], "UTF-8");
				if(isMember(request, studyName)) {
					request.setAttribute("studyName", studyName);					
					request.getRequestDispatcher("/study/each/schedule.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/study/each/not-member.jsp").forward(request, response);
				}
				break;
			}
		} else if(uri.length > 4) {
			String studyName = URLDecoder.decode(uri[3], "UTF-8");
			request.setAttribute("studyName", studyName);
			if(isMember(request, studyName)) {
				switch(uri[4]) {
				case "board":
					boardPaging(request, response, chain, uri);
					break;
				case "comment":
					commentPaging(request, response, chain, uri);
					break;
				case "schedule":
					schedulePaging(request, response, chain, uri);
					break;
				case "attendance":
					attendancePaging(request, response, chain, uri);
					break;
				case "fee":
					feePaging(request, response, chain, uri);
					break;
				case "information":
					new Information().service(request, response);
					break;
				case "setup":
					new Setup().service(request, response);
					break;
				default:
					chain.doFilter(request, response);
				}
			} else {
				request.getRequestDispatcher("/study/each/not-member.jsp").forward(request, response);
			}
		}
	}
	
	private void commentPaging(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			String[] uri) throws IOException, ServletException {
		switch(uri[5]) {
		case "list":
			new CommentList().service(request, response);
			break;
		case "count":
			new CommentCount().service(request, response);
			break;
		case "insert":
			new CommentInsert().service(request, response);
			break;
		case "update":
			new CommentUpdate().service(request, response);
			break;
		case "delete":
			new CommentDelete().service(request, response);
			break;
		default :
			chain.doFilter(request, response);
			break;
		}
	}

	private void boardPaging(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			String[] uri) throws IOException, ServletException {
		if(uri.length == 5){
			new BoardList().service(request, response);
		} else {
			switch(uri[5]) {
			case "view":
				new BoardView().service(request, response);
				break;
			case "filedown":
				new BoardFileDown().service(request, response);
				break;
			case "register":
				new BoardRegister().service(request, response);
				break;
			case "modify":
				new BoardModify().service(request, response);
				break;
			case "delete":
				new BoardDelete().service(request, response);
				break;
			default :
				chain.doFilter(request, response);
				break;
			}
		}
	}

	private void feePaging(HttpServletRequest request, HttpServletResponse response, FilterChain chain, String[] uri) throws IOException, ServletException {
		if(uri.length == 5) {
			new CashList().service(request, response);
		} else {
			request.setAttribute("meetingId", uri[5]);
			if(uri.length == 6) {
				new CashView().service(request, response);
			} else if(uri[6].equals("register")) {
				new CashRegister().service(request, response);
			} else {
				chain.doFilter(request, response);
			}
		}
		
	}

	private void attendancePaging(HttpServletRequest request, HttpServletResponse response, FilterChain chain, String[] uri) throws IOException, ServletException {
		if(uri.length == 4 || uri.length == 5) {
			new Attendance().service(request, response);
		} else {
			request.setAttribute("meetingId", uri[5]);
			if(uri[6].equals("confirm")) {
				new AttendanceConfirm().service(request, response);
			} else if(uri[6].equals("record")) {
				new AttendanceEach().service(request, response);
			}
		}
	}

	private void schedulePaging(HttpServletRequest request, HttpServletResponse response, FilterChain chain, String[] uri) throws IOException, ServletException {
		if(uri.length == 5) {
			new Schedule().service(request, response);
		} else {
			switch(uri[5]) {
				case "new": 
					new NewSchedule().service(request, response);
					break;
				default:
					request.setAttribute("meetingId", uri[5]);
					new EachSchedule().service(request, response);
					break;
			}
		}
	}
	
	private boolean isLogin(HttpServletRequest request) throws IOException, ServletException {
		String id = (String) request.getSession().getAttribute("id");
		boolean isLogin = false;
		if(id != null) {
			isLogin = true;
		}
		return isLogin;
	}
	private boolean isMember(HttpServletRequest request, String studyName) throws IOException, ServletException {
		if(!isLogin(request)) {
			return false;
		}
		
		int id =(int)request.getSession().getAttribute("index");
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		ArrayList<Integer> memberIndexes = getter.getMemberIndexes(studyName);
		getter.close();
		boolean isMember = false;
		for(int memberIndex : memberIndexes) {
			if(memberIndex == id) {
				isMember = true;
			}
		}
		return isMember;
	}
}
