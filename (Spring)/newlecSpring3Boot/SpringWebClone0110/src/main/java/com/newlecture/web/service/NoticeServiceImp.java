package com.newlecture.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.NoticeView;

@Service
public class NoticeServiceImp implements NoticeService {
	
	@Autowired
	NoticeDao noticeDao;

	@Override
	public List<NoticeView> getViewList(int page, String field, String query) {
		
		// 1page offset 0
		// 2page offset 10
		// 3page offset 20
		// a1 + (n-1)*d
		// 0 + (page-1)*10
		int size = 10;
		int offset = 0 + (page-1)*size;
		
		List<NoticeView> list = noticeDao.getList(offset, size, field, query);
		return list;
	}
	

}
