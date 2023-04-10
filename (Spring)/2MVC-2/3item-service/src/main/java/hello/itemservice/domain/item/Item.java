package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Data //@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode //핵심도메인에서 사용하기에는 위험하다. 예측하지 못하게 동작할 수 있기때문이다
@Getter @Setter @ToString
public class Item {

    private Long id;
    private String itemName;
    private Integer price; //wrapper타입인 Integer를 쓴 이유는 가격에 null이 들어갈수도 있기 때문임을 가정한거다.
    private Integer quantity; //Integer를 쓴 이유는 null이 들어갈수도 있기 때문임을 가정한거다.

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
