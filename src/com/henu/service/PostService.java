package com.henu.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.henu.dao.PostDao;
import com.henu.dao.UserDao;
import com.henu.entity.Post;
import com.henu.entity.Topic;
import com.henu.entity.User;

public class PostService {
	private PostDao dao = new PostDao();

	public boolean save(Post post) {
		if (post.getCreateTime() == null) {
			post.setCreateTime(new Date());
		}
		return dao.save(post) > 0;
	}

	public Set<Post> listOfUser(Integer uid) {
		return dao.listOfUser(uid);
	}

	public Set<Post> listOfTopic(Integer tid) {
		return dao.listOfTopic(tid);
	}

	public List<Post> list() {
		return dao.list();
	}

	public List<Post> findByInfo(String info) {
		return dao.findByInfo(info);
	}

	public List<Post> findTPByPage(Integer tid, int page, int offset) {
		return dao.findTPByPage(tid, (page - 1) * offset, offset);
	}

	public List<Post> findUPByPage(Integer uid, int page, int offset) {
		return dao.findUPByPage(uid, (page - 1) * offset, offset);
	}

	public Post findById(int pid) {
		return dao.findById(pid);
	}

	public User sender(int pid) {
		UserDao userDao = new UserDao();
		int uid = dao.sender(pid);
		return userDao.findById(uid);
	}

	public void delete(int pid) {
		dao.delete(pid);
	}

	public Topic getTopic(int pid) {
		return dao.getTopic(pid);
	}

	public Integer sizeOfReply(int pid) {
		return dao.sizeOfReply(pid);
	}

	public Integer sizeOfUser(int uid) {
		return dao.sizeOfUser(uid);
	}
}
