package hello.itemservice.repository.jpa;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemRepository;
import hello.itemservice.repository.ItemSearchCond;
import hello.itemservice.repository.ItemUpdateDto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static hello.itemservice.domain.QItem.*;

@Repository
@Transactional
public class JpaItemRepositoryV3 implements ItemRepository {

    private final EntityManager em;
    private final JPAQueryFactory query;

    public JpaItemRepositoryV3(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
        //쿼리DSL은 결과적으로 JPA의 JPQL을 만들어주는 빌더 역할을 한다.
        //그 JPAQuery를 만들어주는 공장이라고 해서 JPAQueryFactory이며, 매개변수로 em을 넣어주면된다.
    }

    @Override
    public Item save(Item item) {
        em.persist(item);
        return item;
    }

    @Override
    public void update(Long itemId, ItemUpdateDto updateParam) {
        Item findItem = em.find(Item.class, itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    @Override
    public Optional<Item> findById(Long id) {
        Item findItem = em.find(Item.class, id);
        return Optional.ofNullable(findItem);
    }

    /*
    public List<Item> findAllOld(ItemSearchCond cond) {

        String itemName = cond.getItemName();
        Integer maxPrice = cond.getMaxPrice();

        BooleanBuilder builder = new BooleanBuilder();
        if (StringUtils.hasText(itemName)) {
            builder.and(item.itemName.like("%" + itemName + "%"));
        }
        if (maxPrice != null) {
            builder.and(item.price.loe(maxPrice));
        }

        // QItem item = new QItem("i"); // QItem item = new QItem("엘리어스as 가 된다고 보면 된다");
        // -> public static final QItem item = new QItem("item");  QItem내부에 static 메서드로 가지고 있다.
        //     그래서 QItem.item이렇게 사용해도 된다. static import해도 되고.
        List<Item> result = query
                .select(item)
                .from(item)
                .where(builder)
                .fetch();

        return result;
    }
    */

    @Override
    public List<Item> findAll(ItemSearchCond cond) {

        String itemName = cond.getItemName();
        Integer maxPrice = cond.getMaxPrice();

        // QItem item = new QItem("i"); // QItem item = new QItem("엘리어스as 가 된다고 보면 된다");
        // -> public static final QItem item = new QItem("item");  QItem내부에 static 메서드로 가지고 있다.
        //     그래서 QItem.item이렇게 사용해도 된다. static import해도 되고.

        return query
                .select(item)
                .from(item)
                .where(likeItemName(itemName), maxPrice(maxPrice)) //BooleanExpression을 나열하면 and조건이된다. // null이면 그 조건은 무시가된다
                .fetch();
    }

    private BooleanExpression likeItemName(String itemName) {
        if (StringUtils.hasText(itemName)) {
            return item.itemName.like("%" + itemName + "%");
        }
        return null;
    }

    private BooleanExpression maxPrice(Integer maxPrice) {
        if (maxPrice != null) {
            return item.price.loe(maxPrice);
        }
        return null;
    }
}
