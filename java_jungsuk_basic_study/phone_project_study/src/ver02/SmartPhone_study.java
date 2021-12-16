package ver02;

import java.util.Scanner;

public class SmartPhone_study {

	Scanner sc = new Scanner(System.in);

	// 객체배열을 선언
	private Contact_study[] contacts;
	private int cnt;

	// 객체배열을 생성
	public SmartPhone_study(int size) {
		contacts = new Contact_study[size];
		cnt = 0;
	}

	// 정보등록하는 메서드 (객체를 생성해서 객체배열의 각 요소에 저장)
	public void insertContact() {
		System.out.println("이름을 입력하세요>>");
		String name = sc.nextLine();
		System.out.println("전화번호를 입력하세요>>");
		String phonenumber = sc.nextLine();
		System.out.println("이메일을 입력하세요>>");
		String email = sc.nextLine();
		System.out.println("주소를 입력하세요>>");
		String address = sc.nextLine();
		System.out.println("생일을 입력하세요>>");
		String birth = sc.nextLine();
		System.out.println("그룹을 입력하세요>>");
		String group = sc.nextLine();
		System.out.println("-----------------------");

		contacts[cnt++] = new Contact_study(name, phonenumber, email, address, birth, group);
	}

	// 정보출력하는 메서드
	public void printAllData() {

		System.out.println("리스트를 출력합니다.(" + cnt + ")명");

		for (int i = 0; i < cnt; i++) {
			contacts[i].printContact();
		}
	}

	// 이름으로 인덱스 검색하는 메서드
	private int searchIndex(String name) {
		int index = -1;

		for (int i = 0; i < cnt; i++) {
			if(contacts[i].getName().equals(name)) {
			index = i;
			break;
			}
		}

		return index;
	}

	// 이름으로 정보검색
	public void searchData() {
		System.out.println("검색을 시작합니다");
		System.out.println("이름을 입력해주세요>>");
		String name = sc.nextLine();

		int index = searchIndex(name);

		if (index < 0) {
			System.out.println("찾으시는 이름이 없습니다.");
		} else {
			contacts[index].printContact();
		}

	}

	// 이름으로 정보검색 -> 수정
	public void updateData() {
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();

		int index = searchIndex(name);

		if (index < 0) {
			System.out.println("찾으시는 이름이 없습니다.");
		} else {
			System.out.println("이름을 입력하세요>>");
			String ename = sc.nextLine();
			System.out.println("전화번호를 입력하세요>>");
			String phonenumber = sc.nextLine();
			System.out.println("이메일을 입력하세요>>");
			String email = sc.nextLine();
			System.out.println("주소를 입력하세요>>");
			String address = sc.nextLine();
			System.out.println("생일을 입력하세요>>");
			String birth = sc.nextLine();
			System.out.println("그룹을 입력하세요>>");
			String group = sc.nextLine();
			contacts[index] = new Contact_study(ename, phonenumber, email, address, birth, group);
			System.out.println("정보가 수정되었습니다.");
		}

	}

	// 이름으로 정보검색 -> 삭제
	public void deleteDate() {
		System.out.println("삭제할 정보의 이름을 입력하세요.");
		String name = sc.nextLine();

		int index = searchIndex(name);

		if (index < 0) {
			System.out.println("찾으시는 이름이 없습니다.");
		} else {
			for (int i = index; i < cnt - 1; i++) {
				contacts[index] = contacts[index + 1];
				cnt--;
			}
			System.out.println(name + "의 데이터가 삭제되었습니다.");
		}

	}

}
