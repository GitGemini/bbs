package com.henu.service;

import java.util.List;
import java.util.Set;

import com.henu.dao.TopicDao;
import com.henu.entity.Topic;

public class TopicService {

TopicDao dao = new TopicDao();
	
	public Set<Topic> listOfForum(Integer fid) {		
		return dao.listOfForum(fid);
	}
	
	public List<Topic> list() {		
		return dao.list();
	}
	
	public void save(Topic topic) {		
		Integer id = dao.save(topic);
		System.out.println(id);
	}
	
	public Topic findByName(String tname) {		
		return dao.findByName(tname);
	}
	
	public Topic findById(Integer tid) {		
		return dao.findById(tid);
	}
	
	public Integer size(Integer tid) {		
		return dao.size(tid);
	}
}
