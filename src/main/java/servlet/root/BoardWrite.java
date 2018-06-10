package servlet.root;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import beans.prototype.Inquiry;
import dao.DataPoster;
import dao.DatabaseAccounts;

@WebServlet("/boardWrite")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Inquiry inquiry = new Inquiry();
		
		
		
		HttpSession session = request.getSession();
		int index = (int) session.getAttribute("index");
		System.out.println("write 에서받는 멤버 인덱스 번호"  + index);
		
		String realFolder = "";
		
		
		String saveFolder = "inquiryupload";
		
		int size = 5 * 1024 * 1024;
		
		ServletContext sc = request.getServletContext();
		realFolder = sc.getRealPath(saveFolder);

		System.out.println("realFolder=" + realFolder);
		boolean result = false;
		
		
		
		try {

			/*
			 * 업로드를 담당하는 부분입니다. -첫 번째 인자 request : 폼에서 가져온 값을 얻기 위해 request 객체를 전달해줍니다. -두
			 * 번째 인자 uploadPath : 업로드될 파일의 위치 입니다. -세 번째 인자 size : 업로드 할 크기이며 지정 크기보다 크면
			 * Excetption 발생합니다. -네 번째 인자 "euc-kr" : 파일 이름이 한글인 경우 처리하는 부분입니다. -다섯 번째 인자 :
			 * 똑같은 파일을 업로드 할 경우 중복되지 않도록 자동으로 파일이름을 변환해주는 기능을 합니다.
			 */
			MultipartRequest multi = new MultipartRequest(request, realFolder, size, "UTF-8",
					new DefaultFileRenamePolicy());
			
			inquiry.setM_id(multi.getParameter("id"));
			inquiry.setSubject(multi.getParameter("subject"));
			inquiry.setContent(multi.getParameter("content"));

			// 업로드의 파일명은 업로드한 파일의 전체 경로에서 파일 이름만 저장합니다.
			inquiry.setFile(multi.getFilesystemName((String) multi.getFileNames().nextElement())); // 첨부파일 명
			
			
			DataPoster poster = new DataPoster(DatabaseAccounts.PROJECT);
			result = poster.writeInquiry(inquiry,index);
			poster.close();
			if (result == false) {
				System.out.println("게시판 등록 실패");
			} else {
				System.out.println("게시판 등록 성공");
			}

			// 글 등록이 완료되면 글 목록을 단순히 보여주기만 할 것이므로
			// Redircet 여부를 true 로 설정합니다.
			
			
			response.sendRedirect("/study-of-us/inquiryPage");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
