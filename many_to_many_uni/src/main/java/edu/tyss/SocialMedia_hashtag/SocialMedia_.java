package edu.tyss.SocialMedia_hashtag;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class SocialMedia_ {
	@Id
	private int id;
	private String name;
	private String url;
	
	@ManyToMany
	private List<Hashtag> hashtags;
	
	public List<Hashtag> getHashtags() {
		return hashtags;
	}

	public void setHashtags(List<Hashtag> hashtags) {
		this.hashtags = hashtags;
	}

	public SocialMedia_() {
	}

	public SocialMedia_(int id, String name, String url) {
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
