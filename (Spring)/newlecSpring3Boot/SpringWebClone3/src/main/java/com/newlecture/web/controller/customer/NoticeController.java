package com.newlecture.web.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*

http://localhost:8080/customer/notice/list

*/

@Controller
@RequestMapping("/customer/notice/")
public class NoticeController {

	@GetMapping("list")
	public String list() {
		return "customer/notice/list";
	}
	
	@GetMapping("detail")
	public String detail() {
		return "customer/notice/detail";
	}
}
