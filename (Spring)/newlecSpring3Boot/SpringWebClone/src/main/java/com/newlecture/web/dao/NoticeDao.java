package com.newlecture.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

@Mapper // @Mapper를 읽으면 인터페이스이지만, 객체를 생성해서 IoC컨테이너에 담아준다
public interface NoticeDao {

	
	@Results({
	@Result(property = "memberName", column="member_name"),
	@Result(property = "memberId", column="member_id")
	})
	@Select("select * from noticeview")
	List<NoticeView> getList();

	Notice get(int id);

}
