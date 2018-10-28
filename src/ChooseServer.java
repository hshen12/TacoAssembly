import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ChooseServer {

	private APICrawler apiCrawler;
	private int port;
	static TacoResult choose;
	
	/**
	 * Constructor 
	 * 	use default port number to set the server
	 * @param apiCrawler data structure to store the web api
	 */
	public ChooseServer(APICrawler apiCrawler) {
		this.apiCrawler = apiCrawler;
		this.port = 8080;
		ChooseServer.choose = new TacoResult();
	}
	
	/**
	 * Constructor
	 * 	set the server to given port
	 * @param port given port number
	 * @param apiCrawler data structure to store the web api
	 */
	public ChooseServer(int port, APICrawler apiCrawler) {
		this.apiCrawler = apiCrawler;
		this.port = port;
		ChooseServer.choose = new TacoResult();
	}

	/**
	 * Start the server
	 */
	public void serverStarts() {
		Server server = new Server(port);
		ServletHandler handler = new ServletHandler();
		
		handler.addServletWithMapping(new ServletHolder(new index(apiCrawler)), "/");
		handler.addServletWithMapping(new ServletHolder(new THistory()), "/TacoCar");
		handler.addServletWithMapping(new ServletHolder(new NewTaco()), "/addNewTaco");
		
		server.setHandler(handler);
		try {
			server.start();
			server.join();
		} catch(Exception e) {
			System.err.println("error during the servlet");
		}
		
	}

}
