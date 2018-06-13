package servlet.study.each.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import beans.study.each.board.BoardViewRegisterBean;
import dao.DataGetter;
import dao.DataPoster;
import dao.DatabaseAccounts;

@WebServlet("/study/each/boardregister")
public class BoardRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studyName = (String) (String)request.getAttribute("studyName");
		int personIndex = (int) request.getSession().getAttribute("index");
		
		
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		String writer = getter.getMemberName(studyName, personIndex);
		getter.close();
		
		request.setAttribute("writer", writer);
		System.out.println(writer);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/each/board/boardRegister.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("BoardRegister 서블릿으로 들어옴");
		// TODO Auto-generated method stub
		int personIndex = (int) request.getSession().getAttribute("index");
		String studyName = (String) (String)request.getAttribute("studyName");
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		int studyIndex = getter.getStudyIndex(studyName);
		getter.close();
		
		String realFolder = "";
		
		//WebContent아래에 꼭 폴더 생성
	    String saveFolder = "boardupload";
		
	    //업로드할 파일의 최대 사이즈
	    int fileSize = 5*1024*1024; 
		
	    //실제 저장 경로를 지정합니다.
	    ServletContext sc = request.getServletContext();
	    realFolder = sc.getRealPath(saveFolder);
	     
	    //파일 이름 찍어보기
	    System.out.println("realFolder = " + realFolder);
		
	    MultipartRequest multi = null;
	    multi = new MultipartRequest(request, realFolder, fileSize,"UTF-8",new DefaultFileRenamePolicy());

	    //BoardBean 객체에 글 등록 폼에서 입력 받은 정보들을 저장
		BoardViewRegisterBean board = new BoardViewRegisterBean();
		board.setName(multi.getParameter("boardName"));
		board.setTitle(multi.getParameter("boardSubject"));
		board.setContent(multi.getParameter("boardContent"));
		//업로드의 파일명은 업로드한 파일의 전체 경로에서 파일 이름만 저장합니다.
        board.setFilename(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
        System.out.println("filename=" + multi.getFilesystemName((String)multi.getFileNames().nextElement()));
        
		DataPoster poster = new DataPoster(DatabaseAccounts.PROJECT);
		poster.postBoard(board, studyIndex, personIndex); 
		poster.close();
		
		/* 사용자 아이디 session에서 가져오는 것 필요 */
        /* 사용자 아이디 session에서 저장해서 form으로 보내는 것 필요 */
		
		//나중엔 그 해당 글번호를 가져와서 등록한 글의 세부보기 페이지로 이동할 것임.
		response.sendRedirect("../board");
	}

}
