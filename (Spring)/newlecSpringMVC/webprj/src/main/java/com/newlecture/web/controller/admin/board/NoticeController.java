package com.newlecture.web.controller.admin.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/*
http://localhost:8080/admin/board/notice/reg
*/

@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeController {
	@Autowired
	ServletContext ctx;

	@RequestMapping("list")
	public String list() {
		return "admin.board.notice.list";
	}

	@RequestMapping("reg")
//	@ResponseBody
	public String reg(String title, String content, MultipartFile[] files, String pets, String[] monsters, String drone)
			throws IllegalStateException, IOException {
		// get요청에서는 form에서 전달된 인자들이 필요가 없다. post요청에서만 필요하지.
		
		
		// MultipartFile[] files는 사용하고있으니까 null이 오면 안된다.
		for(MultipartFile file : files) {
			if(file.getSize()!=0 && !file.getOriginalFilename().equals("")) {
				String fileName = file.getOriginalFilename();
				String webPath = "/static/upload";
				String realPath = ctx.getRealPath(webPath);
				File savePath = new File(realPath);
				if(!savePath.exists()) {
					savePath.mkdirs();
				}
				
				realPath += File.separator + fileName;
				File saveFile = new File(realPath);
				file.transferTo(saveFile);
			}
		}
		
		/*
		for (MultipartFile file : files) {
			if (file.getSize() > 0 && !file.getOriginalFilename().equals("")) {

				String fileName = file.getOriginalFilename();

//			long fileSize = file.getSize();
//			System.out.printf("fileName: %s, fileSize:%d\n", fileName, fileSize);

				String webPath = "/static/upload";
				String realPath = ctx.getRealPath(webPath); // 서블릿컨텍스트야 개발환경내에서경로의 실제물리경로를 알려줘.
				System.out.println(realPath);
				// C:\Users\TH\Documents\GitHub\bitClass\(Spring)\newlecSpringMVC\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\webprj\static\
				// upload
				File savePath = new File(realPath);
				if (!savePath.exists()) {
					savePath.mkdirs();
				}

				realPath += File.separator + fileName;
				File saveFile = new File(realPath); // 지정된 파일명까지붙힌실제물리경로에 비어있는 파일을 생성한다.

				file.transferTo(saveFile); // 클라이언트에게서 받아온 MultipartFile을 실제물리경로에있는비어있는파일로 .transferTo해준다
			}
		}*/

//		for(String monster : monsters) {
//			System.out.println(monster);
//		}

//		return String.format("title:%s <br> content:%s <br> pets:%s <br>drone:%s", title, content, pets, drone);
		return "admin.board.notice.reg";
	}

	@RequestMapping("edit")
	public String edit() {
		return "admin.board.notice.edit";
	}

	@RequestMapping("del")
	public String del() {
		return "admin.board.notice.del";
	}

}
