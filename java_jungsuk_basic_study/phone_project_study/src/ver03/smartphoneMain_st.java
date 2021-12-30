package ver03;

import java.util.Scanner;

public class smartphoneMain_st {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		smartphone_st sp = new smartphone_st(10);
		
		while(true) {
			System.out.println("전화번호부");
			System.out.println("1.전화번호등록");
			System.out.println("2.전화번호전체조회");
			System.out.println("3.검색해서조회");
			System.out.println("4.검색해서수정");
			System.out.println("5.검색해서삭제");
			System.out.println("6.프로그램종료");
			
			int select = sc.nextInt();
			
			switch (select) {
			case 1:
				sp.addData();
				break;
			case 2:
				sp.printData();
				break;
			case 3:
				sp.seeData();
				break;
			case 4:
				sp.editData();
				break;
			case 5:
				sp.deleteData();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("잘못입력하셨습니다. 다시 입력하세요.");
				break;
			}
		}
	
	}

}
