package com.newlecture.app.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.newlecture.app.entity.NoticeCl;
import com.newlecture.app.service.NoticeServiceCl;

// Controller
public class NoticeConsoleCl {

	// 생성자 밖에서 변수를 '선언'해서 생성자가 아닌 다른 메서드도 이 변수를 사용할 수 있게한다.
	// private를 붙혀서 캡슐화한다. 다른 클래스에서 접근하지 못하도록해. 선언하는 변수(참조변수포함)에게 거의 필수라고 보면된다.
	private NoticeServiceCl service;
	private int page;
	private int count;

	public NoticeConsoleCl() {
		service = new NoticeServiceCl();
		page=1;
		count=0;
	}

	public void printNoticeList() throws ClassNotFoundException, SQLException {
		List<NoticeCl> list = service.getList(page);
		count=service.getCount();
		
		System.out.println("───────────────────────────────────────────");
		System.out.printf("<공지사항> 총%d게시글\n", count);
		System.out.println("───────────────────────────────────────────");

		for (NoticeCl n : list) {
			System.out.printf("%d. %s / %s / %s\n", n.getId(), n.getTitle(), n.getWriterId(), n.getRegdate());
		}

		System.out.println("───────────────────────────────────────────");
		System.out.printf("               %dxx/%dxx pages\n", 1, 2);
	}

	public int inputNoticeMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("1.상세조회 / 2.이전 / 3.다음 / 4.글쓰기 / 5.종료 >");
		
		
		String menu_ = scan.nextLine();
		int menu = Integer.parseInt(menu_);
		
		
		return menu;
	}

	public void movePrevPage() {
		if(page==1) {
			System.out.println("첫페이지입니다.");
			return;
		}
		page--;
		
	}

	public void moveNextPage() {

	}


}
