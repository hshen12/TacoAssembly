import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ChooseServer {

	private APICrawler apiCrawler;
	private int port;
	static TacoResult choose;
	
	
	public ChooseServer(APICrawler apiCrawler) {
		this.apiCrawler = apiCrawler;
		this.port = 8080;
		ChooseServer.choose = new TacoResult();
	}
	
	
	
	public ChooseServer(int port, APICrawler apiCrawler) {
		this.apiCrawler = apiCrawler;
		this.port = port;
		ChooseServer.choose = new TacoResult();
	}

	public void serverStarts() {
		Server server = new Server(port);
		ServletHandler handler = new ServletHandler();
		
		handler.addServletWithMapping(new ServletHolder(new THistory()), "/Taco Car");
		
		
		server.setHandler(handler);
		try {
			server.start();
			server.join();
		} catch(Exception e) {
			System.err.println("error during the servlet");
		}
		
	}

}
