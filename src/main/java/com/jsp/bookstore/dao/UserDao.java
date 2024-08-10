package com.jsp.bookstore.dao;

import java.sql.SQLException;

import com.jsp.bookstore.model.User;

public interface UserDao {
	//userdao --> register login

	boolean registerUser(User user) throws SQLException;
	
	User login(String email, String password) throws SQLException;
	
	User login(long phone , String password) throws SQLException;
	
}
