package com.henu.action;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.henu.entity.Forum;
import com.henu.entity.Topic;
import com.henu.service.ForumService;
import com.henu.service.TopicService;


public class IndexAction{

	public String execute() {
		ForumService fs = new ForumService();
		TopicService ts = new TopicService();
		List<Forum> forums = fs.list();
		for (Forum forum : forums) {
			Set<Topic> topics = ts.listOfForum(forum.getFid());
			for (Topic topic : topics) {
				topic.setSize(ts.size(topic.getTid()));
			}
			forum.setTopicSet(topics);
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("forums", forums);
		return "success";
	}
	
	public String summary() {		
		return "success";
	}
	
	public String help() {		
		return "success";
	}
}
