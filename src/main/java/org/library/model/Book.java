package org.library.model;

 
import java.io.Serializable;
import java.util.Date;

import org.apache.tapestry5.annotations.Property;

public class Book implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Property
	private String title;
	@Property
	private String author;
	@Property
	private Date publicationDate;
	
	public Book(final String title, final String author, final Date publicationDate ) {
		this.author = author;
		this.title = title;
		this.publicationDate = publicationDate;
	}
	
	public Book(final String title, final String author ) {
		this(title,author,null);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(final String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(final String author) {
		this.author = author;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(final Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	 
 
}
