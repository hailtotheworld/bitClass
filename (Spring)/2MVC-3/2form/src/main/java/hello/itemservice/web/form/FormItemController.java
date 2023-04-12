package hello.itemservice.web.form;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/form/items")
@RequiredArgsConstructor
public class FormItemController {

    private final ItemRepository itemRepository;

    // 이렇게 두면 이 컨트롤러를 호출할때면 항상 자동으로 model.addAttribute("괄호에서지정해준이름",return으로반환한값) 담긴다.
    // 어떤 컨트롤러메서드(전달되는뷰)에서도 이 모델에 다 접근할 수 있다.
    @ModelAttribute("regions") //컨트롤러메서드의 매개변수로 받는 @ModelAttribute는 이름은 같지만 다른 기능이다!!
    public Map<String, String> regions() {
        Map<String, String> regions = new LinkedHashMap<>(); // HashMap은 순서가 보장이 안된다. LinkedHashMap은 순서가 보장이 된다.
        regions.put("SEOUL","서울");
        regions.put("BUSAN","부산");
        regions.put("JEJU","제주");
        return regions;
    }

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "form/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);

//        Map<String, String> regions = new LinkedHashMap<>(); // HashMap은 순서가 보장이 안된다. LinkedHashMap은 순서가 보장이 된다.
//        regions.put("SEOUL","서울");
//        regions.put("BUSAN","부산");
//        regions.put("JEJU","제주");
//        model.addAttribute("regions",regions);

        return "form/item";
    }
    
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new Item()); // view에서 th:object를 사용하기위해서 빈객체를 전달해준다. 빈객체 하나 만드는건 비용이 거의 들지 않는다

//        Map<String, String> regions = new LinkedHashMap<>(); // HashMap은 순서가 보장이 안된다. LinkedHashMap은 순서가 보장이 된다.
//        regions.put("SEOUL","서울");
//        regions.put("BUSAN","부산");
//        regions.put("JEJU","제주");
//        model.addAttribute("regions",regions);

        return "form/addForm";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute Item item, RedirectAttributes redirectAttributes) { //RedirectAttributes는 Model을 상속받은 인터페이스다.

        log.info("item.getOpen()={}", item.getOpen());
        log.info("item.getRegions()={}", item.getRegions());


        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId()); // pathVariable
        redirectAttributes.addAttribute("status", true); // 쿼리파라미터로 전달
        return "redirect:/form/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);

//        Map<String, String> regions = new LinkedHashMap<>(); // HashMap은 순서가 보장이 안된다. LinkedHashMap은 순서가 보장이 된다.
//        regions.put("SEOUL","서울");
//        regions.put("BUSAN","부산");
//        regions.put("JEJU","제주");
//        model.addAttribute("regions",regions);

        return "form/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item) {
        itemRepository.update(itemId, item);
        return "redirect:/form/items/{itemId}";
    }

}

