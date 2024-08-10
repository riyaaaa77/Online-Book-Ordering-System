package com.jsp.bookstore.dao;

import java.sql.SQLException;
import java.util.List;

import com.jsp.bookstore.model.Book;

public interface AdminDao {
	//update a book
		Book update(Book book) throws SQLException;

	//add a book
		boolean addBook(Book book);

		// get all book details
		List<Book> allBook() throws SQLException;

		// find book by their book title
		Book findBookByTitle(String title) throws SQLException;

		// find book by their Author name
		Book findBookByAuthor(String author) throws SQLException;

		// find book by their id
		Book findBookById(String id) throws SQLException;

		// delete a book by their by id
		Book deleteById(String id) throws SQLException;

//		List<Order> orderlist() throws SQLException;

}
