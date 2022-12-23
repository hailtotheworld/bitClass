package spring.aop.advice;

import org.springframework.aop.ThrowsAdvice;

public class LogAfterThrowingAdvice implements ThrowsAdvice {

	// 구현해야할 함수가 정해질수가 없다.
	// 다른 AOP들은 인자가 정해져있다.
	// ThrowsAdvice는 어떤 예외가 발생하느냐에 따라서 함수의 인자가 달라지기 때문에 어떤 것을 구현하라고하는 것을 고정시킬수가 없어서
	// ThrowsAdvice인터페이스는 디폴트메서드가 구현되어있다.
	
	// 어떤 오류가 발생하느냐에 따라 발생하는 예외가 있는데 이 예외 종류가 너무 많은거다.
	public void afterThrowing(IllegalArgumentException e) throws Throwable {
		//                         ㄴ필요로하는 Exception을 내가 맘대로 넣을 수 있다.
		
		// 예외가 발생하지않으면 AfterReturningAdvice 또는
		// 예외가 발생하면       AfterThrowingAdvice가 실행되는거다.
		
		System.out.println("예외가 발생하였습니다." + e.getMessage());
		
		
	}
	
}
