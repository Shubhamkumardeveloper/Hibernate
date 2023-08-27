package edu.tyss.User_SocialMedia;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SocialMedia {
	@Id
	private int id;
	private String name;
	private String url;
	
	public SocialMedia() {
	}

	public SocialMedia(int id, String name, String url) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "SocialMedia [id=" + id + ", name=" + name + ", url=" + url + "]";
	}
	
	
	
	

}
