package com.bit2016.jblog.vo;

public class PostVo {

	private Long categoryNo;
	private String content;
	private Long userNo;
	private String regDate;
	private String title;
	
	public Long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "PostVo [categoryNo=" + categoryNo + ", content=" + content
				+ ", userNo=" + userNo + ", regDate=" + regDate + ", title="
				+ title + "]";
	}
	
	
	
}
