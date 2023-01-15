package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

//@Mapper // @Mapper를 읽으면 인터페이스이지만, 객체를 생성해서 IoC컨테이너에 담아준다

public interface NoticeDao {

	/*
	@Results({
	@Result(property = "memberName", column="member_name"),
	@Result(property = "memberId", column="member_id")
	})
	*/
	/*
	@Select("select * from noticeview "
			+ "where ${field} like '%${query}%' "
			+ "order by regdate desc "
			+ "limit #{offset},#{size}") // #{}은 값이라 양쪽에 ''가 들어간다.  ${}은 그대로 남게된다.
	List<NoticeView> getList(int offset, int size, String field, String query);
	*/
	

	List<NoticeView> getViewList(int offset, int size, String field, String query, boolean pub);
	int getCount(String field, String query, boolean pub);
	NoticeView getView(int id);

	Notice getNext(int id);
	Notice getPrev(int id);
	
	int update(Notice notice);
	int insert(Notice notice);
	int delete(int id);

	int deleteAll(int[] ids);
	int updatePubAll(int[] pubIds, int[] closeIds); // close0 pub1 
//	int updatePubAll(int[] ids, boolean pub); 

} 
