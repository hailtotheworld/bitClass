package viewer;

import controller.BookController;
import util.ScannerUtil;

public class BookViewer {
	
	BookController bookController;
	
	public BookViewer () {
		bookController = new BookController();
		
	}
	
	//	Book menu
	public void showBookMenu() {
		boolean onOff = true;
		while (onOff) {
			
			showMenu();			// 메뉴 출력
			
			int select = ScannerUtil.scanInt();
			switch (select) {

			case 1:	
					bookController.showAll();	// 전체 리스트 보기 메소드
					break;

			case 2: 
					showCtgyMenu();				// 카테고리별 검색 메소드
					break;

			case 3: 
					showTitleMenu();			// 제목으로 검색 메소드
					break;

			case 4:	
					showWriterMeun();			// 저자명으로 검색 메소드
					break;

			case 5:	
					showPublisherMeun();		// 출판사명으로 검색 메소드
					break;

			case 6: 
					showSaleBookMenu();			//	책 구매하기
					break;
					
			case 7:
					System.out.println("메인 화면으로 돌아갑니다.");
					onOff = false;
					
			default:
					System.out.println("해당하는 메뉴가 없습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	
	public void showMenu(){
		System.out.println("=======================================");
		System.out.println("       WLECOME TO BIT_BOOKSTORE");
		System.out.println("=======================================");
		System.out.println("1. 전체 리스트 보기");
		System.out.println("2. 카테고리별 검색");
		System.out.println("3. 제목으로 검색");
		System.out.println("4. 저자명으로 검색");
		System.out.println("5. 출판사명으로 검색");
		System.out.println("6. 책 구매하기");
		System.out.println("7. 메인 화면으로 가기");
		System.out.println("> ");
	}
	
	public void showCtgyMenu() {
		System.out.println("카테고리 번호를 입력해 주세요.");
		System.out.println("1. 유아 2. IT 3. 역사 4. 소설 5. 만화");
		System.out.println("> ");
		
		int categoryId = ScannerUtil.scanInt();
		bookController.selectByCategory(categoryId);
	}
	
	public void showTitleMenu() {
		System.out.println("제목의 키워드를 입력해 주세요.");
		System.out.println("> ");
		String bookName = ScannerUtil.scanString();
		bookController.selectByName(bookName);
	}
	
	public void showWriterMeun() {
		System.out.println("작가 이름을 입력해 주세요.");
		System.out.println("> ");
		String writer = ScannerUtil.scanString();
		bookController.selectByWriter(writer);
	}
	
	public void showPublisherMeun() {
		System.out.println("출판사명을 입력해 주세요.");
		System.out.println("> ");
		String publisher = ScannerUtil.scanString();
		bookController.selectByPublisher(publisher);
	}
	
	public void showSaleBookMenu() {
		System.out.println("구매하실 책의 번호나 이름을 입력해주세요.");
		System.out.println("1. 책 번호로 구입 \n2. 책 이름으로 구입 \n3. 뒤로가기");
		boolean result = false;
		int userChoice = ScannerUtil.scanInt();
		
		if( userChoice == 1 ) {
			System.out.println("책 번호를 입력해주세요.");
			
			int bookId = ScannerUtil.scanInt();

			result = bookController.buyBook(bookId);

			if(!result) {
				System.out.println("현재 선택하신 책이 없습니다.");
			} else {
				System.out.println("책 구입이 완료되었습니다.");
			}
			
		} else if ( userChoice == 2 ){
			System.out.println("책 제목을 입력해주세요.");
			String bookTitle = ScannerUtil.scanString();

			result = bookController.buyBook(bookTitle);
		} 
		
	}
	
	public void showBeforeOrder() {
		bookController.userOrderDetail();	
	}

}
