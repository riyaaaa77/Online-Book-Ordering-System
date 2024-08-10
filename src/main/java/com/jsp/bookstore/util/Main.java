package com.jsp.bookstore.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.jsp.bookstore.dao.UserDao;
import com.jsp.bookstore.dao.imp.UserDaoImp;
import com.jsp.bookstore.model.Role;
import com.jsp.bookstore.model.User;

public class Main {
	public static void main(String [] args) throws SQLException
	{
		Connection connection = DBUtil.createConnection();
		
		User user = new User();
		user.setEmail("riya@gmail.com");
		user.setFirstName("riya");
		user.setLastName("gupta");
		user.setPassword("r123");
		user.setPhone(7289059144l);
		user.setAddress("Gurugram");
		user.setRole(Role.ADMIN);
		
		UserDao dao = new UserDaoImp();
		//dao.registerUser(user);
		
		User us = dao.login("riya@gmail.com", "r123");
		if(us!=null) {
			System.out.println(us.getFirstName());
		}
	}
}


