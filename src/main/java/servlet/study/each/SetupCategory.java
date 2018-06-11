package servlet.study.each;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.DataGetter;
import dao.DatabaseAccounts;


@WebServlet("/setupcategory")
public class SetupCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SetupCategory() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		DataGetter getter = new DataGetter(DatabaseAccounts.PROJECT);
		ObjectMapper mapper = new ObjectMapper();
		String mainCategory = request.getParameter("category1");
		String[] subCategory = new String[getter.getSubCategoryCount(mainCategory)];
		
		subCategory = getter.getSubCategory(mainCategory);
		
		for(int i=0; i<subCategory.length; i++) {
			System.out.println("subCategory = " + subCategory[i]);
		}
		
		PrintWriter out = response.getWriter();
		System.out.println(mapper.writeValueAsString(subCategory));
		out.println(mapper.writeValueAsString(subCategory));
		
		getter.close();
	}

}
