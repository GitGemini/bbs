package com.henu.entity;

import java.util.Date;

/**
 * 论坛回复实体类
 */

public class Reply {
	private Integer rid; //回复Id	
	private String content;//回复内容
	private Date replyTime;//回复时间		
	
	private Post post;//回复所属贴子
	private User user;//回复所属用户
	
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}	
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
