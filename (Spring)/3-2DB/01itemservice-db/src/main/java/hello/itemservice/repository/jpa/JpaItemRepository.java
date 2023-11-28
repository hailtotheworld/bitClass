package hello.itemservice.repository.jpa;

import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemRepository;
import hello.itemservice.repository.ItemSearchCond;
import hello.itemservice.repository.ItemUpdateDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
@Transactional
/* JPA의 모든 데이터 변경(등록, 수정, 삭제)은 트랜잭션 안에서 이루어져야 한다. 조회는 트랜잭션이 없어도 가능하다.
변경의 경우 일반적으로 서비스 계층에서 트랜잭션을 시작하기 때문에 문제가 없다.
중요) 일반적으로는 비즈니스 로직을 시작하는 서비스 계층에 트랜잭션을 걸어주는 것이 맞다.(이예제만예외적으로)*/
public class JpaItemRepository implements ItemRepository {

    // JPA의 모든 동작은 엔티티 매니저를 통해서 이루어진다. 엔티티 매니저는 내부에 데이터소스를 가지고 있고, 데이터베이스에 접근할 수 있다.
    private final EntityManager em;

    public JpaItemRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Item save(Item item) {
        em.persist(item);
        // 객체를 테이블에 저장할때는 persist()메서드를 사용하면 된다.
        // 객체를 보고 insert쿼리를 만들어서 DB에 저장한다. DB에서 자동생성되는값도 조회해서 넣어준다.
        return item;
    }

    @Override
    public void update(Long itemId, ItemUpdateDto updateParam) {
        Item findItem = em.find(Item.class, itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
/*      em.update() 같은 메서드를 전혀 호출하지 않았다.그런데 어떻게 UPDATE SQL이 실행되는 것일까?
        JPA는 트랜잭션이 커밋되는 시점에, 변경된 엔티티 객체가 있는지 확인한다. 특정 엔티티 객체가 변경된 경우에는 UPDATE SQL을 실행한다.
        JPA가 처음 조회하는 시점에 내부에 원본객체를 복사해서 스냅샷이란걸 가지고 있다.
        그 스냅샷과 바뀐게 있는지 트랜잭션 커밋시점에 체크를 해서 바뀐게 있으면 update쿼리를 만들어서 날린다.

        JPA는 트랜잭션이 rollback되면 update문을 실행하지 않는다. commit될때만 수행한다.
        테스트의 경우 마지막에 트랜잭션이 롤백되기 때문에 JPA는 UPDATE SQL을 실행하지 않는다.
        (테스트에서 UPDATE SQL을 확인하려면 @Commit 을 붙이면 확인할 수 있다. 또는 JPA에서 제공하는 flush()메서드를 사용해도된다)*/
    }

    @Override
    public Optional<Item> findById(Long id) {
        Item item = em.find(Item.class, id);//em.find(반환받을타입.class, pk를넣어준다);
        // JPA에서 엔티티 객체를 PK를 기준으로 조회할 때는 find() 를 사용하고 조회 타입과 PK 값을 주면 JPA가 조회 SQL을 만들어서 실행하고,
        // 결과를 객체로 바로 변환해준다.
        return Optional.ofNullable(item);
    }

    @Override
    public List<Item> findAll(ItemSearchCond cond) {
        String jpql = "select i from Item i"; //jpql문법은 sql과 거의 비슷한데, 테이블을 대상으로하는게 아니고, 엔티티를 대상으로 한다.

        //동적쿼리
        Integer maxPrice = cond.getMaxPrice();
        String itemName = cond.getItemName();
        if (StringUtils.hasText(itemName) || maxPrice != null) {
            jpql += " where";
        }
        boolean andFlag = false;
        if (StringUtils.hasText(itemName)) {
            jpql += " i.itemName like concat('%',:itemName,'%')";
            andFlag = true;
        }
        if (maxPrice != null) {
            if (andFlag) {
                jpql += " and";
            }
            jpql += " i.price <= :maxPrice";
        }
        log.info("jpql={}", jpql);
        //동적쿼리

        TypedQuery<Item> query = em.createQuery(jpql, Item.class);

        ////동적쿼리
        if (StringUtils.hasText(itemName)) {
            query.setParameter("itemName", itemName);
        }
        if (maxPrice != null) {
            query.setParameter("maxPrice", maxPrice);
        }
        ////동적쿼리

        return query.getResultList();
    }
}
