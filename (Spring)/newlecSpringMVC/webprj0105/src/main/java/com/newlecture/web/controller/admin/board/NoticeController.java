package com.newlecture.web.controller.admin.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/*

http://localhost:8080/webprj0104/admin/board/notice/reg

*/

@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeController {
	
	@Autowired
	private ServletContext ctx;
	
	@GetMapping("reg")
	public String reg() {
		return "admin/board/notice/reg";
	}
	
	@PostMapping("reg")
	public String reg(String title, String content, MultipartFile[] files,String pets, @RequestParam(defaultValue = "없음") String[] interests, String contact) throws IllegalStateException, IOException {
		
		
		
//		String fileName = file.getOriginalFilename();
//		long fileSize = file.getSize();
//		System.out.printf("fileName: %s\n fileSize: %d\n",fileName,fileSize);

		
		for(MultipartFile file : files) {
			if(file.getSize()!=0 && !file.getName().equals("")) {
			
			String fileName = file.getOriginalFilename();
			String realPath = ctx.getRealPath("/static/upload");
			File realSave = new File(realPath);
			if(!realSave.exists()) {
				realSave.mkdirs();
			}
			System.out.println(realSave);
			
			realPath = realPath + File.separator + fileName;
			File saveFile = new File(realPath);
			file.transferTo(saveFile);
			}
		}
//		for(String interest : interests) {
//			if(interest==null) continue;
//			System.out.println(interest);
//		}
		
//		return String.format("title:%s <br> content:%s <br> pets:%s <br> contact:%s", title, content, pets, contact);
		return "admin/board/notice/reg";
	}

}
