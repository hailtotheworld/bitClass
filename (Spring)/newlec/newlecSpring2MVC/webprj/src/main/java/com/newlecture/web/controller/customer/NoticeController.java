package com.newlecture.web.controller.customer; // 폴더위의 폴더는 패키지

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

/*

http://localhost:8080/customer/notice/list

*/

@Controller
@RequestMapping("/customer/notice/") //클래스에url매핑한게 메서드에url매핑과 결합이된다.
public class NoticeController { // .jsp바로 위의 폴더는 클래스

	@Autowired
	private NoticeService noticeService;

/*
	@RequestMapping("list") //@RequestMapping("/customer/notice/list")  //.jsp가 이제 그저 함수가됐네
	public String list(HttpServletRequest request) throws ClassNotFoundException, SQLException{
		String p = request.getParameter("p");
		System.out.println(p);
		
		return "notice.list";
	}
	*/

	@RequestMapping("list")
	public String list(Model model, @RequestParam(name="p", defaultValue="1") int page) throws ClassNotFoundException, SQLException{
		
		List<Notice> list = noticeService.getList(1, "title", "");
		model.addAttribute("list", list);
		
		return "notice.list";
	}
	
	
	
	@RequestMapping("detail") //@RequestMapping("/customer/notice/detail")
	public String detail(){
		return "notice.detail";
	}
	
}
