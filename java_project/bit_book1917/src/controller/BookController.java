package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.BookDao;
import object.Book;

public class BookController {
	BookDao bookDao;

	public BookController() {
		bookDao = BookDao.getInstance();
	
	}
	
	// list 출력
	public void printList(List<Book> bookList) {
		for (int i = 0; i < bookList.size(); i++) {
			System.out.println("NO." + bookList.get(i).getBookid());
			System.out.println("이름 : " + bookList.get(i).getBookName());
		}
		
	}
		
	// 전체 목록 출력
	public void showAll() {
		List<Book> bookList = new ArrayList<>();
		bookList = bookDao.selectAllList();
		printList(bookList);
	}


	// 카테고리 번호로 검색
	public  void selectByCategory( int categoryId ) {
		List<Book> bookList = new ArrayList<>();
		bookList = bookDao.selectByCategory(categoryId);
		printList(bookList);
	}

	
	// 책의 제목으로 검색
	public  void selectByName(String bookName) {
		List<Book> bookList = new ArrayList<>();
		bookList = bookDao.selectByBookName(bookName);
		printList(bookList);
	}
	
	
	// 책의 저자명으로 검색
	public void selectByWriter(String writer ) {
		List<Book> bookList = new ArrayList<>();
		bookList = bookDao.selectByWriter(writer);
		printList(bookList);
	}
	
	
	// 출판사명으로 검색
	public void selectByPublisher(String publisher) {
		List<Book> bookList = new ArrayList<>();
		bookList = bookDao.selectByWriter(publisher);
		printList(bookList);
	}
	
	
	// 도서 등록 메소드
	public void insertBook(Book book) {
		bookDao.insertBook(book);
	}
	
	
	// 도서 정보를 수정하는 메소드
	public  void editBook() {
		// TODO Auto-generated method stub
		
	}
	// 도서 정보를 삭제하는 메소드
	public static void deleteBook() {
		// TODO Auto-generated method stub
		
	}

}
