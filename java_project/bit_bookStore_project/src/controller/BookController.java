package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.BookDao;
import object.Book;

public class BookController {
	static BookDao bookDao;

	public BookController() {
		bookDao = BookDao.getInstance();
	
	}

	// 전체 목록 출력
	public static void showAll() {
		List<Book> bookList = new ArrayList<>();

		bookList = bookDao.selectAllList();

		for (int i = 0; i < bookList.size(); i++) {
			System.out.println("NO." + bookList.get(i).getBookid());
			System.out.println("이름 : " + bookList.get(i).getBookName());
		}
	}

	// 카테고리 번호로 검색
	public static void selectByCategory() {

		List<Book> bookList = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		System.out.println("카테고리 번호를 입력해 주세요.");
		System.out.println("1. 유아 2. IT 3. 역사 4. 소설 5. 만화");
		System.out.println("> ");

		int categoryId = sc.nextInt();

		bookList = bookDao.selectByCategory(categoryId);

		for (int i = 0; i < bookList.size(); i++) {
			System.out.println("NO." + bookList.get(i).getBookid());
			System.out.println("이름 : " + bookList.get(i).getBookName());
		}

	}
	// 책의 제목으로 검색
	public static void selectByName() {

		List<Book> bookList = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		System.out.println("제목의 키워드를 입력해 주세요.");
		System.out.println("> ");

		String bookName = sc.nextLine();

		bookList = bookDao.selectByBookName(bookName);

		for (int i = 0; i < bookList.size(); i++) {
			System.out.println("NO." + bookList.get(i).getBookid());
			System.out.println("이름 : " + bookList.get(i).getBookName());
		}
	}
	// 책의 저자명으로 검색
	public static void selectByWriter() {
		
		List<Book> bookList = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		System.out.println("작가 이름을 입력해 주세요.");
		System.out.println("> ");

		String writer = sc.nextLine();

		bookList = bookDao.selectByWriter(writer);

		for (int i = 0; i < bookList.size(); i++) {
			System.out.println("NO." + bookList.get(i).getBookid());
			System.out.println("이름 : " + bookList.get(i).getBookName());
		}
	}
	// 출판사명으로 검색
	public static void selectByPublisher() {
		
		List<Book> bookList = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		System.out.println("출판사명을 입력해 주세요.");
		System.out.println("> ");

		String publisher = sc.nextLine();

		bookList = bookDao.selectByWriter(publisher);

		for (int i = 0; i < bookList.size(); i++) {
			System.out.println("NO." + bookList.get(i).getBookid());
			System.out.println("이름 : " + bookList.get(i).getBookName());
		}
		
	}
	// 도서 등록 메소드
	public static void insertBook() {
			
		Scanner sc = new Scanner(System.in);
		
		System.out.println("도서의 일련번호를 입력해 주세요.");
		System.out.println("> ");
		int bookid = sc.nextInt();
		
		System.out.println("도서의 제목을 입력해 주세요.");
		System.out.println("> ");
		String bookName = sc.nextLine();
		
		System.out.println("도서의 가격을 입력해 주세요.");
		System.out.println("> ");
		int price = sc.nextInt();
		
		System.out.println("도서의 저자를 입력해 주세요.");
		System.out.println("> ");
		String writer = sc.nextLine();
		
		System.out.println("도서의 카테고리를 입력해 주세요.");
		System.out.println("1. 유아 2. IT 3. 역사 4. 소설 5. 만화");
		System.out.println("> ");
		int category = sc.nextInt();
		
		System.out.println("도서의 출판사를 입력해 주세요.");
		System.out.println("> ");
		String publisher = sc.nextLine();
		
		System.out.println("도서의 수량을 입력해 주세요.");
		System.out.println("> ");
		int stock = sc.nextInt();
		
		Book book = new Book(bookid,bookName, price, writer, category, publisher, stock);
		
	}
	// 도서 정보를 수정하는 메소드
	public static void editBook() {
		
		Scanner sc = new Scanner(System.in);
		
	}
	// 도서 정보를 삭제하는 메소드
	public static void deleteBook() {
		
	}

}
