package com.jsp.bookstore.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.bookstore.model.Book;
import com.jsp.bookstore.model.User;

public interface CustomerDao {
	public boolean orderBook(List<Book> booklist,User user) throws SQLException;

	boolean bookList(List<Book> booklist, User user) throws SQLException; 
	
	List<Book> orderedBooks(User user) throws SQLException;
	
}
