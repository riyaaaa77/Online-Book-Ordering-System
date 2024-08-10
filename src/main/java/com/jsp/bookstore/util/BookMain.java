package com.jsp.bookstore.util;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.jsp.bookstore.dao.AdminDao;
import com.jsp.bookstore.dao.imp.AdminDaoImplementation;
import com.jsp.bookstore.model.Book;
import com.jsp.bookstore.model.Genres;

public class BookMain {

	public static void main(String[] args) {
		AdminDao ad = new AdminDaoImplementation();
		
		//Add book
		Book bk4 = new Book("bk002", "Shivani", 199, 10, "Happy soul", Genres.ADVENTURE);
	//	Book bk1 = new Book("bk004", "Prince", 195, 18, "Ramayan", Genres.ADVENTURE);
//		Book bk1 = new Book("bk003", "riya", 250, 20, "Java", Genres.NOVEL);
		System.out.println(ad.addBook(bk4) ? "Book is added successfully" : "Book addition failed try again later");
//
//		try {
//			List<Book> bl = ad.allBook();
//			for (Book book : bl) {
//		System.out.println();
//		System.out.println("-----Book Details-----");
//		System.out.println("Title  : "+book.getTitle());
//		System.out.println("Author : "+book.getAuthor());
//		System.out.println("Genre  : "+book.getGenre());
//		System.out.println("Price  : ₹"+book.getPrice());
//		System.out.println();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
		//Find Book
//		try {
//			Book bk = ad.findBookById("bk003");
////			Book bk1 = ad.findBookByAuthor("luckywews");
////			Book bk2 = ad.findBookByTitle("fully enter10");
//			if (bk!=null) {
//				System.out.println();
//				System.out.println("-----Book Details-----");
//				System.out.println("Title  : "+bk.getTitle());
//				System.out.println("Author : "+bk.getAuthor());
//				System.out.println("Genre  : "+bk.getGenre());
//				System.out.println("Price  : ₹"+bk.getPrice());
//				System.out.println();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		// delete a book
//		try {
//			Book book = ad.deleteById("bk001");
//			System.out.println();
//			System.out.println("-----Deleted Book-----");
//			System.out.println("Title  : "+book.getTitle());
//			System.out.println("Author : "+book.getAuthor());
//			System.out.println("Genre  : "+book.getGenre());
//			System.out.println("Price  : ₹"+book.getPrice());
//			System.out.println();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// update a book
		try {
			List<Book> bl = ad.allBook();
			for (Book book : bl) {
				System.out.println();
				System.out.println("--------Book Details--------");
				System.out.println("1. BookId : " + book.getBookId());
				System.out.println("2. Title  : " + book.getTitle());
				System.out.println("3. Author : " + book.getAuthor());
				System.out.println("4. Genre  : " + book.getGenre());
				System.out.println("5. Price  : ₹" + book.getPrice());
				System.out.println("6. Quantity  : " + book.getQuantity());
				System.out.println();
			}
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter Bookid for updation :");
			String choice = scanner.next();
			Book book2 = ad.findBookById(choice);
			System.out.println();
			System.out.println("Enter the index what do you want to update");
			System.out.println();
			int updationChoice = scanner.nextInt();
			switch (updationChoice) {
			case 2:
				System.out.print("Enter the updated value for title :");
				scanner.nextLine();
				String titleUpdate = scanner.nextLine();
				book2.setTitle(titleUpdate);
				break;
			case 3:
				System.out.print("Enter the updated value for author :");
				scanner.nextLine();
				String authorUpdate = scanner.nextLine();
				book2.setAuthor(authorUpdate);
				break;
			case 5:
				System.out.print("Enter the updated value for price :");
				double priceUpdate = scanner.nextDouble();
				book2.setPrice(priceUpdate);
				break;
			case 6:
				System.out.print("Enter the updated value for quantity :");
				int quantityUpdate = scanner.nextInt();
				book2.setQuantity(quantityUpdate);
				break;

			default:
				System.out.println("your entered index is either not there or not updatable");
				break;
			}
			Book updatedBook = ad.update(book2);
			System.out.println();
			System.out.println("now updated book details");
			System.out.println();
			System.out.println("-----Updated Book-----");
			System.out.println("Title  : " + updatedBook.getTitle());
			System.out.println("Author : " + updatedBook.getAuthor());
			System.out.println("Genre  : " + updatedBook.getGenre());
			System.out.println("Price  : ₹" + updatedBook.getPrice());
			System.out.println("Quantity: " + updatedBook.getQuantity());
			System.out.println();
			scanner.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

