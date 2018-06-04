package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDispatcher {
	public static void forward(HttpServletRequest request, HttpServletResponse response, String requestURL) throws ServletException, IOException {
		String[] uri = (String[]) request.getAttribute("uri");
		String path = "";
		for(int i = 2; i < uri.length - 1; i++) {
			path += '/' + uri[i];
		}
		System.out.println(path);
		request.getRequestDispatcher(path + '/' + requestURL).forward(request, response);;
	}
}
