package com.bit2016.jblog.vo;

public class CategoryVo {

	private Long categoryNo;
	private String categoryName;
	private String description;
	private String regDate;
	private Long usersNo;
	

	public Long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Long getUsersNo() {
		return usersNo;
	}
	public void setUsersNo(Long usersNo){
		this.usersNo = usersNo;
	}
	
	
	
	@Override
	public String toString() {
		return "CategoryVo [categoryNo=" + categoryNo + ", categoryName="
				+ categoryName + ", description=" + description + ", regDate="
				+ regDate + ", usersNo=" + usersNo + "]";
	}
	
	
	
}
