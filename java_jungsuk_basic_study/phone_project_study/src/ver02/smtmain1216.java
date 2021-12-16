package ver02;

import java.util.Scanner;

public class smtmain1216 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		smt1216 smt = new smt1216(10);



		while (true) {
			
			System.out.println("전화번호부");
			System.out.println("1.전화번호등록");
			System.out.println("2.등록된 번호 전체보기");
			System.out.println("3.이름으로 검색");
			System.out.println("4.이름으로 검색해서 수정");
			System.out.println("5.이름으로 검색해서 삭제");
			System.out.println("6.프로그램 종료");
			System.out.println(">>");

			int key = sc.nextInt();

			switch (key) {
			case 1:
				smt.writeData();
				break;
			case 2:
				smt.seeData();
				break;
			case 3:
				smt.searchName();
				break;
			case 4:
				smt.upupName();
				break;
			case 5:
				smt.byeDate();
				break;
				
				
			case 6:
				System.exit(0);


			}

		}

	}

}
