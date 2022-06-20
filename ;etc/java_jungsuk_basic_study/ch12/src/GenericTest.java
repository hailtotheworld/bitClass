import java.util.ArrayList;

public class GenericTest {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(10);
		list.add(20);
		list.add("30"); // String을 추가했네.
		
//		Integer i = (Integer) list.get(2);
		// 컴파일은 되는데 ClassCastException(형변환) 에러가 난다. 컴파일러의 한계구나.
		// ClassCastException(형변환): 실행시 발생하는 에러이다.
		// 실행시 발생하는 에러를 어떻게하면 컴파일러 급으로 가져올수 있을까? 에 대한 고민으로부터 지네릭스가 만들어졌다.

		System.out.println(list);
		//--------------------------------------------------------------------- 
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(10);
		list2.add(20);
//		list2.add("30"); // 컴파일러가 에러를 잡아내준다!
		
		Integer i2 = list2.get(1);

		
		
		
	}

}
