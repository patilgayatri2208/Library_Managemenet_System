package com.Book;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	private int isbn;
	private String title;
	private String author;
	private String publisher;
	private int edition;
	private String subject;
	private int aval_quantity;
	public Book() {
		super();
	}
	public Book(int isbn, String title, String author, String publisher, int edition, String subject,
			int aval_quantity) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.edition = edition;
		this.subject = subject;
		this.aval_quantity = aval_quantity;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getAval_quantity() {
		return aval_quantity;
	}
	public void setAval_quantity(int aval_quantity) {
		this.aval_quantity = aval_quantity;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", edition=" + edition + ", subject=" + subject + ", aval_quantity=" + aval_quantity + "]";
	}
	
	
}
