package kr.green.practice.vo;

public class UserVo {
	private String id;
	private String pw;
	private String email;
	private String isDel;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	@Override
	public String toString() {
		return "UserVo [id=" + id + ", pw=" + pw + ", email=" + email + ", isDel=" + isDel + "]";
	}
	
	

}
