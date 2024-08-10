package com.jsp.bookstore.model;

public class Book {
	//primary key
	private String bookId;
	private String author;
	private double price;
	private int quantity;
	private String title;
	private Genres genre;
	
	public Book(String bookId, String author, double price, int quantity, String title, Genres genre) {
		super();
		this.bookId = bookId;
		this.author = author;
		this.price = price;
		this.quantity = quantity;
		this.title = title;
		this.genre = genre;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Genres getGenre() {
		return genre;
	}

	public void setGenre(Genres genre) {
		this.genre = genre;
	}
	
}
