package ex1.io;

public class Program {

	public static void main(String[] args) {
		
		System.out.write(3); // 숫자가 출력된다. 단 코드값으로 인식된다. 3이라는 코드값을 갖고있는 문자를 출력해주지.
		System.out.flush();
		
		System.out.println();
		
		System.out.write('3'); // '' 3이라는 기호를 출력해달라는거다.
		System.out.flush();
		
		System.out.println();
		
		System.out.write('3'+1); // '3'이라는 기호의 코드값의 다음값(+1)에 해당하는 문자가 나올 것이다.
		System.out.write('3'+2); // 3이라는 기호의 코드값의 다음값(+1)에 해당하는 문자가 나올 것이다.
		System.out.write('3'+3); // 3이라는 기호의 코드값의 다음값(+1)에 해당하는 문자가 나올 것이다.
		System.out.write('3'+4); // 3이라는 기호의 코드값의 다음값(+1)에 해당하는 문자가 나올 것이다.
		System.out.flush();
		
		System.out.println();
		
		System.out.write('A'+1); // 'A'라는 기호의 코드값의 다음값(+1)에 해당하는 문자가 나올 것이다.
		System.out.write('A'+2); 
		System.out.write('A'+3);
		System.out.write('A'+4); 
		System.out.flush();		
 
	}

}
