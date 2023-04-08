package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.NoticeView;


//@AutoConfigureTestDatabase(replace=Replace.NONE)
//@MybatisTest // @MybatisTest는 mybatis의 @mapper를 직접 테스트할때 사용하는거다.

@SpringBootTest
class MybatisNoticeDaoTest {

	@Autowired
	private NoticeDao noticeDao;
	
	@Test
	void test() {
		List<NoticeView> list = noticeDao.getViewList(0, 10, null, null, false);
		System.out.println(list.get(0));
	}

}
