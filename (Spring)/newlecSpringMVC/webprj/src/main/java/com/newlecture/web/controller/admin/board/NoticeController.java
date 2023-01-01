package com.newlecture.web.controller.admin.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
http://localhost:8080/admin/board/notice/reg
*/

@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeController {
	
	@RequestMapping("list")
	public String list() {
		return "";
	}

	@RequestMapping("reg")
	@ResponseBody
	public String reg(String title, String content, String pets, String[] monsters,String drone) {
		
		for(String monster : monsters) {
			System.out.println(monster);
		}
		
		return String.format("title:%s <br> content:%s <br> pets:%s <br>drone:%s", title, content, pets,drone);
	}
	
	@RequestMapping("edit")
	public String edit() {
		return "";
	}
	
	@RequestMapping("del")
	public String del() {
		return "";
	}
	
	
}
