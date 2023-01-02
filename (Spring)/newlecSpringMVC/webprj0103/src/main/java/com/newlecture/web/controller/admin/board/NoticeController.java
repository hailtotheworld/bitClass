package com.newlecture.web.controller.admin.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*

http://localhost:8080/webprj0102/admin/board/notice/reg.html

*/

@RestController("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeController {
	
	@RequestMapping("reg")
	public String reg(String title, String content, String pets, @RequestParam(defaultValue = "없음") String[] interests, String contact) {
		
		for(String interest : interests) {
			if(interest==null) continue;
			System.out.println(interest);
		}
		
		
		return String.format("title:%s <br> content:%s <br> pets:%s <br> contact:%s", title, content, pets, contact);
	}

}
