package com.sds.icto.mysite.vo;

public class GuestBookVo {
	private int no;
	private String name;
	private String password;
	private String message;
	private String date;
	
	public GuestBookVo() {
	}

	public GuestBookVo(int no, String name, String password, String message,
			String date) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.message = message;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "GuestBookVO [no=" + no + ", name=" + name + ", password="
				+ password + ", message=" + message + ", date=" + date + "]";
	}
	
}
