package ver02;

import java.util.Scanner;

public class SmartPhone_study_Main {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		SmartPhone_study st = new SmartPhone_study(10);
		

		while (true) {
			System.out.println("전화번호등록부");
			System.out.println("1. 전화번호등록");
			System.out.println("2. 전화번호전체보기");
			System.out.println("3. 이름으로 검색");
			System.out.println("4. 이름으로 검색-> 정보수정");
			System.out.println("5. 이름으로 검색-> 정보삭제");
			System.out.println("6. 프로그램종료");
			System.out.println(">>>메뉴선택하세요");
			
			int select = sc.nextInt();
			
			
			switch (select) {
			case 1:
				st.insertContact();
				break;
			case 2:
				st.printAllData();
				break;
			case 3:
				st.searchData();
				break;
			case 4:
				st.updateData();
				break;
			case 5:
				st.deleteDate();
				break;
				
			case 6:
				System.out.println("프로그램 종료합니다");
				System.exit(0);

				
				


			}
			
		}
		
		
	}

}
