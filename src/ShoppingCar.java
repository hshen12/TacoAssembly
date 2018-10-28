import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ShoppingCar extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>Taco Shopping Car</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print(" <h1> Taco Shopping Car </h1>");
		if(!ChooseServer.choose.isEmpty()) {
			int index = 1;
			for(Taco o: ChooseServer.choose.getResult()) {
				out.printf(" <p><h2>Taco %d</h2><br/>"
						+ "%s<br/>"
						+ "Date: %s<br/>",index, o.webAppToString(), o.getData());
				index++;
			}
		} else {
			out.println("empty car");
		}
		out.print(" </p>");
		out.println("<form method=\"post\" action=\"/TacoCar\">");
		out.println(" <input type=\"submit\" value=\"Clear\"  >");
		out.println("  </form>");
		out.println("<br> <a href=/>Click here back to Home page.</a> <br/>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		ChooseServer.choose.clear();
		doGet(request,response);
	}


}
