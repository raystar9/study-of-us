package servlet.root;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDown
 */
@WebServlet("/fileDown")
public class FileDown extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String filename = request.getParameter("filename");		//엥커태그로 보낸이름 받고
		System.out.println(filename);
		String savePath = "inquiryupload";
		
		ServletContext context = request.getServletContext(); 
    	String sDownloadPath = context.getRealPath(savePath);
    	
    	String sFilePath = sDownloadPath + "/" + filename;				//★실질적으로 파일이있을 위치
    	System.out.println(filename);
		
    	byte b[] = new byte[4096];
    	
    	
    	String sMimeType = context.getMimeType(sFilePath);			//페이지에 뿌려줄때 나타내는 방식 ex) html, png, jpg 이런거 나타내는애
    	System.out.println("sMimeType >>>" + sMimeType);
		
    	if(sMimeType == null)
    		sMimeType = "application/octet-stream";					//마임타입이 없는애들은 이렇게 나타내줘라
    	response.setContentType(sMimeType);
    	
    	String sEncoding =
				new String(filename.getBytes("UTF-8"),"ISO-8859-1");			//iso : 서버가 갖고 있는 캐릭터
			System.out.println(sEncoding);
			
			response.setHeader("Content-Disposition","attachment; filename = " + sEncoding);		//response 는 요청에 대해 응답을 전달해주는 객체이다
			
			
			try(
					
					//웹브라우저로의 출력 스트림 생성합니다.
						BufferedOutputStream out2 = 
						new BufferedOutputStream(response.getOutputStream());
					//sFilePath 로 지정한 파일에 대한 입력 스트림을 생성합니다.
						BufferedInputStream in =
						new BufferedInputStream(new FileInputStream(sFilePath));)
				{
					int numRead;
					//read(b,0, b.length) : 바이트 배열 b의 0번 부터 b.length
					//크기 만큼 읽어옵니다.
						while((numRead = in.read(b,0,b.length)) != -1) {//읽을게 없으면
							//바이트 배열 b의 0 번부터 numRead 크기만큼 브라우저 출력
							out2.write(b,0,numRead);
						}
				}
    	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
