package program;

import java.sql.SQLException;

import com.newlecture.app.console.NoticeConsoleCl;

public class ProgramCl {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		NoticeConsoleCl console = new NoticeConsoleCl();

		EXIT:
		while (true) {
			console.printNoticeList();
			int menu = console.inputNoticeMenu();

			switch (menu) {
			case 1: // 상세조회
				break;
			case 2: // 이전
				break;
			case 3: // 다음
				break;
			case 4: // 글쓰기
				break;
			case 5: // 종료
				System.out.println("bye~~");
				break EXIT;
			default:
				System.out.println("1~5까지만 입력할 수 있습니다.");
				break;
			}
		}
		

		
		
	}

}
