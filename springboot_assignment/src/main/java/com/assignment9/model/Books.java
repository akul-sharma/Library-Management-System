package com.assignment9.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Books {

	@Id
	int bookId;
	String bookName, authorName, date;
	
	public Books() {
		super();
	}
	
	public Books(int bookId, String bookName, String authorName, String date) {
		this.bookId=bookId;
		this.bookName=bookName;
		this.authorName=authorName;
		this.date=date;
	}
		
	
	public int getId() {
		return bookId;
	}
	
	public void setId(int bookId) {
		this.bookId=bookId;
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date=date;
	}
	
}
