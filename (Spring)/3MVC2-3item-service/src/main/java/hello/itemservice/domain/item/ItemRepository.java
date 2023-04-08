package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>(); //동시에 여러쓰레드가 접근하기에 실무에서는 ConcurrentHashMap써야한다.
    private static Long sequence = 0L; // 동시에 여러쓰레드가 접근하기에 atomic long을 사용해야한다.

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        Item item = store.get(id);
        return item;
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
        // 지금 setId도 되는데 사용을 안하고 있네. 정석적으로는 itemName,price,quantity만 있는 DTO를 하나 더 만들어야 한다.
        // 중복보다 명확한게 낫다.
    }

    public void clearStore() {
        store.clear();
    }

}
