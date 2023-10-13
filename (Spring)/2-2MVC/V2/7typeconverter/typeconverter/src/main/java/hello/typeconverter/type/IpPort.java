package hello.typeconverter.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.security.PrivilegedExceptionAction;
import java.util.Objects;

@Getter
@EqualsAndHashCode //들어있는 값이 같으면 같은걸로 취급한다.
public class IpPort {


    private String ip;
    private int port;

    public IpPort(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

}
