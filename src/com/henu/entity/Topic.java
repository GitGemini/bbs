package com.henu.entity;

import java.util.HashSet;
import java.util.Set;

public class Topic {

	private Integer tid;// 话题id
	private String tname;// 话题名字
	private String info;// 话题简介
	

	private Integer size;// 帖子数	
	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	//话题中的帖子的集合  一对多
	private Set<Post> postSet = new HashSet<Post>();
	
	// 所属版块
	private Forum froum;

	public Forum getFroum() {
		return froum;
	}

	public void setFroum(Forum froum) {
		this.froum = froum;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Set<Post> getPostSet() {
		return postSet;
	}

	public void setPostSet(Set<Post> postSet) {
		this.postSet = postSet;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}
}