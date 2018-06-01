package param;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class ParameterGetter {
	public static HashMap<String, String> get(HttpServletRequest request) throws IOException{
		String queryString = new BufferedReader(new InputStreamReader(request.getInputStream())).readLine();
		HashMap<String, String> result = new HashMap<>();
		if(queryString != null) {
			String[] splitted = queryString.split("&");
			for(int i = 0; i < splitted.length; i++) {
				String[] keyValue = splitted[i].split("=");
				result.put(keyValue[0], URLDecoder.decode(keyValue[1], "utf-8"));
				System.out.println(URLDecoder.decode(keyValue[1], "utf-8"));
			}
		}
		return result;	
	}
}
