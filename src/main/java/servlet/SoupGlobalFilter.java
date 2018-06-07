package servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.study.each.attendance.Attendance;
import servlet.study.each.attendance.AttendanceConfirm;
import servlet.study.each.attendance.AttendanceEach;
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
			request.setAttribute("uri", uri);
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
			uri[3] = "each";
			request.setAttribute("eachStudyPath", getPath(2, 4, uri));
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
					default:
						chain.doFilter(request, response);
				}
			}
		}
	}
	
	private void attendancePaging(HttpServletRequest request, HttpServletResponse response, FilterChain chain, String[] uri) throws IOException, ServletException {
		if(uri.length == 4 || uri.length == 5) {
			new Attendance().service(request, response);
		} else {
			uri[5] = "each";
			request.setAttribute("eachAttendancePath", getPath(2, 6, uri));
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
					new EachSchedule().service(request, response);
					break;
			}
		}
	}
	
	private String getPath(int start, int end, String[] uri) {
		String result = "";
		for(int i = start; i < end; i++ ) {
			result += "/" + uri[i];
		}
		return result;
	}
}
