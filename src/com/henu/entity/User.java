package com.henu.entity;

import java.util.HashSet;
import java.util.Set;

public class User {
	/** 普通用户 */
	public static final int USER = 1;
	/** 管理员  */
	public static final int MANAGER = 2;
	
	private Integer userId;
	private String  username;
	private String  password;
	private String email;
	private String phone;
	private String gender;
	private String synopsis;//用户简介
	private Integer type;
	private String usericon;
	
	private Set<Post> postSet = new HashSet<Post>();
	private Set<Reply> replySet = new HashSet<Reply>();
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + ", gender=" + gender + ", synopsis=" + synopsis + ", type=" + type
				+ ", usericon=" + usericon + "]";
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getUsericon() {
		return usericon;
	}
	public void setUsericon(String usericon) {
		this.usericon = usericon;
	}	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public Set<Post> getPostSet() {
		return postSet;
	}
	public void setPostSet(Set<Post> postSet) {
		this.postSet = postSet;
	}
	public Set<Reply> getReplySet() {
		return replySet;
	}
	public void setReplySet(Set<Reply> replySet) {
		this.replySet = replySet;
	}
}
