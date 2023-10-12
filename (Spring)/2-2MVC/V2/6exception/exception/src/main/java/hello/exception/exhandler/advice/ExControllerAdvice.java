package hello.exception.exhandler.advice;

import hello.exception.exception.UserException;
import hello.exception.exhandler.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestControllerAdvice(basePackages = "hello.exception.api") //@ResponseBody @ControllerAdvice
public class ExControllerAdvice {

    // 이 컨트롤러 안에서 지정해준예외(자식예외들다포함) 에러가 발생하면 잡는다. 정상흐름으로 바꿔준다(상태코드200) 그리고 메서드에 지정한 로직이 호출된다.
    // 상태코드 바꾸고 싶다면 @ResponseStatus 붙여주면 된다.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalExHandler(IllegalArgumentException e) {
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("BAD", e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResult> userExHandler(UserException e) { //매개변수에 넣은 예외를 @ExceptionHandler이 잡아준다.
        log.error("[exceptionHandler] ex", e);
        ErrorResult errorResult = new ErrorResult("USER-EX", e.getMessage());
        return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public ErrorResult exHandler(Exception e) { //지정해준예외의 자식예외까지 다 잡아준다.
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("EX", "내부 오류");
    }
}
