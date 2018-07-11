package com.bit.vo;

import java.sql.Date;

public class CommentsVO {

	private int cno;
	private String writer;
	private String content;
	private int no;
	private Date regdate;

	public CommentsVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentsVO(int cno, String writer, String content, int no, Date regdate) {
		super();
		this.cno = cno;
		this.writer = writer;
		this.content = content;
		this.no = no;
		this.regdate = regdate;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

}
