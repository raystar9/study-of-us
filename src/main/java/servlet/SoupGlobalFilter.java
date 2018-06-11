package servlet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.study.each.Information;
import servlet.study.each.Setup;
import servlet.study.each.attendance.Attendance;
import servlet.study.each.attendance.AttendanceConfirm;
import servlet.study.each.attendance.AttendanceEach;
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
		} else if(uri.length >= 3) {
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
			//TODO study 기본페이지 구현해야됨!
		} else {
			if(uri[3].equals("search")) {
				chain.doFilter(request, response);
			}
			
			request.setAttribute("studyName", URLDecoder.decode(uri[3], "UTF-8"));
			if(uri.length == 4) {
				//TODO 각study의 기본 페이지로
			} else {
				switch(uri[4]) {
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
}
