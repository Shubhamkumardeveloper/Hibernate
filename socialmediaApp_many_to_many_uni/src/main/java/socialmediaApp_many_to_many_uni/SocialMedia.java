package socialmediaApp_many_to_many_uni;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SocialMedia {
	@Id
	private int social_media_id;
	private String social_media_name;
	private String social_media_url;
	
	public SocialMedia() {
	}
	
	public SocialMedia(int social_media_id, String social_media_name, String social_media_url) {
		this.social_media_id = social_media_id;
		this.social_media_name = social_media_name;
		this.social_media_url = social_media_url;
	}



	public int getSocial_media_id() {
		return social_media_id;
	}
	public String getSocial_media_name() {
		return social_media_name;
	}
	public String getSocial_media_url() {
		return social_media_url;
	}
	public void setSocial_media_id(int social_media_id) {
		this.social_media_id = social_media_id;
	}
	public void setSocial_media_name(String social_media_name) {
		this.social_media_name = social_media_name;
	}
	public void setSocial_media_url(String social_media_url) {
		this.social_media_url = social_media_url;
	}
}
