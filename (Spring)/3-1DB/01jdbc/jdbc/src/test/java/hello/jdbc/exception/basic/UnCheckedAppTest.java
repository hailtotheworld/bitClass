package hello.jdbc.exception.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.net.ConnectException;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
public class UnCheckedAppTest {

    @Test
    void unchecked() {
        Controller controller = new Controller();
        assertThatThrownBy(() -> controller.request()).isInstanceOf(Exception.class);
    }

    @Test
    void printEx() {
        Controller controller = new Controller();
        try {
            controller.request();
        } catch (RuntimeConnectException e) {
            log.info("ex첫번째", e);
        } catch (Exception e) {
            log.info("ex두번째", e);
        }
    }

//    @Test
//    void catchTest() {
//        try {
//            throw new SQLException();
//            throw new RuntimeConnectException();
//        } catch (RuntimeConnectException e) {
//            log.info("ex", e);
//        } catch (SQLException e) {
//            log.info("ex", e);
//        }
//    }

    static class Controller {
        Service service = new Service();

        public void request() {
            service.logic();
        }
    }

    static class Service {
        Repository repository = new Repository();
        NetworkClient networkClient = new NetworkClient();

        public void logic() {
            networkClient.call();
            repository.call();
        }
    }

    static class NetworkClient {
        public void call() {
            throw new RuntimeConnectException("연결 실패");
        }
    }

    static class Repository {
        public void call() {
            try {
                runSQL();
            } catch (SQLException e) {
                throw new RuntimeSQLException(e);
            }
        }

        public void runSQL() throws SQLException {
            throw new SQLException("SQL예외도 잡는다!! ex");
        }
    }

    static class RuntimeConnectException extends RuntimeException {
        public RuntimeConnectException() {
        }

        public RuntimeConnectException(String message) {
            super(message);
        }

        public RuntimeConnectException(Throwable cause) {
            super(cause);
        }
    }

    static class RuntimeSQLException extends RuntimeException {
        public RuntimeSQLException(String message) {
            super(message);
        }

        public RuntimeSQLException(Throwable cause) {
            super(cause);
        }
    }

}
