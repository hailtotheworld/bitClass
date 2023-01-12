package com.newlecture.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;


@Mapper
public interface NoticeDao {

	/*
	@Select("SELECT * FROM noticeview "
			+ "where ${field} like '%${query}%' "
			+ "order by regdate desc "
			+ "limit #{offset},#{size}")
	List<NoticeView> getList(int offset, int size, String field, String query);
	*/
	
	List<NoticeView> getViewList(int offset, int size, String field, String query); //pub 넣고 다시해봐
	int getCount(String field, String query);
	NoticeView getView(int id);

	Notice getNext(int id);
	Notice getPrev(int id);
	
	int update(Notice notice);
	int insert(Notice notice);
	int delete(int id);
	
//	int deleteAll(int[] ids);
	int deleteAll();
	int updatePubAll(int[] pubIds, int[] closeIds); // close0 pub1 
//	int updatePubAll(int[] ids, boolean pub); 
}
