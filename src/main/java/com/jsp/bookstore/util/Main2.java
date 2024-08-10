package com.jsp.bookstore.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jsp.bookstore.dao.AdminDao;
import com.jsp.bookstore.dao.CustomerDao;
import com.jsp.bookstore.dao.UserDao;
import com.jsp.bookstore.dao.imp.AdminDaoImplementation;
import com.jsp.bookstore.dao.imp.CustomerDaoImp;
import com.jsp.bookstore.dao.imp.UserDaoImp;
import com.jsp.bookstore.exception.User1Exception;
import com.jsp.bookstore.model.Book;
import com.jsp.bookstore.model.User;

public class Main2 {
static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
//User user = new User("lkjasoria@gmail.com", "lk", "Lucky", "Kumar", 7206169908l, "Rewari", Role.ADMIN);
//	UserDao dao = new UserDaoImplementation();
//	System.out.println(dao.register(user)?"You are successfully registered":"Something went wrong");
//	User user = new User("lkjasoria@gmail.com", "lk", "Lucky", "Kumar", 7206169908l, "Rewari", Role.ADMIN);
		UserDao dao = new UserDaoImp();
		User user, user2;
		try {
			user = dao.login("riya@gmail.com", "r123");
			if (user != null) {
				AdminDao adminDao = new AdminDaoImplementation();
				try {
					List<Book> bl = adminDao.allBook();
					List<Book> listBooks = new ArrayList<Book>();
					int check = 1;
					do {
						for (Book book : bl) {

							System.out.println();
							System.out.println("--------Book Details--------");
							System.out.println("BookId  : " + book.getBookId());
							System.out.println("Title  : " + book.getTitle());
							System.out.println("Author : " + book.getAuthor());
							System.out.println("Genre  : " + book.getGenre());
							System.out.println("Price  : ₹" + book.getPrice());
							System.out.println("Quantity: " + book.getQuantity());
							System.out.println();
						}
						
						System.out.print("Enter Bookid for adding to your cart :");				
						String choice = scanner.nextLine();
						System.out.println();
						Book addBook = adminDao.findBookById(choice);
						if (addBook != null && addBook.getQuantity() > 0) {
							System.out.println("Enter the quantity of the book you want to order");
							int bookQuantity = scanner.nextInt();
							System.out.println();
							if (addBook.getQuantity()>=bookQuantity) {
								addBook.setQuantity(bookQuantity);
								listBooks.add(addBook);
								
							}else {
								System.out.println("Quantity is not sufficient");
							}
						}
                        
						System.out.println("If you want to exit then press 0 else any number");
						check = scanner.nextInt();
						scanner.nextLine();
						System.out.println();
						
					} while (check != 0);
					System.out.println();
					for (Book books : listBooks) {

						System.out.println();
						System.out.println("----Order Book Details----");
						System.out.println("BookId  : " + books.getBookId());
						System.out.println("Title  : " + books.getTitle());
						System.out.println("Author : " + books.getAuthor());
						System.out.println("Genre  : " + books.getGenre());
						System.out.println("Price  : ₹" + books.getPrice());
						System.out.println("Quantity: " + books.getQuantity());
						System.out.println();
					}
					CustomerDao customerDao = new CustomerDaoImp();
					if(customerDao.orderBook(listBooks, user)&&!listBooks.isEmpty()) {
						System.out.println("Order Done!");
					}
	
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
//		System.out.println(user.getFirstName());

//			user2 = dao.login(72061699087l, "lk");
//			System.out.println(user2.getFirstName());
		} catch (User1Exception e) {
			// TODO Auto-generated catch block
			System.err.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
