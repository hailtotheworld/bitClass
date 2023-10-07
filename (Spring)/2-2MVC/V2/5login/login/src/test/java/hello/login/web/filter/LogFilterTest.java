package hello.login.web.filter;

import org.junit.jupiter.api.Test;
import org.springframework.util.PatternMatchUtils;

import static org.junit.jupiter.api.Assertions.*;

class LogFilterTest {

    @Test
    void patternMatchUtils() {

        boolean simpleMatch = PatternMatchUtils.simpleMatch("abc", "abc");
        System.out.println("simpleMatch = " + simpleMatch);

        boolean simpleMatchFalse = PatternMatchUtils.simpleMatch("abc", "ccc");
        System.out.println("simpleMatchFalse = " + simpleMatchFalse);


    }

}