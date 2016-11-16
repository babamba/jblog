package com.bit2016.jblog.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


public class UserVo {
	private Long no;
	
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	@Length(min=3, max=8)
	private String id;
	
	
	@NotEmpty
	@Pattern(regexp="^[0-9]+$")
	private String password;
	
	private String date;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", id=" + id + ", name=" + name
				+ ", password=" + password + ", date=" + date + "]";
	}
	
	
	
	
	
}
