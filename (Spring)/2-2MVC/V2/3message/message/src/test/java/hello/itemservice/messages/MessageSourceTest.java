package hello.itemservice.messages;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource ms;

    @Test
    void helloMessage() {
        String result = ms.getMessage("hello", null, null);
        assertThat(result).isEqualTo("안녕");
    }

    @Test
    void notFoundMessageCode() {
        assertThatThrownBy(() -> ms.getMessage("noCode", null, null)).isInstanceOf(NoSuchMessageException.class);
    }

    @Test
    void notFoundMessageCodeDefaultMessage() {
        String result = ms.getMessage("noCode", null, "기본메시지", null);
        assertThat(result).isEqualTo("기본메시지");
    }

    @Test
    void argumentMessage() {
        String result = ms.getMessage("hello.name", new Object[]{"spring"}, null);
        assertThat(result).isEqualTo("안녕 spring");

    }

}
