import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Represent a single taco based on users choice
 * @author Hao Shen
 *
 */
public class Taco {
	
	private ArrayList<String> baseLayer;
	private ArrayList<String> mixin;
	private ArrayList<String> seasoning;
	private ArrayList<String> condiment;
	private ArrayList<String> shells;
	private String date;
	
	public Taco() {
		this.baseLayer = new ArrayList<String>();
		this.mixin = new ArrayList<String>();
		this.seasoning = new ArrayList<String>();
		this.condiment = new ArrayList<String>();
		this.shells = new ArrayList<String>();
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("BaseLayer:");
		sb.append(System.lineSeparator());
		sb.append("\t");
		sb.append(String.join(System.lineSeparator()+"\t", baseLayer));
		sb.append(System.lineSeparator());
		
		sb.append("Mixin:");
		sb.append(System.lineSeparator());
		sb.append("\t");
		sb.append(String.join(System.lineSeparator()+"\t", mixin));
		sb.append(System.lineSeparator());
		
		sb.append("Seasoning:");
		sb.append(System.lineSeparator());
		sb.append("\t");
		sb.append(String.join(System.lineSeparator()+"\t", seasoning));
		sb.append(System.lineSeparator());
		
		sb.append("Condiment:");
		sb.append(System.lineSeparator());
		sb.append("\t");
		sb.append(String.join(System.lineSeparator()+"\t", condiment));
		sb.append(System.lineSeparator());
		
		sb.append("Shells:");
		sb.append(System.lineSeparator());
		sb.append("\t");
		sb.append(String.join(System.lineSeparator()+"\t", shells));
		sb.append(System.lineSeparator());
		
		return sb.toString();
	}
	
	/**
	 * Return a String represent html
	 * 	used when output data structure to web application
	 * @return
	 */
	public String webAppToString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<pre>");
		sb.append("BaseLayer:");
		sb.append("<br/>");
		sb.append("&#9");
		sb.append(String.join("<br/>"+"&#9", baseLayer));
		sb.append("<br/>");
		
		sb.append("Mixin:");
		sb.append("<br/>");
		sb.append("&#9");
		sb.append(String.join("<br/>"+"&#9", mixin));
		sb.append("<br/>");
		
		sb.append("Seasoning:");
		sb.append("<br/>");
		sb.append("&#9");
		sb.append(String.join("<br/>"+"&#9", seasoning));
		sb.append("<br/>");
		
		sb.append("Condiment:");
		sb.append("<br/>");
		sb.append("&#9");
		sb.append(String.join("<br/>"+"&#9", condiment));
		sb.append("<br/>");
		
		sb.append("Shells:");
		sb.append("<br/>");
		sb.append("&#9");
		sb.append(String.join("<br/>"+"&#9", shells));
		sb.append("<br/>");
		
		sb.append("</pre>");
		return sb.toString();
	}
	
	public void addSingle(String baseLayer, String mixin, String seasoning, String condiment, String shells) {
		this.baseLayer.add(baseLayer);
		this.mixin.add(mixin);
		this.seasoning.add(seasoning);
		this.condiment.add(condiment);
		this.shells.add(shells);
		this.date = getDate();
	}
	
	/**
	 * Returns the date and time in a long format. For example: "12:00 am on
	 * Saturday, January 01 2000".
	 *
	 * @return current date and time
	 */
	private String getDate() {
		String format = "hh:mm a 'on' MMMM dd yyyy";
		DateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(new Date());
	}
	
	/**
	 * Return a string indicate when the taco was created
	 * @return
	 */
	public String getData() {
		return date;
	}
	
	/**
	 * Helper method to add given choice to data structure
	 * @param otherBaseLayer
	 */
	private void addAllBaseLayer(ArrayList<String> otherBaseLayer) {
		if(otherBaseLayer != null && !otherBaseLayer.isEmpty()) {
			this.baseLayer.addAll(otherBaseLayer);
		}
	}
	
	/**
	 * Helper method to add given choice to data structure
	 * @param otherBaseLayer
	 */
	private void addAllMixin(ArrayList<String> otherMixin) {
		if(otherMixin != null && !otherMixin.isEmpty()) {
			this.mixin.addAll(otherMixin);
		}
	}
	
	/**
	 * Helper method to add given choice to data structure
	 * @param otherBaseLayer
	 */
	private void addAllSeasoning(ArrayList<String> otherSeasoning) {
		if(otherSeasoning != null && !otherSeasoning.isEmpty()) {
			this.seasoning.addAll(otherSeasoning);
		}
	}
	
	/**
	 * Helper method to add given choice to data structure
	 * @param otherBaseLayer
	 */
	private void addAllCondiment(ArrayList<String> otherCondiment) {
		if(otherCondiment != null && !otherCondiment.isEmpty()) {
			this.condiment.addAll(otherCondiment);
		}
	}
	
	/**
	 * Helper method to add given choice to data structure
	 * @param otherBaseLayer
	 */
	private void addAllShells(ArrayList<String> otherShells) {
		if(otherShells != null && !otherShells.isEmpty()) {
			this.shells.addAll(otherShells);
		}
	}
	
	/**
	 * Add multiple ingredient to the data structure
	 * @param baseLayer array list of baselayer choices
	 * @param mixin array list of mixin choices
	 * @param seasoning array list of seasoning choices
	 * @param condiment array list of condiment choices
	 * @param shells array list of shells choices
	 */
	public void addMultiple(ArrayList<String> baseLayer, ArrayList<String> mixin, ArrayList<String> seasoning, ArrayList<String> condiment, ArrayList<String> shells) {
		addAllBaseLayer(baseLayer);
		addAllMixin(mixin);
		addAllSeasoning(seasoning);
		addAllCondiment(condiment);
		addAllShells(shells);
		this.date = getDate();
	}
	
}
