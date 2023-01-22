package com.example.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect //적어줘야 aop로 쓸 수 있다.
// @Component해서 쓰는것보다 Config파일에서 @Bean으로 만드는게 더 낫다. 정형화된게 아니니까 aop걸어뒀구나 인지하기 위해서. 둘 중 아무하나 써도 되긴한다.
@Component
public class TimeTraceAop {

    @Around("execution(* com.example.web..*(..))") //어디에 적용해줄지 범위를 적어준다.
    // @Around("execution(* 패키지명..클래스명(파라미터타입..))")
    // @Around("execution(* com.example.web.service..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString()); // 어떤 메서드를 호출했는지 확인
        try {
//            Object result = joinPoint.proceed();// 다음메서드로 진행이된다.
//            return result;
            return joinPoint.proceed(); // 다음메서드로 진행이된다.
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
