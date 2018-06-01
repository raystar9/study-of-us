package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		
		String queryString = new BufferedReader(new InputStreamReader(request.getInputStream())).readLine();
		if(queryString != null) {
			String[] splitted = queryString.split("&");
			for(int i = 0; i < splitted.length; i++) {
				String[] keyValue = splitted[i].split("=");
				request.setAttribute(keyValue[0], URLDecoder.decode(keyValue[1], "utf-8"));
				System.out.println(URLDecoder.decode(keyValue[1], "utf-8"));
			}
		}
		
		if(httpRequest.getRequestURI().split("/")[2].equals("test")) {
			new TestPage().doGet(httpRequest, httpResponse);
		} else {
			httpRequest.setAttribute("root", httpRequest.getContextPath());
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
