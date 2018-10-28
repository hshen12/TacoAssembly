
/**
 * Represent an object crawled form web api
 * @author Hao Shen
 *
 */
public class ApiObj {

	private String slug;
	private String name;
	
	/**
	 * Constructor
	 * 	initialize the data member 
	 * @param slugContent
	 * @param nameContent
	 */
	public ApiObj(String slugContent, String nameContent) {
		this.slug = slugContent;
		this.name = nameContent;
	}
	
	/**
	 * ToString
	 * @return a string representation of the object
	 */
	@Override
	public String toString() {
		return name;
	}

}
