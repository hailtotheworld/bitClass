package controller;

import java.util.ArrayList;
import java.util.Scanner;

import dao.BookDao;
import object.Book;

public class BookController {
	static BookDao bookDao;
	Scanner sc;

	
	public BookController() {
		bookDao = BookDao.getInstance();
	}
	
	
	public static void showAll() {
		ArrayList<Book> bookList = new ArrayList<>();
		bookDao.selectAllList();
	}
	
	

	
	
}
