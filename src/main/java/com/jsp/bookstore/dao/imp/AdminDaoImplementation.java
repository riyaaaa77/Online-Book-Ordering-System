package com.jsp.bookstore.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jsp.bookstore.dao.AdminDao;
import com.jsp.bookstore.exception.User1Exception;
import com.jsp.bookstore.model.Book;
import com.jsp.bookstore.util.DBUtil;

public class AdminDaoImplementation implements AdminDao {
	@Override
	public boolean addBook(Book book) {

		try {
			Connection conn = DBUtil.createConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO `book` VALUES (?,?,?,?,?,?)");
			ps.setString(1, book.getBookId());
			ps.setString(2, book.getAuthor());
			ps.setDouble(3, book.getPrice());
			ps.setInt(4, book.getQuantity());
			ps.setString(5, book.getTitle());
			ps.setString(6, book.getGenre().toString());
			int execute = ps.executeUpdate();
			if (execute > 0)
				return true;
			else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Book update(Book book) throws SQLException {
		
			Connection conn = DBUtil.createConnection();
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE `book` SET `author`=?,`price`=?,`quantity`=?,`title`=?,`genre`=? WHERE bookId=?");

			ps.setString(1, book.getAuthor());
			ps.setDouble(2, book.getPrice());
			ps.setInt(3, book.getQuantity());
			ps.setString(4, book.getTitle());
			ps.setString(5, book.getGenre().toString());
			ps.setString(6, book.getBookId());
			int execute = ps.executeUpdate();
			if (execute > 0)
				return book;
			try {
				throw new User1Exception("Error!! Updation not done!");
			}

			catch (User1Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		
		}

	@Override
	public List<Book> allBook() throws SQLException {
		List<Book> list = new ArrayList<Book>();
		Connection conn = DBUtil.createConnection();
		Statement s = conn.createStatement();
		String query = "SELECT * FROM book";
		s.execute(query);
		ResultSet resultSet = s.getResultSet();
		while (resultSet.next()) {
			Book bk = new Book(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3),resultSet.getInt(4), resultSet.getString(5),com.jsp.bookstore.model.Genres.valueOf(resultSet.getString(6)));
			list.add(bk);
		}
		return list;

	}

	@Override
	public Book deleteById(String id) throws SQLException {
		Connection conn = DBUtil.createConnection();
		Statement s = conn.createStatement();
		Book book = findBookById(id);
		if (book!=null) {
			String query = "DELETE from book where bookId='"+id+"'";
			s.execute(query);
			return book;
		}

		try {
			throw new User1Exception("No Book is present as per your input");
		}

		catch (User1Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			return null;
		}

	}

	@Override
	public Book findBookByTitle(String title) throws SQLException {
		Connection conn = DBUtil.createConnection();
		Statement s = conn.createStatement();
		String query = "SELECT * FROM `book` WHERE title='" + title + "'";
		s.execute(query);
		ResultSet resultSet = s.getResultSet();
		while (resultSet.next()) {
			Book bk = new Book(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3),
					resultSet.getInt(4), resultSet.getString(5),
					com.jsp.bookstore.model.Genres.valueOf(resultSet.getString(6)));
			return bk;
		}
		try {
			throw new User1Exception("No Book is present as per your input");
		}

		catch (User1Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			return null;
		}

	}

	@Override
	public Book findBookById(String id) throws SQLException {
		Connection conn = DBUtil.createConnection();
		Statement s = conn.createStatement();
		String query = "SELECT * FROM `book` WHERE bookid='" + id + "'";
		s.execute(query);
		ResultSet resultSet = s.getResultSet();
		while (resultSet.next()) {
			Book bk = new Book(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3),
					resultSet.getInt(4), resultSet.getString(5),
					com.jsp.bookstore.model.Genres.valueOf(resultSet.getString(6)));
			return bk;
		}
		try {
			throw new User1Exception("No Book is present as per your input");
		}

		catch (User1Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			return null;
		}

	}

	@Override
	public Book findBookByAuthor(String author) throws SQLException {
//		return null;
		Connection conn = DBUtil.createConnection();
		Statement s = conn.createStatement();
		String query = "SELECT * FROM `book` WHERE author='" + author + "'";
		s.execute(query);
		ResultSet resultSet = s.getResultSet();
		while (resultSet.next()) {
			Book bk = new Book(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3),
					resultSet.getInt(4), resultSet.getString(5),
					com.jsp.bookstore.model.Genres.valueOf(resultSet.getString(6)));
			return bk;
		}
		try {
			throw new User1Exception("No Book is present as per your input");
		}

		catch (User1Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			return null;
		}
	}

//	@Override
//	public List<Order> orderlist() throws SQLException {
//		List<Order> list = new ArrayList<Order>();
//		Connection conn = DBUtil.createConnection();
//		Statement s = conn.createStatement();
//		String query = "SELECT * FROM `bookorder`";
//		s.execute(query);
//		ResultSet resultSet = s.getResultSet();
//		while (resultSet.next()) {
//		Order bk = new Order(resultSet.getString(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getInt(4),resultSet.getString(5),com.jsp.bookstore.model.Genres.valueOf(resultSet.getString(6)));
//			list.add(bk);
//		} 
//		return list;
//	}

}

