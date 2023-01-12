package com.newlecture.web.controller.admin.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.service.NoticeService;

/*

http://localhost:8080/admin/board/notice/list
http://localhost:8080/admin/board/notice/detail
http://localhost:8080/admin/board/notice/reg

*/

@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeController {

	@Autowired
	private NoticeService service;
	
	@GetMapping("list")
	public String list() {
		
//		List<NoticeView> list = service.getList();
		
		return "admin.board.notice.list";
	}

	@GetMapping("detail")
	public String detail() {
		
//		Notice notice = service.get(1);
		
		return "admin.board.notice.detail";
	}
	
	@GetMapping("reg")
	public String reg() {
		return "admin.board.notice.reg";
	}


}

