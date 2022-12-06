package com.newlecture.web.service;

import java.util.List;

import com.newlecture.web.entity.Notice;

public class NoticeService {
	
	////
	public List<Notice> getNoticeList() {
		return getNoticeList("title", "", 1);
	}
	
	public List<Notice> getNoticeList(int page) {
		return getNoticeList("title", "", page);
	}
	
	public List<Notice> getNoticeList(String field, String query, int page) {
		
		String sql = "select * from ( "
				+ "select rownum num, N.* "
				+ "from (select * from notice order by regdate desc) N) "
				+ "where num between ? and ?";
		
		return null; 
	}

	////
	public int getNoticeCount() {
		return getNoticeCount("title", "");
	}
	
	
	public int getNoticeCount(String field, String query) {
		
		String sql = "select * from ( "
				+ "select rownum num, N.* "
				+ "from (select * from notice order by regdate desc) N) "
				+ "where num between ? and ?";
		
		return 0;
	}
	
	////
	public Notice getNotice(int id) {
		String sql = "select * from notice where id = ?";
		return null;
	}
	
	public Notice getNextNotice(int id) {
		return null;
	}
	
	public Notice getPrevNotice(int id) {
		return null;
	}
}