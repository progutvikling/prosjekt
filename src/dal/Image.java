package dal;

public class Image {
	
	private String url;
	private int id;
	private String description;

	public Image(String url, int id, String description) {
		this.url = url;
		this.id = id;
		this.description = description;
	}

	public String getUrl() {
		
		return this.url;
	}

	public int getID() {
		return this.id;
	}
	
	public String getDescription() {
		return this.description;
	}

}
