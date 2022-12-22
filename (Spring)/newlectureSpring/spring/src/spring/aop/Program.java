package spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import spring.aop.entity.Exam;
import spring.aop.entity.NewlecExam;

public class Program {

	public static void main(String[] args) {

		Exam exam = new NewlecExam(1, 2, 3, 4);

		// proxy는 원본과 기능이 똑같다. 사용자에게는 원본을 사용하는것과 차이가 없다.

//		Exam proxy = Proxy.newProxyInstance(loader, interfaces, h)
		// loader 실제업무를 호출하는거다. 실질적인 객체를 load하는거야.
		// interfaces 인터페이스 여러개 implements할수있으니까 배열로 제공. 원본이 여러개 인터페이스구현했다면 여러개인터페이스
		// 적는거다.
		// 그래야 가짜를 만드는데 문제가 없겠지.
		// h handler다. invocationHandler라는 인터페이스를 구현한 클래스를 객체화하는 작업을 해야한다.
		// 별도의 클래스파일 만들지말고, 익명클래스를 작성한다.
		Exam proxy = (Exam) Proxy.newProxyInstance(NewlecExam.class.getClassLoader(),
				new Class[] { Exam.class },
				new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

				long start = System.currentTimeMillis();

				// 실제업무
				Object result = method.invoke(exam, args);
				// obj the object the underlying method is invoked from
				// args the arguments used for the method call
				
				long end = System.currentTimeMillis();

				String message = (end - start) + "ms 시간이 걸렸습니다.";

				System.out.println(message);

				return result;
			}
		});

		System.out.printf("total is %d\n", proxy.total());
		System.out.printf("total is %f\n", proxy.avg());

	}

}
