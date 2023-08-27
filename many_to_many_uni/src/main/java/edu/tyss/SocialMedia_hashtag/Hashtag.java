package edu.tyss.SocialMedia_hashtag;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hashtag {
	@Id
	private int id;
	private String name;
	
	public Hashtag() {
	}
	public Hashtag(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Hashtag [id=" + id + ", name=" + name + "]";
	}
	
	

}
