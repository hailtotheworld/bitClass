package hello.itemservice.web.validation;

import hello.itemservice.web.validation.form.ItemSaveForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController //@ResponseBody의 클래스버전
@RequestMapping("/validation/api/items")
public class ValidationItemApiController {

    @PostMapping("/add")
    public Object addItem(@RequestBody @Validated ItemSaveForm form, BindingResult bindingResult) {
//        {"itemName":"hello", "price":"QQQ", "quantity": 10}
        // 이 경우에는 JSON 파싱 자체를 하지 못해서, 컨트롤러가 호출되지 않는다.

        log.info("API 컨트롤러 호출");

        if(bindingResult.hasErrors()) {
            log.info("검증 오류 발생 error={}", bindingResult);
            return bindingResult.getAllErrors(); // 필드에러,오브젝트에러 다 반환해준다. (ObjectError의 자식이 FieldError다)
        }

        log.info("성공 로직 실행");
        return form;
    }
}
