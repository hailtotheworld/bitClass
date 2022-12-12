package com.newlecture.web.entity;

import java.util.Date;

public class NoticeView extends Notice {

	// 부모상속받았으니까 속성메서드 다 상속된거다!!
	
	private int cmtCount;

	public NoticeView() {

	}
	
	public NoticeView(int id, String title, Date regdate, String writerId, int hit, String files, boolean pub, int cmtCount) {
		super(id, title, regdate, writerId, hit, files, "", pub); //부모의생성자를 호출
		                                                // 자식클래스에서는 content는 사용하지 않으므로 기본값을 넣어준다.
		this.cmtCount = cmtCount;
	}
	
	public int getCmtCount() {
		return cmtCount;
	}

	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}

}
