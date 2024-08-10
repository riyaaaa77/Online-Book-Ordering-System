package com.jsp.bookstore.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.bookstore.dao.UserDao;
import com.jsp.bookstore.exception.User1Exception;
import com.jsp.bookstore.model.Role;
import com.jsp.bookstore.model.User;
import com.jsp.bookstore.util.DBUtil;

import jdk.jshell.spi.ExecutionControl.UserException;

public class UserDaoImp implements UserDao{

	Connection connection = DBUtil.createConnection();
	@Override
	public boolean registerUser(User user) throws SQLException {
		PreparedStatement  preparedStatement = connection.prepareStatement("insert into User values(?,?,?,?,?,?,?)");
		preparedStatement.setString(1, user.getEmail());
		preparedStatement.setString(2,user.getPassword());
		preparedStatement.setString(3,user.getFirstName());
		preparedStatement.setString(4, user.getLastName());
		preparedStatement.setLong(5, user.getPhone());
		preparedStatement.setString(6, user.getAddress());
		preparedStatement.setString(7, user.getRole().toString());
		
		int executeUpdate = preparedStatement.executeUpdate();
		if(executeUpdate>0)
			return true;
		
		return false;
	}

	@Override
	public User login(String email, String password) throws SQLException {
		PreparedStatement  preparedStatement = connection.prepareStatement("select * from user where email=? and password=?");
		preparedStatement.setString(1, email);
		preparedStatement.setString(2,password);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			User user = new User();
			user.setEmail(resultSet.getString(1));
			user.setPassword(resultSet.getString(2));
			user.setFirstName(resultSet.getString(3));
			user.setLastName(resultSet.getString(4));
			user.setPhone(resultSet.getLong(5));
			user.setAddress(resultSet.getString(6));
			user.setRole(Role.valueOf(resultSet.getString(7)));
			return user;
		}
		try {
			throw new User1Exception("No Data Found");
		}catch(User1Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public User login(long phone, String password) throws SQLException {
		PreparedStatement  preparedStatement = connection.prepareStatement("select * from user where phone=? and password=?");
		preparedStatement.setLong(1, phone);
		preparedStatement.setString(2,password);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			User user = new User();
			user.setEmail(resultSet.getString(1));
			user.setPassword(resultSet.getString(2));
			user.setFirstName(resultSet.getString(3));
			user.setLastName(resultSet.getString(4));
			user.setPhone(resultSet.getLong(5));
			user.setAddress(resultSet.getString(6));
			user.setRole(Role.valueOf(resultSet.getString(7)));
			return user;
		}
		try {
			throw new User1Exception("No Data Found");
		}catch(User1Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
}
