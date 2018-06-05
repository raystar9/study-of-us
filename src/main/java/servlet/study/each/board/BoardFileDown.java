package servlet.study.each.board;

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

@WebServlet("/study/each/boardfiledown")
public class BoardFileDown extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardFileDown() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String fileName = request.getParameter("filename");
		System.out.println("fileName = " + fileName);
		String savaPath = "./boardupload";

		// 서블릿의 실행 환경 정보를 담고 있는 객체를 리턴합니다.
		// (application 내장 객체를 리턴합니다.)
		ServletContext context = request.getServletContext();
		String sDownloadPath = context.getRealPath(savaPath);
		// 위 두 문장을 한 문장으로 나타내면 다음과 같습니다.
		// String sDownloadPath = application.getRealPath(savePath);

		String sFilePath = sDownloadPath + "/" + fileName;
		System.out.println(sFilePath);

		byte b[] = new byte[4096];

		String sMimeType = context.getMimeType(sFilePath);
		System.out.println("sMimeType>>>" + sMimeType);

		if (sMimeType == null) {
			sMimeType = "application/octet-stream";
		}
		response.setContentType(sMimeType);

		// 한글 파일명이 깨지는것을 방지해줌
		String sEncoding = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		// ISO-8859-1 톰캣이 가지고 있는 기본 캐릭터셋.
		System.out.println("sEncoding = " + sEncoding);

		// 다운로드 처리
		response.setHeader("Content-Disposition", "attachment; filename= " + sEncoding);

		try (
				// 웹 브라우저로의 출력 스트림 생성합니다.
				BufferedOutputStream out2 = new BufferedOutputStream(response.getOutputStream());
				// sFilePath로 지정한 파일에 대한 입력 스트림을 생성합니다.
				BufferedInputStream in = new BufferedInputStream(new FileInputStream(sFilePath));) {
			int numRead;
			// read(b, 0, b.length) : 바이트 배열 b의 0번부터 b.length
			// 크기 만큼 읽어옵니다.
			while ((numRead = in.read(b, 0, b.length)) != -1) {
				// 바이트 배열 b의 0번부터 numRead크기 만큼 브라우저로 출력
				out2.write(b, 0, numRead);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
