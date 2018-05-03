package com.henu.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.henu.dao.ReplyDao;
import com.henu.dao.UserDao;
import com.henu.entity.Post;
import com.henu.entity.Reply;
import com.henu.entity.User;

public class ReplyService {
	private ReplyDao dao = new ReplyDao();

	public Integer save(Reply reply) {	
		if(reply.getReplyTime()==null) {
			reply.setReplyTime(new Date());
		}
		return dao.save(reply);
	}
	
	public Set<Reply> listOfUser(Integer uid) {		
		return dao.listOfUser(uid);
	}

	public Set<Reply> listOfPost(Integer pid) {		
		return dao.listOfPost(pid);
	}

	public List<Reply> list() {		
		return dao.list();
	}

	public List<Reply> findByInfo(String info) {		
		return dao.findByInfo(info);
	}
	
	public List<Reply> findPRByPage(Integer pid, int page, int offset) {		
		return dao.findPRByPage(pid, (page-1)*offset, offset);
	}
	
	public List<Reply> findURByPage(Integer uid, int page, int offset) {		
		return dao.findURByPage(uid, (page-1)*offset, offset);
	}
	
	public User sender(int rid) {
		UserDao userDao = new UserDao();
		int uid = dao.sender(rid);
		return userDao.findById(uid);
	}

	public Reply findById(int rid) {		
		return dao.findById(rid);
	}
	
	public Post getPost(int rid) {		
		return dao.getPost(rid);
	}
	
	public Integer sizeOfUser(int uid) {		
		return dao.sizeOfUser(uid);
	}
}
