package com.newlecture.web.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

/*
http://localhost:8080/notice/list
*/

public class ListController implements Controller{

	@Autowired
	private NoticeService noticeService;

//	public void setNoticeService(NoticeService noticeService) {
//		this.noticeService = noticeService;
//	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
		ModelAndView mv = new ModelAndView("notice.list");
		
		List<NoticeView> list = noticeService.getList(1, "title", "");
		mv.addObject("list", list);
		
		return mv;
	}

}
