package viewer;

import java.util.Scanner;

import controller.BookController;
import controller.UserController;
import dao.BookDao;
import object.Book;
import object.User;
import util.ScannerUtil;

public class UserViewer {

	public static int logInId;

	UserController userController;
	BookController bookController;
	Scanner sc;
	BookDao bookdao;

	public UserViewer() {
		userController = new UserController();
		bookController = new BookController();
		sc = new Scanner(System.in);
	}

	///////////////// 회원가입 ///////////////////////////////////
	public void showJoinForm() {
		System.out.println("회원가입!! 시작 나중에 수정");
		/*
		 * 회원가입 아이디, 비밀번호 등 입력받고 컨트롤러 ㄱㄱ
		 * 
		 * 컨트롤러 회원가입까지 만들기
		 * 
		 * 
		 * 
		 */

	}

	///////////////// 로그인 ///////////////////////////////////
	// 로그인
	public void showLogin() {
		while (true) {
			System.out.println("아이디를 입력해주세요.");
			System.out.print("> ");
			String username = ScannerUtil.scanString();
			System.out.println("비밀번호를 입력해주세요.");
			System.out.print("> ");
			String password = ScannerUtil.scanString();

			logInId = userController.auth(username, password);
			if (logInId == 0) {
				System.out.println("로그인에 실패했습니다. 다시 한 번 확인해주세요.");
			} else {
				System.out.println("로그인 성공!");
				showMenu();
				break;
			}
		}
	}
	/////////////////////// 북 검색 ////////////////////////////

	private void adminMenu() {
		/*
		 * 관리자용 메뉴
		 * 
		 */

	}

	public void showMenu() {

		while (true) {

			System.out.println("1. 전체 리스트 보기");
			System.out.println("2. 카테고리별 검색");
			System.out.println("3. 제목으로 검색");
			System.out.println("4. 저자명으로 검색");
			System.out.println("5. 출판사명으로 검색");
			System.out.println("6. 메인 화면으로 가기");
			System.out.println("> ");

			int select = sc.nextInt();

			switch (select) {

			case 1:
				// 전체 리스트 보기 메소드
				BookController.showAll();
				break;

			case 2:
				// 카테고리별 검색 메소드
				break;
			case 3:
				// 제목으로 검색 메소드
				break;
			case 4:
				// 저자명으로 검색 메소드
			case 5:
				// 출판사명으로 검색 메소드
			case 6:
				System.out.println("메인 화면으로 돌아갑니다.");
				System.exit(10);
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

///////////////////////////////////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////////////////////////////////	
	public void showPurchase() {

		while (true) {

			System.out.println("1. 도서 구매하기");
			System.out.println("2. 구매 목록 확인하기");
			System.out.println("3. 메인 화면으로 가기");

			System.out.println("> ");
			


			int select = sc.nextInt();

			switch (select) {

			case 1:
				// 도서 구매하기 메소드
				
				System.out.println("구매하실 책 번호를 입력해주세요.");
				int orderId = 1;
				int bookId = sc.;
				
				bookdao.purchaseBook(orderId, bookId);
											
				if(resultCnt > 0) {
					System.out.println("구매완료");
				} else {
					System.out.println("구매실패");
				}
				
				
				break;

			case 2:
				// 구매목록 확인하기 메소드
				break;

			case 3:
				System.out.println("메인 화면으로 돌아갑니다.");
				System.exit(10);
			default:
				System.out.println("해당하는 메뉴가 없습니다. 다시 입력해 주세요.");
			}

		}
	}
///////////////////////////////////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////////////////////////////////
}
