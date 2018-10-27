import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class APICrawler {

	private WorkQueue wq;
	private ArrayList<ApiObj> baseLayerList;
	private ArrayList<ApiObj> mixinList;
	private ArrayList<ApiObj> seasoningList;
	private ArrayList<ApiObj> condimentList;
	private ArrayList<ApiObj> shellList;
	
	public APICrawler(int threads) {
		this.baseLayerList = new ArrayList<ApiObj>();
		this.mixinList = new ArrayList<ApiObj>();
		this.seasoningList = new ArrayList<ApiObj>();
		this.condimentList = new ArrayList<ApiObj>();
		this.shellList = new ArrayList<ApiObj>();
	}
	
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
	
	public List<ApiObj> getBaseLayer() {
		return Collections.unmodifiableList(baseLayerList);
	}

	public List<ApiObj> getMixin() {
		return Collections.unmodifiableList(mixinList);
	}
	
	public List<ApiObj> getSeasoning() {
		return Collections.unmodifiableList(seasoningList);
	}
	
	public List<ApiObj> getCondiment() {
		return Collections.unmodifiableList(condimentList);
	}
	
	public List<ApiObj> getShell() {
		return Collections.unmodifiableList(shellList);
	}
	
	
	
}
