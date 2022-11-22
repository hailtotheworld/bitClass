package program;

import java.sql.SQLException;

import com.newlecture.app.console.NoticeConsoleCl;

public class programCl {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		NoticeConsoleCl console = new NoticeConsoleCl();
		console.printNoticeList();
		int menu = console.inputNoticeMenu();
		
		switch(menu) {
		case 1: // 상세조회
			break;
		case 2: // 이전
			break;
		case 3: // 다음
			break;
		case 4: // 글쓰기
			break;
		}

	}

}
