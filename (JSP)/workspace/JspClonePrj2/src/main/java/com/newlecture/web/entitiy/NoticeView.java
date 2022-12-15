package com.newlecture.web.entitiy;

import java.util.Date;

public class NoticeView extends Notice {
	
	private int cmtCount;

	public NoticeView() {
	}

	public NoticeView(int id, String title, String writerId, Date regdate, int hit, String files, boolean pub, int cmtCount) {
		super(id, title, writerId, "", regdate, hit, files, pub);
		this.cmtCount = cmtCount;
	}

	public int getCmtCount() {
		return cmtCount;
	}

	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}

	
	
	

}
