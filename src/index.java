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
		out.println("  <BODY>");
		out.println(" <h1> Taco Assembly </h1>");
		out.print(" <a style = \"float: right; color: #000\"href = \"/TacoCar\">Shopping Car</a><br>");
		out.println(" <form action=\"/newTaco\">");
		for(ApiObj o: apiCrawler.getBaseLayer()) {
			out.printf(" <input type=\"checkbox\" name = \"baselayer\" value=\"%s\"> %s<br>", o.toString(), o.toString());
		}
		out.println("<br>");
		for(ApiObj o: apiCrawler.getMixin()) {
			out.printf(" <input type=\"checkbox\" name = \"mixin\" value=\"%s\"> %s<br>", o.toString(), o.toString());
		}
		out.println("<br>");
		for(ApiObj o: apiCrawler.getSeasoning()) {
			out.printf(" <input type=\"checkbox\" name = \"seasoning\" value=\"%s\"> %s<br>", o.toString(), o.toString());
		}
		out.println("<br>");
		for(ApiObj o: apiCrawler.getCondiment()) {
			out.printf(" <input type=\"checkbox\" name = \"condiment\" value=\"%s\"> %s<br>", o.toString(), o.toString());
		}
		out.println("<br>");
		for(ApiObj o: apiCrawler.getShell()) {
			out.printf(" <input type=\"checkbox\" name = \"shell\" value=\"%s\"> %s<br>", o.toString(), o.toString());
		}
		
		out.println(" <input type=\"submit\" value=\"Submit\">");
		out.println(" <input type=\"reset\"");
		out.println("</form>");
		out.println("<form method = \"post\" action = \"/addNewTaco\">");
		out.println("  </form>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}


}
