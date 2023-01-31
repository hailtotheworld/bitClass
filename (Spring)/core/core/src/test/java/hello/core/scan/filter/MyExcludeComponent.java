package hello.core.scan.filter;

import java.lang.annotation.*;

// @Component에 있는 어노테이션들을 가져왔다.
@Target(ElementType.TYPE) //TYPE은 클래스레벨에 붙는거다.
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
    
}
