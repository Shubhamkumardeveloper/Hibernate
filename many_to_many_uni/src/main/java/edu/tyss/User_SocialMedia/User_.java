package edu.tyss.User_SocialMedia;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User_ {
	@Id
	private int id;
	private String name;
	private String email;
	@ManyToMany
	List<SocialMedia> socialMedias;
	public User_() {
	}

	public User_(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public List<SocialMedia> getSocialMedias() {
		return socialMedias;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSocialMedias(List<SocialMedia> socialMedias) {
		this.socialMedias = socialMedias;
	}

	@Override
	public String toString() {
		return "User_ [id=" + id + ", name=" + name + ", email=" + email + ", socialMedias=" + socialMedias + "]";
	}
}
