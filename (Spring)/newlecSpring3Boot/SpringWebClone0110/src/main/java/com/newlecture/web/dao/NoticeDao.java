package com.newlecture.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

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
	
	List<NoticeView> getList(int offset, int size, String field, String query);

}
