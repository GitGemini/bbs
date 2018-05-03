package com.henu.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.henu.entity.Post;
import com.henu.entity.Topic;
import com.henu.entity.User;
import com.henu.service.PostService;
import com.henu.service.TopicService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PostAction extends ActionSupport implements ModelDriven<Post> {
	private static final long serialVersionUID = 1L;

	private Post post = new Post();
	private PostService ps = new PostService();

	public String addPost() {
		HttpServletRequest req = ServletActionContext.getRequest();
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		TopicService ts = new TopicService();
		String tids = req.getParameter("tid");
		int tid = 1;
		try {
			tid = Integer.parseInt(tids);
		} catch (Exception e) {
			tid = 1;
		}
		Topic topic = ts.findById(tid);
		post.setCreateTime(new Date());
		post.setUser(user);
		post.setTopic(topic);
		if(!ps.save(post)) {
			return ERROR;
		}
		return SUCCESS;
	}
	private String username;
	
	public String deletePost() {
		HttpServletRequest req = ServletActionContext.getRequest();
		User user = (User) req.getSession().getAttribute("user");
		String pidStr = req.getParameter("pid");
		int pid = 0;
		try {
			pid = Integer.parseInt(pidStr);
		} catch (Exception e) {
			return ERROR;
		}
		if(user==null) {
			return ERROR;
		}else {
			this.username = user.getUsername();
		}		
		ps.delete(pid);
		return SUCCESS;		
	}

	@Override
	public Post getModel() {
		return post;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
