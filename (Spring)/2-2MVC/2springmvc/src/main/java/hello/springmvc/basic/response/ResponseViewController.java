package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("/response/hello")
                .addObject("data", "helloV1");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "helloV2");
        return "/response/hello";
    }

    //절대 권장하지 않는다. 너무 불명확하다
    // 컨트롤러의경로와 뷰의논리적이름이 똑같으면, 반환값없어도 경로가 뷰의논리적이름으로 진행이된다.
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "helloV3");
    }
}
