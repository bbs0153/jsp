package com.vo;

public class BoardVO {

	private int no;
	private String title;
	private String writer;
	private String regdate;
	private int hit;
	private String content;

	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardVO(int no, String title, String writer, String regdate, int hit, String content) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.regdate = regdate;
		this.hit = hit;
		this.content = content;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
