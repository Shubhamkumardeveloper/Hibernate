package edu.tyss.Book_Librabry;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	private int id;
	private String title;
	private String subject;
	@ManyToOne
	private Library library;
	
	public Book() {
	}

	public Book(int id, String title, String subject) {
		super();
		this.id = id;
		this.title = title;
		this.subject = subject;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getSubject() {
		return subject;
	}

	public Library getLibrary() {
		return library;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", subject=" + subject + ", library=" + library + "]";
	}

}
