package com.henu.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 版块 分区
 */
public class Forum {
	
	private Integer fid;// 版块id
	
	private String fname;// 版块名字
	private String info;// 版块简介
	
	//板块中的话题集合  一对多
	private Set<Topic> topicSet = new HashSet<Topic>();	
	
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Set<Topic> getTopicSet() {
		return topicSet;
	}
	public void setTopicSet(Set<Topic> topicSet) {
		this.topicSet = topicSet;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
}