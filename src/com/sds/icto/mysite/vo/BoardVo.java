package com.sds.icto.mysite.vo;

public class BoardVo {
	private int no;
	private String title;
	private String content;
	private String member_no;
	private String member_name;
	private String password;
	private String date;

	public BoardVo() {
	}

	public BoardVo(int no, String title, String content, String member_no,
			String member_name, String password, String date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.member_no = member_no;
		this.member_name = member_name;
		this.password = password;
		this.date = date;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMember_no() {
		return member_no;
	}

	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", content="
				+ content + ", member_no=" + member_no + ", member_name="
				+ member_name + ", password=" + password + ", date=" + date
				+ "]";
	}
	
}
