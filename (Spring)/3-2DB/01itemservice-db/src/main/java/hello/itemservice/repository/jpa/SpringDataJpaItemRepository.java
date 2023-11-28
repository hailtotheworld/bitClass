package hello.itemservice.repository.jpa;

import hello.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//이 인터페이스를 구현한 Aop객체가 내부에서 알아서 생성된다.
public interface SpringDataJpaItemRepository extends JpaRepository<Item, Long> { //JpaRepository<관리할Entity, 그Entity의pk타입>

    //(1) 공통 인터페이스가 제공하는 기능은 전부 포함되어있다. alt + insert로 override Methods를 보면 확인해볼수있다.

    //(2) 쿼리 메서드
    List<Item> findByItemNameLike(String itemName);

    List<Item> findByPriceLessThanEqual(Integer price);

    List<Item> findByItemNameLikeAndPriceLessThanEqual(String itemName, Integer price); // (아래 쿼리 직접 실행 메서드와 기능이 같다)

    // (3) 쿼리 직접 실행
    @Query("select i from Item i where i.itemName like :itemName and i.price <= :price")
    List<Item> findItems(@Param("itemName") String itemName, @Param("price") Integer price);
    //org.springframework.data.repository.query.Param;    import할때 주의. ibatis거 아니다.
    // @Param("여기적은게") -> @Query에 기재한  :적은것에 매칭된다
}
