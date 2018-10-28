import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Data structure to store the taco
 */
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
	
	/**
	 * Add a single ingredient to the taco and store to the data structure
	 * @param baseLayer single string represented chosen ingredient
	 * @param mixin single string represented chosen ingredient
	 * @param seasoning single string represented chosen ingredient
	 * @param condiment single string represented chosen ingredient
	 * @param shells single string represented chosen ingredient
	 */
	public void addSingleIngredient(String baseLayer, String mixin, String seasoning, String condiment, String shells) {
		Taco ta = new Taco();
		ta.addSingle(baseLayer, mixin, seasoning, condiment, shells);
		result.add(ta);
	}
	
	/**
	 * Add multiple ingredients to the taco and store to the data structure
	 * @param baseLayer array contains the chosen ingredient
	 * @param mixin array contains the chosen ingredient
	 * @param seasoning array contains the chosen ingredient
	 * @param condiment array contains the chosen ingredient
	 * @param shells array contains the chosen ingredient
	 */
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
	
	/**
	 * Return a iterator to loop through the data structure
	 * @return iterator
	 */
	public Iterator<Taco> iterator() {
		return result.iterator();
	}
	
	/**
	 * Return a unmodifiable version of data structure
	 * @return unmodifiable version of data structure
	 */
	public List<Taco> getResult() {
		return Collections.unmodifiableList(result);
	}
	
	/**
	 * Return true if the data structure is empty, false other wise
	 * @return true if the data structure is empty, false other wise
	 */
	public boolean isEmpty() {
		return result.isEmpty();
	}
	
	
}
