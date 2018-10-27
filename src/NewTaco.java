import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class NewTaco extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("here");
		response.sendRedirect("/"+request.getParameter("baselayer"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		String[] baselayerArr = request.getParameterValues("baselayer");
		String[] mixinArr = request.getParameterValues("mixin");
		String[] seasoningArr = request.getParameterValues("seasoning");
		String[] condimentArr = request.getParameterValues("condiment");
		String[] shellArr = request.getParameterValues("shell");
		ChooseServer.choose.addMutipleIngredient(baselayerArr, mixinArr, seasoningArr, condimentArr, shellArr);
		response.sendRedirect("/addNewTaco");
	}
	
	
}
