package spring.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class LogBeforeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		System.out.println("앞에서 실행될 로직");
		
		// target에 대한 함수를 호출해주지 않아도 된다..!
		
	}

}
