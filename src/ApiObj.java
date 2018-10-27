
public class ApiObj {

	private String slug;
	private String name;
	
	public ApiObj(String slugContent, String nameContent) {
		this.slug = slugContent;
		this.name = nameContent;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
