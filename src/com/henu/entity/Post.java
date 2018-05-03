package com.henu.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 一条帖子 可按照话题id
 */
public class Post {
	private Integer pid; // 贴子的id
	private String title; // 标题
	private String content; // 问题详细描述
	private Date createTime;// 创建时间

	// 创建该贴子的用户
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	// 所属话题
	private Topic topic;
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	//话题中的帖子的集合  一对多
	private Set<Reply> replySet = new HashSet<Reply>();
	public Set<Reply> getReplySet() {
		return replySet;
	}

	public void setReplySet(Set<Reply> replySet) {
		this.replySet = replySet;
	}	
	
	private int size;
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}	
}
