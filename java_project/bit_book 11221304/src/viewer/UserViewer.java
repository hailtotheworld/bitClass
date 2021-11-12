package viewer;

import java.util.Scanner;

import controller.BookController;
import controller.UserController;
import object.Book;
import util.ScannerUtil;

public class UserViewer {
	public static int logInId; // 로그인된 유저의 고유번호를 저장하는 변수
	public static boolean logInChk; // 로그인 여부를 저장하는 변수

	UserController userController;
	BookController bookController;
	Scanner sc;
	
	public UserViewer() {
		userController = new UserController();
		bookController = new BookController();
		sc = new Scanner(System.in);
	}

	///////////////// 회원가입 ///////////////////////////////////
	public void showJoinForm() {
		System.out.println("==============		회 원 가 입		 ==============\n");
		System.out.println(" 아래 양식에 따라 입력해주세요.");

		System.out.println("로그인 아이디  (영문, 숫자만 입력 가능합니다. ex: AaBbcZ012)");
		System.out.print("> ");
		String userName = ScannerUtil.getString();

		while (!userController.patternChk.userNameForm(userName)) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			System.out.println("로그인 아이디를 입력해주세요.  (영문, 숫자만 입력 가능합니다. ex: AaBbcZ012)");
			System.out.print("> ");
			userName = ScannerUtil.getString();
		}

		System.out.println("\n로그인 비밀번호 (숫자,영어,한글,특수문자(!, _, -, @)로 이루어진 문자 6~20개) 를 입력해주세요. (예: !@지abd123)");
		System.out.print("> ");
		String password = ScannerUtil.getString();

		while (!userController.patternChk.pwForm(password)) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			System.out.println("로그인 비밀번호 (숫자,영어,한글,특수문자(!, _, -, @)로 이루어진 문자 6~20개) 를 입력해주세요. (예: !@지abd123)");
			System.out.print("> ");
			password = ScannerUtil.getString();
		}

		System.out.print("\n이름을 입력해주세요.\n> ");
		String name = ScannerUtil.getString();

		while (!userController.patternChk.nameForm(name)) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			System.out.print("이름을 입력해주세요.\n> ");
			name = ScannerUtil.getString();
		}

		System.out.print("\n이메일을 입력해주세요. (예: mail@email.com)\n> ");
		String email = ScannerUtil.getString();

		while (!userController.patternChk.emailForm(email)) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			System.out.print("이메일을 입력해주세요. (예: mail@email.com)\n> ");
			email = ScannerUtil.getString();
		}

		System.out.print("\n전화번호를 입력해주세요. (-를 포함해주세요.) (예: 010-1111-2222)\n> ");
		String phnum = ScannerUtil.getString();

		while (!userController.patternChk.phnumForm(phnum)) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			System.out.print("전화번호를 입력해주세요. (-를 포함해주세요.) (예: 010-1111-2222)\n> ");
			phnum = ScannerUtil.getString();
		}

		System.out.print("\n주소를 입력해주세요.\n> ");
		String address = ScannerUtil.getString();

		userController.joinUser(userName, password, name, email, phnum, address);
	}

	
	///////////////// 로그인 ///////////////////////////////////
	// 로그인
	public void showLogin() {
		while (true) {
			System.out.println("아이디를 입력해주세요.");
			System.out.print("> ");
			String userName = ScannerUtil.getString();

			while (!userController.patternChk.userNameForm(userName)) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				System.out.println("아이디를 입력해주세요. (영문, 숫자만 입력 가능합니다. ex: AaBbcZ012)");
				System.out.print(">	");
				userName = ScannerUtil.getString();
			}

			System.out.println("비밀번호를 입력해주세요.");
			System.out.print("> ");
			String password = ScannerUtil.getString();

			while (!userController.patternChk.pwForm(password)) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				System.out.println("비밀번호 (숫자,영어,한글,특수문자(!, _, -, @)로 이루어진 문자 6~20개) 를 입력해주세요. (예: !@지abd123)");
				System.out.print("> ");
				password = ScannerUtil.getString();
			}

			logInId = userController.auth(userName, password);
			if (logInId == 0) {
				System.out.println("로그인에 실패했습니다. 다시 한 번 확인해주세요.");
			} else {
				System.out.println("로그인 성공!");
				logInChk = true;

				if (logInId < 10) {
					adminMenu();
				} else {
					showMenu();
				}
				break;
			}
		}
	}


	// 내 정보 확인
	private void showMyInfo() {
		while (logInChk) {
			userController.showInfo(logInId);
			System.out.println("================================");

			System.out.println("1. 정보수정\t 2. 회원탈퇴\t 3. 뒤로가기");
			System.out.print("메뉴를 선택해주세요.\n> ");
			int select = ScannerUtil.scanInt();

			switch (select) {
			case 1: // 정보수정
				updateMyInfo();
				break;
			case 2: // 회원탈퇴
				deleteAccount();
				break;
			case 3:
				// 뒤로가기
				return;
			default:
				System.out.println("해당하는 메뉴가 없습니다. 다시 확인해주세요.");
			}
		}
	}

	
	// 정보 수정
	private void updateMyInfo() {
		System.out.println("회원정보 수정을 시작합니다.");
		System.out.println("정말로 수정하시겠습니까? 수정하시려면 이전 비밀번호를 입력해주세요.");
		String password = ScannerUtil.getString();

		if (userController.userDao.passwordChk(logInId, password)) {
			System.out.print("변경할 비밀번호를 입력하세요.\n> ");
			String newPassword = ScannerUtil.getString();

			System.out.print("변경할 이메일을 입력하세요.\n> ");
			String email = ScannerUtil.getString();
			while (!userController.patternChk.emailForm(email)) {
				System.out.println("올바른 이메일 형식으로 입력하세요.");
				System.out.print("변경할 이메일을 입력하세요.\n> ");
				email = ScannerUtil.getString();
			}

			System.out.print("변경할 전화번호를 입력하세요.\n> ");
			String phnum = ScannerUtil.getString();
			while (!userController.patternChk.phnumForm(phnum)) {
				System.out.println("올바른 전화번호 형식으로 입력하세요.");
				System.out.print("변경할 전화번호를 입력하세요.\n> ");
				phnum = ScannerUtil.getString();
			}

			System.out.print("변경할 주소를 입력하세요.\n> ");
			String address = ScannerUtil.getString();

			userController.updateInfo(newPassword, email, phnum, address, logInId);
			System.out.println("회원정보가 수정되었습니다.");

		} else {
			System.out.println("회원정보 수정을 취소하였습니다.");
		}
	}

	
	// 회원 탈퇴
	private void deleteAccount() {
		System.out.println("정말로 탈퇴하시겠습니까? Y/N");
		String yesNo = ScannerUtil.getString();

		if (yesNo.equalsIgnoreCase("Y")) {
			System.out.println("탈퇴하시려면 비밀번호를 입력해주세요.");
			String password = ScannerUtil.getString();

			int deleteChk = userController.deleteUser(logInId, password);
			if (deleteChk > 0) {
				logInId = 0;
				logInChk = false;
			}
		} else {
			System.out.println("회원 탈퇴가 취소되었습니다.");
		}
	}

	
	////////////////////////// 도서 //////////////////////////////////////////////////////////////
	// 일반회원 메뉴
	private void showMenu() {
		while (logInChk) {

			System.out.println("============== 비트서점 ==============");
			System.out.println("1. 내 정보 확인");
			System.out.println("2. 도서 검색 및 구매");
			System.out.println("3. 내 주문 내역");
			System.out.println("4. 로그아웃");
			System.out.println("5. 랜덤!!!");
			System.out.println("===================================");
			System.out.print("메뉴를 선택하세요.\n> ");

			int select = ScannerUtil.scanInt();

			switch (select) {
			case 1: // 내 정보 확인
				showMyInfo();
				break;
			case 2: // 도서 검색
				showBookMenu();
				break;
			case 3:
				// 지난 주문내역
				bookController.userOrderDetail(logInId);
				break;
			case 4:
				// 로그아웃 후 이전메뉴로 돌아가기
				System.out.println("로그아웃 후 메인화면으로 돌아갑니다.");
				logInId = 0;
				logInChk = false;
				System.out.println("로그아웃되었습니다.");
				return;
			case 5:
				bookController.showRandom();
				break;
			default:
				System.out.println("해당하는 메뉴 번호가 없습니다. 다시 확인해주세요.");
			}
		}
	}
	
	private void adminMenu() {

		while (logInChk) {
			System.out.println("============= 관리자 메뉴 =============");
			System.out.println("1. 신규 도서 등록");
			System.out.println("2. 기존 도서 관리");
			System.out.println("3. 매출 현황");
			System.out.println("4. 뒤로가기");
			System.out.println("===================================");
			System.out.print("메뉴를 선택하세요.\n> ");

			int select = ScannerUtil.scanInt();

			switch (select) {
			case 1:
				// 신규도서 등록
				System.out.println("도서의 일련번호를 입력해 주세요.");
				System.out.print("> ");
				int bookid = ScannerUtil.scanInt();
				
				System.out.println("\n도서의 제목을 입력해 주세요.");
				System.out.print("> ");
				String bookName = ScannerUtil.getString();
				
				System.out.println("\n도서의 가격을 입력해 주세요.");
				System.out.print("> ");
				int price = ScannerUtil.scanInt();
				
				System.out.println("\n도서의 저자를 입력해 주세요.");
				System.out.print("> ");
				String writer = ScannerUtil.getString();
				
				System.out.println("\n도서의 카테고리를 입력해 주세요.\n1. 유아 2. IT 3. 역사 4. 소설 5. 만화");
				System.out.print("> ");
				int category = ScannerUtil.scanInt();
				
				System.out.println("\n도서의 출판사를 입력해 주세요.");
				System.out.print("> ");
				String publisher = ScannerUtil.getString();
				
				System.out.println("\n도서의 수량을 입력해 주세요.");
				System.out.print("> ");
				int stock = ScannerUtil.scanInt();

				bookController.insertBook(new Book(bookid,bookName, price, writer, publisher, category, stock));
				break;
				
				
			case 2:
				// 기존도서 관리
				showBookAdmin();
				break;
			case 3:
				// 매출현황
				//bookController.deleteBook();
				break;
			case 4:
				// 관리자 메뉴 종료
				System.out.println("로그아웃 후 메인화면으로 돌아갑니다.");
				logInId = 0;
				logInChk = false;
				System.out.println("로그아웃되었습니다.");
				return;
			default:
				System.out.println("해당하는 메뉴 번호가 없습니다. 다시 확인해주세요.");
			}
		}
	}
	public void showBookAdmin() {
		boolean onOff = true;
		while(onOff) {
			
			System.out.println("1. 기존 도서 수정");
			System.out.println("2. 기존 도서 삭제");
			System.out.println("3. 뒤로가기");
			System.out.println("===================================");
			System.out.print("메뉴를 선택하세요.\n> ");
			
			int select = ScannerUtil.scanInt();

			
			switch(select) {
			
			case 1:
				
				Scanner sc = new Scanner(System.in);
				
				System.out.println("도서의 일련번호를 입력해 주세요.");
				System.out.println("> ");
				int bookid = sc.nextInt();
				
				System.out.println("도서의 제목을 입력해 주세요.");
				System.out.println("> ");
				sc.nextLine();
				String bookName = sc.nextLine();
				
				System.out.println("도서의 가격을 입력해 주세요.");
				System.out.println("> ");
				int price = sc.nextInt();
				
				System.out.println("도서의 저자를 입력해 주세요.");
				System.out.println("> ");
				sc.nextLine();
				String writer = sc.nextLine();
				
				System.out.println("도서의 카테고리를 입력해 주세요.");
				System.out.println("1. 유아 2. IT 3. 역사 4. 소설 5. 만화");
				System.out.println("> ");
				int category = sc.nextInt();
				
				System.out.println("도서의 출판사를 입력해 주세요.");
				System.out.println("> ");
				sc.nextLine();
				String publisher = sc.nextLine();
				
				System.out.println("도서의 수량을 입력해 주세요.");
				System.out.println("> ");
				int stock = sc.nextInt();
				
				Book book = new Book(bookid,bookName, price, writer, publisher, category, stock);
				bookController.editBook(book);
				
				break;
			case 2:
				sc = new Scanner(System.in);
				
				System.out.println("도서의 일련번호를 입력해 주세요.");
				System.out.println("> ");
				bookid = sc.nextInt();
			
				bookController.deleteBook(bookid);
				break;
				
			case 3:
				onOff = false;
			}
		}
	}

	//	Book menu
	public void showBookMenu() {
		boolean onOff = true;
		while (onOff) {
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

			int select = ScannerUtil.scanInt();
			
			switch (select) {

			case 1:
				// 전체 리스트 보기 메소드
				bookController.showAll();
				break;

			case 2:
				// 카테고리별 검색 메소드
				System.out.println("카테고리 번호를 입력해 주세요.");
				System.out.println("1. 유아 2. IT 3. 역사 4. 소설 5. 만화");
				System.out.println("> ");

				int categoryId = ScannerUtil.scanInt();
				bookController.selectByCategory(categoryId);
				break;

			case 3:
				// 제목으로 검색 메소드
				System.out.println("제목의 키워드를 입력해 주세요.");
				System.out.println("> ");
				String bookName = ScannerUtil.scanString();
				bookController.selectByName(bookName);
				break;

			case 4:
				// 저자명으로 검색 메소드
				System.out.println("작가 이름을 입력해 주세요.");
				System.out.println("> ");
				String writer = ScannerUtil.scanString();
				bookController.selectByWriter(writer);
				break;

			case 5:
				// 출판사명으로 검색 메소드
				System.out.println("출판사명을 입력해 주세요.");
				System.out.println("> ");
				String publisher = ScannerUtil.scanString();
				bookController.selectByPublisher(publisher);
				break;

			case 6:
				//	책 구매하기
				System.out.println("구매하실 책의 번호나 이름을 입력해주세요.");
				System.out.println("1. 책 번호로 구입 \n2. 책 이름으로 구입 \n3. 뒤로가기");
				boolean result = false;
				int userChoice = ScannerUtil.scanInt();
				
				if( userChoice == 1 ) {
					System.out.println("책 번호를 입력해주세요.");
					
					int bookId = ScannerUtil.scanInt();
					System.out.println(bookId);
				    result = bookController.buyBook(bookId,logInId);
				    System.out.println(result);
				    if(!result) {
						System.out.println("현재 선택하신 책이 없습니다.");
					} else {
						System.out.println("책 구입이 완료되었습니다.");
					}
				} else if ( userChoice == 2 ){
					System.out.println("책 제목을 입력해주세요.");
					String bookTitle = ScannerUtil.scanString();

					result = bookController.buyBook(bookTitle,logInId);
				} 
				

			case 7:
				System.out.println("메인 화면으로 돌아갑니다.");
				onOff = false;
			default:
				System.out.println("해당하는 메뉴가 없습니다. 다시 입력해 주세요.");
			}
		}

		/*
		 * - 일반유져 도서 검색 마이페이지
		 * 
		 * - 관리자 도서관리
		 * 
		 */
	}
}
