
class AA { // AA는 BB의 외부 클래스
	int i=100;
	BB b = new BB();
	
	class BB { // BB는 AA의 내부클래스
		void method() {
//			AA a = new AA();
//			System.out.println(a.i);
			System.out.println(i); // 객체 생성없이 외부 클래스의 멤버 접근가능
		}
	}
	
}


class CC {
//	BB b = new BB(); //BB가 내부 클래스가 되면서 사용불가
}




public class InnerTest {

	public static void main(String[] args) {
//		BB b = new BB(); 
//		b.method();
	}

}
