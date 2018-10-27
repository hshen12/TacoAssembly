import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

public class URLTask implements Runnable {

	private URL seed;
	private ArrayList<ApiObj> arrayList;

	public URLTask(URL seed, ArrayList<ApiObj> hashmap) {
		this.seed = seed;
		this.arrayList = hashmap;
	}

	@Override
	public void run() {
		synchronized(arrayList) {
			try {
				readAPI();
			} catch (IOException e) {
				System.err.println("Unable to read the taco api.");
			}
		}
	}


	private void readAPI() throws IOException {
		HttpsURLConnection conn = (HttpsURLConnection)seed.openConnection();

		try(BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))){
			String slugLine;
			while((slugLine = br.readLine().trim()) != null) {

				if(slugLine.startsWith("\"slug\":")) {
					String slugContent = slugLine.substring(9, slugLine.lastIndexOf(",")-1);
					String nameLine = br.readLine().trim();
					String nameContent = nameLine.substring(9, nameLine.lastIndexOf("\""));
					arrayList.add(new ApiObj(slugContent, nameContent));
				}
			}
		}
	}
}
