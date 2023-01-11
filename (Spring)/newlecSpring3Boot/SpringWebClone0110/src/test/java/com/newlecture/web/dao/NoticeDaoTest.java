package com.newlecture.web.dao;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@MybatisTest
class NoticeDaoTest {

	@Autowired
	NoticeDao noticeDao;
	/*
	@Test
	void getList() {
		List<NoticeView> list = noticeDao.getViewList(0, 10, "title", "");
		System.out.println(list);
	}
	
	@Test
	void getCount() {
		int result = noticeDao.getCount("title", "제목");
		System.out.println(result);
	}
	
	@Test
	void getView() {
		Notice notice = noticeDao.getView(3);
		System.out.println(notice);
	}
	
	@Test
	void getNext() {
		Notice notice = noticeDao.getNext(6);
		System.out.println(notice);
	}
	
	@Test
	void getPrev() {
		Notice notice = noticeDao.getPrev(6);
		System.out.println(notice);
	}


	
	@Test
	void update() {
		Notice notice = new Notice();
		notice.setId(50);
		notice.setTitle("이것은제목");
		notice.setContent("이것은내용");
		notice.setHit(3);
		notice.setPub(true);
		
		int result = noticeDao.update(notice);
		System.out.println(result);
	}
		
	
	@Test
	void insert() {
		Notice notice = new Notice();
		notice.setTitle("이것은제목");
		notice.setContent("이것은내용");
		notice.setMemberId(1);
		int result = noticeDao.insert(notice);
		System.out.println(result);
	}*/
	@Test
	void delete() {
		int result = noticeDao.delete(7);
		System.out.println(result);
	}

	


}
