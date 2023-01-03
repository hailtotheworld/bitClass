package com.newlecture.web.controller.admin.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/*

http://localhost:8080/webprj0103/admin/board/notice/reg.html

*/

@RestController("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeController {
	
	@RequestMapping("reg")
	public String reg(String title, String content, MultipartFile file,String pets, @RequestParam(defaultValue = "없음") String[] interests, String contact) throws IllegalStateException, IOException {
		
		String fileName = file.getOriginalFilename();
		long fileSize = file.getSize();
		System.out.printf("fileName: %s\n fileSize: %d\n",fileName,fileSize);

		
		
		
		
//		for(String interest : interests) {
//			if(interest==null) continue;
//			System.out.println(interest);
//		}
		
		return String.format("title:%s <br> content:%s <br> pets:%s <br> contact:%s", title, content, pets, contact);
	}

}
