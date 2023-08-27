package edu.tyss.Person_Ebook;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ebook {
	@Id
	private int id;
	private String author;
	private String title;
	
	public Ebook() {
		// TODO Auto-generated constructor stub
	}

	public Ebook(int id, String author, String title) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Ebook [id=" + id + ", author=" + author + ", title=" + title + "]";
	}
	
	


}
