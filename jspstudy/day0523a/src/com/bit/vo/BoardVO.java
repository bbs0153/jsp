package com.bit.vo;

public class BoardVO {

	private int no;
	private String title;
	private String writer;
	private String pwd;
	private String regdate;
	private int hit;
	private String content;
	private String fname;
	private int fsize;
	private String ip;

	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardVO(int no, String title, String writer, String pwd, String regdate, int hit, String content,
			String fname, int fsize, String ip) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.pwd = pwd;
		this.regdate = regdate;
		this.hit = hit;
		this.content = content;
		this.fname = fname;
		this.fsize = fsize;
		this.ip = ip;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getFsize() {
		return fsize;
	}

	public void setFsize(int fsize) {
		this.fsize = fsize;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
