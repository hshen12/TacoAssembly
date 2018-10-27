import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class index extends HttpServlet {

	private APICrawler apiCrawler;

	public index(APICrawler apiCrawler) {
		this.apiCrawler = apiCrawler;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.sendRedirect("/");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {


		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>Search engine</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print(" <p> Taco Car </p>");
		for(ApiObj o: apiCrawler.getBaseLayer()) {
			out.printf(" <p>%s<br/>",o.toString());
		}

		out.print(" </p>");
		out.println("<form method = \"post\" action = \"/search history\">");
		out.println(" <input type=\"submit\" value=\"Clear\"  >");
		out.println("  </form>");
		out.printf("<a href=\"/?query=%s&ifAdd=false\">Click here back to Home page.</a>",request.getParameter("query"));
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}


}
