package com.newlecture.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.newlecture.web.entity.Notice;


@Mapper
public interface NoticeDao {

	@Select("select * from notice")
	List<Notice> getList();

}
