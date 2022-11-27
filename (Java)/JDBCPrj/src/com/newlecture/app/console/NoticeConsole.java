package com.newlecture.app.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.newlecture.app.entity.Notice;
import com.newlecture.app.service.NoticeService;

// Controller
public class NoticeConsole {

	// 생성자 밖에서 변수를 '선언'해서 생성자가 아닌 다른 메서드도 이 변수를 사용할 수 있게한다.
	// private를 붙혀서 캡슐화한다. 다른 클래스에서 접근하지 못하도록해. 선언하는 변수(참조변수포함)에게 거의 필수라고 보면된다.
	private NoticeService service;
	private int page;

	public NoticeConsole() {
		service = new NoticeService();
		page = 1;
	}

	public void printNoticeList() throws ClassNotFoundException, SQLException {
		List<Notice> list = service.getList(page);
		
		/*
		list를 구할때마다 count 값이 1매번 달라지기때문에 다시 구해야하며, 2지역내에서만 써야한다.
		공유되야할 멤버변수로 쓰는건 바람직하지 않다. 지역변수로 둔다.
		*/
		int count = service.getCount(); 
		int lastPage = count/10;
		lastPage = count%10>0?lastPage+1:lastPage;
		
		System.out.println("───────────────────────────────────────────");
		System.out.printf("<공지사항> 총 %d게시글\n", count);
		System.out.println("───────────────────────────────────────────");

		for (Notice n : list) {
			System.out.printf("%d. %s / %s / %s\n", n.getId(), n.getTitle(), n.getWriterId(), n.getRegdate());
		}

		System.out.println("───────────────────────────────────────────");
		System.out.printf("               %d/%d pages\n", page, lastPage);
	}

	public int inputNoticeMenu() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1.상세조회 / 2.이전 / 3.다음 / 4.글쓰기 / 5.검색 / 6.종료 >>");
		String menu_ = scan.nextLine();
		int menu = Integer.parseInt(menu_);
		
		// int menu = scan.nextInt();
		// 문제1) 입력된값이 정수형으로 변환될 수 없을때에는 변환하다 에러가날수가있다.
		// 문제2) 버퍼에 남겨져있는 엔터키의 키값이 다음입력에 영향을 줄 수 있다.
				
		return menu;
	}

	public void movePrevList() {
		if(page==1) {
			System.out.println("첫번째페이지입니다.");
			return;
		}
		page--;
		
	}

	public void moveNextList() throws ClassNotFoundException, SQLException {
		int count = service.getCount(); 
		int lastPage = count/10;
		lastPage = count%10>0?lastPage+1:lastPage;
		
		if(page == lastPage) {
			System.out.println("마지막 페이지 입니다.");
			return;
		} else {
			page++;
	
		}
		
		
	}

	public void inputSearchWord() {
		Scanner scan = new Scanner(System.in);
	}

	
	
	
	
	
	
}
