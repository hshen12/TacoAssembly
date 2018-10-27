import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TacoResult {
	
	private ArrayList<Taco> result;
	
	public TacoResult() {
		this.result = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(Taco t: result) {
			sb.append(t.toString());
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}
	
	public void addSingleIngredient(String baseLayer, String mixin, String seasoning, String condiment, String shells) {
		Taco ta = new Taco();
		ta.addSingle(baseLayer, mixin, seasoning, condiment, shells);
		result.add(ta);
	}
	
	public void addMutipleIngredient(ArrayList<String> baseLayer, ArrayList<String> mixin, ArrayList<String> seasoning, ArrayList<String> condiment, ArrayList<String> shells) {
		Taco ta = new Taco();
		ta.addMultiple(baseLayer, mixin, seasoning, condiment, shells);
		result.add(ta);
	}
	
	public void addMutipleIngredient(String[] baseLayer, String[] mixin, String[] seasoning, String[] condiment, String[] shell) {
		Taco ta = new Taco();
		ArrayList<String> baseLayerList = new ArrayList<String> (Arrays.asList(baseLayer));
		ArrayList<String> mixinList = new ArrayList<String> (Arrays.asList(mixin));
		ArrayList<String> seasoningList = new ArrayList<String> (Arrays.asList(seasoning));
		ArrayList<String> condimentList = new ArrayList<String> (Arrays.asList(condiment));
		ArrayList<String> shellList = new ArrayList<String> (Arrays.asList(shell));
		ta.addMultiple(baseLayerList, mixinList, seasoningList, condimentList, shellList);
		result.add(ta);
	}
	
	public Iterator<Taco> iterator() {
		return result.iterator();
	}
	
	public List<Taco> getResult() {
		return Collections.unmodifiableList(result);
	}
	
	public boolean isEmpty() {
		return result.isEmpty();
	}
	
	
}
