import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class NewTaco extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		response.sendRedirect("/"+request.getParameter("baselayer"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		response.sendRedirect("/"+request.getParameter("baslayer"));
//		request.getParameterValues("baslayer");
		System.out.println(Arrays.deepToString(request.getParameterValues("baslayer")));
	}
	
	
}
