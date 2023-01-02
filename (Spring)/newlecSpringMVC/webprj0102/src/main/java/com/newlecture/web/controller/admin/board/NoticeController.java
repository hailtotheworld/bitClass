package com.newlecture.web.controller.admin.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeController {
	
	@RequestMapping("reg")
	public String reg() {
		
		
		return "reg";
	}

}
