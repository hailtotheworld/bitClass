package com.newlecture.web.controller.customer.notice;

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

http://localhost:8080/webprj0104/customer/notice/list

*/

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
	public String list(Model model, @RequestParam(name = "p", defaultValue = "1") int page) throws ClassNotFoundException, SQLException {
		List<Notice> list = noticeService.getList(1, "title", "");
		model.addAttribute("list", list);
		
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
