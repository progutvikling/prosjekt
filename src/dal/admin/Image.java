package dal.admin;

import java.sql.Date;

public class Image {
	
	private String url;
	private int id;
	private String description;
	private Date createdTime;

	public Image(String url, int id, String description, Date createdTime) {
		this.url = url;
		this.id = id;
		this.description = description;
		this.createdTime = createdTime;
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
	
	public Date getCreatedTime() {
		return this.createdTime;
	}

}
