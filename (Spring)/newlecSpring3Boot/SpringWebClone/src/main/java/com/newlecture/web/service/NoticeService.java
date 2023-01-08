package com.newlecture.web.service;

import java.util.List;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

public interface NoticeService {

	List<NoticeView> getList(int page, String field, String query);

	Notice get(int id);

}
