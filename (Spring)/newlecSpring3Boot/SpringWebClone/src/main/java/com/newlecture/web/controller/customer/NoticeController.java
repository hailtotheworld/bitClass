package com.newlecture.web.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

/*

http://localhost:8080/customer/notice/list

*/

@Controller
@RequestMapping("/customer/notice/")
public class NoticeController {

	@Autowired
	private NoticeService service;
	
	@GetMapping("list")
	public String list(Model model) {
		
		List<NoticeView> list = service.getList();
		
		model.addAttribute("list",list);
		
		return "customer.notice.list";
	}
	
	@GetMapping("detail")
	public String detail() {
		return "customer.notice.detail";
	}
}
