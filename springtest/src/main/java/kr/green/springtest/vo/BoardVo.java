package kr.green.springtest.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardVo {
	private int num;
	private String title;
	private String writer;
	private String content;
	private Date registerDate;
	private char isDel;
	private int views;
	private Date delDate;
	private int up;
	private String file;
	
	
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public int getUp() {
		return up;
	}
	public void setUp(int up) {
		this.up = up;
	}
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
	public String getwriter() {
		return writer;
	}
	public void setwriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegisterDate() {
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = transFormat.format(registerDate);
		return date;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	public void setRegisterDate(String registerDate) {
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		try {
			this.registerDate = transFormat.parse(registerDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public char getIsDel() {
		return isDel;
	}
	public void setIsDel(char isDel) {
		this.isDel = isDel;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public Date getDelDate() {
		return delDate;
	}
	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}
	
	@Override
	public String toString() {
		return "BoardVo [num=" + num + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", registerDate=" + registerDate + ", isDel=" + isDel + ", views=" + views + ", delDate=" + delDate
				+ ", up=" + up + ", file=" + file + "]";
	}
	
	
	public String getOriFile() {
		int index = file.indexOf("_");
		return file.substring(index+1);
		//처음 언더바 뒤에 있는것을 추출 
	}
	

}
