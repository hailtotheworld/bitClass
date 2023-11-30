package hello.springtx.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="orders") //DB에서 order by라는 예약어가 있어서 order를 쓸 수 없는 DB가 많다.
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private String username;  // 정상,예외,잔고부족
    private String payStatus; // 대기, 완료

    public Order() {
    }
}
