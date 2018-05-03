package com.henu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.henu.entity.Topic;
import com.henu.entity.User;
import com.henu.service.TopicService;

public class PostManageAction {

	TopicService ts = new TopicService();
	public String toAddPost() {
		HttpServletRequest req = ServletActionContext.getRequest();
		User user = (User) req.getSession().getAttribute("user");
		if(user==null) {
			return "error";
		}
		List<Topic> topics = ts.list();
		req.setAttribute("topics", topics);		
		return "success";
	}
}
