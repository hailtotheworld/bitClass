package hello.itemservice.domain.item;

public enum ItemType {

    BOOK("도서"),FOOD("음식"), ETC("기타");

    private final String description;

    ItemType(String description) { //private가 생략되어 있다.
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
