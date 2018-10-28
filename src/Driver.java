import java.net.MalformedURLException;
import java.net.URL;

/**
 * Taco Assembly main 
 * 	usage: -port int -threads int
 * @author Hao Shen
 *
 */
public class Driver {

	public static void main(String[] args) {

		ArgumentMap maps = new ArgumentMap(args);
		final int threads = maps.getInteger("-threads", 5);
		final int default_port = 8080;
		APICrawler apiCrawler = new APICrawler(threads);

		URL baseLayerURL = null;
		URL mixinURL = null;
		URL seasoningURL = null;
		URL condimentURL = null;
		URL shellsURL = null;
		try {
			baseLayerURL = new URL("https://tacos-ocecwkpxeq.now.sh/baseLayers");
			mixinURL = new URL("https://tacos-ocecwkpxeq.now.sh/mixins");
			seasoningURL = new URL("https://tacos-ocecwkpxeq.now.sh/seasonings");
			condimentURL = new URL("https://tacos-ocecwkpxeq.now.sh/condiments");
			shellsURL = new URL("https://tacos-ocecwkpxeq.now.sh/shells");
		} catch (MalformedURLException e) {
			System.err.println("Unable to read the api.");
			return;
		}

		apiCrawler.crawl(baseLayerURL, mixinURL, seasoningURL, condimentURL, shellsURL, threads);

		if(maps.hasFlag("-port")){
			int inputPort = maps.getInteger("-port", default_port);
			ChooseServer server = new ChooseServer(inputPort, apiCrawler);
			server.serverStarts();
		} else {
			ChooseServer server = new ChooseServer(apiCrawler);
			server.serverStarts();
		}
	}

}
