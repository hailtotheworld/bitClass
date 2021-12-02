package pkg1;

public class MyParent {// 접근제어자가 public
	private   int private1;   // 같은 클래스
			  int default1;   // 같은 패키지
	protected int protected1; // 같은 패키지 + 자손(다른 패키지)
	public 	  int public1; 	  // 접근제한 없음.
	
	public void printMembers() {
		System.out.println(private1);
		System.out.println(default1);
		System.out.println(protected1);
		System.out.println(public1);

	}
}

class MyParentTest {
	public static void main(String[] args) {
		MyParent p = new MyParent();
		
//		System.out.println(p.private1); // 에러가 난다. private 접근범위는 같은클래스니까.
		System.out.println(p.default1);
		System.out.println(p.protected1);
		System.out.println(p.public1);
		
	}

}
