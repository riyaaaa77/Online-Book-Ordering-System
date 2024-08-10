package com.jsp.bookstore.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jsp.bookstore.dao.CustomerDao;
import com.jsp.bookstore.exception.User1Exception;
import com.jsp.bookstore.model.Book;
import com.jsp.bookstore.model.User;
import com.jsp.bookstore.util.DBUtil;

public class CustomerDaoImp implements CustomerDao {

	@Override
	public boolean bookList(List<Book> booklist, User user) {
		try {
			Connection conn = DBUtil.createConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO listbook(`bookid`, `userid`,quantity) VALUES (?,?,?)");
			for (Book books : booklist) {
				ps.setString(1, books.getBookId());
				ps.setString(2, user.getEmail());
				ps.setInt(3, books.getQuantity());
				ps.addBatch();
			}

			int[] execute = ps.executeBatch();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean orderBook(List<Book> booklist, User user) throws SQLException {

		double totalPrice = 0;
		Connection conn = DBUtil.createConnection();
		if (bookList(booklist, user)) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO `bookorder`(`totalprice`, `user`) VALUES (?,?)");
			for (Book books : booklist) {
				totalPrice += books.getPrice() * books.getQuantity();
			}
			ps.setDouble(1, totalPrice);
			ps.setString(2, user.getEmail());
			Boolean execute = ps.execute();
			return true;
		}
		try {
			throw new User1Exception("Pta ni kya hua yr");

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}

	}

	@Override
	public List<Book> orderedBooks(User user) throws SQLException {
		List<Book> list = new ArrayList<Book>();
		Connection connection = DBUtil.createConnection();
		Statement statement = connection.createStatement();
		String query = "SELECT * FROM book where ";
		statement.execute(query);
		ResultSet resultSet = statement.getResultSet();
		while (resultSet.next()) {
			Book bk = new Book(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3),
					resultSet.getInt(4), resultSet.getString(5),
					com.jsp.bookstore.model.Genres.valueOf(resultSet.getString(6)));
			list.add(bk);
		}
		return list;
	}
}
