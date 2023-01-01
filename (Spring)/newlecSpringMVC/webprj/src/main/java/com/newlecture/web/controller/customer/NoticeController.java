package com.newlecture.web.controller.customer; // 폴더위의 폴더는 패키지

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

/*

http://localhost:8080/customer/notice/list

*/

@Controller
@RequestMapping("/customer/notice/") //클래스에url매핑한게 메서드에url매핑과 결합이된다.
public class NoticeController { // .jsp바로 위의 폴더는 클래스

	@Autowired
	private NoticeService noticeService;

/*
	@RequestMapping("list") //@RequestMapping("/customer/notice/list")  //.jsp가 이제 그저 함수가됐네
	public String list(HttpServletRequest request) throws ClassNotFoundException, SQLException{
		String p = request.getParameter("p");
		System.out.println(p);
		
		return "notice.list";
	}
	*/

	
	@RequestMapping("list") //@RequestMapping("/customer/notice/list")  //.jsp가 이제 그저 함수가됐네
	public String list(String p) throws ClassNotFoundException, SQLException{
		System.out.println(p);
		return "notice.list";
	}
	
	
	
	@RequestMapping("detail") //@RequestMapping("/customer/notice/detail")
	public String detail(){
		return "notice.detail";
	}
	
}
