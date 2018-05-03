package com.henu.service;

import com.henu.dao.UserDao;
import com.henu.entity.User;
import com.henu.exception.UserExistException;
import com.henu.exception.UserNotExistException;
import com.henu.utils.UserUtil;

public class UserService {
	private UserDao dao = new UserDao();

	public boolean register(User user) throws UserExistException {
		// 用MD5加密密码
		String pwd = UserUtil.md5(user.getPassword());
		User u = dao.findByName(user.getUsername());
		if (u != null) {// 如果发现用户已存在，抛出UserExistException异常，通知web层处理
			throw new UserExistException("用户已存在，请直接登录！！");
		}
		// 加密密码
		user.setPassword(pwd);
		if (user.getSynopsis() == null) {
			user.setSynopsis("这个人很懒，什么也没有留下！");
		}
		if (user.getUsericon() == null) {
			user.setUsericon("default.png");
		}
		return dao.save(user);
	}
	
	public boolean save(User user){		
		if (user.getSynopsis() == null) {
			user.setSynopsis("这个人很懒，什么也没有留下！");
		}
		if (user.getUsericon() == null) {
			user.setUsericon("default.png");
		}
		return dao.update(user);
	}

	public User login(String username, String password) throws UserNotExistException {
		String m_psw = UserUtil.md5(password);
		User user = dao.login(username, m_psw);
		if (user == null) {
			throw new UserNotExistException("登录出错，用户不存在！！");
		}
		return user;
	}

	public boolean resetPassword(String username, String phone, String newPassword) throws UserNotExistException {
		User user = dao.findByName(username);
		if(user == null || !phone.equals(user.getPhone())) {
			throw new UserNotExistException("用户不存在！！");
		}
		user.setPassword(UserUtil.md5(newPassword));		
		return dao.save(user);
	}
	
	public User findByName(String username) {		
		return dao.findByName(username);
	}
	
	public User findById(int uid) {		
		return dao.findById(uid);
	}
}
