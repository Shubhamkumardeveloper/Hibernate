package socialmediaApp_many_to_many_uni;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User_{
	@Id
	private int user_id;
	private String username;
	private String email;
	
	public User_() {
	}
	
	public User_(int user_id, String username, String email) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.email = email;
	}

	@ManyToMany
	List<SocialMedia> socialMedias;

	public int getUser_id() {
		return user_id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public List<SocialMedia> getSocialMedias() {
		return socialMedias;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSocialMedias(List<SocialMedia> socialMedias) {
		this.socialMedias = socialMedias;
	}
}
