package com.newlecture.web.controller.api;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

/*

http://localhost:8080/api/notice/list
 
 */



@RestController("apiNoticeController")
@RequestMapping("/api/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@RequestMapping("list")
	public List<NoticeView> list() throws ClassNotFoundException, SQLException {
		List<NoticeView> list = service.getList(1, "TITLE", "");
		return list;
	}

}

/*
@Controller("apiNoticeController")
@RequestMapping("/api/notice/")
public class NoticeController {
	
	@RequestMapping("list")
	@ResponseBody
	public String list() {
		
		return "공지 list";
	}

}
*/


