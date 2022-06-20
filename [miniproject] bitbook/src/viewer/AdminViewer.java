package viewer;

import controller.BookController;
import controller.OrdersController;
import object.Book;
import util.BookPatternChk;
import util.PatternChk;
import util.ScannerUtil;

public class AdminViewer {
	
	BookController bookController;
	OrdersController ordersController;
	PatternChk patternChk;
	BookPatternChk bookChk;
	
	public AdminViewer() {
		bookController = new BookController();
		ordersController = new OrdersController();
		patternChk = new PatternChk();
		bookChk = new BookPatternChk();
	}
	
	public void adminMenu() {
		System.out.println("여기는?");
		while (logger.LoginUser.loginStatus) {
			
			showAdminMenu();	// 관리자 메뉴 출력	
			
			System.out.print("메뉴를 선택하세요.\n> ");
			int select = ScannerUtil.scanInt();

			switch (select) {
			
			case 1:	
					showAddBookMenu();		// 신규도서 등록 메뉴
					break; 	
				
			case 2: 
					showBookAdmin();		// 기존도서 관리
					break;
			
			case 3: 
					if(ordersController.ordersChk()) {
						viewOrders();			// 매출현황
					} else {
						System.out.println("매출내역이 존재하지 않습니다.\n");
					}
					break;

			case 4:
					System.out.println("로그아웃되었습니다. 메인화면으로 돌아갑니다.");
					logger.LoginUser.logOut();
					return;
					
			default:
					System.out.println("해당하는 메뉴 번호가 없습니다. 다시 확인해주세요.");
			}
		}
	}
	
	
	
	public void viewOrders() {
		while (true) {
			System.out.println("============== 매출 현황 ==============");
			System.out.println("1. 전체 매출 목록");
			System.out.println("2. 일별 매출");
			System.out.println("3. 월별 매출");
			System.out.println("4. 이전 메뉴");
			System.out.println("===================================");
			System.out.print("메뉴를 선택하세요.\n> ");

			int select = ScannerUtil.scanInt();

			switch (select) {

			case 1: // 전체 목록
					ordersController.viewAllOrders();
					break;
					
			case 2: // 일별 매출
					viewDailyOrders();
					break;
					
			case 3:	// 월별 매출
					viewMonthlyOrders();
					break;
			case 4:	// 메뉴 종료
					System.out.println("이전 메뉴로 돌아갑니다.");
					return;
			default:
					System.out.println("해당하는 메뉴 번호가 없습니다. 다시 확인해주세요.");
			}
		}
	}
	
	
	// 월별 매출 보기 메소드
	private void viewMonthlyOrders() {
		ordersController.viewOrderMonth();

		System.out.println("자세히 보고 싶은 연월을 입력하세요. (예: 202101)");
		System.out.print("> ");
		String orderMonth = ScannerUtil.getString();

		while (!patternChk.orderMonthForm(orderMonth)) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			System.out.println("자세히 보고 싶은 날짜를 입력하세요. (예: 202101)");
			System.out.print("> ");
			orderMonth = ScannerUtil.getString();
		}

		ordersController.viewMonthlyOrders(orderMonth);
	}

	
	// 일별 매출 보기 메소드
	private void viewDailyOrders() {
		ordersController.viewOrderdate();

		System.out.println("자세히 보고 싶은 날짜를 입력하세요. (예: 20210101)");
		System.out.print("> ");
		String orderdate = ScannerUtil.getString();

		while (!patternChk.orderdateForm(orderdate)) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			System.out.println("자세히 보고 싶은 날짜를 입력하세요. (예: 20210101)");
			System.out.print("> ");
			orderdate = ScannerUtil.getString();
		}

		ordersController.viewDailyOrders(orderdate);
	}
	
	private void showBookAdmin() {
		while(true) {
			
			System.out.println("1. 기존 도서 수정");
			System.out.println("2. 기존 도서 삭제");
			System.out.println("3. 뒤로가기");
			System.out.println("===================================");
			System.out.print("메뉴를 선택하세요.\n> ");
			
			int select = ScannerUtil.scanInt();

			
			switch(select) {
			
			case 1:
				
				System.out.println("도서의 일련번호를 입력해 주세요.");
				System.out.println("> ");
				int bookid = ScannerUtil.scanInt();
				
				System.out.println("도서의 제목을 입력해 주세요.");
				System.out.println("> ");
				String bookName = ScannerUtil.scanString();
				
				System.out.println("도서의 가격을 입력해 주세요.");
				System.out.println("> ");
				int price = ScannerUtil.scanInt();
				
				System.out.println("도서의 저자를 입력해 주세요.");
				System.out.println("> ");
				String writer = ScannerUtil.scanString();
				
				System.out.println("도서의 카테고리를 입력해 주세요.");
				System.out.println("1. 유아 2. IT 3. 역사 4. 소설 5. 만화");
				System.out.println("> ");
				int category = ScannerUtil.scanInt();
				
				System.out.println("도서의 출판사를 입력해 주세요.");
				System.out.println("> ");
				String publisher = ScannerUtil.scanString();
				
				System.out.println("도서의 수량을 입력해 주세요.");
				System.out.println("> ");
				int stock = ScannerUtil.scanInt();
				
				Book book = new Book(bookid,bookName, price, writer, publisher, category, stock);
				bookController.editBook(book);
				break;
				
			case 2:
				System.out.println("도서의 일련번호를 입력해 주세요.");
				System.out.println("> ");
				bookid = ScannerUtil.scanInt();
			
				bookController.deleteBook(bookid);
				break;
				
			case 3:
				return;
			}
		}
	}
	
	private void showAddBookMenu() {
		System.out.println("도서의 일련번호를 입력해 주세요.");
		System.out.print("> ");
		int bookid = ScannerUtil.scanInt();
		
		System.out.println("\n도서의 제목을 입력해 주세요.");
		System.out.println("도서 제목은 최대 20글자를 넘을 수 없습니다.");
		System.out.print("> ");
		String bookName = ScannerUtil.getString();
		
		while(!bookChk.bookNameForm(bookName)) {
			System.out.println("도서 제목이 너무 길거나 입력할 수 없는 문자를 포함하고 있습니다.");
			System.out.print("다시 한 번 입력해주세요.\n> ");
			bookName = ScannerUtil.getString();
		}
		
		System.out.println("\n도서의 가격을 입력해 주세요.");
		System.out.print("> ");
		int price = ScannerUtil.scanInt();
		
		System.out.println("\n도서의 저자를 입력해 주세요.");
		System.out.println("영문, 한글, '.,' 만 입력 가능하며 최대 12글자를 넘을 수 없습니다.");
		System.out.print("> ");
		String writer = ScannerUtil.getString();
		
		while(!bookChk.writerForm(writer)) {
			System.out.println("저자가 너무 길거나 입력할 수 없는 문자를 포함하고 있습니다.");
			System.out.print("다시 한 번 입력해주세요.\n> ");
			writer = ScannerUtil.getString();
		}
		
		System.out.println("\n도서의 카테고리를 입력해 주세요.\n1. 유아 2. IT 3. 역사 4. 소설 5. 만화");
		System.out.print("> ");
		int category = ScannerUtil.scanInt();
		
		System.out.println("\n도서의 출판사를 입력해 주세요.");
		System.out.println("영문, 한글, 숫자, '&' 만 입력 가능하며 최대 10글자를 넘을 수 없습니다.");
		System.out.print("> ");
		String publisher = ScannerUtil.getString();
		
		while(!bookChk.publisherForm(publisher)) {
			System.out.println("출판사명이 너무 길거나 입력할 수 없는 문자를 포함하고 있습니다.");
			System.out.print("다시 한 번 입력해주세요.\n> ");
			publisher = ScannerUtil.getString();
		}
		
		System.out.println("\n도서의 수량을 입력해 주세요.");
		System.out.print("> ");
		int stock = ScannerUtil.scanInt();

		bookController.insertBook(new Book(bookid,bookName, price, writer, publisher, category, stock));

	}

	public void showAdminMenu() {
		System.out.println("============= 관리자 메뉴 =============");
		System.out.println("1. 신규 도서 등록");
		System.out.println("2. 기존 도서 관리");
		System.out.println("3. 매출 현황");
		System.out.println("4. 뒤로가기");
		System.out.println("===================================");
	}
}
