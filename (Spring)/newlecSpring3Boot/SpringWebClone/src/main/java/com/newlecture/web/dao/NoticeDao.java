package com.newlecture.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.newlecture.web.entity.Notice;

@Mapper // 이 @Mapper를 읽어서 마이바티스가 IoC컨테이너에 담아준다
public interface NoticeDao {

	@Select("select * from notice")
	List<Notice> getList();
	
	Notice get(int id);

}
