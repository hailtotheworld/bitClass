
public class VarEx2 {

	public static void main(String[] args) {
		// 변수: 하나의 값을 저장할 수 있는 저장공간
		// 변수의값 읽어오기: 변수의 값이 필요한 곳에 변수의 이름을 적는다
		/* 변수의 초기화: 변수에 처음으로 값을 저장하는것
			클래스변수
			인스턴스변수
			지역변수 - 자동초기화되기 않으므로, 읽기전에 반드시 초기화해야한다. */
		
		System.out.println(4+2);
		System.out.println(4-2);
		System.out.println(4*2);
		System.out.println(4/2); 
		
		
		int x = 4, y = 2;
		int tmp;
		
		tmp = x;
		x = y;
		y = tmp;
		
		System.out.println("x="+x);
		System.out.println("y="+y);
		
		System.out.println(x+y);
		System.out.println(x-y);
		System.out.println(x*y);
		System.out.println(x/y); 
		// 이렇게 변수이용하는게 편리하네.

	}

}
