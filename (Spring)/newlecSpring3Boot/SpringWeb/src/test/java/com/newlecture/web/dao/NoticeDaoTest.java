package com.newlecture.web.dao;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@AutoConfigureTestDatabase(replace=Replace.NONE)
@MybatisTest
class NoticeDaoTest {

	@Autowired
	private NoticeDao noticeDao;
	
	@Test
	void test() {
		// fail("Not yet implemented"); // 실패했다는걸 보여주는 역할을하는 함수다
		// System.out.println("hello");
		
//		List<NoticeView> list = noticeDao.getViewList(0, 1, "title", null, false);
//		System.out.println(list.get(0));
		
		System.out.println(noticeDao.delete(13));
		
	}
// 그냥 함수라고보면된다. main함수만들어서 테스트하는데 귀찮으니까 이 test()함수를 쓴다고 생각하면 된다.
// 실제로 그냥 아무거나 만들면 된다.
	
}
 
