package com.newlecture.web.controller.customer;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

@Controller
@RequestMapping("/customer/notice/") //클래스에url매핑한게 메서드에url매핑과 결합이된다.
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	
	@RequestMapping("list") //@RequestMapping("/customer/notice/list")
	public String list() throws ClassNotFoundException, SQLException{
		List<NoticeView> list = noticeService.getList(1, "title", "");
		return "notice.list";
	}
	
	@RequestMapping("detail") //@RequestMapping("/customer/notice/detail")
	public String detail(){
		return "notice.detail";
	}
	
}
