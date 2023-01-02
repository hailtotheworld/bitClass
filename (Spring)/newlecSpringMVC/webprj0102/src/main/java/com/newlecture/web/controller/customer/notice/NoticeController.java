package com.newlecture.web.controller.customer.notice;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@Controller
@RequestMapping("/customer/notice/")
public class NoticeController{
	
	@Autowired
	NoticeService noticeService;
	
//	public void setNoticeService(NoticeService noticeService) {
//		this.noticeService = noticeService;
//	}

//	@RequestMapping("list")
//	public List<Notice>  list() throws ClassNotFoundException, SQLException {
//		List<Notice> list = noticeService.getList(1, "title", "");
//		return list;
//	}
	
	@RequestMapping("list")
	public String list(@RequestParam(name = "p", defaultValue = "1") int page) {
		System.out.println(page);
		return "notice.list";
	}
	
	@RequestMapping("detail")
	public String detail() {
		return "notice.detail";
	}


//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		ModelAndView mv = new ModelAndView("notice.list");
//		List<Notice> list = noticeService.getList(1, "TITLE", "");
//		mv.addObject("list", list);
//		return mv;
//	}

}
