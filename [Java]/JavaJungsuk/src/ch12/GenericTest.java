package ch12;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericTest {
	public static void main(String[] args) {
		ArrayList<Object> list = new ArrayList<Object>();
		// 컴파일러에게 더 많은 정보를 제공해주는거야.
		
		list.add(10); // list.add(new Integer(10)); 오토박싱
		list.add(20);
		list.add("30"); // String을 추가.  지네릭스로 인해 컴파일러가 체크해준다.
		
		
//		Integer i = (Integer) list.get(2);
		String i = list.get(2);
		// 컴파일에러가 없네. 컴파일러의 한계다.
		// 컴파일러는 값을 꺼낼때 Object라서 허용했는데 실제로는 뭐가 들었는지 체크를 할 수가 없다.
		// 실행하면 java.lang.ClassCastException 형변환에러가 발생
		
		// 실행시 에러가 발생하면 프로그램이 죽으니까 차라리 컴파일에러가 낫지.
		// 컴파일러가 에러를 체크해주는게 좋은데 컴파일러가 한계가 있어서 컴파일러가 못잡아준 에러가 실행시 발생하는거다.
		// 실행시 발생하는 에러를 어떻게 하면 컴파일 때 잡아낼 수 있을까? 고민에 대한 결과가 지네릭스다.
		
		
		
		System.out.println(list);
	}

}
