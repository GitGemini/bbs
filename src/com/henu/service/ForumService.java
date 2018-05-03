package com.henu.service;

import java.util.List;

import com.henu.dao.ForumDao;
import com.henu.entity.Forum;

public class ForumService {
	ForumDao dao = new ForumDao();
	
	public List<Forum> list() {		
		return dao.list();
	}
	
	public void save(Forum forum) {		
		Integer id = dao.save(forum);
		System.out.println(id);
	}
	
	public Forum findByName(String fname) {		
		return dao.findByName(fname);
	}
	
	public Forum findById(Integer fid) {		
		return dao.findById(fid);
	}
}
