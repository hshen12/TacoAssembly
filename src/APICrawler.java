import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Crawl the web api and store into an array list
 * @author Hao Shen
 *
 */
public class APICrawler {

	private WorkQueue wq;
	private ArrayList<ApiObj> baseLayerList;
	private ArrayList<ApiObj> mixinList;
	private ArrayList<ApiObj> seasoningList;
	private ArrayList<ApiObj> condimentList;
	private ArrayList<ApiObj> shellList;
	
	/**
	 * Constructor
	 * 	initialize all array list
	 * @param threads the number of threads we want to use in work queue
	 */
	public APICrawler(int threads) {
		this.baseLayerList = new ArrayList<ApiObj>();
		this.mixinList = new ArrayList<ApiObj>();
		this.seasoningList = new ArrayList<ApiObj>();
		this.condimentList = new ArrayList<ApiObj>();
		this.shellList = new ArrayList<ApiObj>();
	}
	
	/**
	 * Crawl the api web page and store the content into a array list
	 * @param baseLayerURL url seed
	 * @param mixinURL url seed
	 * @param seasoningURL url seed
	 * @param condimentURL url seed
	 * @param shellsURL url seed
	 * @param threads url seed
	 */
	public void crawl(URL baseLayerURL, URL mixinURL, URL seasoningURL, URL condimentURL, URL shellsURL, int threads) {
		wq = new WorkQueue(threads);
		if(shellsURL != null && mixinURL != null && seasoningURL != null &&  condimentURL!= null && shellsURL != null) {
			wq.execute(new URLTask(baseLayerURL, baseLayerList));
			wq.execute(new URLTask(condimentURL, condimentList));
			wq.execute(new URLTask(mixinURL, mixinList));
			wq.execute(new URLTask(seasoningURL, seasoningList));
			wq.execute(new URLTask(shellsURL, shellList));
			wq.finish();
			wq.shutdown();
		}
	}
	
	/**
	 * Return a unmodifiable version of baselayer list
	 * @return unmodifiable version of baselayer list
	 */
	public List<ApiObj> getBaseLayer() {
		return Collections.unmodifiableList(baseLayerList);
	}

	/**
	 * Return a unmodifiable version of mixin list
	 * @return unmodifiable version of mixin list
	 */
	public List<ApiObj> getMixin() {
		return Collections.unmodifiableList(mixinList);
	}
	
	/**
	 * Return a unmodifiable version of seasoning list
	 * @return unmodifiable version of seasoning list
	 */
	public List<ApiObj> getSeasoning() {
		return Collections.unmodifiableList(seasoningList);
	}
	
	/**
	 * Return a unmodifiable version of condiment list
	 * @return unmodifiable version of condiment list
	 */
	public List<ApiObj> getCondiment() {
		return Collections.unmodifiableList(condimentList);
	}
	
	/**
	 * Return a unmodifiable version of shell list
	 * @return unmodifiable version of shell list
	 */
	public List<ApiObj> getShell() {
		return Collections.unmodifiableList(shellList);
	}
	
	
	
}
