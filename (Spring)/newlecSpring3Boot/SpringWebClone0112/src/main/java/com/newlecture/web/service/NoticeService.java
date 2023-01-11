package com.newlecture.web.service;

import java.util.List;

import com.newlecture.web.entity.NoticeView;


public interface NoticeService {

	List<NoticeView> getViewList(int page, String field, String query);

}
