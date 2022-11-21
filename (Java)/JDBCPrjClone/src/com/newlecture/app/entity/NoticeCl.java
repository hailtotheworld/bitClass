package com.newlecture.app.entity;

public class NoticeCl {
	
//	ID
//	TITLE
//	WRITER_ID
//	CONTENT
//	REGDATE
//	HIT
//	FILES
//	PUB
	
	private int id;
	private String title;
	private String writerId;
	private String content;
	private String regdate;
	private int hit;
	private String files;
	
	public NoticeCl() {
	}

	public NoticeCl(int id, String title, String writerId, String content, String regdate, int hit, String files) {
		this.id = id;
		this.title = title;
		this.writerId = writerId;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
		this.files = files;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getwriterId() {
		return writerId;
	}

	public void setwriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}
	
	
	
	
}
