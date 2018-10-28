import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
	
	public String toString() {
		
		return String.join("and", baseLayer) + " " + String.join("and", mixin) + " " + String.join("and", seasoning) + " " 
				+ String.join("and", condiment) + " " + String.join("and", shells);
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
	
	public String getData() {
		return date;
	}
	
	private void addAllBaseLayer(ArrayList<String> otherBaseLayer) {
		if(otherBaseLayer != null && !otherBaseLayer.isEmpty()) {
			this.baseLayer.addAll(otherBaseLayer);
		}
	}
	
	private void addAllMixin(ArrayList<String> otherMixin) {
		if(otherMixin != null && !otherMixin.isEmpty()) {
			this.mixin.addAll(otherMixin);
		}
	}
	
	private void addAllSeasoning(ArrayList<String> otherSeasoning) {
		if(otherSeasoning != null && !otherSeasoning.isEmpty()) {
			this.seasoning.addAll(otherSeasoning);
		}
	}
	
	private void addAllCondiment(ArrayList<String> otherCondiment) {
		if(otherCondiment != null && !otherCondiment.isEmpty()) {
			this.condiment.addAll(otherCondiment);
		}
	}
	
	private void addAllShells(ArrayList<String> otherShells) {
		if(otherShells != null && !otherShells.isEmpty()) {
			this.shells.addAll(otherShells);
		}
	}
	
	public void addMultiple(ArrayList<String> baseLayer, ArrayList<String> mixin, ArrayList<String> seasoning, ArrayList<String> condiment, ArrayList<String> shells) {
		addAllBaseLayer(baseLayer);
		addAllMixin(mixin);
		addAllSeasoning(seasoning);
		addAllCondiment(condiment);
		addAllShells(shells);
		this.date = getDate();
	}
	
}
