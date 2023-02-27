package hello.itemservice.web.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

    private final ItemRepository itemRepository;

//    @Autowired //스프링에서는 생성자가 하나만 있으면 @Autowired 생략할수있다. 생략해도 @Autowired해준다.
//    public BasicItemController(ItemRepository itemRepository) {
//        this.itemRepository = itemRepository;
//    }

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items"; //  resources/templates/  basic/items  .html
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item",item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

    ///////////////////////////////////////////////////////////////////////////////////
//    @PostMapping ("/add")
    public String addItemV1(@RequestParam String itemName,
                       @RequestParam Integer price,
                       @RequestParam Integer quantity,
                       Model model) {
        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);
        itemRepository.save(item);
        model.addAttribute("item",item);
        return "basic/item";
    }

//    @PostMapping ("/add")
    public String addItemV2(@ModelAttribute("item") Item item, Model model) { //@ModelAttribute("매개변수이름") 매개변수이름은 모델에 담을때 쓰는 이름이다
        
        //@ModelAttribute의기능1: 객체생성, setXXX
//        Item item = new Item();
//        item.setItemName(itemName);
//        item.setPrice(price);
//        item.setQuantity(quantity);
        itemRepository.save(item);

        //@ModelAttribute의기능2: 모델에 담아준다
//        model.addAttribute("item",item);
        return "basic/item";
    }

//    @PostMapping ("/add")
    public String addItemV3(@ModelAttribute Item item) {
        // @ModelAttribute로 받는 클래스명의 첫글자를 소문자로 바꾼이름을 model에 담는거다.
        // eg) Item -> item

        itemRepository.save(item);

        return "basic/item";
    }


    @PostMapping ("/add")
    public String addItemV4(Item item) {
        itemRepository.save(item);
        return "basic/item";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item",item);
        return "basic/editForm";
    }

    @PostMapping ("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, Model model) {
        return "basic/editForm";
    }





    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("내가넣은샘플A", 10000, 10));
        itemRepository.save(new Item("내가넣은샘플B", 20000, 20));
    }

}
