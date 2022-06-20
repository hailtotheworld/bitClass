package pkg2;

import pkg1.MyParent; // crtl+shift+o

class MyChild extends MyParent { // 접근제어자가 default라서 에러가 난다.
	public void printMembers() {
//		System.out.println(private1); //에러 같은클래스
//		System.out.println(default1); //에러 같은패키지
		System.out.println(protected1); //패키지가 달라도 자손이면ㅇㅋ
		System.out.println(public1);
	}
	
	
}

public class MyParentTest2 {

	public static void main(String[] args) {
		MyParent p = new MyParent();

//		System.out.println(p.private1); // 에러
//		System.out.println(p.default1);
//		System.out.println(p.protected1);
		System.out.println(p.public1);

	}

}
