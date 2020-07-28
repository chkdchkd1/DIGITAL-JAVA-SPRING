package kr.green.practice.vo;

import java.util.Date;

public class BoardVo {
	private int num;
	private String title;
	private String writer;
	private String content;
	private Date registerDate;
	private char isDel;
	private Date delDate;
	private int views;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public char getIsDel() {
		return isDel;
	}
	public void setIsDel(char isDel) {
		this.isDel = isDel;
	}
	public Date getDelDate() {
		return delDate;
	}
	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	@Override
	public String toString() {
		return "boardVo [num=" + num + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", registerDate=" + registerDate + ", isDel=" + isDel + ", delDate=" + delDate + ", views=" + views
				+ "]";
	}
	
	
	
}
